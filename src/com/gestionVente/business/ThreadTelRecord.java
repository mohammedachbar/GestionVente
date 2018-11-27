package com.gestionVente.business;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import com.gestionVente.beans.TelRecord;
import com.gestionVente.services.TelRecordService;


public class ThreadTelRecord implements Runnable {
	
	private TelRecord tel ;
	private String typeFile;
	private ArrayList<TelRecord> listPhones; 
	
	public ThreadTelRecord(TelRecord tel,String  typeFile ){
		this.tel =tel; 
		this.typeFile= typeFile; 
	}
	
	public ThreadTelRecord(TelRecord tel,String  typeFile, ArrayList<TelRecord> listPhones ){
		this.tel =tel; 
		this.typeFile= typeFile; 
		this.listPhones= listPhones;
	}

	
	public void run() {
		if (typeFile == "liste"){
			this.listPhones.add(tel);	
			}
		if(typeFile=="CSV"){
			TelRecordService service = new TelRecordService() ;
			service.exportOneTelRecord("telephone.csv", tel);
		
		}

	}
}
