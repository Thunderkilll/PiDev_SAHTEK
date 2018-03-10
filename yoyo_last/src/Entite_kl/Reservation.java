/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author asus
 */
public class Reservation {
    private int id ; 
    private Date date_reservation ; 
    private int nbjours; 
    private  String nom;  //nom offre reservé
    private Users user ;
    private Offres id_offre ;
    private String nom_user;
    private String prenom_user ;
    private int cin_user ;
    private int tel_user ;
     private String email ;

    public Reservation() {
        nbjours=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public int getCin_user() {
        return cin_user;
    }

    public void setCin_user(int cin_user) {
        this.cin_user = cin_user;
    }

    public int getTel_user() {
        return tel_user;
    }

    public void setTel_user(int tel_user) {
        this.tel_user = tel_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  

    public Date getDate_reservation() {
        return date_reservation;
    } public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

    public int getNbjours() {
        return nbjours;
    } public void setNbjours(int nbjours) {
        this.nbjours = nbjours;
    }

    public String getNom() {
        return nom;
    } public void setNom(String nom) {
        this.nom = nom;
    }  public Users getUser() {
        return user;
    }  public void setUser(Users user) {
        this.user = user;
    }

    public Offres getId_offre() {
        return id_offre;
    }

    public void setId_offre(Offres id_offre) {
        this.id_offre = id_offre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.user);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservation other = (Reservation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", date_reservation=" + date_reservation + ", nbjours=" + nbjours + ", nom=" + nom + ", user=" + user + ""
                + ", l'identifiant de l'offre =" + id_offre.getId_offre() + "\n'}'";
    }

    
    
    
  
    
    
}
