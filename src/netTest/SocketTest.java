package netTest;

import java.util.*;
import java.io.*;
import java.net.*;

public class SocketTest {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("www.baidu.com", 80);
			try {
				InputStream sin = s.getInputStream();
				Scanner ss = new Scanner(sin);
				while (ss.hasNextLine()) {
					String line = ss.nextLine();
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				s.close();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
