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
public class Users {
    private int id_usr ;           private int cin ;
    private String nom ;           private String prenom ;
    private String email ;         private String adresse ;
    private String password ;      private Date dateNaissance;
    private  int telephone;        private String username;
    private int num_carte_serv ;   private int id_f ;
    private int id_centre ;        private int id_pharmacie;
    private  String user;          private static Users connectUser;

           //user type 1 : patient or normal user centre de notre projet 
    public Users(int cin, String nom, String prenom, String email, String adresse, String password, Date dateNaissance, int telephone, String username, String user) {   
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;   
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.username = username;
        this.user = user;
    }

    //user type 2 : medecin
    //user type 3 : pharmacien
    public Users(int cin, String nom, String prenom, String email, String adresse, String password, Date dateNaissance, int telephone, String username, int num_carte_serv, int id_f, int id_centre, int id_pharmacie, String user) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.username = username;
        this.num_carte_serv = num_carte_serv;
        this.id_f = id_f;
        this.id_centre = id_centre;
        this.id_pharmacie = id_pharmacie;
        this.user = user;
    }

    //constructeur par default :
    public Users() {    
    }

    //Login  du users :
//    public Users(String password, String username) {
//        this.password = password;
//        this.username = username;
//    }

    //getters et setters
    public int getCin() {
        return cin;
    }                public void setCin(int cin) {
        this.cin = cin;
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

    public String getEmail() {
        return email;
    }              public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }            public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPassword() {
        return password;
    }           public void setPassword(String password) {
        this.password = password;
    }
    
    public Date getDateNaissance() {
        return dateNaissance;
    }      public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getTelephone() {
        return telephone;
    }             public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }           public void setUsername(String username) {
        this.username = username;
    }

    public int getNum_carte_serv() {
        return num_carte_serv;
    }        public void setNum_carte_serv(int num_carte_serv) {
        this.num_carte_serv = num_carte_serv;
    }

    public int getId_f() {
        return id_f;
    }                  public void setId_f(int id_f) {
        this.id_f = id_f;
    }

    public int getId_centre() {
        return id_centre;
    }             public void setId_centre(int id_centre) {
        this.id_centre = id_centre;
    }

    public int getId_pharmacie() {
        return id_pharmacie;
    }          public void setId_pharmacie(int id_pharmacie) {
        this.id_pharmacie = id_pharmacie;
    }

    public String getUser() {
        return user;
    }               public void setUser(String user) {
        this.user = user;
    }

    public static Users getConnectUser() {
        return connectUser;
    }  public static void setConnectUser(Users connectUser) {
        Users.connectUser = connectUser;
    }

    @Override
    public String toString() {
        return "usr{user id :"+id_usr+
                "\ncarte identité nationale : "+cin+
                " \tnom :"+nom +
                " \nprenom :"+prenom+
                " \temail :"+email+
                " \nadresse"+adresse+
                " \tpassword :"+password+
                " \ndateNaissance :"+dateNaissance+
                " \ttelephone :"+telephone+
                "username :"+username+
                "numero de carte service : "+num_carte_serv+
                "identifiant formulaire :"+id_f+
                "identifiant du centre : "+id_centre+
                "identifiant du pharmacie :"+id_pharmacie+
                "role : "+user+"}";
    }

    

    
    
}
