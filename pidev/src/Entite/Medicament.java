/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.List;

/**
 *
 * @author lafa
 */
public class Medicament {
     private int id_medicament;
    private String nom_medicament;
    private double prix;
    private String nom_labo;
    
    
    
    
    public Medicament(int id_medicament, String nom_medicament,double prix, String nom_labo){
        this.id_medicament=id_medicament;
        this.nom_medicament=nom_medicament;
        this.prix =prix;
        this.nom_labo=nom_labo;
    }

    public Medicament() {
        }

    public String getNom_labo() {
        return nom_labo;
    }

    public void setNom_labo(String nom_labo) {
        this.nom_labo = nom_labo;
    }

    public int getId_medicament() {
        return id_medicament;
    }

    public String getNom_medicament() {
        return nom_medicament;
    }

    public void setId_medicament(int id_medicament) {
        this.id_medicament = id_medicament;
    }

    public void setNom_medicament(String nom_medicament) {
        this.nom_medicament = nom_medicament;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    

    @Override
    public String toString() {
        return "Servicesmedicament{" + "id_medicament=" + id_medicament + ", nom_medicament=" + nom_medicament + '}';
    }

   
    
}
