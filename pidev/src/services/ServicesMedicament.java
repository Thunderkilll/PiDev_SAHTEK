/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DB.MyConnection;
import Entite.Medicament;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author lafa
 */
public class ServicesMedicament implements Iservices.IservicesMedicament{

    
    
   Connection conn=  MyConnection.getInstance().getCon(); 
    
    @Override
    public void ajouterMedicament(Medicament m) {
         try 
        {
            String insert = "INSERT INTO medicament (id_medicament,nom_medicament ,prix, nom_labo) VALUES (?,?,?,?)";
            PreparedStatement st1 = conn.prepareStatement(insert);
            st1.setInt(1, m.getId_medicament());
            st1.setString(2, m.getNom_medicament());
            st1.setDouble(3, m.getPrix());
            st1.setString(4, m.getNom_labo());
            
           
           
           
            st1.executeUpdate();
            System.out.println("medicament"+m.getId_medicament()+" ajoutée !!!");
            
        } 
        catch (SQLException e) 
        {
            System.err.println(e.getMessage());
        }}

    @Override
    public void supprimerMedicament(Medicament m) {
        try 
        {
        String delete = "DELETE FROM medicament WHERE id_medicament= ?";
        PreparedStatement st2 = conn.prepareStatement(delete);
        st2.setInt(1,m.getId_medicament());
        st2.executeUpdate();
        System.out.println("medicament "+m.getId_medicament()+" supprimee !!!");
        
        }
        catch (SQLException e)
        {

                    System.err.println("SQLException: "+e.getMessage()); //To change body of generated methods, choose Tools | Templates.
    }}
    


    @Override
    public Medicament chercherMedicament( int id_medicament) {
        
        Medicament o = new Medicament();
        try
        {
       
        String select = "SELECT * FROM medicament WHERE id_medicament = '"+id_medicament+"' ";
        Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(select);
      
     
        while (result.next()) 
        {
            o.setId_medicament(result.getInt("id_medicament"));
            o.setNom_medicament(result.getString("nom_medicament"));
             o.setPrix(result.getDouble("prix"));
            o.setNom_labo(result.getString("nom_labo"));
               
           // m.setCat(medicament.nom_medicament.valueOf(result.getString("nom_medicament")));
           
           }
        System.out.println("recherche done and medicament est trouve");
     
       }
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                
                    
        }
     return o;
    }
    @Override
    public void afficherMedicament(Medicament m) {
         try
        {
        String select = "SELECT * FROM medicament WHERE id_medicament = '"+m.getId_medicament()+"'";
        Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(select);
      
     
        while (result.next()) 
        {
            m.setId_medicament(result.getInt("id_medicament"));
            m.setNom_medicament(result.getString("nom_medicament"));
             m.setPrix(result.getDouble("prix"));
            m.setNom_labo(result.getString("nom_labo"));
           
           
           }
     System.out.println("affiche done ");
       }
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
    
    }

    @Override
    public void modifierMedicament(Medicament m, String nom_medicament) {
      try {
             String SQL = "UPDATE medicament SET `nom_medicament`=? WHERE `nom_medicament`=?";
             PreparedStatement state;
             state = conn.prepareStatement(SQL);
             state.setString(1, nom_medicament);
             state.setString(2, m.getNom_medicament());
             
             state.executeUpdate();
             System.out.println("modif nom_medicament");
         } 
catch (SQLException ex) {
    System.out.println("Exception"+ex);
}
    }

    
}
    
    
         


   
        
          


   


