/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DB.MyConnection;
import Entite.Offres;
import Entite.Produits;
import Iservices.IProduits;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author asus
 */
public class CrudProduits implements IProduits {
    
    
   
    
   Connection conn ;
   

public CrudProduits()
{
    
    conn = MyConnection.getInstance().getCon(); 
}
    public void ajouterProduit (Produits pd)
  {
  

      try {
       

          Statement st= conn.createStatement();
          String requete= "INSERT INTO produit (réf, nom , prix,description) VALUES('" +
          pd.getRéf()+ "','"+pd.getNom()+"','"+pd.getPrix()+"','"+pd.getDescription()+"')";
        st.executeUpdate(requete);
          System.out.println("Produits ajouter");
      } catch (SQLException ex) {
        System.out.println("Ajout failed "+ex);
      }

    }

        public void modifierProduit (Produits pd,String nom , int réf )
    {

        try {
                

          
            String requete = "UPDATE `produit`  set `nom`= '"+ nom + "',s`réf`=' "+réf+" ' WHERE `réf`=' "+pd.getRéf()+" '";
            PreparedStatement st =conn.prepareStatement(requete);
            //st.setString(1,c.getNom());
        
            st.executeUpdate();
            System.out.println("Produit modifier");
        } catch (SQLException ex) {
            //Logger.getLogger(CrudCentre.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("error  modifier !!  \n"+ex);
        }
    }
     public void afficherProduit(){
          try {
                
              String requete ="SELECT * FROM produit ";
                   Statement st =conn.createStatement();
              ResultSet r = st.executeQuery(requete);
              
              while(r.next())
              {
                  System.out.println(r.getInt("réf"));
                  System.out.println(r.getString("nom"));
                   System.out.println(r.getString("prix"));
                    System.out.println(r.getString("description"));
                    
                   
                  
              }
          } 
          catch (SQLException ex) {
              System.err.println("afficher erreur  "+ex);
               
          }
         
           }/*
           public void afficherProduit (String nom  ){
          try {
              String requete ="SELECT id from produit where nom="test1";
              Statement k =conn.createStatement();
              ResultSet rs= k.executeQuery(requete);
              
              while(rs.next())
              {
                  System.out.println(rs.getString(nom));
              } 
          } catch (SQLException ex) {
              Logger.getLogger(CrudProduits .class.getName()).log(Level.SEVERE, null, ex);
          }
}*/
            public boolean supprimerProduit(int id) {
                {
                 
 try{
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         String req = "delete from centre  WHERE `id`=' "+id+"'; ";
         String req1 = "update `users` set `id` ='"+null+" `user`='Patient' where `id`='"+id+"';";
       Statement ps = conn.prepareStatement(req);
       Statement ps1 =conn.prepareStatement(req1);
       
       ps.executeUpdate(req);
         ps.executeUpdate(req1);
                   System.out.println("Le produit d'id= "+id+" est supp");
                    System.out.println("le produit de cette id sera supp");
                    
              return true;
               }
               catch(SQLException ex){
                   System.out.println("error lord du supp \n"+ex);
               }
               return false ;
    }
            }
    public Produits  chercherProduits(String réf){
    
         Produits pt = new Produits();
        try
        {
       
        String select = "SELECT * FROM produit WHERE réf = '"+réf+"' ";
        Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(select);
      
     
       while (result.next()) 
        {
            pt.setNom(result.getString("nom"));
            pt.setPrix(result.getDouble("prix"));
            pt.setRéf(result.getInt("ref"));     
            
            pt.setDescription(result.getString("description"));
        
            
          
           
   
           
            
            }
            System.out.println("Produit trouvée");
        }
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
        return pt ; //To change body of generated methods, choose Tools | Templates.
    }

    
    

   
    
                 
}

    

