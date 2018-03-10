/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Entite.Categorie_centre;

/**
 *
 * @author asus
 */
public interface ICategorieCentre {
      public void modifiercategorie (Categorie_centre cat ,String nom  );
       public void ajouterCategorie (Categorie_centre cat );
        public boolean supprimerCatergorie( Categorie_centre cat ,int id);
        public Categorie_centre chercherCategorie_centre (Categorie_centre cat ,String nom) ; 
           public void afficherCategore();
           
    
}
