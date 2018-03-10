/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Entite.Produits;

/**
 *
 * @author asus
 */
public interface IProduits {
       public void ajouterProduit (Produits pd); 
            public void modifierProduit (Produits pd,String nom  );
            public void afficherProduit(); 
             public boolean supprimerProduit(String nom );
              public Produits  chercherProduits(int réf);
              

    
   
}
