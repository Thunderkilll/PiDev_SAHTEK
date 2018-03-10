/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.io.FileInputStream;
import java.util.Date;

/**
 *
 * @author music
 */
public class Beaute extends Users {
    FileInputStream img; 

   
    

    public FileInputStream getImg() {
        return img;
    }

    public void setImg(FileInputStream img) {
        this.img = img;
    }

    public Beaute(FileInputStream img, String nom, String prenom, String password, java.sql.Date dateNaissance, String username, String status) {
        super(nom, prenom, password, dateNaissance, username, status);
        this.img = img;
    }
    
}
