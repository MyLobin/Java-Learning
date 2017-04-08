package com.lobin.base.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String... strings) {
		String serverName = "localhost";
		int port = Integer.parseInt("8888");
		try {
			System.out.println(serverName + port);
			Socket client = new Socket(serverName, port);
			print("connect" + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF("outToServer");
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			print("from server:" + in.readUTF());
			client.close();
		} catch (IOException e) {

		}
	}

	public static void print(Object obj) {
		System.out.println(obj + "");
	}
}
