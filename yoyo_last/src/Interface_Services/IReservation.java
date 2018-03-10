/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Entite.Reservation;
import Entite.Users;

/**
 *
 * @author asus
 */
public interface IReservation {
   // public void ajouterReservation(Reservation r);
     // public void ajouterProduit(Reservation r, int id_produit) ;
          public void ajouterOffreReservation(Reservation r, int id_offre);
            public void modifierReservation(Reservation r,String nom , int id ); 
             public void afficherReservation (); 
               public boolean supprimerReservation (String nom ); 
                public Reservation chercherReservation(String nom); 
                            public void afficherReservationOffreUser(Users u); 
}
