/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DB.MyConnexion;
import Entite.Centre;
import Entite.Offres;
import Iservices.IOffres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;

/**
 *
 * @author asus
 */
public class CrudOffres {
  
  Connection conn ;
    private int x;
    private Statement ste;

public CrudOffres()
{
    
    conn = MyConnexion.Get_Instance().getCon(); 
}
  //@Override
    public void ajouterOffres(Offres o,Centre c)
  {
  

      try {
          
       //INSERT INTO `offres` ( `nom`, `date_debut`, `date_fin`, `descr_offre`,
          //`prix`, `id_centre`) VALUES (NULL, 'offre2', '2018-02-01', '2018-02-08', 'offre 1 dans le contest de tester', '12.22', '1');

          Statement st= conn.createStatement();
          String requete= "INSERT INTO `offres` ( `nom`, `date_debut`, `date_fin`, `descr_offre`,`prix`, `id_centre`) VALUES ('"+o.getNom()+"','"+o.getDate_debut()+"','"+o.getDate_fin()+"','"+o.getDescription()+"','" +
          o.getPrix()+"','"+c.getId_centre()+"');";
        st.executeUpdate(requete);
          System.out.println("offres ajouter");
      } catch (SQLException ex) {
        System.out.println("Ajout offre failed "+ex);
      }

    }

    
  //@Override
        public void modifierOffres (Offres o,String nom , double prix )
    {

        try {
                

          
            String requete = "UPDATE `offres`  set `nom`= '"+ nom + "',`prix`=' "+prix+" ' WHERE `nom`=' "+o.getNom()+" '";
            PreparedStatement st =conn.prepareStatement(requete);
            //st.setString(1,c.getNom());
        
            st.executeUpdate();
            System.out.println("offres modifier");
        } catch (SQLException ex) {
            //Logger.getLogger(CrudCentre.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("error  modifier !!  \n"+ex);
        }
    }
         public boolean update(Offres p) {
        String qry = "UPDATE offres SET nom=?,descr_offre=? WHERE id_offre = ?";
        System.out.println(qry);
        try {
            PreparedStatement ps = conn.prepareStatement(qry);
                
          
          
       
            ps.setString(1,p.getNom());
            ps.setString(2,p.getDescription());
            ps.setInt(3,p.getId_offre());       
             
            if (ps.executeUpdate() > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudOffres.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;   
    }public ArrayList<Offres> afficher() {
         try {
             ArrayList<Offres> list=new ArrayList<>();
             String req="select * from offres";
             ResultSet rs= ste.executeQuery(req);
             Offres per=null;
             while (rs.next()){
                   per=new Offres();
                   per.setNom(rs.getString("nom"));
                   per.setDate_debut(rs.getDate("date_debut"));
                   per.setDate_fin(rs.getDate("date_fin"));
                   per.setPrix(rs.getString("prix"));
                   per.setDescription(rs.getString("description"));
                   list.add(per);
             }
                 return list;
             
         } catch (SQLException ex) {
             Logger.getLogger(CrudOffres.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
     
    }
         public ArrayList<Offres> Rechercher(String description) {
         try {
             ArrayList<Offres> list=new ArrayList<>();
             String req="select * from offres where descr_offre  like'%"+description+"%'";
               ResultSet rs ;
                       Statement ste = conn.createStatement();
        rs = ste.executeQuery(req);
            Offres per=null;
             while (rs.next()){
                 Offres o1 = new Offres();
            o1.setNom(rs.getString(2));
          o1.setDate_debut(rs.getDate(3));
          o1.setDate_fin(rs.getDate(4));
            
            o1.setDescription(rs.getString(5));
          
            o1.setPrix(rs.getString(6));
            list.add(o1);
             }
                 return list;
             
         } catch (SQLException ex) {
             Logger.getLogger(CrudOffres.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
     
    }
     public void update1(Offres r)
    
             
     {
        
        String requete = "UPDATE offres SET nom=? ,descr_offre=? WHERE id_offre=? "; 
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
                
            
       
            ps.setString(1,r.getNom());
            ps.setString(2,r.getDescription());
            ps.setInt(3,r.getId_offre());
            System.out.println("(((((((((((("+r.getId_offre()+")))))))))");
            System.out.println(ps);
           
            ps.executeUpdate();
            System.out.println(" offre modifiée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de modification " + ex.getMessage());
        } }   
 // @Override
     public void afficherOffres (){
          try {
                
              String requete ="SELECT * FROM offres ";
                   Statement st =conn.createStatement();
              ResultSet r = st.executeQuery(requete);
              
              while(r.next())
              {
                  System.out.println(r.getInt("id_reservations"));
                  System.out.println(r.getString("nom"));
                   System.out.println(r.getString("prix"));
                    System.out.println(r.getString("descr_offre"));
                     System.out.println(r.getInt("date_debut"));
                    System.out.println(r.getInt("date_fin"));
                   
                  
              }
          } 
          catch (SQLException ex) {
              System.err.println("afficher erreur  "+ex);
               
          }
         
           }


    public Offres chercherOffres (int id_offre  ){
     Offres f = new Offres();
     try {
              String requete ="SELECT * from offres where id_offre='"+id_offre+"';";
              Statement k =conn.createStatement();
              ResultSet rs= k.executeQuery(requete);
              
              while(rs.next())
              {
                  f.setId_offre(rs.getInt("id_offre"));
                 f.setNom(rs.getString("nom"));
                  System.out.println(f.getNom());
                 f.setDate_debut(rs.getDate("date_Debut"));
                  f.setDate_debut(rs.getDate("date_fin"));
                  f.setDescription(rs.getString("descr_offre"));
                 f.setPrix(rs.getString("prix"));
                 return f;
              } 
          } catch (SQLException ex) {
              System.out.println("problem dans la recherche d'offre par ID\n"+ex);
          }
     return f;
}

   
  //@Override
             public boolean supprimerOffres(String nom ) {
                 
 try
 {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         String req = "delete from offres  WHERE `nom`=' "+nom+"'; ";
       
       Statement ps = conn.prepareStatement(req);

       
       ps.executeUpdate(req);
  
                   System.out.println("Le centre de nom= "+nom+" est supp");
                  
                    
              return true;
               }
               catch(SQLException ex){
                   System.out.println("error lord du supp \n"+ex);
               }
               return false ;
           }    
  //@Override
    public Offres  chercherOffres(String nom) {
    
         Offres of = new Offres();
        try
        {
       
        String select = "SELECT * FROM offres WHERE nom = '"+nom+"' ";
        Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(select);
      
     
       while(result.next()){
            Offres o1 = new Offres();
            o1.setId_offre(result.getInt("id_offre"));
            o1.setNom(result.getString("nom"));
          o1.setDate_debut(result.getDate("date_debut"));
          o1.setDate_fin(result.getDate("date_fin"));
            
            o1.setDescription(result.getString("descr_offre"));
          
            o1.setPrix(result.getString("prix"));
          
          
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

   
  public ArrayList<Offres> afficheOffres(int id) {
                 ArrayList<Offres> Offrees = new ArrayList<>();
         
               try {
                      String sql = " SELECT * from offres where id_offre='"+id+"';";
                ResultSet result ;
                       Statement ste = conn.createStatement();
        result = ste.executeQuery(sql);
     while(result.next()){
            Offres off = new   Offres();
            off.setId_offre(result.getInt(1));
            off.setNom(result.getString(2));
            off.setDate_debut(result.getDate(3));
            off.setDate_fin(result.getDate(4));
            off.setDescription(result.getString(5));
            off.setPrix(result.getString(6));
            off.setId_reservation(result.getInt(7));
        
          Offrees.add(off);
         System.out.println("liste remplit ");
     }
        } catch (SQLException e) {
                System.out.println("error is \n"+e);
        }

     return Offrees ;
    
    
    }
//
//    @Override
//    public void ajouterOffres(Offres o) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
  
  
     public ArrayList<Offres> AfficherAll (){
      ArrayList<Offres> of = new ArrayList<>();
         
               try {
                      String sql = " SELECT * from offres where 1 ;";
                ResultSet result ;
                       Statement ste = conn.createStatement();
        result = ste.executeQuery(sql);
     while(result.next()){
            Offres o1 = new Offres();
            o1.setId_offre(result.getInt(1));
            o1.setNom(result.getString(2));
          o1.setDate_debut(result.getDate(3));
          o1.setDate_fin(result.getDate(4));
            
            o1.setDescription(result.getString(5));
          
            o1.setPrix(result.getString(6));
        
          
   
     of.add(o1);
         //System.out.println("liste remplit ");
     }
        } catch (SQLException e) {
                System.out.println("error is \n"+e);
        }

     return of;
    }
     
      public void deleteOffre(String nom ) {
        String requete = "delete from offres where nom=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1,nom);
            ps.executeUpdate();
            System.out.println("Offre supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression Offre" + ex.getMessage());
        }
    }

                
                
            }
           


    

