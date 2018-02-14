/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DB.MyConnection;
import Entite.Rendez_vous;
import Entite.Users;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author khaled22
 */
public class ServicesRdv implements Iservices.IServicesRendez_Vous {
                Connection con =MyConnection.getInstance().getCon();
    public ServicesRdv() {
    }
    

    @Override
    public void AjouterRDV(Users p, int id_med ,Rendez_vous r) {
        ServicesUsers su = new ServicesUsers();
        if(su.verifierLogin(p)){
       String req1 ="INSERT INTO `rendez_vous`(`nom`, `prenom`, `cin`, `date_naissance`, `telephone`, `adresse`, `Date_Rendez_vous`,"
               + " `id_medecin`) VALUES (?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps=con.prepareStatement(req1);
                ps.setString(1, r.getNom());                                  ps.setString(2, r.getPrenom());
                ps.setInt(3, p.getCin());                                     ps.setDate(4,r.getDateNaissance());
                ps.setInt(5, r.getTelephone());                               ps.setDate(7,r.getDate_reservation());
                ps.setString(6,r.getAdresse());                                     ps.setInt(8,id_med);    
                
        
               ps.executeUpdate();
               System.out.println("user ajouter RDV ");
            } catch (SQLException ex) {
                
                System.out.println("error lors de requette sql ajout \n\n"+ex);
            }
        }else{
            
            System.out.println("User no where to be found  or role user <> 'Medecin'");
            
        }
        
    }

    @Override
    public void AnnulerRDV(Users m,Users p) {
        try{
             
            PreparedStatement prep = con.prepareStatement("delete from rendez_vous where cin=? and id_medecin=?");
            prep.setInt(1, p.getCin());
            prep.setInt(2,m.getNum_carte_serv());
            prep.executeUpdate();
            System.out.println("rendez-vous est annuler par l'utilisateur : \n"+p.getNom());
            
        }catch(SQLException ex){
            System.out.println("error type \n "+ex);
        }
   
    }

    @Override
    public void ModifierRDV(Users u, Rendez_vous r, Date rdv) {
        
          try {
             // le patient va modifier la date du rdv et la recherche se fait par id_medecin car il est unique
                   String sql = "UPDATE rendez_vous  SET `Date_Rendez_vous` ='"+ rdv+ "' where id_medecin='"+u.getNum_carte_serv();
                   PreparedStatement ste = con.prepareStatement(sql);
                   ste.executeUpdate();
           System.out.println("update done ");
                   
         
       
      
           
           
          }
          catch(SQLException ex){
              
              System.out.println("update failed "+ex);
          }
        
    }
//
//    @Override
//    public boolean ChercherRDV(String nom_med ) {
//       String sql = "SELECT * FROM rendez_vous WHERE id_rdv ='" + +"';";
//        try {
//
//            PreparedStatement ps = con.prepareStatement(sql);
//
//            ps.executeQuery();
//            System.out.println("Rendez-vous existe sous l'id :"+r.getId_rdv());
//            return true ;
//
//        } catch (SQLException ex) {
//            //Logger.getLogger(ServiceAdmin.class.getName()).log(Level.SEVERE, null, ex);
//                    System.out.println("error "+ex);
//        }
//        return false ;
//    }
//
//    @Override
//    public boolean ChercherRDV(String nom_med) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
