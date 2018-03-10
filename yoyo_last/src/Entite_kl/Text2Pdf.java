
/**
 * Example written for JavaOne 2016.
 * Differences between iText 5 and iText 7 are discussed in the JavaOne talk
 * "Oops, I broke my API" by Raf Hens and Bruno Lowagie.
 * This is the iText 5 version of one of the examples.
 */
package Entite;

import Services.ServicesFiche;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Writer;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

public class Text2Pdf {
//    Services.ServicesFiche sf = new ServicesFiche();
//    FichePatient f = new FichePatient(12, "gasem", "lamouro", "maladi404", "treatment 0", "your mother is gonna die ", new java.sql.Date(2019-1900, 12-1, 10));

    public Text2Pdf() {
    }
    
    
    public  void Test2PdfFunction(FichePatient p) throws Exception {
       DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Writer output = null;
        //String id_fiche = p.getId_fiche()+"";
        
        //Font font = new Font(FontFamily.getFamily(id_fiche), 14, Font.BOLD, BaseColor.WHITE);
        String text  = ServicesFiche.PrepareToConversion(p);
        File file = new File("C:\\Users\\samie\\Desktop\\yoyo_last\\src\\pdfExtrait\\"+p.getNom()+""+p.getPrenom()+".PDF");
        output = new BufferedWriter(new FileWriter(file));
        output.write(text);
        output.close();
        InputStream is = new BufferedInputStream(new FileInputStream(file));
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob job = service.createPrintJob();
        Doc doc = new SimpleDoc(is, flavor, null);
       // PrintJobWatcher pjDone = new PrintJobWatcher(job);
       // job.print(doc, null);
       // pjDone.waitForDone();
        is.close();
    }
}