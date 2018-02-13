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
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author khaled22
 */
public class TestUserCrudes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          
        MyConnection.getInstance();
        ServicesUsers su = new ServicesUsers();
        java.util.Date myDate1 = new java.util.Date("2018/03/22");
        java.sql.Date sqlDate1 = new java.sql.Date(myDate1.getTime());
        //*********************************************************
         java.util.Date myDate2 = new java.util.Date("2018/04/12");
        java.sql.Date sqlDate2 = new java.sql.Date(myDate2.getTime());
        //*********************************************************
        java.util.Date myDate3 = new java.util.Date("2020/04/12");
        java.sql.Date sql3 = new java.sql.Date(myDate3.getTime());
        //***********************************************************
        java.util.Date myDate4 = new java.util.Date("2019/04/12");
        java.sql.Date sql4 = new java.sql.Date(myDate4.getTime());
        //*******************************************************************
           Users p3 = new Users(7777, "nom1", "prenom1", "jfdhsh", "kjhfd", "jkhjksdh",sqlDate1 , 50405012, "Skankun42", "Patient");
       
           //su.addPatient(p3);
      // su.addMedecin(m1);
        //su.addPharmacien(ph1);
       // su.addPropCentre(prop1);
           ServicesRdv rdv = new ServicesRdv();
           Rendez_vous r1 = new Rendez_vous(7777, sqlDate1, "nom1", "prenom1", 50405012, "hgfhf", sqlDate2);
           Rendez_vous r2 = new Rendez_vous(588, sqlDate2, "nom1", "prenom1", 50405012, "hgfhf", sqlDate1);
           Rendez_vous r3 = new Rendez_vous(6666, sql3, "nom1", "prenom1", 50405012, "hgfhf", sql4);
           Rendez_vous r4 = new Rendez_vous(8888, sql4, "nom1", "prenom1", 50405012, "hgfhf", sql3);
         rdv.AjouterRDV(p3,8, r1);
           rdv.AjouterRDV(p3, 8, r4);
           rdv.AjouterRDV(p3, 8, r2);
           rdv.AjouterRDV(p3, 8, r3);
          
        
    }
    
}
