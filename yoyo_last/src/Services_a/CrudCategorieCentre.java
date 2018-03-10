/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;



import DB.MyConnexion;
import Entite.Categorie_centre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.SQLException;
import java.util.ArrayList;



public class CrudCategorieCentre implements Iservices.ICategorieCentre{

 
Connection conn ;
   

public CrudCategorieCentre()
{
    
    conn = MyConnexion.Get_Instance().getCon(); 
}

    
    
@Override
     public void ajouterCategorie (Categorie_centre cat )
  {
     
  


      try {
       

          Statement st= conn.createStatement();
          
          String requete= "INSERT INTO categorie_centre (`id_categorie`,`nom_categ` ) VALUES('"+cat.getId_categorie()+"','"+cat.getNom_categ()+"');";
        st.executeUpdate(requete);
          System.out.println("categorie ajouter ");
      }
      catch (SQLException ex) {
        System.out.println("ajout failed "+ex);
      }
      }
    

@Override
        public void modifiercategorie (Categorie_centre cat ,String nom  )
    {

        try {
            
            String requete = "UPDATE `categorie_centre`  set `nom_categ`= '"+ nom + "  ' WHERE `id_categorie`=' "+cat.getId_categorie()+" '";
            PreparedStatement st =conn.prepareStatement(requete);
            
        
            st.executeUpdate();
            System.out.println("categorie modifier");
        } catch (SQLException ex) {
          
              System.out.println("error  modifier !!  \n"+ex);
        }
    }
    


         
@Override
           public boolean supprimerCatergorie( Categorie_centre cat ,int id)
           {
              
               try{
  
         String req = "delete from Categorie_centre  WHERE `id_categorie`=' "+id+"'; ";
       Statement ps = conn.prepareStatement(req);

       
       ps.executeUpdate(req);
      
                   System.out.println("Le Categorie_centre d'id = "+id+" est supp");
                   
                    
              return true;
               }
               
               catch(SQLException ex){
                   System.out.println("error lord du supp \n"+ex);
               }
               
           
               return false ;
           }
           
           //recherche 
@Override
           public Categorie_centre chercherCategorie_centre (Categorie_centre cat ,String nom) {  /// un seul centre
    
         Categorie_centre ce = new Categorie_centre();
          //if(su.verifierLogin(u)){
        try
        {
       
        String select = "SELECT * FROM categorie_centre WHERE nom_categ = '"+nom+"' ";
        Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(select);
      
     
      
       while (result.next()) 
        {
            ce.setId_categorie(result.getInt("id_categorie"));
           
            ce.setNom_categ(result.getString("nom_categ"));
           
        
         
           
            }
            System.out.println("categorie trouvée");
        }
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
        //  }
        return ce; //To change body of generated methods, choose Tools | Templates.
           }
           
           



  
        
        
    

  
      
        
        
          



@Override
    public void afficherCategore() {
       
    
      try
        {
       
        String select = "SELECT * FROM Categorie_centre  ";
        Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(select);
      
     
       while (result.next()) 
        {
            System.out.println("Nom_categ "+result.getString("nom_categ"));
            System.out.println(" ");
            System.out.println("");
            System.out.println("");
            System.out.println("");
           
            }
            System.out.println("categorie trouvée");
        }
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }

    }
    public ArrayList<Categorie_centre> affichecatego(int id) {
                 ArrayList<Categorie_centre> cat = new ArrayList<>();
         
               try {
                      String sql = " SELECT * from categorie_centre where id_categorie='"+id+"';";
                ResultSet result ;
                       Statement ste = conn.createStatement();
        result = ste.executeQuery(sql);
     while(result.next()){
            Categorie_centre c = new   Categorie_centre();
            c.setId_categorie(result.getInt(1));
            c.setNom_categ(result.getString(2));
            
        
          cat.add(c);
         System.out.println("liste remplit ");
     }
        } catch (SQLException e) {
                System.out.println("error is \n"+e);
        }

     return cat ;
    
    
    }

}