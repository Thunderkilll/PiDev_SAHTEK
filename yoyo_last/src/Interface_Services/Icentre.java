/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Entite.Categorie_centre;
import Entite.Centre;
import Entite.Offres;
import Entite.Produits;
import Entite.Users;


/**
 *
 * @author asus
 */
public interface Icentre {
    //1
      public void ajoutercentreVide (Centre c);
//      public void ajouterProduitCentre(Centre c , Produits p);
//      public void ajouterOffreeCentre(Centre c , Offres f);
       public void modifiercentre(Users u ,String nom , String addresse);
       //4
        public void affichercentre();
        //5
        public boolean supprimerCentre(Centre c );
        //6
         public Centre chercherCentre(Users u ,String nom);
         //7
//         public void ajouterOffre (Users u ,Centre c , Offres id_offre);  c'est dans offre
//         //8
//         public void ajouterProduit (Users u ,Centre c , Produits id_produit); c'est dans produit
//         //9
      
         
    
}
