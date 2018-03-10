/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DB.MyConnexion;
import Entite.Centre;
import Entite.Offres;
import Entite.Produits;
import Iservices.IProduits;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author asus
 */
public class CrudProduits implements IProduits {
    
    
   
    
   Connection conn ;
   private int x;
    private Statement ste;
   

public CrudProduits()
{
    
    conn = MyConnexion.Get_Instance().getCon(); 
}
   @Override
    public void ajouterProduit (Produits pd)
  {
  
      try {
         

          Statement st= conn.createStatement();
          String requete= "INSERT INTO produit(reference, nom , prix,descr_produit,id_centre) VALUES('" +
          pd.getRéf()+ "','"+pd.getNom()+"','"+pd.getPrix()+"','"+pd.getDescription()+"','"+pd.getId_centre()+"')";
        st.executeUpdate(requete);
          System.out.println("Produit ajouter");
      } catch (SQLException ex) {
        System.out.println("Ajout failed "+ex);
      }

    }
@Override
        public void modifierProduit (Produits pd,String nom )
    {

        try {
                

          
            String requete = "UPDATE `produit` SET `id_produit`='"+pd.getId()+"'`reference`='"+pd.getRéf()+"',`nom`='"+pd.getNom()+"',`prix`='"+pd.getPrix()+"',`descr_produit`='"+pd.getDescription()+" ' WHERE `nom`=' "+nom+"';";
            PreparedStatement st =conn.prepareStatement(requete);
            //st.setString(1,c.getNom());
        
            st.executeUpdate();
            System.out.println("Produit modifier");
        } catch (SQLException ex) {
      
              System.out.println("error  modifier !!  \n"+ex);
        }
    }
        
   @Override
     public void afficherProduit(){
         CrudCentre c = new CrudCentre();
          try {
                
              String requete ="SELECT * FROM produit ";
                   Statement st =conn.createStatement();
              ResultSet r = st.executeQuery(requete);
              
              while(r.next())
              {
                  System.out.println(r.getInt("reference")+"\n");
                  System.out.println(r.getString("nom")+"\n");
                   System.out.println(r.getString("prix"));
                    System.out.println(r.getString("descr_produit"));
                    int id_centre = r.getInt("id_centre");
                   Centre centre = c.chercherCentreParId(id_centre);
                   System.out.println("\n"+centre.toString()+"\n");
                   
                  
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
   @Override
            public boolean supprimerProduit(String nom ) {
                {
                 
 try{
    
         String req = "delete from produit  WHERE `nom`=' "+nom+"'; ";
         
       Statement ps = conn.prepareStatement(req);

       
       ps.executeUpdate(req);
   
                   System.out.println("Le produit d'id= "+nom+" est supp");
                 
                    
              return true;
               }
               catch(SQLException ex){
                   System.out.println("error lord du supp \n"+ex);
               }
               return false ;
    }
            }
   @Override
    public Produits  chercherProduits(int réf){
    
         Produits pt = new Produits();
        try
        {
       
        String select = "SELECT * FROM produit WHERE reference = '"+réf+"' ";
        Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(select);
      
     
       while (result.next()) 
        {
            pt.setNom(result.getString("nom"));
            pt.setPrix(result.getDouble("prix"));
            pt.setRéf(result.getInt("reference"));     
            
            pt.setDescription(result.getString("descr_produit"));
        
            
          
           
   
           
            
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

   

    public ArrayList<Produits> afficheproduits(int id) {
                 ArrayList<Produits> pdt = new ArrayList<>();
         
               try {
                      String sql = " SELECT * from produit where id_produit='"+id+"';";
                ResultSet result ;
                       Statement ste = conn.createStatement();
        result = ste.executeQuery(sql);
     while(result.next()){
            Produits prod = new   Produits();
            prod.setId(result.getInt(1));
            prod.setRéf(result.getInt(2));
            prod.setNom(result.getString(3));
            prod.setPrix(result.getDouble(4));
            prod.setDescription(result.getString(5));
            
        
          pdt.add(prod);
         System.out.println("liste remplit ");
     }
        } catch (SQLException e) {
                System.out.println("error is \n"+e);
        }

     return pdt ;
    
    
    }
    
    
     public ArrayList<Produits> AfficherAll (){
      ArrayList<Produits> pd = new ArrayList<>();
         
               try {
                      String sql = " SELECT * from produit where 1 ;";
                ResultSet result ;
                       Statement ste = conn.createStatement();
        result = ste.executeQuery(sql);
     while(result.next()){
            Produits p1 = new Produits();
            p1.setId(result.getInt("id_produit"));
              p1.setRéf(result.getInt("reference"));
               p1.setNom(result.getString("nom"));
                   p1.setPrix(result.getDouble("prix"));
                   p1.setId_centre(result.getInt("id_centre"));
      p1.setDescription(result.getString("descr_produit"));
           
      
         
            
         
          
   
     pd.add(p1);
         //System.out.println("liste remplit ");
     }
        } catch (SQLException e) {
                System.out.println("error is \n"+e);
        }

     return pd;
    }
    

     public void deleteProduit(String nom ) {
        String requete = "delete from produit where descr_produit=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, nom);
            ps.executeUpdate();
            System.out.println("Proudt supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression produit" + ex.getMessage());
        }
    }
 public void update2(Produits p)
    
             
     {
        
        String requete = "UPDATE produit SET nom=? ,descr_produit=? WHERE id_produit=? ";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
                
          
          
       
            ps.setString(1,p.getNom());
            ps.setString(2,p.getDescription());
            ps.setInt(3,p.getId());
            
            System.out.println(ps);
           
            ps.executeUpdate();
            System.out.println(" produit modifiée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de modification " + ex.getMessage());
        } }   
              
 
 
 public ArrayList<Produits> afficher() {
         try {
             ArrayList<Produits> list=new ArrayList<>();
             String req="select * from produit ";
             ResultSet rs= ste.executeQuery(req);
             Produits pr=null;
             while (rs.next()){
                   pr=new Produits();
                   pr.setRéf(rs.getInt("reference"));
                   pr.setNom(rs.getString("nom"));
                   pr.setPrix(rs.getDouble("prix"));
              
                   pr.setDescription(rs.getString("description"));
                   list.add(pr);
             }
                 return list;
             
         } catch (SQLException ex) {
             Logger.getLogger(CrudProduits.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
     
    }
 
 
 //rechercher
 
         public ArrayList<Produits> Rechercher(String description) {
         try {
             ArrayList<Produits> list=new ArrayList<>();
             String req="select * from produit where descr_produit  like '%"+description+"%';";
               ResultSet rs ;
                       Statement ste = conn.createStatement();
        rs = ste.executeQuery(req);
            Produits pr=null;
             while (rs.next()){
                 Produits p1 = new  Produits();
                 p1.setId(rs.getInt("id_produit"));
             p1.setRéf(rs.getInt("reference"));
          p1.setNom(rs.getString("nom"));
             p1.setPrix(rs.getDouble("prix"));
          p1.setDescription(rs.getString("descr_produit"));
          p1.setId_centre(rs.getInt("id_centre"));
    
            list.add(p1);
             }
                 return list;
             
         } catch (SQLException ex) {
             Logger.getLogger(CrudProduits.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
     
    }
                
            }
           
    
                 

    

