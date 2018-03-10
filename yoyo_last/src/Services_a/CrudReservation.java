/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import DB.MyConnexion;
import Entite.Offres;
import Entite.Produits;
import Entite.Reservation;
import Entite.Users;
import Iservices.IReservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**s
 *
 * @author asus
 */
public class CrudReservation implements IReservation {
    Connection conn ;
       private int x;
    private Statement ste;
   

public CrudReservation()
{
    
    conn = MyConnexion.Get_Instance().getCon(); 
}
   
    
    
    
    
    //ajout offre dans reservation  bel 3akesss fel prooduit  produit p int id-reserv
    @Override
     public void ajouterOffreReservation(Reservation r, int id_offre) {
           try {
        Statement st= conn.createStatement();
          String req1 = "INSERT INTO `reservation`(`nom`, `date_reservation`, `id_user`,`id_offre`) VALUES ('"+r.getNom()+"','"+r.getDate_reservation()+"','"+r.getUser().getId_usr()+"','"+id_offre+"');";
          
        st.executeUpdate(req1);
          System.out.println("offre ajouter dans reservation");
      } catch (SQLException ex) {
        System.out.println("Ajout failed "+ex);
      }
        
        
          }
     
       public void ajouterOffreReservation1(Reservation r,Offres o ) {
           try {
        Statement st= conn.createStatement();
          String req1 = "INSERT INTO `reservation`(`nom`, `date_reservation`, `nbjours`, `id_user`) VALUES ('"+r.getNom()+"','"+r.getDate_reservation()+"','"+r.getNbjours()+
                  "','"+r.getUser().getId_usr()+"');";
          
        st.executeUpdate(req1);
          System.out.println("produit ajouter dans reservation");
      } catch (SQLException ex) {
        System.out.println("Ajout failed "+ex);
      }
       }
    
    
    
    
    
    
    @Override
        public void modifierReservation(Reservation r,String nom , int id )
    {

        try {
                

        
            String requete =   "UPDATE `reservation`  set `nom`= '"+ nom + "',`id`=' "+id+" ' WHERE `id`=' "+r.getId()+" '";
            PreparedStatement st =conn.prepareStatement(requete);
            //st.setString(1,c.getNom());
        
            st.executeUpdate();
            System.out.println("reservationmodifier");
        } catch (SQLException ex) {
            //Logger.getLogger(CrudCentre.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("error  modifier !!  \n"+ex);
        }
    }
    @Override
     public void afficherReservation (){
          try {
                
              String requete ="SELECT * FROM Reservation ";
                   Statement st =conn.createStatement();
              ResultSet r = st.executeQuery(requete);
              
              while(r.next())
              {
                  System.out.println(r.getInt("id"));
                  System.out.println(r.getString("nom"));
                   System.out.println(r.getString("date_reservation"));
                 
                    
                   
                  
              }
          } 
          catch (SQLException ex) {
              System.err.println("afficher erreur  "+ex);
               
          }
         
           }
     
     
    @Override
            public boolean supprimerReservation (String nom) {
      try{
         String req = "delete from `reservation`  WHERE `nom`=' "+nom+"'; ";
  
       Statement ps = conn.prepareStatement(req);

       
       ps.executeUpdate(req);
      
                   System.out.println("Le Categorie_centre d'nom = "+nom+" est supp");
                   
                    
              return true;
               }
               catch(SQLException ex){
                   System.out.println("error lord du supp \n"+ex);
               }
               return false ;
    }

    
    @Override
            public Reservation chercherReservation(String nom) {
    
          Reservation  res = new Reservation();
//        try
//        {
//       
//        String select = "SELECT * FROM reservation WHERE nom = '"+nom+"' ";
//        Statement statement1 = conn.createStatement();
//        ResultSet result = statement1.executeQuery(select);
//      
//     
//       while (result.next()) 
//        {
//            re.setId(result.getInt("id"));
//            re.setNom(result.getString("nom"));
//            re.setDate_reservation(result.getDate("date_reservation"));   
//            re.setNbjour(result.getInt("nbjour"));
//            
//            
//            
//          
//          
//          
//           
//   
//           
//            
//            }
//            System.out.println("reservation trouvée");
//        }
//        catch (SQLException e)
//                {
//                    System.err.println("SQLException: "+e.getMessage());
//                    System.err.println("SQLSTATE: "+e.getSQLState());
//                    System.err.println("VnedorError: "+e.getErrorCode());
//                }
//        return re; //To change body of generated methods, choose Tools | Templates.
//    }
//
//  
//
//   public ArrayList<Reservation> afficheReservation(int id) {
//                 ArrayList<Reservation> res = new ArrayList<>();
//         
//               try {
//                      String sql = " SELECT * from reservation where id='"+id+"';";
//                ResultSet result ;
//                       Statement ste = conn.createStatement();
//        result = ste.executeQuery(sql);
//     while(result.next()){
//            Reservation r = new   Reservation();
//            r.setId(result.getInt(1));
//            r.setNom(result.getString(2));
//            r.setDate_reservation(result.getDate(3));
//           
//            r.setNbjour(result.getInt(4));
//        
//          res.add(r);
//         System.out.println("liste remplit ");
//     }
//        } catch (SQLException e) {
//                System.out.println("error is \n"+e);
//        }

     return res ;
    
    
    }

