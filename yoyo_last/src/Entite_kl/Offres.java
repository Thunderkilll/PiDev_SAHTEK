
package Entite;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author asus
 */

public class Offres {
    private int id_offre ;

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    private int id_prop; 
    private String nom ;
    private Date  date_debut;
    private Date date_fin ;
    private String description ; 
    private String prix ; 
    private int id_centre ;
        private int id_reservation ; 
    private ArrayList<Reservation> Reservations;

    public Offres(String nom) {
        this.nom = nom;
    }
    
   
   public Offres(){
        Reservations = new ArrayList<>();
   
       
   }

    public Offres(String nom, Date date_debut, Date date_fin, String description, String prix) {
        this.nom = nom;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
        this.prix = prix;
    }

    
   

    
    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getId_prop() {
        return id_prop;
    }

    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
    }


    public String getNom() {
        return nom;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public String getDescription() {
        return description;
    }

   

    public int getId_centre() {
        return id_centre;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

   

    public void setId_centre(int id_centre) {
        this.id_centre = id_centre;
    }

    @Override
    public String toString() {
        return "Offres{ ID:" + id_offre + " nom=" + nom + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", description=" + description + ", prix=" + prix + ", id_centre=" + id_centre + '}';
    }
    
    
    
}
