/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;
import Entite.Categorie;
import Entite.Medicament;
/**
 *
 * @author lafa
 */
public interface IservicesMedicament {
  public  void ajouterMedicament(Medicament m, Categorie c);
    public void supprimerMedicament(Medicament m);
    public  Medicament chercherMedicament(String nom_medicament);
     public void afficherMedicament(Medicament m);
    public void modifierMedicament(Medicament m, String nom_medicament);
    
}
