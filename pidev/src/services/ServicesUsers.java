/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DB.MyConnection;
import Entite.Users;
import Iservices.InterfaceUsers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author khaled22
 */
public class ServicesUsers implements InterfaceUsers{
       Connection con =MyConnection.getInstance().getCon(); ;
       public static InterfaceUsers service ;
   
    public static InterfaceUsers getInstance(){
    if(service==null)
         service=new ServicesUsers();
    return service;
    
}
    
    
    


    @Override
    public void verifierLogin(Users u) {
                String req="SELECT email,password FROM users WHERE email=? and password=? ;";
         try {
        PreparedStatement ps=con.prepareStatement(req);
        ps.setString(1, u.getEmail());
        ps.setString(2, u.getPassword());
        
        ResultSet rs=ps.executeQuery();
             
             
            if(rs.next()){
                String s1=rs.getString(1);
                 String s2=rs.getString(2);
                 
              //  System.out.println(s1+s2);
             }
        System.out.println("conexion validé");
         } catch (SQLException ex) {
            
             System.out.println("\nconnexion didn't pass "+ex);
        }
    }

    @Override
    public void addPatient(Users u) {
        String requete ="insert into users (username,nom,prenom,date_naissance,cin,email,password,telephone,"
                + "adresse,user) "
                + " values (?,?,?,?,?,?,?,?,?,?);";
        
        try{
                   
                  
             
        PreparedStatement ps=con.prepareStatement(requete);
        ps.setInt(5, u.getCin());                                     ps.setString(1, u.getUsername());
        ps.setString(2, u.getNom());                                  ps.setString(3, u.getPrenom());
        ps.setString(6, u.getEmail());                                ps.setString(7, u.getPassword());
        ps.setDate(4,u.getDateNaissance());                        ps.setInt(8, u.getTelephone());
        ps.setString(10, u.getUser());                                ps.setString(9, u.getAdresse());
        
        
        ps.executeUpdate();
        System.out.println("user ajouter Type : Patient ");
           
        }
         catch (SQLException ex) {
             System.out.println(" error lors de l'ajout du patient"+ex);
        }
     
    }
     
    @Override
    public void addMedecin(Users u) {
               String requete ="insert into users (username,nom,prenom,date_naissance,cin,email,password,telephone,"
                + "adresse,user,num_carte_serv) "
                + " values (?,?,?,?,?,?,?,?,?,?,?);";
        
        try{
                   
                  
             
        PreparedStatement ps=con.prepareStatement(requete);
        ps.setInt(5, u.getCin());                                     ps.setString(1, u.getUsername());
        ps.setString(2, u.getNom());                                  ps.setString(3, u.getPrenom());
        ps.setString(6, u.getEmail());                                ps.setString(7, u.getPassword());
        ps.setDate(4,u.getDateNaissance() );       ps.setInt(8, u.getTelephone());
        ps.setString(10, u.getUser());                                ps.setString(9, u.getAdresse());
        ps.setInt(11, u.getNum_carte_serv());
        
        ps.executeUpdate();
        System.out.println("user ajouter Type : Medecin");
           
        }
         catch (SQLException ex) {
             System.out.println(" error lors de l'ajout du medecin"+ex);
        }
     
    }

    //a refaire et completé
    @Override
    public void addPharmacien(Users u) {
                 String requete ="insert into users (username,nom,prenom,date_naissance,cin,email,password,telephone,"
                + "adresse,user,num_carte_serv , id_pharmacie) "
                + " values (?,?,?,?,?,?,?,?,?,?,?,?);";
        
        try{
                   
                  
             
        PreparedStatement ps=con.prepareStatement(requete);
        ps.setInt(5, u.getCin());                                     ps.setString(1, u.getUsername());
        ps.setString(2, u.getNom());                                  ps.setString(3, u.getPrenom());
        ps.setString(6, u.getEmail());                                ps.setString(7, u.getPassword());
        ps.setDate(4,u.getDateNaissance()  );                       ps.setInt(8, u.getTelephone());
        ps.setString(10, u.getUser());                                ps.setString(9, u.getAdresse());
        ps.setInt(11, u.getNum_carte_serv());                         ps.setInt(12, u.getId_pharmacie());
        
        ps.executeUpdate();
        System.out.println("user ajouter Type : Pharmacien");
           
        }
         catch (SQLException ex) {
             System.out.println(" error lors de l'ajout du pharmacien "+ex);
        }
       
    }
   //a refaire
    @Override
    public void addPropCentre(Users u) {
       String requete ="insert into users (username,nom,prenom,date_naissance,cin,email,password,telephone,"
                + "adresse,user,num_carte_serv , id_centre) "
                + " values (?,?,?,?,?,?,?,?,?,?,?,?);";
        
        try{
                   
                  
             
        PreparedStatement ps=con.prepareStatement(requete);
        ps.setInt(5, u.getCin());                                     ps.setString(1, u.getUsername());
        ps.setString(2, u.getNom());                                  ps.setString(3, u.getPrenom());
        ps.setString(6, u.getEmail());                                ps.setString(7, u.getPassword());
        ps.setDate(4,u.getDateNaissance() );                          ps.setInt(8, u.getTelephone());
        ps.setString(10, u.getUser());                                ps.setString(9, u.getAdresse());
        ps.setInt(11, u.getNum_carte_serv());                         ps.setInt(12, u.getId_centre());
        
        ps.executeUpdate();
        System.out.println("user ajouter Type : Pharmacien");
           
        }
         catch (SQLException ex) {
             System.out.println(" error lors de l'ajout du pharmacien "+ex);
        }
       
    }
/*  try {
               Connection db = MyConnection.getInstance().getCon();
            
        String sql = "UPDATE users  SET  `id_usr`= 2 WHERE cin= '"+p2.getCin()+"';";
      
           PreparedStatement ste = db.prepareStatement(sql);
           ste.executeUpdate();
           System.out.println("update done ");
          }
          catch(SQLException ex){
              
              System.out.println("update failed \n"+ex);
          }*/
    
    
}
