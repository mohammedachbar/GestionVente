package com.gestionVente.SocketTP5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	// CONST FIELDS	
	public final static String ADDR = "127.0.0.1";
	public final static int PORT = 5050;

	protected Socket clientSocket;
	protected DataInputStream  dataIn;
	protected DataOutputStream dataOut;
	public Client(String clientName, String articleTitle) throws UnknownHostException, IOException {
		
		//create the client socket and connect to the server		
		this.clientSocket = new Socket(ADDR,PORT);
		//try to send the server the article we looking for 
		dataIn = new DataInputStream(this.clientSocket.getInputStream());
		dataOut= new DataOutputStream(this.clientSocket.getOutputStream());
		dataOut.writeUTF(articleTitle);
		//get server response
		String response = dataIn.readUTF();
		System.out.print("[" + clientName + "] -reponse serveur ... :\t");
		System.out.println(response);
		//close the client output stream
		dataIn.close();
		dataOut.close();
		this.clientSocket.close();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		// create our client list
		new Client("client 1", "pack cuisine");

	}
}
