package netTest;

import java.net.*;
import java.io.*;
import java.util.*;

public class GetAddress {
	public static void main(String[] args) {
		// Socket iconnect = new Socket();
		if (args.length == 0) {
			// local address
			InetAddress address = null;
//			Inet6Address address6 = null;
			try {
				address = InetAddress.getLocalHost();
//				address6 = (Inet6Address) Inet6Address.getLocalHost();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(address.getHostAddress());
			try {
				System.out.println(getLocalIPv6Address());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			InetAddress[] addresses = null;
			try {
				addresses = InetAddress.getAllByName(args[0]);
				for (InetAddress ia : addresses) {
					System.out.println(ia.getHostAddress());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public static void getLocalIPv6Address() throws IOException {
		InetAddress inetAddress = null;
		Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
		while (networkInterfaces.hasMoreElements()) {
			System.out.println(networkInterfaces.nextElement().getName()+" : ");
			Enumeration<InetAddress> inetAds = networkInterfaces.nextElement().getInetAddresses();
			while (inetAds.hasMoreElements()) {
				inetAddress = inetAds.nextElement();
				System.out.print(inetAddress.getHostAddress());
				// Check if it's ipv6 address and reserved address
				if (inetAddress instanceof Inet6Address) {
//					System.out.println(inetAddress.getHostName());
					System.out.println("  //IPV6");
//					return inetAddress.getHostAddress();
				}else{
					System.out.println();
				}
			}
		}
	}

}
