package com.gestionVente.SocketTP5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.gestionVente.beans.Article;
import com.gestionVente.services.ArticleService;


public class Handler implements Runnable{
	
	protected Socket client;
	protected DataInputStream dataIn;
	protected DataOutputStream dataOut;
	private ArrayList<Article> arts;
	
	public Handler(Socket client, DataInputStream dataIn, DataOutputStream dataOut) {
		super();
		this.client = client;
		this.dataIn = dataIn;
		this.dataOut =  dataOut;
	}

	
	
	@Override
	public synchronized void run() {
		ArticleService service = new ArticleService();
		boolean isFound = false;
		String article = null;
		try {
				article = dataIn.readUTF();
				arts = service.importListOfArticles("fichier.csv");
				for(Article a : arts) {
					System.out.println("Comparing " + a.getTitre() + "To " + article);
					if(a.getTitre().equalsIgnoreCase(article)){
						isFound = true;
						break;
					}
				}
			dataOut.writeUTF(String.format("%s : %s", article, isFound ? "Found" : "Not Found"));
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				dataIn.close();
				dataOut.close();
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	
	}

	
}
