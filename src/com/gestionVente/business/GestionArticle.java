package com.gestionVente.business;

import java.util.ArrayList;

import com.gestionVente.beans.Article;
import com.gestionVente.beans.Article.Produit;
import com.gestionVente.beans.Promotion;

public class GestionArticle {

	public GestionArticle() {
		super();
	}
	
	
	public void stockerProduit(String titre, Article a) {
		a.stockerProduit(titre);
		}
	

	public ArrayList<String> listeProduit(Article a ) {
		return a.getListProduitbyTitle();
	}
	
	public void addArticle (ArrayList <Article> liste,Article a){
		liste.add(a);
	}
	
	public double calculerPrixActicle(double prix,Promotion p){
		switch(p) {
		case ETE : return  (prix * 0.9) ;
		case PRINTEMPS : return (prix * 0.7) ;
		case AUTOMNE : return (prix* 0.95) ; 
		case HIVER : return (prix * 0.8);
		default : return (prix * 1.0);
		}
		
	}
	
}
