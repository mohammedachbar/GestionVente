package com.gestionVente.test;
import java.io.*;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.gestionVente.business.GestionArticle;
import com.gestionVente.business.GestionTelRecord;
import com.gestionVente.business.ThreadTelRecord;
import com.gestionVente.beans.*;
import com.gestionVente.services.ArticleService;
import com.gestionVente.services.TelRecordService;
public class Test_tps {	
	public static void main(String[] args)throws IOException {
		new Test_tps();        
	}
   	
	public Test_tps (){	
		test_TelRecordThread();
			    
	}
	// methode pour créer une liste d'articles
	public ArrayList<Article> createListOfArticles(){
		ArrayList<String> listeProduitTelephone= new ArrayList<String>();
		listeProduitTelephone.add("chargeur");listeProduitTelephone.add("batterie");
		ArrayList<String> listeProduitTelephone2= new ArrayList<String>();
		listeProduitTelephone2.add("chargeur");listeProduitTelephone2.add("kit");
		
		
	    ArrayList<Article> listOfArticles= new ArrayList<Article>();	   
	    listOfArticles.add(new Article("telephone", 2500.00, 2, Promotion.ETE,listeProduitTelephone));
	    listOfArticles.add(new Article("telephone", 2500.00, 2, Promotion.ETE,listeProduitTelephone2));
	    listOfArticles.add(new Article("refrigerateur", 2500.00, 3, Promotion.HIVER));
	    listOfArticles.add(new Article("television", 2500.00, 8, Promotion.PRINTEMPS));

		return listOfArticles;		
	}
	
	//methode pour créer une liste de clients
	public ArrayList<TelRecord> createListOfTelRecords(){
		ArrayList<TelRecord> clients = new ArrayList<TelRecord>();
		clients.add(new TelRecord ("achbar", "mohammed", 0657202143));
		clients.add(new TelRecord ("berrada", "said", 0657202143));		
		return clients;
	}
	
	//methode pour tester l'importation d'une liste d'article à partir d'un fichier CSV 
	public void test_importListOfArticles(){
		ArticleService service = new ArticleService() ;
		System.out.println(ArticleService.importListOfArticles("fichier.csv").get(1).toString());
	}

	//methode pour tester l'exportation d'une liste d'article vers un fichier CSV 
	public void test_exportListOfArticles(){
		ArticleService service = new ArticleService() ;
		ArticleService.exportListOfArticles(createListOfArticles(), "fichier.csv");
	}
	
	//methode pour tester l'exportation d'une liste d'article vers un fichier CSV 
	public void test_exportListOfTelRecord(){
		TelRecordService serviceTel = new TelRecordService();
		ArrayList <TelRecord> listeOfTel = createListOfTelRecords();
		serviceTel.exportListOfTelRecords(listeOfTel,"phones.csv");
	
	}
	
	// method pour tester l'exercice 2 du tp 4
	public void test_TelRecordThread(){
		ArrayList<TelRecord> listePhones =  createListOfTelRecords();
		TelRecord tel = new TelRecord("benjelloune", "hassane", 0657202143) ;
		Thread t = new Thread(new ThreadTelRecord(tel,"liste",listePhones));
	    Thread t2 = new Thread(new ThreadTelRecord(tel,"CSV"));
	    
	    t.start();
	    t2.start();
	    for(int i=0;i<listePhones.size();i++){
	    	System.out.println(listePhones.get(i).toString());
	    	}	    
	}
	


}




