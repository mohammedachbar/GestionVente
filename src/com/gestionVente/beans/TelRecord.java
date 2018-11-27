package com.gestionVente.beans;

public class TelRecord {
	
	private String nom;
	private String prenom;
	private int numTel;
	
	
	public TelRecord(String nom, String prenom, int numTel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
	}
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getNumTel() {
		return numTel;
	}
	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}
	@Override
	public String toString() {
		return "TelRecord [nom=" + nom + ", prenom=" + prenom + ", numTel="
				+ numTel + "]";
	}
	
	
	
	

}
