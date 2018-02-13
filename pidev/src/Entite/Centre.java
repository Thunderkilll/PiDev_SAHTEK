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

public class Centre {
   private int id_centre; 
    private String nom;
  
    private String description;
    private String addresse ; 
    private ArrayList<Offres> Offres;      private int id_offre ;
     private ArrayList<Offres> Produits;    private int id_produit ;
    private String categories; 

    public String getCategories() {
        return categories;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
    

    public Centre() {
        Offres = new ArrayList<>();
         Produits = new ArrayList<>();
        
    }

    public Centre(int id_centre, String nom, String description, String addresse, ArrayList<Offres> Offres, ArrayList<Offres> Produits, String categories) {
        this.id_centre = id_centre;
        this.nom = nom;
        this.description = description;
        this.addresse = addresse;
        this.Offres = Offres;
        this.Produits = Produits;
        this.categories = categories;
    }

    
        //ajouter centre sans produits et sans offres
    public Centre(String nom, String description, String addresse, int id_offre, int id_produit, String categories) {
        this.nom = nom;
        this.description = description;
        this.addresse = addresse;
        this.id_offre = id_offre;
        this.id_produit = id_produit;
        this.categories = categories;
    }
            //ctor avec id_offre
    public Centre(String nom, String description, String addresse, int id_offre, String categories) {
        this.nom = nom;
        this.description = description;
        this.addresse = addresse;
        this.id_offre = id_offre;
        this.categories = categories;
    }
                //ctor avec id_produit
    public Centre(String nom, String description, String addresse, ArrayList<Offres> Offres, int id_produit, String categories) {
        this.nom = nom;
        this.description = description;
        this.addresse = addresse;
        this.Offres = Offres;
        this.id_produit = id_produit;
        this.categories = categories;
    }
     
      
    

    public int getId_centre() {
        return id_centre;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setId_centre(int id_centre) {
        this.id_centre = id_centre;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String addresse) {
        this.addresse = addresse;
    }

    @Override
    public String toString() {
        return "Centre{" + "id_centre=" + id_centre + ", nom=" + nom + ", description=" + description + ", addresse=" + addresse + ", Offres=" + Offres + ", Produits=" + Produits + ", categories=" + categories + '}';
    }
}
  