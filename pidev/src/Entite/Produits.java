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

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }
    private int id_reservation ; 
      private ArrayList<Reservation> Reservations;

    public Produits(int réf, String nom, double prix, String description) {
        this.réf = réf;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
    }

    public Produits() {
        Reservations = new ArrayList<>();
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
        return "Produits{" + "r\u00e9f=" + réf + ", nom=" + nom + ", prix=" + prix + ", description=" + description + '}';
    }

   
    
}
