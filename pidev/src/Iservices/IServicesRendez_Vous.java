/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Entite.Rendez_vous;
import Entite.Users;
import java.sql.Date;

/**
 *
 * @author khaled22
 */
public interface IServicesRendez_Vous {
   public void AjouterRDV(Users p , int id_med , Rendez_vous r);
      public void AnnulerRDV(Users m ,Users p);
         public void ModifierRDV(Users u , Rendez_vous r , Date rdv);
        // public boolean ChercherRDV(String nom_med);
    
}
