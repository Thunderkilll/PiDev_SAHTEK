

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services ;

import DB.MyConnection;
import Entite.Categorie_centre;
import Entite.Centre;
import Entite.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





/**
 *
 * @author USER
 */


    /**
     *  
     */





public class CrudCentre implements Iservices.Icentre{

 
Connection conn ;
   

public CrudCentre()
{
    
    conn = MyConnection.getInstance().getCon(); 
}
@Override
    public void ajoutercentre (Centre c)
  {
  

      try {
       

          Statement st= conn.createStatement();
          
          String requete= "INSERT INTO centre (adresse ,telephone , nom ,categories,description ) VALUES('" +
       c.getNom()+"','"+c.getAddresse()+"','"+c.getDescription()+"','"+c.getCategories()+"')";
        st.executeUpdate(requete);
          System.out.println("centre ajouter");
      } catch (SQLException ex) {
        System.out.println("Ajout failed "+ex);
      }

    }

@Override
        public void modifiercentre(Users u,String nom , String addresse)
    {

        try {
                

          
            String requete = "UPDATE `centre`  set `nom`= '"+ nom + "',adresse =' "+addresse+" ' WHERE `id_centre`=' "+u.getId_centre()+" '";
            PreparedStatement st =conn.prepareStatement(requete);
            //st.setString(1,c.getNom());
        
            st.executeUpdate();
            System.out.println("centre modifier");
        } catch (SQLException ex) {
            //Logger.getLogger(CrudCentre.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("error  modifier !!  \n"+ex);
        }
    }




         
@Override
           public boolean supprimerCentre(int id)
           {
               try{
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         String req = "delete from centre  WHERE `id_centre`=' "+id+"'; ";
         String req1 = "update `users` set `id_centre` ='"+null+" `user`='Patient' where `id_centre`='"+id+"';";
       Statement ps = conn.prepareStatement(req);
       Statement ps1 =conn.prepareStatement(req1);
       
       ps.executeUpdate(req);
         ps.executeUpdate(req1);
                   System.out.println("Le centre d'id = "+id+" est supp");
                    System.out.println("L'utilisateur de cet id centre devient un Patient");
                    
              return true;
               }
               catch(SQLException ex){
                   System.out.println("error lord du supp \n"+ex);
               }
               return false ;
           }
           
           
           //recherche 
@Override
           public Centre chercherCentre(int id) {
    
         Centre ce = new Centre();
        try
        {
       
        String select = "SELECT * FROM centre WHERE id_centre = '"+id+"' ";
        Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(select);
      
     
       while (result.next()) 
        {
            ce.setId_centre(result.getInt("id_centre"));
            ce.setAddress(result.getString("adresse"));
            ce.setDescription(result.getString("description"));     
            ce.setNom(result.getString("nom"));
           
           
            }
            System.out.println("centre trouvée");
        }
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
        return ce; //To change body of generated methods, choose Tools | Templates.
           }
           
           



    @Override
    public void ajouterOffre(Centre c, int id_offre) {
        
      try {
        Statement st= conn.createStatement();
          
          String requete= "INSERT INTO centre id_offre ='"+id_offre+"' where id_centre='"+c.getId_centre()+"';";
        st.executeUpdate(requete);
          System.out.println("offre ajouter");
      } catch (SQLException ex) {
        System.out.println("Ajout failed "+ex);
      }
        
        
    }

    @Override
    public void ajouterProduit(Centre c, int id_produit) {
           try {
        Statement st= conn.createStatement();
          
          String requete= "INSERT INTO centre id_produit ='"+id_produit+"' where id_centre='"+c.getId_centre()+"';";
        st.executeUpdate(requete);
          System.out.println("produit ajouter");
      } catch (SQLException ex) {
        System.out.println("Ajout failed "+ex);
      }
        
        
          }



    @Override
    public void affichercentre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
   
@Override
    public void ajouterCategories(Centre c, Categorie_centre catt,int id_cat) {
       try {
        Statement st= conn.createStatement();
          
          String requete= "select count(*) from categorie_centre right join centre on id_centre where id_centre='"+c.getId_centre();
          String requete2="INSERT INTO centre (id_categories , nom_categ ) values('" +
          catt.getId_categorie()+ "','"+catt.getNom_categ()+"')" ;
       ResultSet set= st.executeQuery(requete);
       
       if (set.next())
       {
           
           st.executeUpdate(requete2) ;
           
       }
       
       else {
           System.out.println("existe  ");
           
       }
      
        
        
      } catch (SQLException ex) {
        System.out.println("Ajout failed "+ex);
      }
        
    }
}

    

    
                
           
         
    