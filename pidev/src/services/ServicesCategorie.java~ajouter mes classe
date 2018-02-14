/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DB.MyConnection;
import Entite.Categorie;
import Entite.Medicament;
import Iservices.IservicesCategorie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lafa
 */
public class ServicesCategorie implements IservicesCategorie {
 Connection conn=  MyConnection.getInstance().getCon(); 
    
 
 @Override
    public void ajouterCategorie(Categorie c) {
         try 
        {
            String insert = "INSERT INTO categorie_medicament (id_categorie,nom_categorie ) VALUES (?,?)";
            PreparedStatement st1 = conn.prepareStatement(insert);
            st1.setInt(1, c.getId_categorie());
            st1.setString(2, c.getNom_categorie());
            
            st1.executeUpdate();
            System.out.println("categorie"+c.getId_categorie()+" ajoutée !!!");
            
        } 
        catch (SQLException e) 
        {
            System.err.println(e.getMessage());
        }
}

    @Override
    public void supprimerCategorie(Categorie c) {
        
        try 
        {
        String delete = "DELETE FROM categorie WHERE id_categorie= ?";
        PreparedStatement st2 = conn.prepareStatement(delete);
        st2.setInt(1,c.getId_categorie());
        st2.executeUpdate();
            System.out.println("categorie supprimé !!!! \n");
            System.out.println("categorie "+c.getId_categorie()+" supprimee !!!");
        String req2= "delete * from `medicament` where id_categorie= '"+c.getId_categorie()+"';";
        PreparedStatement st = conn.prepareStatement(req2);
        st2.executeUpdate();
            System.out.println("medicaments supprimé \n");
        
        
        }
        catch (SQLException e)
        {

                    System.err.println("SQLException: "+e.getMessage()); //To change body of generated methods, choose Tools | Templates.
    }}
    


    @Override
    public Categorie chercherCategorie(String nom_categorie) {
         Categorie t = new Categorie();
        try
        {
       
        String select = "SELECT * FROM categorie WHERE nom_categorie = '"+nom_categorie+"' ";
        Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(select);
      
     
        while (result.next()) 
        {
            t.setId_categorie(result.getInt("id_categorie"));
            t.setNom_categorie(result.getString("nom_categorie"));
        }
         System.out.println("recherche done and categorie est trouve");
     
       }
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                
                    
        }
     return t;
    }

    @Override
    public void afficherCategorie(Categorie c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierCategorie(Categorie c, String nom_categorie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
