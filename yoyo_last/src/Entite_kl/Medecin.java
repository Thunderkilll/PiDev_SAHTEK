package Entite;

import java.sql.Date;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Medecin extends Users{
    String specialite;
    String image;
    int Num_carte_service;
    
    
    public Medecin(){
      String specialite="";
  }
   public Medecin(String password, String username) {
        super(password, username);
    }

    public Medecin(String nom, String prenom, String password, Date dateNaissance, String username, String status) {
        super(nom, prenom, password, dateNaissance, username, password) ;
        
 
    }

      @Override
    public String toString() {
       return super.toString();
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getImage() {
        return image;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getNum_carte_service() {
        return Num_carte_service;
    }

    public void setNum_carte_service(int Num_carte_service) {
        this.Num_carte_service = Num_carte_service;
    }
    

  
    @Override
    public boolean equals(Object obj) {
       return super.equals(obj);
        
    }

    @Override
    public int hashCode() {
        
        return super.hashCode();
    }
}
