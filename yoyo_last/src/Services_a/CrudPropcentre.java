/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





import Iservices.IPropcentre; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB.MyConnexion;
import Entite.Propcentre;

/**
 *
 * @author asus
 */
public class CrudPropcentre  implements  IPropcentre {
    
Connection conn ;

public CrudPropcentre()
{
    
    conn = MyConnexion.Get_Instance().getCon(); 
}
Services.Services_user su = new Services.Services_user();

    public void ajouterPropcentre(Propcentre p)
  {
  

      try {
       

          Statement st= conn.createStatement();
          String requete= "INSERT INTO propcentre(id_users , nom , diplome ) VALUES('" +
          p.getId_usr()+ "','"+p.getNom()+"','"+p.getDiplome()+"')";
        st.executeUpdate(requete);
          System.out.println("Propcentre ajouter");
      } catch (SQLException ex) {
        System.out.println("Ajout failed "+ex);
      }

    }

        public void modifierPropcentre (Propcentre p,String nom , int id , String diplome )
    {

        try {
                

          
            String requete = "UPDATE `utilisateurs`  set `nom`= '"+ nom + "',`diplome`= '"+ diplome  + "',s`id`=' "+id+" ' WHERE `id`=' "+p.getId_usr()+" '";
            PreparedStatement st =conn.prepareStatement(requete);
            //st.setString(1,c.getNom());
        
            st.executeUpdate();
            System.out.println("Propcentremodifier");
        } catch (SQLException ex) {
            //Logger.getLogger(CrudCentre.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("error  modifier !!  \n"+ex);
        }
    }
     public void afficherPropcentre (){
          try {
                
              String requete ="SELECT * FROM utilisateur ";
                   Statement st =conn.createStatement();
              ResultSet r = st.executeQuery(requete);
              
              while(r.next())
              {
                  System.out.println(r.getInt("id"));
                  System.out.println(r.getString("nom"));
                 
                    System.out.println(r.getString("numcarte"));
                    
                   
                  
              }
          } 
          catch (SQLException ex) {
              System.err.println("afficher erreur  "+ex);
               
          }
         
           }/*
           public void afficherPropcentre (String nom  ){
          try {
              String requete ="SELECT id from propcentre where nom="test1";
              Statement k =conn.createStatement();
              ResultSet rs= k.executeQuery(requete);
              
              while(rs.next())
              {
                  System.out.println(rs.getString(nom));
              } 
          } catch (SQLException ex) {
              Logger.getLogger(CrudPropcentre .class.getName()).log(Level.SEVERE, null, ex);
          }
}*/
            public boolean supprimerPropcentre (int id) {
                 
               try{
  
         String req = "delete from utilisateurs   WHERE `id_prop `=' "+id+"'; ";
       Statement ps = conn.prepareStatement(req);

       
       ps.executeUpdate(req);
      
                   System.out.println("propcentre  d'id = "+id+" est supp");
                    System.out.println("le prop devient simple user ");
                    
              return true;
               }
               
               catch(SQLException ex){
                   System.out.println("error lord du supp \n"+ex);
               }
               
           
               return false ;
           }
    
            public Propcentre chercherPropcentre(int id) {
    
         Propcentre prop = new Propcentre();
        try
        {
       
        String select = "SELECT * FROM utilisateurs WHERE id= '"+id+"' ";
        Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(select);
      
     
       while (result.next()) 
        {
            prop.setNom(result.getString("nom"));
            //prop.setNum(result.getInt("num"));
            //prop.setPrenom(result.getString("prenom"));     
            
            
           // prop.setPassword(result.getString("password"));
        
            //prop.setId(result.getInt("id"));
          
          
           
   
           
            
            }
            System.out.println("prop  trouvée");
        }
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
        return prop; //To change body of generated methods, choose Tools | Templates.
    }
    
                
           
}
