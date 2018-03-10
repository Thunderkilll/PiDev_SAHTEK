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
public class Clients extends Users {
    
    
    private int id;
    private String numcarte;

    public Clients() {
    }

    public Clients(String numcarte) {
        this.numcarte = numcarte;
    }

    public Clients(String numcarte, String nom) {
      
      
        this.numcarte = numcarte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumcarte() {
        return numcarte;
    }

    public void setNumcarte(String numcarte) {
        this.numcarte = numcarte;
    }

    @Override
    public String toString() {
        return "Clients{" + "id=" + id + ", numcarte=" + numcarte + '}';
    }
    
    
    
    
    
}
