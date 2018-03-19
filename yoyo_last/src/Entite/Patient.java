/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Date ;

/**
 *
 * @author music
 */
public class Patient extends Users {
 int id_article ;
    String image ;
  
 //ArrayList <Articles> a ;
 
    public Patient() {
        
        id_article = 0;
        image="\\SAHTEK_Patient\\src\\images\\profil_png.png";
        //a = new ArrayList<>(); ;
  
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Patient( String nom, String prenom, String password, java.sql.Date dateNaissance, String username, String status) {
        super(nom, prenom, password, dateNaissance, username, status);
      
    }

    
    
    public Patient(String password, String username) {
        super(password, username);
    }

    public Patient(String image, int id_usr, int cin, String nom, String prenom, String email, String adresse, String password, java.sql.Date dateNaissance, int telephone, String username) {
        super(id_usr, cin, nom, prenom, email, adresse, password, dateNaissance, telephone, username);
        this.image = image;
    }

    public Patient(String image, int cin, String nom, String prenom, String email, String adresse, String password, java.sql.Date dateNaissance, int telephone, String username, String status) {
        super(cin, nom, prenom, email, adresse, password, dateNaissance, telephone, username, status);
        this.image = image;
    }

    public Patient(String image, String password, String username) {
        super(password, username);
        this.image = image;
    }



    
    

    @Override
    public String toString() {
       return super.toString()+"URL IMAGE = "+image;
    }
    

}
