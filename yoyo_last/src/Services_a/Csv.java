/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entite.Articles;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.collections.ObservableList;


/**
 *
 * @author allela
 */
public class Csv {
       

  
                      
    public Csv(ObservableList<Articles> v) {
        // TODO code application logic here
        String outputFile = "C:\\Users\\samie\\Desktop\\yoyo_last\\src\\ExcelExtrait\\Articles.csv";
		//String g=;
		// before we open the file check to see if it already exists
		boolean alreadyExists = new File(outputFile).exists();
			
		try {
			// use FileWriter constructor that specifies open for appending
			  CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), '\n');
			
			// if the file didn't already exist then we need to write out the header line
			if (!alreadyExists)
			{
				csvOutput.endRecord();
                           csvOutput.write("********************************");
				csvOutput.write("Identifiant Article :");
                                csvOutput.endRecord();
                           csvOutput.write("********************************");
                                      csvOutput.write("\tTitre Question :");
                                     csvOutput.endRecord();
                           csvOutput.write("********************************");
				csvOutput.write("\tSous Titre Question");
                               csvOutput.endRecord();
                           csvOutput.write("********************************");
				      csvOutput.write("\tDescription");
                                      csvOutput.endRecord();
                           csvOutput.write("********************************");
                                csvOutput.write("\tIdentifiant  User :");
                                csvOutput.endRecord();
                           csvOutput.write("********************************");
				csvOutput.endRecord();
                              //  csvOutput.
				

				
			}
			// else assume that the file already has the correct header line
			 System.out.println(v.size());
                               

				csvOutput.endRecord();
                       for(int i=0;i<v.size();i++)
                        {
                         
                            csvOutput.endRecord();
                                csvOutput.endRecord();
                                csvOutput.endRecord();
                           csvOutput.write("\rIdentifiant Article : \t "+Integer.toString(v.get(i).getId()));//get(i).getMatricule()
                           csvOutput.endRecord();
                           csvOutput.write("********************************");
                           csvOutput.write("\rTitre Question :\t"+v.get(i).getTitre());                     
                           csvOutput.endRecord();
                           csvOutput.write("********************************");
                           csvOutput.write("\rSous Titre Question : \t"+v.get(i).getSub_t());
                           csvOutput.endRecord();
                           csvOutput.write("********************************");
                           csvOutput.write("\rDescription :  \t"+v.get(i).getDescript());
                           csvOutput.endRecord();
                           csvOutput.write("********************************");
                           csvOutput.write("\rIdentifiant  User : \t"+Integer.toString(v.get(i).getId_user()));
                           csvOutput.endRecord();
                           csvOutput.write("********************************\n");
                           csvOutput.endRecord();
                           csvOutput.write("********************************\n");
                           csvOutput.endRecord();
                                csvOutput.endRecord();
                                csvOutput.endRecord();
                        }
			
			
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
 
}
