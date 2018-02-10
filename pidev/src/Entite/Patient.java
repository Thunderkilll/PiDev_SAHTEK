/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;

/**
 *
 * @author khaled22
 */
public class Patient {
        private int cin ;
    private String nom ;
    private String prenom ;
    private Date date_naissance ;
    private String password ;
    private String image ;

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
     public Patient(int cin, String nom, String prenom, Date date_naissance) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance ;
    }

    public Patient(int cin, String prenom, Date date_naissance, String password) {
        this.cin = cin;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.password = password;
    }

    public Patient(int cin, String nom, String prenom, Date date_naissance, String password, String image) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.password = password;
        this.image = image;
    }
    

    public Patient(String nom, String prenom, Date date_naissance, String password, String image) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.password = password;
        this.image = image;
    }

    public Patient(String nom, String prenom, String password, String image) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.image = image;
    }

    
    public Patient() {
        cin = 0 ;
        nom="chindoul";
        prenom ="mouldi";
        password="0000";
        image="url:= ";
    }
    
        @Override
       public String toString() {
        return " Nom : "+getNom()+" Prenom : "+getPrenom()+ " Numero CIN : "+
                getCin()+" La Date de Naissance : "+getDate_naissance()+" Le password : "+getPassword()
                +" Url Image = "+getImage();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Patient && obj != null)
        {
            Patient p =(Patient) obj ;
            if (this.getCin()== p.getCin()){
                return true  ; //si p existe déja par cin je doit le chercher 
            }
            
        }
         return false ;
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.cin;
        return hash;
    }
  
    
    
}
