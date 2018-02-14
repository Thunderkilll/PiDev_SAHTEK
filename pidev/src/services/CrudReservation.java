/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import DB.MyConnection;
import Entite.Centre;
import Entite.Reservation;
import Iservices.IReservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author asus
 */
public class CrudReservation implements IReservation {
    Connection conn ;
   

public CrudReservation()
{
    
    conn = MyConnection.getInstance().getCon(); 
}
    public void ajouterReservation(Reservation r)
  {
  

      try {
       

          Statement st= conn.createStatement();
          String requete= "INSERT INTO reservation (id, nom ,date_reservation ) VALUES('" +
          r.getId()+ "','"+r.getNom()+"','"+r.getDate_reservation()+"')";
        st.executeUpdate(requete);
          System.out.println("Reservation ajouter");
      } catch (SQLException ex) {
        System.out.println("Ajout failed "+ex);
      }

    } 
    //ajout offre dans reservation  bel 3akesss fel prooduit  produit p int id-reserv
     public void ajouterProduit(Reservation r, int id_produit) {
           try {
        Statement st= conn.createStatement();
          
          String requete= "INSERT INTO Reservation id_produit ='"+id_produit+"' where id_reservation='"+r.getId()+"';";
        st.executeUpdate(requete);
          System.out.println("produit ajouter dans reservation");
      } catch (SQLException ex) {
        System.out.println("Ajout failed "+ex);
      }
        
        
          }
    
    
    
    
    
    
    
    ///ajout produit dans reservation 
    
    
    
    
    
    

//     @Override
//        public void modifierReservation(Reservation r,String nom , int id )
//    {
//
//        try {
//                
//
//          
//            String requete = "UPDATE `reservation`  set `nom`= '"+ nom + "',s`id`=' "+id+" ' WHERE `id`=' "+r.getId()+" '";
//            PreparedStatement st =conn.prepareStatement(requete);
//            //st.setString(1,c.getNom());
//        
//            st.executeUpdate();
//            System.out.println("reservationmodifier");
//        } catch (SQLException ex) {
//            //Logger.getLogger(CrudCentre.class.getName()).log(Level.SEVERE, null, ex);
//              System.out.println("error  modifier !!  \n"+ex);
//        }
//    }
//     @Override
//     public void afficherReservation (){
//          try {
//                
//              String requete ="SELECT * FROM Reservation ";
//                   Statement st =conn.createStatement();
//              ResultSet r = st.executeQuery(requete);
//              
//              while(r.next())
//              {
//                  System.out.println(r.getInt("id"));
//                  System.out.println(r.getString("nom"));
//                   System.out.println(r.getString("date_reservation"));
//                 
//                    
//                   
//                  
//              }
//          } 
//          catch (SQLException ex) {
//              System.err.println("afficher erreur  "+ex);
//               
//          }
//         
//           }
       /*
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

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
//     @Override
//            public boolean supprimerReservation (int id) throws SQLException {
//      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//         String req = "delete from Reservation where id= "+id;
//       PreparedStatement ps = MyConnexion.preparedStatement(req);
//       
//       ps.setInt(1,id);
//       ps.executeUpdate();
//              return true;
//
//    }
//     @Override
//            public Reservation chercherReservation(int id) {
//    
//          Reservation  re = new Reservation();
//        try
//        {
//       
//        String select = "SELECT * FROM reservation WHERE nom = '"+id+"' ";
//        Statement statement1 = conn.createStatement();
//        ResultSet result = statement1.executeQuery(select);
//      
//     
//       while (result.next()) 
//        {
//            re.setNom(result.getString("nom"));
//            re.setId(result.getInt("id"));
//            re.setDate_reservation(result.getDate("date_reservation"));     
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
//    
    
    
    
}
