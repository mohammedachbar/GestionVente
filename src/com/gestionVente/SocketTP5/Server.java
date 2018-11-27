package com.gestionVente.SocketTP5;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
	
	protected int serverPort;
	protected ServerSocket serverSocket = null;
	protected boolean isClosed = false;
	
	

	
	public Server(int port) {
		// TODO Auto-generated constructor stub
		this.serverPort = port;
		this.openServer();
		while(!isClosed) {
			try {
			  Socket sc = this.serverSocket.accept();
			  System.out.println("client connecté ....");
			  DataInputStream dis = new DataInputStream(sc.getInputStream());
			  DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
			  Thread worker = new Thread(new Handler(sc, dis, dos));
			  worker.start();
			}catch(Exception ex) {
				ex.getStackTrace();
			}
			
		}
	}
	
	public void stop() throws IOException {
		if(this.serverSocket.isBound())
			this.serverSocket.close();
	}

	public void openServer() {
		
		try {
			this.serverSocket = new ServerSocket(this.serverPort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		//create the server object
		
		Server MultithredServer = new Server(5050);
		
	}
}
