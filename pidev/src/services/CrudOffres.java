/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DB.MyConnection;
import Entite.Offres;
import Iservices.IOffres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author asus
 */
public class CrudOffres implements IOffres{
  
  Connection conn ;
   

public CrudOffres()
{
    
    conn = MyConnection.getInstance().getCon(); 
}
    public void ajouterOffres(Offres o)
  {
  

      try {
       

          Statement st= conn.createStatement();
          String requete= "INSERT INTO offres(prix, nom , date_debut ,date_fin,description,id_centre) VALUES('" +
          o.getPrix()+ "','"+o.getNom()+"','"+o.getDate_debut()+"','"+o.getDate_fin()+"','"+o.getDescription()+"','"+o.getId_centre()+"')";
        st.executeUpdate(requete);
          System.out.println("offres ajouter");
      } catch (SQLException ex) {
        System.out.println("Ajout failed "+ex);
      }

    }

        public void modifierOffres (Offres o,String nom , double prix )
    {

        try {
                

          
            String requete = "UPDATE `offres`  set `nom`= '"+ nom + "',s`prix`=' "+prix+" ' WHERE `prix`=' "+o.getPrix()+" '";
            PreparedStatement st =conn.prepareStatement(requete);
            //st.setString(1,c.getNom());
        
            st.executeUpdate();
            System.out.println("offres modifier");
        } catch (SQLException ex) {
            //Logger.getLogger(CrudCentre.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("error  modifier !!  \n"+ex);
        }
    }
     public void afficherOffres (){
          try {
                
              String requete ="SELECT * FROM offres ";
                   Statement st =conn.createStatement();
              ResultSet r = st.executeQuery(requete);
              
              while(r.next())
              {
                  System.out.println(r.getInt("id_centre"));
                  System.out.println(r.getString("nom"));
                   System.out.println(r.getString("prix"));
                    System.out.println(r.getString("description"));
                     System.out.println(r.getInt("date_debut"));
                    System.out.println(r.getInt("date_fin"));
                   
                  
              }
          } 
          catch (SQLException ex) {
              System.err.println("afficher erreur  "+ex);
               
          }
         
           }

    /**
     *
     * @param nom
     * @return 
     * @throws java.sql.SQLException
     *//*
    public void afficherOffres (String nom  ){
          try {
              String requete ="SELECT id from offres where nom="test1";
              Statement k =conn.createStatement();
              ResultSet rs= k.executeQuery(requete);
              
              while(rs.next())
              {
                  System.out.println(rs.getString(nom));
              } 
          } catch (SQLException ex) {
              Logger.getLogger(CrudOffres .class.getName()).log(Level.SEVERE, null, ex);
          }
}

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
             public boolean supprimerOffres(String nom ) {
                 
 try{
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         String req = "delete from centre  WHERE `nom`=' "+nom+"'; ";
         String req1 = "update `users` set `nom` ='"+null+" `user`='Patient' where `nom`='"+nom+"';";
       Statement ps = conn.prepareStatement(req);
       Statement ps1 =conn.prepareStatement(req1);
       
       ps.executeUpdate(req);
         ps.executeUpdate(req1);
                   System.out.println("Le centre de nom= "+nom+" est supp");
                    System.out.println("L'utilisateur de cet nom centre devient un Patient");
                    
              return true;
               }
               catch(SQLException ex){
                   System.out.println("error lord du supp \n"+ex);
               }
               return false ;
           }    
    public Offres  chercherOffres(int nom) {
    
         Offres of = new Offres();
        try
        {
       
        String select = "SELECT * FROM offres WHERE nom = '"+nom+"' ";
        Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(select);
      
     
       while (result.next()) 
        {
            of.setNom(result.getString("nom"));
            of.setPrix(result.getDouble("prix"));
            of.setDate_debut(result.getDate("date_debut"));     
            of.setDate_fin(result.getDate("date_fin"));
            of.setDescription(result.getString("description"));
        
            of.setId_centre(result.getInt("id_centre"));
          
          
           
   
           
            
            }
            System.out.println("offre trouvée");
        }
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
        return of; //To change body of generated methods, choose Tools | Templates.
    }

  
                
                
            }
           


    

