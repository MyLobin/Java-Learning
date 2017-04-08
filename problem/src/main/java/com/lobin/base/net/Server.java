package com.lobin.base.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server extends Thread{
	private ServerSocket serverSocket;
	public Server(int port) throws IOException{
		serverSocket=new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}
	public void run(){
		while(true){
			try{
				print("waiting for client...");
				Socket server=serverSocket.accept();
				print("connected:"+server.getRemoteSocketAddress());
				DataInputStream in=new DataInputStream(server.getInputStream());
				print(in.readUTF());
				DataOutputStream out=new DataOutputStream(server.getOutputStream());
				out.writeUTF("server says");
				server.close();
			}catch(SocketTimeoutException s){
				print("out of time");
				break;
			}catch(IOException e){
				e.printStackTrace();
				break;
			}
		}
	}
	public static void main(String... strings) {
		int port=Integer.parseInt("8888");
		try {
			Thread t=new Server(port);
			t.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void print(Object obj) {
		System.out.println(obj + "");
	}
}
