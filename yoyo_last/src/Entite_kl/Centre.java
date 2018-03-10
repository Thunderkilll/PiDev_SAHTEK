/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;


import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author asus
 */

public class Centre {
   private int id_centre; 
    private String nom;
    private String description;
    private String addresse ; 
    private int  telephone ; 
    private Double altitude;
    private double longitude ; 
    
      private Offres Offres;    
      private Produits Produits;  
      private int id_categorie;

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public Centre(int id_centre, String nom, String description, String addresse, int telephone) {
        this.id_centre = id_centre;
        this.nom = nom;
        this.description = description;
        this.addresse = addresse;
        this.telephone = telephone;
   
    }

    /** Centre Vide sans rien  **/

    public Centre(String nom, String description, String addresse, int telephone) {
        this.nom = nom;
        this.description = description;
        this.addresse = addresse;
        this.telephone = telephone;
    }
/*           offres dans le centre             */
    public Centre(String nom, String description, String addresse, int telephone, Produits Produits) {
        this.nom = nom;
        this.description = description;
        this.addresse = addresse;
        this.telephone = telephone;
        this.Produits = Produits;
    }
    
  /*          produits dans le centre    */

    public Centre() {
    }
         
     
    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public Centre(String s) {
 
    }

    public int getId_centre() {
        return id_centre;
    }

    public void setId_centre(int id_centre) {
        this.id_centre = id_centre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }


    public Offres getOffres() {
        return Offres;
    }

    public void setOffres(Offres Offres) {
        this.Offres = Offres;
    }

    public Produits getProduits() {
        return Produits;
    }

    public void setProduits(Produits Produits) {
        this.Produits = Produits;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Centre other = (Centre) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Centre{" + "id_centre=" + id_centre + ", nom=" + nom + ", description=" + description + ", addresse=" + addresse + ", telephone=" + telephone + ", Offres=" + Offres.toString()+ ", Produits=" + Produits.toString() + ", id_categorie=" + id_categorie + "\n'}'";
    }

    
    
   
    
    
    

}