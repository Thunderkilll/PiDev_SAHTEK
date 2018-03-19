/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;

/**
 *
 * @author khaled22
 */
public class FichePatient {
    private int id_fiche ;
    private String nom ;
    private String prenom ;
    private String maldaie ;
    private String traitement ;
    private String Diagnostique ;
    private Date date ;

    public int getId_fiche() {
        return id_fiche;
    }

    public void setId_fiche(int id_fiche) {
        this.id_fiche = id_fiche;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMaldaie() {
        return maldaie;
    }

    public void setMaldaie(String maldaie) {
        this.maldaie = maldaie;
    }

    public String getTraitement() {
        return traitement;
    }

    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }

    public String getDiagnostique() {
        return Diagnostique;
    }

    public void setDiagnostique(String Diagnostique) {
        this.Diagnostique = Diagnostique;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public FichePatient() {
    }

    public FichePatient(String nom, String prenom, String maldaie, String traitement, String Diagnostique, Date date) {
        this.nom = nom;
        this.prenom = prenom;
        this.maldaie = maldaie;
        this.traitement = traitement;
        this.Diagnostique = Diagnostique;
        this.date = date;
    }

    public FichePatient(int id_fiche, String nom, String prenom, String maldaie, String traitement, String Diagnostique, Date date) {
        this.id_fiche = id_fiche;
        this.nom = nom;
        this.prenom = prenom;
        this.maldaie = maldaie;
        this.traitement = traitement;
        this.Diagnostique = Diagnostique;
        this.date = date;
    }

    @Override
    public String toString() {
        return "FichierPatient{" + "identifiant de la fiche =" + id_fiche + "\n nom patient =" + nom + "\nprenom patient=" + prenom + "\nmaldaie = " + maldaie + "\ntraitement= " + traitement + "\n Diagnostique=" + Diagnostique + "\ndate=" + date + '}';
    }
    
    
}