    @Override
    public void afficherReservationOffreUser(Users u) {
        CrudOffres f = new CrudOffres();
        CrudPropcentre u1 = new CrudPropcentre();
                
        //services.
                
        try {
             if (u.getId_usr()!=0) {
                 String requete ="SELECT * FROM `reservation` WHERE `id_user` ='"+u.getId_usr()+"';";
              Statement k =conn.createStatement();
              ResultSet rs= k.executeQuery(requete);
              
              while(rs.next())
              {
                  System.out.println("Nom du reservation :"+rs.getString("nom"));
                  System.out.println("Date de début de reservation  :"+rs.getDate("date_reservation"));
                  System.out.println("Nombre de jours réservé pour l'offre :"+rs.getInt("nbjours"));
                  int id_offre = rs.getInt("id_offre");
                  int id_user = rs.getInt("id_user");
                  Offres o = f.chercherOffres(id_offre);
                  u1.chercherPropcentre(id_user);
                System.out.println( o.toString());
                  System.out.println( u1.toString());
                  
                  
              } 
            }
          } catch (SQLException ex) {
              System.out.println("la recherche reservation \nd'offre par user a un erreur :\n"+ex);
          }
    }
    
   CrudPropcentre u = new CrudPropcentre();
    public ArrayList<Reservation> AfficherAll (){
      ArrayList<Reservation> re = new ArrayList<>();
         
               try {
                      String sql = " SELECT * from reservation where 1 ;";
                      
                ResultSet result ;
                       Statement ste = conn.createStatement();
        result = ste.executeQuery(sql);
     while(result.next()){
            Reservation r1 = new Reservation();
            r1.setId(result.getInt(1));
             r1.setNom(result.getString(2));
               r1.setDate_reservation(result.getDate(3));
                   r1.setNbjours(result.getInt(4));
                   r1.setUser(u.chercherPropcentre(result.getInt("id_user")));
                  r1.setNom_user(r1.getUser().getNom()); 
                  r1.setPrenom_user(r1.getUser().getPrenom());
                  r1.setCin_user(r1.getUser().getCin());
                  r1.setEmail(r1.getUser().getEmail());
                  r1.setTel_user(r1.getUser().getTelephone());
     re.add(r1);
         
     }
        } catch (SQLException e) {
                System.out.println("error is \n"+e);
        }

     return re;
    }
    
     public void deleteReservation(String nom ) {
        String requete = "delete from reservation where nom=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, nom);
            ps.executeUpdate();
            System.out.println("reservation supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression reservation" + ex.getMessage());
        }
    }
     
     public ArrayList<Reservation> afficher() {
         try {
             ArrayList<Reservation> list=new ArrayList<>();
             String req="select * from reservation ";
             ResultSet rs= ste.executeQuery(req);
             Reservation res=null;
             while (rs.next()){
                   res=new Reservation();
                   res.setId(rs.getInt("id"));
                   res.setNom(rs.getString("nom"));
                   res.setDate_reservation(rs.getDate("date_reservation"));
              
                   res.setNbjours(rs.getInt("nbjours"));
                   list.add(res);
             }
                 return list;
             
         } catch (SQLException ex) {
             Logger.getLogger(CrudReservation.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
     
    }
      public ArrayList<Reservation> Rechercher(String nom) {
         try {
             ArrayList<Reservation> list=new ArrayList<>();
             String req="select * from reservation where nom  like'%"+nom+"%'";
               ResultSet rs ;
                       Statement ste = conn.createStatement();
        rs = ste.executeQuery(req);
            Reservation r=null;
             while (rs.next()){
                 Reservation r1 = new  Reservation();
            r1.setId(rs.getInt(1));
          r1.setNom(rs.getString(2));
            r1.setDate_reservation(rs.getDate(3));
            
            
            r1.setNbjours(rs.getInt(4));
          
    
            list.add(r1);
             }
                 return list;
             
         } catch (SQLException ex) {
             Logger.getLogger(CrudReservation.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
     
    }
       public void update1(Reservation r)
    
             
     {
        
        String requete = "UPDATE reservation SET date_reservation=? WHERE id_user=? "; 
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
                
          
          
       
            ps.setDate(1,r.getDate_reservation());
          ps.setInt(2,r.getId());

            
            System.out.println(ps);
           
            ps.executeUpdate();
            System.out.println(" Rservation modifiée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de modification " + ex.getMessage());
        } }   
      
      
      
      
                
            }
    

