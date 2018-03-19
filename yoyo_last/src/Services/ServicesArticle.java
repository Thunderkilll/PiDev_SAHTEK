/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DB.MyConnexion;
import Entite.Articles;
import Entite.Users;
import Interface_Services.InterfacesArticle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.ObservableList;

/**
 *
 * @author khaled22
 */
public class ServicesArticle  implements InterfacesArticle{
    Connection db = MyConnexion.Get_Instance().getCon();
 private ObservableList<Articles> data ;
    public ServicesArticle() {
    
    }
    
     public boolean verifierLogin(Users u) {
                String req="SELECT email,password FROM users WHERE email=? and password=? ;";
         try {
        PreparedStatement ps=db.prepareStatement(req);
        ps.setString(1, u.getEmail());
        ps.setString(2, u.getPassword());
        
        ResultSet rs=ps.executeQuery();
             
             
            if(rs.next()){
                String s1=rs.getString(1);
                 String s2=rs.getString(2);
                 
              //  System.out.println(s1+s2);
             }
        System.out.println("conexion validé");
        return true ;
         } catch (SQLException ex) {
            
             System.out.println("\nconnexion didn't pass "+ex);
        }
    
    return false;
    }
   
          public static String ImageConverter(String s) {   //C:UserssamieOneDriveDocumentsSAHTEK_Patientsrcimages5.jpg
          //System.out.println(s.indexOf("Users"));
         
       String image = "C:\\xampp\\htdocs\\images\\"+s;
          System.out.println(image);
        return image;
    }


    @Override
    public void ajouterArticle( Users i  ,Articles a) {
        
    if(verifierLogin(i)){
         try {
             
                   Statement ste = db.createStatement();
               String req1 = "INSERT INTO `articles` (`titre`, `sub_t`, `descript`, `image` , `id_user`) VALUES ('"+a.getTitre()+"','"+a.getSub_t()+"','"+a.getDescript()+"','"+a.getImage()+"','"+i.getId_usr()+"');";
                          
               ste.executeUpdate(req1);
        
              System.out.println("ajouté !!");
               }
       catch (SQLException ex) {
            Logger.getLogger(ServicesArticle.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("\nerror lors de l'ajout d'un article \n"+ex);
        }
        
    }
        
   // }
    
    }

   @Override
    public void deleteArticle(Users u , int id_article) {
          if(verifierLogin(u)){
              try{
                  String sql = "select `id_usr` from `users` where cin ='"+u.getCin()+"'";
                  ResultSet result ;
                   Statement ste = db.createStatement();
               result = ste.executeQuery(sql);
         while(result.next()){
                 
                  u.setId_usr(result.getInt(1));
                  System.out.println("id = "+u.getId_usr());//retourne l'id user qui est auto incrémenté dans la base
                 
              }
                   PreparedStatement prep = db.prepareStatement("delete  from `articles` where id_user=? and id_article=?");
            prep.setInt(1,u.getId_usr());
            prep.setInt(2, id_article);
            prep.executeUpdate();
            System.out.println("supprimer done 2 \n");
        } catch (SQLException ex) {
                System.out.println("supprimer failed \n"+ex);
        }
        
        
          }
          else{
              System.out.println("the User :"+u.getUsername()+"don't have an accout");
          }
    }

  @Override
    public void updateArticle(int t , Articles b) {
            try {   
               
          String sql1 = "UPDATE `articles`  SET `titre`='" + b.getTitre() + "',`sub_t`='" + b.getSub_t() +"',`descript`='"+b.getDescript()+"',image='"+b.getImage()+"' WHERE id_article ='" +t+ "'";
      
           PreparedStatement ste1 = db.prepareStatement(sql1);
           ste1.executeUpdate();
           System.out.println("L'article : "+b.getTitre()+" is updated");
          }
          catch(SQLException ex){
              
              System.out.println("update failed "+ex);
              System.out.println("\n or id doesn't exist ");
          }
            
      
        
    }

@Override
    public ArrayList<Articles> afficheArticle(int id) {
                 ArrayList<Articles> articles = new ArrayList<>();
         
               try {
                      String sql = " SELECT * from articles where id_user ='"+id+"';";
                ResultSet result ;
                       Statement ste = db.createStatement();
        result = ste.executeQuery(sql);
     while(result.next()){
            Articles p2 = new Articles();
            p2.setId(result.getInt(1));
            p2.setTitre(result.getString(2));
            p2.setSub_t(result.getString(3));
            p2.setDescript(result.getString(4));
            p2.setImage(result.getString(5));
            p2.setId_user(result.getInt(6));
        
          articles.add(p2);
         System.out.println("liste remplit ");
     }
        } catch (SQLException e) {
                System.out.println("error is \n"+e);
        }

     return articles ;
    
    
    }
  @Override
    public Articles rechercheArticle(int id) {
      Articles p = new Articles();
       try{
           Connection db = MyConnexion.Get_Instance().getCon();
              String req = "select * from `articles` where `id_article` = '"+id+"'";
            PreparedStatement pre = db.prepareStatement(req);
            ResultSet rs = pre.executeQuery();
              while (rs.next()) 
        {  
    p.setId(rs.getInt(1));
    p.setTitre(rs.getString(2));
    p.setSub_t(rs.getString(3));
    p.setDescript(rs.getString(4));
      p.setImage(rs.getString(5));
      //p.setImage(rs.getString(6));
        }
           System.out.println("Article  de titre "+p.getTitre()+" Trouvé ");
       }catch(SQLException ex){
           System.out.println("erreur de requette "+ex);
       }
       return p;
    }
        public ArrayList<Articles> afficheAll() {
                 ArrayList<Articles> articles = new ArrayList<>();
         
               try {
                      String sql = " SELECT * from articles where 1;";
                ResultSet result ;
                       Statement ste = db.createStatement();
        result = ste.executeQuery(sql);
     while(result.next()){
            Articles p2 = new Articles();
            p2.setId(result.getInt(1));
            p2.setTitre(result.getString(2));
            p2.setSub_t(result.getString(3));
            p2.setDescript(result.getString(4));
            p2.setImage(result.getString(5));
            p2.setId_user(result.getInt(6));
        
          articles.add(p2);
         System.out.println("liste remplit ");
     }
        } catch (SQLException e) {
                System.out.println("error is \n"+e);
        }

     return articles ;
    
    
    }
    
        public int rechercheUserQuestion(int id_article){
            int i =  0;
            try {
                String select = "select id_user from articles where id_article='"+id_article+"';";
             PreparedStatement pre = db.prepareStatement(select);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
              return i = rs.getInt(1);
                
            }  
            } catch (Exception e) {
                System.out.println("error in selec id_user frm articles\n"+e);
            }
          
            
            return i;
        }
        public ObservableList<Articles> ARTICLES() {
                 
         
               try {
                      String sql = " SELECT * from articles where 1;";
                ResultSet result ;
                       Statement ste = db.createStatement();
        result = ste.executeQuery(sql);
     while(result.next()){
            Articles p2 = new Articles();
            p2.setId(result.getInt(1));
            p2.setTitre(result.getString(2));
            p2.setSub_t(result.getString(3));
            p2.setDescript(result.getString(4));
           // p2.setImage(result.getString(5));
            p2.setId_user(result.getInt(6));
        
          data.add(p2);
         System.out.println("liste remplit ");
     }
        } catch (SQLException e) {
                System.out.println("error is \n"+e);
        }

     return data ;
    
    
    }
} 









