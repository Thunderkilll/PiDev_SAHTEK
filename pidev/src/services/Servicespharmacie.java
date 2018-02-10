/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DB.MyConnection;
import Entite.Pharmacie;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lafa
 */
public class Servicespharmacie implements Iservices.IservicesPharmacie {
    
           Connection conn=  MyConnection.getInstance().getCon();  
  

    @Override
    public void ajouterPharmacie(Pharmacie p) {
        try 
        {
            
            String insert = "INSERT INTO pharmacie (id_pharmacie,nom_pharmacie ,adresse,telephone, code_postal,horaire_travail)  VALUES (?,?,?,?,?,?)";
            PreparedStatement st1 = conn.prepareStatement(insert);
            st1.setInt(1, p.getId_pharmacie());
            st1.setString(2, p.getNom_pharmacie());
            st1.setString(3, p.getAdresse());
            st1.setInt(4, p.getTelephone());
            st1.setInt(5, p.getCode_postal());
            st1.setDate(6, p.getHoraire_travail());
           
            st1.executeUpdate();
            System.out.println("pharmacie "+p.getId_pharmacie()+" ajoutée !!!");
            
        } 
        catch (SQLException e) 
        {
            System.err.println(e.getMessage());
        }
                //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerPharmacie(Pharmacie p) {
        try 
        {
        String delete = "DELETE FROM pharmacie WHERE id_pharmacie= ?";
        PreparedStatement st2 = conn.prepareStatement(delete);
        st2.setInt(1,p.getId_pharmacie());
        st2.executeUpdate();
        System.out.println("pharmacie "+p.getId_pharmacie()+" supprimee !!!");
        
        }
        catch (SQLException e)
        {

                    System.err.println("SQLException: "+e.getMessage()); //To change body of generated methods, choose Tools | Templates.
    }}

    @Override
    public Pharmacie chercherPharmacie(int id_pharmacie) {
    
         Pharmacie g = new Pharmacie();
        try
        {
       
        String select = "SELECT * FROM pharmacie WHERE id_pharmacie = '"+id_pharmacie+"' ";
        Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(select);
      
     
       while (result.next()) 
        {
            g.setId_pharmacie(result.getInt("id_pharmacie"));
            g.setNom_pharmacie(result.getString("nom_pharmacie"));
            g.setAdresse(result.getString("adresse"));     
            g.setCode_postal(result.getInt("code_postal"));
        
            g.setHoraire_travail(result.getDate("horaire_travail"));
          
          
            g.setTelephone(result.getInt("telephone"));
          //  g.setCat((Etablissement.categorie.valueOf(result.getString("categorie"))));
           
            
            }
            System.out.println("recherche done and pharmacie est trouver");
        }
        catch (SQLException e)
                {
                    System.err.println("SQLException: "+e.getMessage());
                    System.err.println("SQLSTATE: "+e.getSQLState());
                    System.err.println("VnedorError: "+e.getErrorCode());
                }
        return g; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void afficherPharmacie(Pharmacie p) {
         try
        {
        String select = "SELECT * FROM pharmacie WHERE id_pharmacie = '"+p.getId_pharmacie()+"' ";
        Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(select);
      
     
        while (result.next()) 
        {
            System.out.println("id pharmacien = "+result.getString("id_pharmacie"));
            System.out.println("Nom pharmacie= "+result.getString("nom_pharmacie"));
            System.out.println("Adresse = "+result.getString("adresse"));
             System.out.println("telephone = "+result.getInt("telephone"));
              System.out.println("code postal = "+result.getInt("code_postal"));
               System.out.println("H_T = "+result.getDate("horaire_travail"));
           
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
    public void modifierPharmacie(Pharmacie p , int code , String adresse) {
           try
        {
        String update = "UPDATE pharmacie SET code_postal=?,adresse =? WHERE id_pharmacie =?";
        PreparedStatement statement2 = conn.prepareStatement(update);
        statement2.setInt(1,code);
        statement2.setString(2, p.getAdresse());
        statement2.setInt(3, p.getId_pharmacie());
        statement2.executeUpdate();
        System.out.println("pharmacie "+p.getNom_pharmacie()+" modifiee !!!");
        
        }
        catch (SQLException e)
                {
                    System.err.println("sahtek "+p.getNom_pharmacie()+" non modifiee \n"+e);
                }
    } //To change body of generated methods, choose Tools | Templates.
    }
 
  

