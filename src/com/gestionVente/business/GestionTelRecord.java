package com.gestionVente.business;

import java.util.ArrayList;

import com.gestionVente.beans.TelRecord;

public class GestionTelRecord {
	
	private static ArrayList<TelRecord> annuaire = new ArrayList<TelRecord>();

	public GestionTelRecord() {
	}
	
	public GestionTelRecord(ArrayList<TelRecord> annuaire ) {
		this.annuaire= annuaire;
	}
	
	
	public static void addClient(TelRecord t){
        annuaire.add(t);		
	}
	
	public static void addListOfClients(ArrayList<TelRecord> liste){
		for(int i=0; i<liste.size();i++){
			annuaire.add(liste.get(i));
		}
	}
	
	
	public static void removeClient(TelRecord t){
		annuaire.remove(t);		
	}
	
	public static ArrayList<TelRecord> getAnnuaire(){
		return annuaire;		
		
	}
	
	public static void printAnnuaire(){
		for (int i = 0; i < annuaire.size(); i++) {		
            System.out.println(annuaire.get(i).toString());
        }		
		
	}
	
}

