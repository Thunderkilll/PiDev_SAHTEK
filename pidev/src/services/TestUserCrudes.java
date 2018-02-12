/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DB.MyConnection;
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
        java.util.Date myDate1 = new java.util.Date("10/10/2099");
           
       
      // su.addMedecin(m1);
        //su.addPharmacien(ph1);
       // su.addPropCentre(prop1);
        
    }
    
}
