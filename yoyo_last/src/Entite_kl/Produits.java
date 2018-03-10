/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class Produits {
    private int réf ; 
    private String nom ;
    private double prix ; 
    private String description ; 
    private int id; 
    private int id_centre ;

    public int getId_centre() {
        return id_centre;
    } public void setId_centre(int id_centre) {
        this.id_centre = id_centre;
    } public int getId() {
        return id;
    } public void setId(int id) {
        this.id = id;
    }

    public Produits() {
    }

  
    public Produits(int id , int réf, String nom, double prix, String description) {
        this.réf = réf;
        this.id=id;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
    }

  

    public int getRéf() {
        return réf;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public void setRéf(int réf) {
        this.réf = réf;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Produits{" + "reference" + réf + ", nom=" + nom + ", prix=" + prix + ", description=" + description + '}';
    }

   
    
}
