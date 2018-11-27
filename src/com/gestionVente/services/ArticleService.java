package com.gestionVente.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.gestionVente.beans.Article;
import com.gestionVente.beans.Promotion;

public class ArticleService {

	public ArticleService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static ArrayList<Article> importListOfArticles(String fileName) {
        BufferedReader fileReader = null;
    	ArrayList<Article> articles = new ArrayList<Article>();	
        try {
            String line = "";	
            fileReader = new BufferedReader(new FileReader(fileName));		
            while ((line = fileReader.readLine()) != null) {
            	String[] tokens = line.split(",");	
            	//System.out.println(tokens.length);
            	if (tokens.length == 4) {
                    articles.add(new Article(tokens[0],Double.parseDouble(tokens[1]),
                    		Integer.parseInt(tokens[2]),Promotion.valueOf(tokens[3])));
                }
            	
            	if (tokens.length == 5){
            		//System.out.println(line);
            		String[] tookens = tokens[4].split(":");
                	ArrayList<String> liste=new ArrayList<String>();
                	for(int i=0 ; i<tookens.length; i++){
                		liste.add(tookens[i]);                    	
                    }
                	articles.add(new Article (tokens[0],Double.parseDouble(tokens[1]),
							 Integer.parseInt(tokens[2]),
							 Promotion.valueOf(tokens[3]),liste));		            		
            	}
            	     
            }
         /*for (int i = 0; i < articles.size(); i++) {		
                System.out.println(articles.get(i).toString());
            }*/		
        }
          
        catch (Exception e) {		
            System.out.println("Error in CsvFileReader !!!");		
            e.printStackTrace();
        } finally {		
            try {		
                fileReader.close();		
            } catch (IOException e) {		
                System.out.println("Error while closing fileReader !!!");		
                e.printStackTrace();		
            }
        }
		return articles;
    }
	 
	public static void exportListOfArticles(ArrayList<Article> articleList,String fileName ){
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            for (Article a : articleList){
            	bw.write(a.getTitre()+ "," + a.getPrix() + "," + a.getQuantité() + "," + a.getPromo().toString());
                if(a.getListProduit().size()!=0){
                	bw.write(",(");
                }
            	for(int i=0; i<a.getListProduit().size();i++){
            		if(i<=a.getListProduit().size()-2){
            			bw.write( a.getListProduit().get(i).getTitre() +":");   
            		}
            		else if(i==(a.getListProduit().size())-1){
            			bw.write( a.getListProduit().get(i).getTitre()+")");  
            		}               	
                }      	
            	bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
	
	
}
