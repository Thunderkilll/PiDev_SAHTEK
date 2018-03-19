/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entite.Beaute;
import Interface_Services.IUsers;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author music
 */
public class Services_Beaute extends Services_user implements IUsers {

    @Override
    public void inscription_b(Beaute b) {
        
        try {
            String query="INSERT INTO USERS(username,password,nom,prenom,date_naiss,user_role,image_verif)"
                    + " VALUES (?,?,?,?,?,?,?)" ;
   PreparedStatement ps= con.prepareStatement(query) ;
 ps.setString(1, b.getUsername());
  ps.setString(2, b.getPassword());
   ps.setString(3, b.getNom());
    ps.setString(4, b.getPrenom());
    ps.setDate(5, new java.sql.Date(b.getDateNaissance().getTime()));
    ps.setString(6, "Beaute");
    ps.setBinaryStream(7, (InputStream)b.getImg()) ;
    
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

    @Override
    public void inscription(Entite.Users u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
