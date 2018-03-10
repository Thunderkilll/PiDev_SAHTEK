

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services ;

import DB.MyConnexion;
import Entite.Centre;
import Entite.Offres;
import Entite.Produits;
import Entite.Propcentre;
import Entite.Users;
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
 * @author USER
 */


    /**
     *  
     */





public class CrudCentre implements Iservices.Icentre{

 
Connection conn ;

    private int x;
    private Statement ste;
   

public CrudCentre()
{
    
    conn = MyConnexion.Get_Instance().getCon(); 
}


@Override
    public void ajoutercentreVide ( Centre c)
  {

      try {
       

          Statement st= conn.createStatement();
          
          String requete= "INSERT INTO centre (`nom`, `description`, `adresse`, `telephone` ) VALUES('" +
       c.getNom()+"','"+c.getDescription()+"','"+c.getAddresse()+"','"+c.getTelephone()+"');";
        st.executeUpdate(requete);
          System.out.println("centre ajouter ");
      }
      catch (SQLException ex) {
        System.out.println("Ajout failed "+ex);
      }
      }
    

        public void modifiercentre(Centre c ,String nom , String addresse)
    {

        try {
            
            String requete = "UPDATE `centre`  set `nom`= '"+ nom + "',`adresse` =' "+addresse+" ' WHERE `id_centre`=' "+c.getId_centre()+" '";
            PreparedStatement st =conn.prepareStatement(requete);
            
        
            st.executeUpdate();
            System.out.println("centre modifier");
        } catch (SQLException ex) {
         
              System.out.println("error  modifier !!  \n"+ex);
        }
    }
    


         
@Override
public boolean supprimerCentre(Centre c) //en cascade  donner a amir pour la faire 
           {
               try {
                   String req1 = "select * from users  WHERE `id_centre`=' "+c.getId_centre()+"';";
            
              Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(req1);
        while(result.first())
        {
            Propcentre p =new Propcentre();
            //recherche 3malneha ki yal9aha yasna3 objet jdid w y3amrou
               
      p.setId_usr(result.getInt(1));
      p.setCin((result.getInt(2)));
      p.setNom(result.getString(3));
      p.setPrenom(result.getString(4));
      p.setDateNaissance(result.getDate(5));
      p.setPassword(result.getString(6));
      p.setUsername(result.getString(7));
      p.setEmail(result.getString(8));
      p.setTelephone(result.getInt(9));
      p.setAdresse(result.getString(10));
      p.setRole(result.getString(11));
          p.setDiplome(result.getString(12));
          
             String req2 = "Update  users set `user`='Patient' , `id_centre`='"+null+"'  where id_usr='"+p.getId_usr()+"';";
             Statement ps2 = conn.prepareStatement(req2);
              ps2.executeUpdate(req2);
               } 
        }catch (SQLException ex) {
                   System.out.println("error in search or rempliçage ou même dans le modif \n "+ex);
               }
              //modifier bech nbadil min prop centre lil client
         
           
               
               
      
              try{
               
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         String req = "delete * from centre  WHERE `id_centre`=' "+c.getId_centre()+"'; ";
       Statement ps = conn.prepareStatement(req);

       
       ps.executeUpdate(req);
      
                   System.out.println("Le centre d'id = "+c.getId_centre()+" est supp");
                    System.out.println("L'utilisateur de cet id centre devient un Patient");
                    
              return true;
               }
               
               catch(SQLException ex){
                   System.out.println("error lord du supp \n"+ex);
               }
               
           
               return false ;
           }
         
           //recherche 
 public Centre chercherCentre(String nom) {  /// un seul centre
    Centre ce = new Centre();
         
          //if(su.verifierLogin(u)){
        try
        {
       
        String req = "SELECT * FROM centre WHERE nom = '"+nom+"' ";
        PreparedStatement pre = conn.prepareStatement(req);
        ResultSet result = pre.executeQuery();
      
       while (result.next()) 
        {
            ce.setId_centre(result.getInt(1));
            ce.setAddresse(result.getString(2));
            ce.setDescription(result.getString(6));     
            ce.setNom(result.getString(3));
            ce.setTelephone(result.getInt(4));
            ce.setId_categorie(result.getInt(5));
            }
            System.out.println("centre trouvée "+ce.getNom());
            System.out.println("centre id "+ce.getId_centre());
             
        }
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
        //  }
        //To change body of generated methods, choose Tools | Templates.
        return ce;
           }
           

@Override

