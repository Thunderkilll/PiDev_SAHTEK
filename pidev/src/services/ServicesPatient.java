/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DB.MyConnection;
import Entite.Patient;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author khaled22
 */
public class ServicesPatient implements Iservices.IservicesPatient{
      Connection db=  MyConnection.getInstance().getCon(); 

    @Override
    public void ajouter_Patient(Patient p) {
       //**********************************Ajout Methode 1 *************
                    try {
                       
            Statement stm= db.createStatement();
            String query = "insert into patient (nom, prenom ,date_naissance ,password, image) values ('" +p.getNom()+"','"+p.getPrenom()+"','"+p.getDate_naissance()+"','"+p.getPassword()+"',"+p.getImage()+"')";
            stm.executeUpdate(query);
            System.out.println("ajout ok");
        } catch (SQLException ex) {
            System.out.println("Ajout failed "+ex);
         }
   
    }
       public void ajouter_Patient2(Patient p) {
       //**********************************Ajout Methode 1 *************
                    try {
                       
            Statement stm= db.createStatement();
            String query = "insert into patient (cin,nom, prenom ,date_naissance ,password, image) values ('"+p.getCin()+ "','" +p.getNom()+"','"+p.getPrenom()+"','"+p.getDate_naissance()+"','"+p.getPassword()+"',"+p.getImage()+"')";
            stm.executeUpdate(query);
            System.out.println("ajout ok");
        } catch (SQLException ex) {
            System.out.println("Ajout failed "+ex);
         }
   
    }
      @Override
    public void ajouter_Patient_Elts(String nom, String prenom, Date date_naissance, String password, String image) {
        //**********************************Ajout Methode 1 *************
    }
    

    @Override
    public void supprimer_Patient_Class(Patient p) {
       //********************Supprimer ******************************
    }

    @Override
    public void supprimer_Patient_cin(int c) {
       //************************supprimer 2 ********************
    }

    @Override
    public void update_Info1(Patient p, String nom, String prenom, Date date_naissance) {
        //***************** modifier 1
    }

    @Override
    public void Update_Name_Patient(Patient p, String nom) {
//**********************************Modifier 0 *************
    }

    @Override
    public void Update_Pwd_Patient(Patient p, String password) {
       //********************************** Modifier 1 *************
        
    }

    @Override
    public void Update_PatientComplete(Patient p, String nom, String prenom, Date date_naissance, String password, String image) {
     //**********************************Modifier Methode 2 *************
        
    }

    @Override
    public void Afficher_Patients() {
     //**********************************afficher tous Methode 1 *************
    }

    @Override
    public ArrayList<Patient> AfficherPatient() {
       ArrayList<Patient> p= new ArrayList<>();
            
       
       
        try {
          
              String req = "select * from `patient`";
            PreparedStatement pre = db.prepareStatement(req);
            ResultSet rs = pre.executeQuery();
            Patient p1 = null;
            
            while (rs.next()) {
       
     Patient p2 = new Patient();
      p2.setCin((rs.getInt(1)));
              
      p2.setNom(rs.getString(2));
      p2.setPrenom(rs.getString(3));
      p2.setDate_naissance(rs.getDate(4));
      p2.setPassword(rs.getString(5));
      p2.setImage(rs.getString(6));
      p.add(p2);
                System.out.println("affiche marche");
        }} catch (SQLException ex) {
            System.out.println("error didn't work you bhim because you have to \n"+ex);
        }
         
            return p;
    }

    @Override
    public void Afficher_Patient(Patient p) {
       //********************************** Affichage 1 *************
    }

    @Override
    public Patient recherche_Patient(int id) {
       //********************************** recherche
          Patient p = new Patient();
       try{
           
              String req = "select * from `patient` where `cin` = '"+id+"'";
            PreparedStatement pre = db.prepareStatement(req);
      ResultSet rs = pre.executeQuery();
              while (rs.next()) 
        {  
      
      p.setCin((rs.getInt(1)));
      p.setNom(rs.getString(2));
      p.setPrenom(rs.getString(3));
      p.setDate_naissance(rs.getDate(4));
      p.setPassword(rs.getString(5));
      p.setImage(rs.getString(6));
        }
           System.out.println("Patient "+p.getNom()+" Trouvé ");
       }catch(SQLException ex){
           System.out.println("erreur de requette "+ex);
       }
       return p;
    }

  
}
