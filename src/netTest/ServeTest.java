package netTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServeTest {
	public static void main(String[] args) {
		try {
			ServerSocket serve = new ServerSocket(8100);
			Socket incoming = serve.accept();
			try {
				InputStream input = incoming.getInputStream();
				OutputStream output = incoming.getOutputStream();

				Scanner sin = new Scanner(input);
				PrintWriter sout = new PrintWriter(output, true);

				sout.println("Enter BYE to exit");
				boolean done = false;
				while (!done && sin.hasNextLine()) {
					String next = sin.nextLine();
					if (next.trim().equals("BYE") || next.trim().equals("bye")) {
						done = true;
					} else {

						sout.println("Echo: " + next);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				incoming.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
