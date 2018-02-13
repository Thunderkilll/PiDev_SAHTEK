/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Entite.Categorie;

/**
 *
 * @author lafa
 */
public interface IservicesCategorie {
     public  void ajouterCategorie(Categorie c);
    public void supprimerCategorie(Categorie c);
    public  Categorie chercherCategorie(String nom_categorie);
     public void afficherCategorie(Categorie c);
    public void modifierCategorie(Categorie c, String nom_categorie);
}
