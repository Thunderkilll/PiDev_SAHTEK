/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;

/**
 *
 * @author asus
 */
public class Propcentre  extends Users {
 private int id_centre ; 
 
 private String diplome ; 

     

    public Propcentre () {
    }

    public Propcentre(String diplome,int id_centre ) {
        this.diplome = diplome;
        this.id_centre=id_centre; 
    }

    public int getId_centre() {
        return id_centre;
    }

    public void setId_centre(int id_centre) {
        this.id_centre = id_centre;
    }

    public Propcentre(int id_centre, String diplome, int cin, String nom, String prenom, String email, String adresse, String password, Date dateNaissance, int telephone, String username, String role) {
        super(cin, nom, prenom, email, adresse, password, dateNaissance, telephone, username, role);
        this.id_centre = id_centre;
        this.diplome = diplome;
    }

    public Propcentre(int id_centre, String diplome, int cin, String nom, String prenom, String adresse, Date dateNaissance, String username) {
        super(cin, nom, prenom, adresse, dateNaissance, username);
        this.id_centre = id_centre;
        this.diplome = diplome;
    }


    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

   


  
    
    
    
    
}

    
    
