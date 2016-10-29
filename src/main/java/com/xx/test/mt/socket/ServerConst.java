package com.xx.test.mt.socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class ServerConst {
	//存储已经连接的客户端socket,以连接的IP为键,socket对象为值
	public static Map<String, Socket> clientSocketMap = null;
	//服务端server socket事例
	public static ServerSocket serverSocket = null;
	//服务端socket监听端口
	public static final int serverSocketPort = 9191;
}
