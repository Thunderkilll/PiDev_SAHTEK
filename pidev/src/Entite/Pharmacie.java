/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author lafa
 */
public class Pharmacie {
    private int id_pharmacie;
    private String nom_pharmacie;
    private String adresse;
   // ArrayList<Medicament> medicament ;
    private int code_postal;
    private Date horaire_travail;
    private int telephone;
    
    
public Pharmacie(int id_pharmacie,String nom_pharmacie,String adresse, int telephone,int code_postal, Date horaire_travail){

    this.id_pharmacie=id_pharmacie;
    this.nom_pharmacie=nom_pharmacie;
    this.adresse=adresse;
    //medicament =new ArrayList<>();
    this.code_postal=code_postal;
    this.horaire_travail=horaire_travail;
    this.telephone=telephone;


}
public Pharmacie(){
    
}

 

    public int getId_pharmacie() {
        return id_pharmacie;
    }

    public String getNom_pharmacie() {
        return nom_pharmacie;
    }

    public String getAdresse() {
        return adresse;
    }
/*
    public ArrayList<Medicament> getMedicament() {
        return medicament;
    }*/

    public int getCode_postal() {
        return code_postal;
    }
    public int getTelephone() {
        return telephone;
    }

    public void setId_pharmacie(int id_pharmacie) {
        this.id_pharmacie = id_pharmacie;
    }

    public void setNom_pharmacie(String nom_pharmacie) {
        this.nom_pharmacie = nom_pharmacie;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public Date getHoraire_travail() {
        return horaire_travail;
    }

    public void setHoraire_travail(Date horaire_travail) {
        this.horaire_travail = horaire_travail;
    }
    
  public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    @Override
    public String toString() {
        return "Pharmacie{" + "id_pharmacie=" + id_pharmacie + ", nom_pharmacie=" + nom_pharmacie + ", adresse=" + adresse + ", code_postal=" + code_postal + ", horaire_travail=" + horaire_travail +  ", telephone=" + telephone + '}';
    }

   
    
    
    
    
    
}
