/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import DB.MyConnexion ;
import Entite.Validation_V ;
import Interface_Services.Validation ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author parasol
 */
public class Services_Validation implements Validation {
    Connection con ;
    
    public Services_Validation()
    {
        
        con = MyConnexion.Get_Instance().getCon();
    }
    
   

    @Override
    public void create(Validation_V v) {
       String Q1="INSERT INTO `tmp_validation` (`user_id`, `validation_id`, `code`) VALUES (?, NULL, ?)" ;
      
     
       
       
        try {
            PreparedStatement ps= con.prepareStatement(Q1 );
            
            
            ps.setInt(1,v.getValid_id() );
            ps.setInt(2,v.getCode());
            
         ps.execute() ;
            
            
             
            
        } catch (SQLException ex) {
            Logger.getLogger(Services_Validation.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
               
    }
   

   
    
}
