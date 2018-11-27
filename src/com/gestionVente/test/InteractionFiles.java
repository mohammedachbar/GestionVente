package com.gestionVente.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class InteractionFiles {
	
	public InteractionFiles(){
		ex1();
		//ex2();
		//ex3();
	}

	public static void main(String[] args) {
		new InteractionFiles();
	}


	public static void ex1(){
        	PropertyResourceBundle p = (PropertyResourceBundle)ResourceBundle.getBundle("paramConf");
    	    System.out.println(p.getString("file_lecture"));
    	    System.out.println(p.getString("file_ecriture"));
        }
	 
	public static void ex2(){
		try{
			FileReader   fr = new FileReader("C:\\Users\\simo\\workspace\\GestionVente\\texte.txt"); 
			BufferedReader br = new BufferedReader (fr); 
			while(br.ready()){
				System.out.println(br.readLine());				
			}
			br.close();
			
		}
			
		catch (Exception e){
			System.out.println("erreu"+ e); 
		}
	}
	
	public static void ex3(){
		  try{
				FileWriter   fw = new FileWriter("C:\\Users\\simo\\workspace\\GestionVente\\texte.txt"); 
				BufferedWriter bw = new BufferedWriter (fw);
				bw.write(("Hello"));
				bw.newLine();
				bw.write("world!");
				bw.close();	
				
				}
				
				catch (Exception e){
					System.out.println("erreu"+ e); 
				}

	}
}
