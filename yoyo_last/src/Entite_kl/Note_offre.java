/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author asus
 */
public class Note_offre {
    private int id_offre; 
   private int id_client; 
   private String note ; 

    public Note_offre(int id_offre, int id_client, String note) {
        this.id_offre = id_offre;
        this.id_client = id_client;
        this.note = note;
    }

    public Note_offre() {
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
   
   
   
   
    
}
