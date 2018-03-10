/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import DB.MyConnexion;
import Entite.Patient; 
import Entite.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Interface_Services.IUsers;
import java.sql.Connection;
import java.sql.Statement;


/**
 *
 * @author music
 */
public class Services_Patient extends Services_user implements IUsers{
    Connection con ;
    
    public Services_Patient()
    {
        con =MyConnexion.Get_Instance().getCon();
    }
    
    @Override
    public void inscription_p(Patient p) //corrige le
            
   {
        try {
            String query="INSERT INTO USERS(username,password,nom,prenom,date_naiss)"
                    + " VALUES (?,?,?,?,?)" ;
   PreparedStatement ps= con.prepareStatement(query) ;
 ps.setString(1, p.getUsername());
  ps.setString(2, p.getPassword());
   ps.setString(3, p.getNom());
    ps.setString(4, p.getPrenom());
    ps.setDate(5, new java.sql.Date(p.getDateNaissance().getTime()));
    
 if(!ps.execute() )
 {
     String query2="Select max(user_id) from users" ;
 ResultSet rs = ps.executeQuery(query2) ;
 while(rs.next())
 {
 int id = rs.getInt("MAX(USER_ID)");
 

     System.out.println("ID"+id+"'a été ajouté");}
 }
     else
 {
     System.out.println("non ajotué ");
 }
        } catch (SQLException ex) {
            Logger.getLogger(Services_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


  
    
      public static String ImageConverter(String s) {   //C:UserssamieOneDriveDocumentsSAHTEK_Patientsrcimages5.jpg
          //System.out.println(s.indexOf("Users"));
         
       String image = "C:\\xampp\\htdocs\\images\\"+s;
          System.out.println(image);
        return image;
    }

    
    public void ajouterPatient(Patient p) {
     
                    try {
                        Connection db = MyConnexion.Get_Instance().getCon();
            Statement stm= db.createStatement();
           String query = "insert into users (`username`, `nom`, `prenom`, `date_naissance`, `cin`, `email`, `password`, `telephone`, `adresse`,"
                   + " `image`, `user`) values ('"+ p.getPassword() +"','"+p.getNom()+"','"+p.getPrenom()+"','"+p.getDateNaissance()+"','"+p.getCin()+ "','"+p.getEmail()+ "','"+p.getPassword()+"'"
                   + ","+p.getTelephone()+ "','"+p.getAdresse()+ "','"+p.getImage()+ "','"+p.getStatus()+"')";
           stm.executeUpdate(query);
            System.out.println("ajout ok");
        } catch (SQLException ex) {
            System.out.println("Ajout failed "+ex);
         }
    }
    
             public void ajouterImage (Patient p , String path){
        
        
                    try {
                        Connection db = MyConnexion.Get_Instance().getCon();
                  Statement stm= db.createStatement();
                        System.out.println(p.getId_usr());
         String query = "update  users set image ='"+path+"' where `users`.`id_usr` ='"+p.getId_usr()+"';";
           stm.executeUpdate(query);
            System.out.println("ajout ok");
        } catch (SQLException ex) {
            System.out.println("Ajout failed "+ex);
         }
        
    }
                
public void supprimerPatient(Patient p) {
            try {
                Connection db = MyConnexion.Get_Instance().getCon();
            PreparedStatement prep = db.prepareStatement("delete from users where username=? and password =? ");
                prep.setString(1, p.getUsername());
                prep.setString(1, p.getPassword());
            prep.executeUpdate();
            System.out.println("supprimer done 1 \n");
        } catch (SQLException ex) {
                System.out.println("supprimer failed \n"+ex);
        }
        
        
    }
            public void supprimerPatient(int c) {
          try {
                Connection db = MyConnexion.Get_Instance().getCon();
            PreparedStatement prep = db.prepareStatement("delete from users where cin=?");
            prep.setInt(1,c);
            prep.executeUpdate();
            System.out.println("supprimer done 2 \n");
        } catch (SQLException ex) {
                System.out.println("supprimer failed \n"+ex);
        }
        
    }

@SuppressWarnings("empty-statement")
    public void updatePatient(int p1,Users p2) {
       
          try {
               Connection db = MyConnexion.Get_Instance().getCon();
            
        String sql = "UPDATE `users` SET `username`='"+p2.getUsername()+
                "',`nom`= '"+p2.getNom()+"' ,`prenom`= '"+p2.getPrenom()+"',`date_naissance`='"+
                p2.getDateNaissance()+"',`cin`='"+p2.getCin()+"',`email`= '"+p2.getEmail()+
                "' ,`password`='"+p2.getPassword()+"',`telephone`='"+p2.getTelephone()+"',`adresse`='"
                +p2.getAdresse()+"' WHERE `id_usr` ='"+p1+"';";
      
           PreparedStatement ste = db.prepareStatement(sql);
           ste.executeUpdate();
           System.out.println("update done ");
          }
          catch(SQLException ex){
              
              System.out.println("update failed "+ex);
          }
            
    
}
    
    
     public Patient recherchePatient(int id) {
      Patient p = new Patient();
       try{
           Connection db = MyConnexion.Get_Instance().getCon();
              String req = "select * from `users` where `id_usr` = '"+id+"'";
            PreparedStatement pre = db.prepareStatement(req);
      ResultSet rs = pre.executeQuery();
              while (rs.next()) 
        {  
      p.setId_usr(rs.getInt(1));
      p.setCin((rs.getInt(6)));
      p.setNom(rs.getString(3));
      p.setPrenom(rs.getString(4));
      p.setDateNaissance(rs.getDate(5));
      p.setPassword(rs.getString(8));
      p.setUsername(rs.getString(2));
      p.setEmail(rs.getString(7));
      p.setTelephone(rs.getInt(9));
      p.setAdresse(rs.getString(10));
      p.setStatus(rs.getString(12));
      p.setImage(rs.getString(11));
      
      //p.setImage(rs.getString(6));
        }
           System.out.println("Patient "+p.getNom()+" Trouvé ");
       }catch(SQLException ex){
           System.out.println("erreur de requette "+ex);
       }
       return p;
    }
        
    }

  
    

