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
public class Pharmacien extends Users {

    public Pharmacien(int id_usr, int cin, String nom, String prenom, String email, String adresse, String password, java.sql.Date dateNaissance, int telephone, String username) {
        super(id_usr, cin, nom, prenom, email, adresse, password, dateNaissance, telephone, username);
    }

    public Pharmacien(int cin, String nom, String prenom, String email, String adresse, String password, java.sql.Date dateNaissance, int telephone, String username, String status) {
        super(cin, nom, prenom, email, adresse, password, dateNaissance, telephone, username, status);
    }

    public Pharmacien(String password, String username) {
        super(password, username);
    }

    public Pharmacien(int cin, String nom, String prenom, String adresse, java.sql.Date dateNaissance, String username) {
        super(cin, nom, prenom, adresse, dateNaissance, username);
    }
   
    
}
