/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Entite.Offres;

/**
 *
 * @author asus
 */
public interface IOffres {
    public void ajouterOffres(Offres o);
     public void modifierOffres (Offres o,String nom , double prix ); 
       public void afficherOffres ();
          public boolean supprimerOffres(String nom ); 
               public Offres  chercherOffres(String nom);
               public void updateOffres(Offres o);
    
}
