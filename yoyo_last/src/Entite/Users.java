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
 * @author music
 */
public  class Users {
    
  
    int val_id ;
    int code ;
    private int id_usr ;           private int cin ;
    private String nom ;           private String prenom ;
    private String email ;         private String adresse ;
    private String password ;      private Date dateNaissance;
    private  int telephone;        private String username;
    String status ;                 private String role ;

    public Users() {
    }
   
    
    
    

    public Users(int id_usr, int cin, String nom, String prenom, String email, String adresse, String password, Date dateNaissance, int telephone, String username) {
        this.id_usr = id_usr;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.username = username;
    }

    public Users(int cin, String nom, String prenom, String email, String adresse, String password, Date dateNaissance, int telephone, String username, String status) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.username = username;
        this.status = status;
    }
    
    public Users(String password, String username) {
        this.password = password;
        this.username = username;
    }
    
    public Users(int cin, String nom, String prenom, String adresse, Date dateNaissance, String username) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.username = username;
    }

    public Users(String nom, String prenom, String password, Date dateNaissance, String username, String status) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.username = username;
        this.status = status;
    }
    
    
    
    

    /***************************************************************************/
    
    public void setId_usr(int id_usr) {
        this.id_usr = id_usr;
    } 

    public int getVal_id() {
        return val_id;
    }
public void setVal_id(int val_id) {
        this.val_id = val_id;
    } public int getCode() {
        return code;
    } public void setCode(int code) {
        this.code = code;
    } 
    public int getId_usr() {
        return id_usr;
    } public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    } public String getNom() {
        return nom;
    }  public void setNom(String nom) {
        this.nom = nom;
    } 
    public String getPrenom() {
        return prenom;
    }  public void setPrenom(String prenom) {
        this.prenom = prenom;
    }  public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    } public String getAdresse() {
        return adresse;
    } 
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    } public String getPassword() {
        return password;
    } public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    } public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    } public int getTelephone() {
        return telephone;
    } 
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    } public String getUsername() {
        return username;
    } public void setUsername(String username) {
        this.username = username;
    } public String getStatus() {
        return status;
    } 
    public void setStatus(String status) {
        this.status = status;
    }
   
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    /**************************************************************************************/
    
    
    
    
    
    
    @Override
    public String toString() {
        return "Users{" + "id_usr=" + id_usr + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse=" + adresse + ", password=" + password + ", dateNaissance=" + dateNaissance + ", telephone=" + telephone + ", username=" + username + ", status=" + status + '}';
    }
    
 

   
}
