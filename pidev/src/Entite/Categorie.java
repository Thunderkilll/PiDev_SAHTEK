/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

<<<<<<< Updated upstream
=======
<<<<<<< master
import java.util.ArrayList;

=======
>>>>>>> ajouter mes classe
>>>>>>> Stashed changes
/**
 *
 * @author lafa
 */
public class Categorie {
   private int id_categorie;
   private String nom_categorie;
<<<<<<< Updated upstream
=======
<<<<<<< master
   ArrayList<Medicament> medicament ;
=======
>>>>>>> ajouter mes classe
>>>>>>> Stashed changes
    

    public Categorie(int id_categorie, String nom_categorie) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
<<<<<<< Updated upstream
    }

    public Categorie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
=======
<<<<<<< master
        medicament =new ArrayList<>();
    }

    public Categorie() {
        }
=======
    }

    public Categorie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
>>>>>>> ajouter mes classe
>>>>>>> Stashed changes

    public int getId_categorie() {
        return id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id_categorie=" + id_categorie + ", nom_categorie=" + nom_categorie + '}';
    }
   
   
   
   
   
    
}
