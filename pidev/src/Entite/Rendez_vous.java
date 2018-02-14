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
public class Rendez_vous {
    private int id_rdv;
    private int cin ;                      private Date dateNaissance;
    private String nom ;                   private String prenom ;
    private int telephone;                 private String adresse ;
    private Date date_reservation;         private int id_medecin ; 
    //constructeur objet rendez-vous
      //1- constructeur par defaut

    public Rendez_vous() {
    }

    public Rendez_vous(int cin, Date dateNaissance, String nom, String prenom, int telephone, String adresse, Date date_reservation) {
        this.cin = cin;
        this.dateNaissance = dateNaissance;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.date_reservation = date_reservation;
    }

    public Rendez_vous(int cin, Date dateNaissance, String nom, String prenom, int telephone, String adresse, Date date_reservation, int id_medecin) {
        this.cin = cin;
        this.dateNaissance = dateNaissance;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.date_reservation = date_reservation;
        this.id_medecin = id_medecin;
    }

    public int getCin() {
        return cin;
    }                   public void setCin(int cin) {
        this.cin = cin;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }        public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNom() {
        return nom;
    }                public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }             public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getTelephone() {
        return telephone;
    }             public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }            public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDate_reservation() {
        return date_reservation;
    }     public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

    public int getId_medecin() {
        return id_medecin;
    }            public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
    }

    public int getId_rdv() {
        return id_rdv;
    }                public void setId_rdv(int id_rdv) {
        this.id_rdv = id_rdv;
    }
    

    @Override
    public String toString() {
        return  "Rendez-vous{nom patient :"+nom+"\t prenom patient : "+prenom+"\n cin patiennt : "+cin+"\t date naissance du patient : "+dateNaissance+"\ntelephone du patient : "
                +telephone+"\t adresse : "+adresse+"\n Date Reservation du rendez_vous :"+date_reservation;
                
    }
    
    
    
    
    
    
    
}
