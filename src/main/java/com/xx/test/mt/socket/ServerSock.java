package com.xx.test.mt.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerSock implements Runnable {

	public static void main(String[] args){
		ServerSock s = new ServerSock();
		s.startServer();
	}
	
	public static final int PORT = ServerConst.serverSocketPort;// 监听的端口号
	public static boolean isRun = true;// 服务器运行标识

	/**
	 * 构造方法
	 * 
	 */
	public ServerSock() {
		ServerConst.clientSocketMap = new HashMap<String, Socket>();
	}

	public void run() {
		startServer();
	}

	/**
	 * 启动serversocket服务端
	 * 
	 */
	public void startServer() {
		try {
			ServerConst.serverSocket = new ServerSocket(PORT);
			System.out.println("socket server 启动,端口:" + PORT + " IP:" + ServerConst.serverSocket.getInetAddress().getHostAddress());
			while (isRun) {
				System.out.println("server端等待连接...");
				// 一旦有堵塞, 则表示服务器与客户端获得了连接
				Socket client = ServerConst.serverSocket.accept();
				// 处理这次连接请求
				HandlerThread th = new HandlerThread(client);
				th.start();
				String remoteSocketAddr = client.getInetAddress().getHostAddress();
				System.out.println("server side remoteSocketAddr:" + remoteSocketAddr);
				ServerConst.clientSocketMap.put(remoteSocketAddr, client);
				System.out.println("client socket map is:" + ServerConst.clientSocketMap);
			}
		} catch (Exception e) {
			System.out.println("socket服务异常: " + e.getMessage());
		}
	} // end method initServer

	/**
	 * 向客户端发送数据
	 * 
	 * @param clientSocket  客户端socket
	 * @param str  要发送的字符串
	 * @return
	 */
	public static int sendDataToClient(Socket clientSocket, String str) {
		int isOk = -1;// 发送结果标识
		DataOutputStream out = null;
		// 向客户端回复信息
		try {
			out = new DataOutputStream(clientSocket.getOutputStream());
			out.writeUTF(str);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return isOk;
	}

	/**
	 * 关闭serversocket
	 * 
	 * @param serverSocket
	 */
	public static void closeServer() {
		try {
			if (null != ServerConst.serverSocket) {
				ServerConst.serverSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/**
 * 处理客户端连接请求的线程类
 * 
 * @author Administrator
 *
 */
class HandlerThread extends Thread {
	//客户端socket client
	private Socket socket;
	//客户端IP地址
    private String clientSockIPAddr;
    
    BufferedReader in = null;
    PrintWriter out = null;
    
	public HandlerThread(Socket client) {
		socket = client;
		clientSockIPAddr = socket.getInetAddress().getHostAddress();
	}

	public void run() {
		try {
			System.out.println("进入客户端线程处理socket");
			InputStream ips = socket.getInputStream();
			OutputStream ops = socket.getOutputStream();
			out = new PrintWriter(ops,true);
			in = new BufferedReader(new InputStreamReader(ips));
			String msg = in.readLine();
			System.out.println("msg ==>" + msg);
			out.write(msg);
			out.flush();
			while (!msg.equals("")) {
				// 处理客户端数据
				System.out.println("客户端发过来的内容:" + msg);
				msg = in.readLine();
				out.write(msg);
				out.flush();
			}
		} catch (Exception e) {
			System.out.println("exception e:"+e);
			System.out.println("服务器 run 异常: " + e.getMessage());
			System.out.println("before remove from map:"+ServerConst.clientSocketMap);
			System.out.println("客户端socket异常,clientSockIPAddr:"+clientSockIPAddr);
			ServerConst.clientSocketMap.remove(clientSockIPAddr);
			System.out.println("after remove from map:"+ServerConst.clientSocketMap);
		}finally{
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
} // 结束线程类 HandlerThread