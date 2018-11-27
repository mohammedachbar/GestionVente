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

import com.gestionVente.beans.Article;
import com.gestionVente.beans.Promotion;
import com.gestionVente.beans.TelRecord;

public class TelRecordService {

	public TelRecordService() {
		super();
	}
	
	public static void exportOneTelRecord(String fileName, TelRecord tel){
		final String CSV_SEPARATOR = ",";
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName,true), "UTF-8"));
            bw.write(tel.getNom() +"," + tel.getPrenom() +","+ tel.getNumTel());
            bw.newLine();
            
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    
	}
	
	
	public static void exportListOfTelRecords(ArrayList<TelRecord> TelRecords, String fileName){
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            bw.write("nom ,Prenom,Tel");
            bw.newLine();
            for (TelRecord t : TelRecords)
            {
            	bw.write(t.getNom()+ "," + t.getPrenom() + "," +  t.getNumTel());
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
