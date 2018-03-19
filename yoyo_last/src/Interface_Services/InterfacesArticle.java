/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface_Services;

import Entite.Articles;
import Entite.Users;
import java.util.ArrayList;

/**
 *
 * @author khaled22
 */
public interface InterfacesArticle {     
    
 public void ajouterArticle( Users i  ,Articles a);
 public void deleteArticle(Users u , int id_article);
 public void updateArticle(int t , Articles b);
 public ArrayList<Articles> afficheArticle(int id);
 public Articles rechercheArticle(int id);
    
    
}
