/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DB.MyConnection;
import Entite.Articles;
import Entite.Users;
import Iservices.InterfacesArticle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khaled22
 */
public class ServicesArticle  implements InterfacesArticle{
    Connection con = MyConnection.getInstance().getCon();

    public ServicesArticle() {
    
    }
    
     public boolean verifierLogin(Users u) {
                String req="SELECT email,password FROM users WHERE email=? and password=? ;";
         try {
        PreparedStatement ps=con.prepareStatement(req);
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

    @Override
    public void ajouterArticle(Users u, String title, String subtitle, String desc, String image) {
        
    if(verifierLogin(u)){
         try {
             String sql = "select `id_usr` from `users` where cin ='"+u.getCin()+"'";
                  ResultSet result ;
                   Statement ste = con.createStatement();
               result = ste.executeQuery(sql);
         while(result.next()){
                 
                  u.setId_usr(result.getInt(1));
                  System.out.println("id = "+u.getId_usr());//retourne l'id user qui est auto incrémenté dans la base
                 
              }
             
        String req1 = "INSERT INTO `articles` (`titre`, `sub_t`, `descript`, `image`, `id_user`) VALUES ('"+title+"','"+subtitle+"','"+desc+"','"+image+"','"+u.getId_usr()+"');";
      ste.executeUpdate(req1);
             System.out.println("Ajout avec succée ");
        } catch (SQLException ex) {
            Logger.getLogger(ServicesArticle.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("\nerror lors de l'ajout d'un article \n"+ex);
        }
        
    }
    
    }

    @Override
    public void deleteArticle(Users u) {
          if(verifierLogin(u)){
              try{
                  String sql = "select `id_usr` from `users` where cin ='"+u.getCin()+"'";
                  ResultSet result ;
                   Statement ste = con.createStatement();
               result = ste.executeQuery(sql);
         while(result.next()){
                 
                  u.setId_usr(result.getInt(1));
                  System.out.println("id = "+u.getId_usr());//retourne l'id user qui est auto incrémenté dans la base
                 
              }
                   PreparedStatement prep = con.prepareStatement("delete  from `articles` where id_user=?");
            prep.setInt(1,u.getId_usr());
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
    public void updateArticle(Users u, String a, String b, String c) {
            try {   
                String sql = "select `id_usr` from `users` where cin ='"+u.getCin()+"'";
                  ResultSet result ;
                   Statement ste = con.createStatement();
               result = ste.executeQuery(sql);
                  while(result.next()){
                 
                  u.setId_usr(result.getInt(1));
                  System.out.println("id = "+u.getId_usr());//retourne l'id user qui est auto incrémenté dans la base
                 
                         }
            
          String sql1 = "UPDATE `articles`  SET `titre`='" + a + "',`sub_t`='" + b +"',`descript`='"+ c+"' WHERE id_user ='" +u.getId_usr()+ "'";
      
           PreparedStatement ste1 = con.prepareStatement(sql1);
           ste1.executeUpdate();
           System.out.println("User "+u.getUsername()+"update done ");
          }
          catch(SQLException ex){
              
              System.out.println("update failed "+ex);
          }
            
      
        
    }

    @Override
    public Articles afficheArticle(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
