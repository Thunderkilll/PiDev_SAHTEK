/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Entite.Categorie_centre;
import Entite.Centre;
import Entite.Users;

/**
 *
 * @author asus
 */
public interface Icentre {
    //1
      public void ajoutercentre (Centre c);
      //2
       public void ajouterCategories (Centre c , Categorie_centre catt ,int id_cat);
       //3
       public void modifiercentre(Users u ,String nom , String addresse);
       //4
        public void affichercentre();
        //5
        public boolean supprimerCentre(int id);
        //6
         public Centre chercherCentre(int id);
         //7
         public void ajouterOffre (Centre c , int id_offre);
         //8
         public void ajouterProduit (Centre c , int id_produit);
         //9
      
         
    
}
