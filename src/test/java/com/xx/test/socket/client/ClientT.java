package com.xx.test.socket.client;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class ClientT {

	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 8191;
		try{
			Socket client = new Socket(host, port);
			Writer writer = new OutputStreamWriter(client.getOutputStream());
			writer.write("Hello from client");
			writer.flush();
			writer.close();
			client.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
