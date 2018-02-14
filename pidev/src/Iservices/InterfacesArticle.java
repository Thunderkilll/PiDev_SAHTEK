/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Entite.Articles;
import Entite.Users;

/**
 *
 * @author khaled22
 */
public interface InterfacesArticle {     
    
    public void ajouterArticle(Users u ,String title , String subtitle ,String desc ,String image );
    public void deleteArticle(Users u );
    public void updateArticle (Users u , String a, String b, String c);
    public Articles afficheArticle (int id);
    
    
    
    
}
