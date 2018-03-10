/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entite.Articles;
import Entite.Commentaire;
import Entite.Users ;
import Interface_Services.IUsers;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author music
 */
public class Services_Medecin extends Services_user  implements IUsers {

    @Override
    public void inscription(Entite.Users u) {
     
    }
    
    @Override
    public void Ajoutercommentaire(Commentaire a)
    {
         String Query="insert into commentaire(id_user,comment,id_article) VALUES(?,?,?) " ;
         
        try {
            PreparedStatement ps = con.prepareStatement(Query) ;
            ps.setInt(1, a.getId_user());
            ps.setString(2, a.getComment());
            ps.setInt(3, a.getId_article());
            ps.executeQuery(); 
            
        } catch (SQLException ex) {
            Logger.getLogger(Services_Medecin.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("commenaire non ajouté");
        }
         
         
        
        
        
    }
    
    
}