    public void affichercentre() {
       
    
      try
        {
       
        String select = "SELECT * FROM centre  ";
        Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(select);
      
     
       while (result.next()) 
        {
            System.out.println("Nom "+result.getString("nom"));
            System.out.println(" ");
            System.out.println("");
            System.out.println("");
            System.out.println("");
           
            }
            System.out.println("centre trouvée");
        }
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }

    }

    @Override
    public void modifiercentre(Users u, String nom, String addresse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Centre chercherCentre(Users u, String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   // @Override
    public void ajouterOffre(Users u, Centre c, Offres id_offre) {
        if (u.getRole().equals("PropCentre")){
            try {
                Statement ste = conn.createStatement();
                 String req = " insert into centre id_offre ='"+id_offre.getId_offre()+"' where id_centre='"+c.getId_centre()+"' ;";
                 ste.executeQuery(req);
                 System.out.println("Offre Added");
                
            } catch (SQLException e) {
                System.out.println("error in adding an offre \n"+e);
            }
           
            
        }else{
            System.out.println("user not found !!");
        }
        
       
    }

   public Centre chercherCentreParId(int id_centre) {  /// un seul centre
    Centre ce = new Centre();
         
          //if(su.verifierLogin(u)){
        try
        {
       
        String select = "SELECT * FROM centre WHERE id_centre = '"+id_centre+"' ";
        Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(select);
      
     
       while (result.next()) 
        {
            ce.setId_centre(result.getInt("id_centre"));
            ce.setAddresse(result.getString("adresse"));
            ce.setDescription(result.getString("description"));     
            ce.setNom(result.getString("nom"));
            ce.setTelephone(result.getInt("telephone"));
            ce.setId_categorie(result.getInt("id_categorie"));
            
           
           
            }
            System.out.println("centre trouvée "+ce.toString());
             
        }
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage()+"\n");
                    System.err.println("SQLSTATE: "+e.getSQLState()+"\n");
                    System.err.println("VnedorError: "+e.getErrorCode()+"\n");
                }
        //  }
        //To change body of generated methods, choose Tools | Templates.
        return ce;
           }
   
   public ArrayList<Centre> AfficherAll (){
      ArrayList<Centre> centres = new ArrayList<>();
         
               try {
                      String sql = " SELECT * from centre where 1 ;";
                ResultSet result ;
                       Statement ste = conn.createStatement();
        result = ste.executeQuery(sql);
     while(result.next()){
            Centre p2 = new Centre();
            p2.setId_centre(result.getInt(1));
            p2.setNom(result.getString(3));
            p2.setAddresse(result.getString(2));
            p2.setDescription(result.getString(6));
            p2.setTelephone(result.getInt(4));
            p2.setId_categorie(result.getInt(5));
          
   
     centres.add(p2);
         //System.out.println("liste remplit ");
     }
        } catch (SQLException e) {
                System.out.println("error is \n"+e);
        }

     return centres ;
    }
     
      public void deleteCentre(String nom ) {
        String requete = "delete from centre where nom=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, nom);
            ps.executeUpdate();
            System.out.println("centre supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression centre" + ex.getMessage());
        }
    }

                public void update3(Centre c)
    
             
     {
        
        String requete = "UPDATE centre SET nom=? ,description=? WHERE id_centre=? ";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
                
          
          
       
            ps.setString(1,c.getNom());
            ps.setString(2,c.getDescription());
            ps.setInt(3,c.getId_centre());
            
            System.out.println(ps);
           
            ps.executeUpdate();
            System.out.println(" centre modifiée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de modification " + ex.getMessage());
        } }   
                
                
                
                
                public ArrayList<Centre> afficher() {
         try {
             ArrayList<Centre> list=new ArrayList<>();
             String req="select * from centre";
             ResultSet rs= ste.executeQuery(req);
             Centre cent=null;
             while (rs.next()){
                   cent=new Centre();
                   cent.setNom(rs.getString("nom"));
                   cent.setAddresse(rs.getString("adresse"));
                   cent.setId_centre(rs.getInt("id"));
                   cent.setTelephone(rs.getInt("telephone"));
                   cent.setDescription(rs.getString("description"));
                   list.add(cent);
             }
                 return list;
             
         } catch (SQLException ex) {
             Logger.getLogger(CrudCentre.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
     
    }
                 public ArrayList<Centre> Rechercher(String description) {
         try {
             ArrayList<Centre> list=new ArrayList<>();
             String req="select * from centre where nom  like'%"+description+"%'";
               ResultSet rs ;
                       Statement ste = conn.createStatement();
        rs = ste.executeQuery(req);
            Centre cent =null;
             while (rs.next()){
                 Centre c1 = new Centre();
                  c1.setId_centre(rs.getInt("id_centre"));
                    c1.setAddresse(rs.getString("adresse"));
            c1.setNom(rs.getString("nom"));
            c1.setTelephone(rs.getInt("telephone"));
             c1.setDescription(rs.getString("description"));
             c1.setId_categorie(rs.getInt("id_categorie"));
             list.add(c1);
             }
                 return list;
             
         } catch (SQLException ex) {
             Logger.getLogger(CrudCentre.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
     
    }
                
            }
           

