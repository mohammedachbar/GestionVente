package com.gestionVente.beans;
import java.util.ArrayList;
import java.util.List;

import com.gestionVente.business.GestionArticle;

public class Article {
	
	private String titre;
	private double prix;
	private int quantité;
	
	private ArrayList<Produit> produits = new ArrayList<Produit>();
	private Promotion promo;
	
	public Article() {
		super();
		produits = new ArrayList<Produit>();
	}
	
	public Article(String titre, double prix, int quantité, Promotion promo) {
		super();
		this.titre = titre;
		this.prix = prix;
		this.quantité = quantité;
		this.promo = promo;
	}

	public Article(String titre, double prix, int quantité, Promotion promo, ArrayList<String> titreProduits) {
		super();
		this.titre = titre;
		this.prix = prix;
		this.quantité = quantité;
		this.promo = promo;
		for( String s : titreProduits){
			this.stockerProduit(s);
		}
	}
	
	public String getTitre() {
		return titre +"  " + promo.suffixe();
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public double getPrix() {
		GestionArticle gestion = new GestionArticle();
		return gestion.calculerPrixActicle(this.prix, this.promo);
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantité() {
		return quantité;
	}

	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
	
	
		
	public Promotion getPromo() {
		return promo;
	}

	public void setPromo(Promotion promo) {
		this.promo = promo;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits =  produits;
	}

	public ArrayList<String> getListProduitbyTitle(){
		ArrayList<String> liste = new ArrayList<String>(); 
		for(int i=0;i<this.produits.size();i++){
			liste.add(produits.get(i).getTitre());
			
		}
		return liste;
		
	}
	public Produit ajouterProduit(String produit) {
		Produit p = new Produit();
		p.setTitre(produit);
		return p;
	}
	
	public void stockerProduit(String p) {
		Produit pr = new Produit();
		pr.setTitre(p);
		produits.add(pr);
	}
	
	public Produit getProduit(String titre) {
		
		for(Produit p: produits ){
			if(p.titre.equals(titre))
				return p;
			
		}
		return null;
	}
	
	public ArrayList<Produit> getListProduit() {
		
		return produits;
	}
	
	
	
	@Override
	public String toString() {
		return "Article [titre=" + titre + ", prix=" + prix + ", quantité=" + quantité + ", produits=" + produits
				+ ", promo=" + promo + "]";
	}
	
	//class interne Produit
	public class Produit{
		
		private String titre;
		
		public Produit() {
			super();
		}
		
		public Produit(String titre) {
			super();
			this.titre = titre;
		}

		
		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		@Override
		public String toString() {
			return "Produit [titre=" + titre + "]";
		}	
	}
}
