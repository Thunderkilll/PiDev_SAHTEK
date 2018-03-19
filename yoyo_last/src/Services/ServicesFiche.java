/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DB.MyConnexion;
import Entite.FichePatient;
import Entite.Users;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.control.Alert;

/**
 *
 * @author khaled22
 */
public class ServicesFiche {
    
    Connection db = MyConnexion.Get_Instance().getCon();
    public ServicesFiche() {
    }
    Services_user su = new Services_user();
    
 
     public static String ImageConverter(String s) {   //C:UserssamieOneDriveDocumentsSAHTEK_Patientsrcimages5.jpg
          //System.out.println(s.indexOf("Users"));
         
       String image = "C:\\xampp\\htdocs\\images\\"+s;
          System.out.println(image);
        return image;
    }

    
    public void AjouterFiche (FichePatient f){
        
        try {
            
            
            
            String query = "insert into fiche (`nom_p` ,`prenom_p`, `maladie`,`traitement` , `diagnostique` ,`date`) values ('"+f.getNom()+"','"+f.getPrenom()+"','"+f.getMaldaie()+"','"+
                    f.getTraitement()+"','"+f.getDiagnostique()+"','"+f.getDate()+"');";
                PreparedStatement ps=db.prepareStatement(query);
              
            ps.executeUpdate(query);
            
            System.out.println("fiche user ajouter ");
            
        } catch (SQLException e) {
            System.out.println("error in Ajout Fiche \n"+e);
        }
        
        
        
        
    }
  
    public ArrayList<FichePatient> AfficherFiche (){
      ArrayList<FichePatient> fiches = new ArrayList<>();
         
               try {
                      String sql = " SELECT * from fiche where 1 ;";
                ResultSet result ;
                       Statement ste = db.createStatement();
        result = ste.executeQuery(sql);
     while(result.next()){
            FichePatient p2 = new FichePatient();
            p2.setId_fiche(result.getInt(1));
            p2.setNom(result.getString(2));
            p2.setPrenom(result.getString(3));
            p2.setMaldaie(result.getString(4));
            p2.setTraitement(result.getString(5));
            p2.setDiagnostique(result.getString(6));
            p2.setDate(result.getDate(7));
   
     fiches.add(p2);
         //System.out.println("liste remplit ");
     }
        } catch (SQLException e) {
                System.out.println("error is \n"+e);
        }

     return fiches ;
    }
    
    public void UpdateFiche (int t ,FichePatient p ){
        
        
        try {
            String query = "update `fiche` set nom_p =? , prenom_p =? , maladie =? , traitement =? , diagnostique =? ,date =? where id_fiche=?  ;";
            PreparedStatement st = db.prepareStatement(query);

             st.setString(1,p.getNom() );
            st.setString(2,p.getPrenom());
            st.setString(3,p.getMaldaie());
            st.setString(4, p.getTraitement());
            st.setString(5, p.getDiagnostique());
            st.setDate(6,p.getDate());
            st.setInt(7,p.getId_fiche() );
           st.execute();
            System.out.println("are you doing this  the querry is saved  ");
        } catch (SQLException e) {
            System.out.println("error in :\n"+e);
        }
        
        
    }
 
    public FichePatient ChercherFiche1(int id)
    {   FichePatient f = new FichePatient();
        try {
            String req = "SELECT * from fiche where id_fiche ='"+id+"';";
             PreparedStatement pre = db.prepareStatement(req);
      ResultSet rs = pre.executeQuery();
       
              while (rs.next()) 
        {  
            f.setId_fiche(rs.getInt(1));
            f.setNom(rs.getString(2));
            f.setPrenom(rs.getString(3));
            f.setMaldaie(rs.getString(4));
            f.setDiagnostique(rs.getString(6));
            f.setTraitement(rs.getString(5));
            f.setDate(rs.getDate(7));
           

        }
            
        } catch (SQLException e) {
            System.out.println("error in recherche du fiche \n"+e);
        }
        System.out.println("Fiche d'id : "+f.getId_fiche()+" Trouvé ");
        return f;
    }

  
        public FichePatient ChercherFiche(String s)
    {   FichePatient f = new FichePatient();
        try {
            String req = "SELECT * from fiche where nom_p ='"+s+"';";
             PreparedStatement pre = db.prepareStatement(req);
      ResultSet rs = pre.executeQuery();
       
              while (rs.next()) 
        {  
            f.setId_fiche(rs.getInt(1));
            f.setNom(rs.getString(2));
            f.setPrenom(rs.getString(3));
            f.setMaldaie(rs.getString(4));
            f.setDiagnostique(rs.getString(6));
            f.setTraitement(rs.getString(5));
            f.setDate(rs.getDate(7));
           

        }
            
        } catch (SQLException e) {
               Alert alert = new Alert(Alert.AlertType.NONE);
            
            alert.setTitle("No Name found");
            alert.setHeaderText("Nom du patient n'existe pas ");
            alert.setContentText("Please search a name of a patient or create a new fiche with this name ");

            alert.show();
        }
        System.out.println("Fiche d'id : "+f.getId_fiche()+" Trouvé ");
        return f;
    }
 
    
    public static String PrepareToConversion (FichePatient f){
        String s =" \nPdf \n";
        s=s+f.toString();
        
        return s;
    } 
    
    public boolean DeleteAction (Users u , FichePatient fp)
    {
        boolean test = false ;
        if(su.verifierLogin(u)){
            
             try { 
            PreparedStatement prep = db.prepareStatement("delete from fiche where id_fiche=?");
            prep.setInt(1,fp.getId_fiche());
            prep.executeUpdate();
            System.out.println("supprimer done fiche \n");
        } catch (SQLException ex) {
                System.out.println("supprimer failed \n"+ex);
        }
        }
        
        
        
        
        
        return test ;
    }
    
}
