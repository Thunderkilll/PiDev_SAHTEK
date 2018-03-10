/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface_Services;

import Entite.* ;

/**
 *
 * @author music
 */
public interface IUsers {
    public void inscription(Entite.Users u) ;
    public boolean validation(int id_user,int code) ;
     public void inscription_p(Patient p) ;
     public void inscription_b(Beaute b) ;
    //  public void inscription_m(Medecin m) ;
    public boolean  authentifier(String u1,String p1) ;
    public String get_role(String u1) ;
    public int Random() ;
    
    public int Id_user(String s ) ;
    public boolean check_user(String a) ;
     public String check_user_confirmation(String a) ;
      public int code_valid(int a) ;
          public void Ajoutercommentaire(Commentaire a) ;

   
    
    
}
