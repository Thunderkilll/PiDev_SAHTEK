/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.logging.Logger;

/**
 *
 * @author lafa
 */
public class Pharmacien {
    private int id;
    private String nom;
    private String prenom;
    private int num_carte_sev;
    
    
    
    public Pharmacien (int id,String nom,String prenom, int num_carte_sev){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.num_carte_sev=num_carte_sev;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNum_carte_sev() {
        return num_carte_sev;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNum_carte_sev(int num_carte_sev) {
        this.num_carte_sev = num_carte_sev;
    }

    @Override
    public String toString() {
        return "Pharmacien{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", num_carte_sev=" + num_carte_sev + '}';
    }
    
    
    
    
    
    
}
