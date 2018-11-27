package com.gestionVente.beans;

public enum Promotion {

	ETE("ete"), PRINTEMPS("PRINTEMPS"), AUTOMNE("AUTOMNE"), HIVER("HIVER"),NORMAL("");

	private String suffixe;
	
	Promotion(String suffixe) {
		this.suffixe = suffixe;
	}
	
	public String suffixe() {
		return suffixe;
	}
	

}
