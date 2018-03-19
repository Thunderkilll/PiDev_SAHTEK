/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entite.Users ;
import DB.MyConnexion ;
import Entite.Beaute;
import Entite.Patient;
import Interface_Services.IUsers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;



/**
 *
 * @author music
 */
public class Services_user implements IUsers{
    Connection con ;
   
    
    public Services_user()
    {
        con = MyConnexion.Get_Instance().getCon() ;
        
    }
        public boolean verifierLogin(Users u) {
                String req="SELECT email,password FROM users WHERE email=? and password=? ;";
         try {
        PreparedStatement ps=con.prepareStatement(req);
        ps.setString(1, u.getEmail());
        ps.setString(2, u.getPassword());
        
        ResultSet rs=ps.executeQuery();
             
             
            if(rs.next()){
                String s1=rs.getString(1);
                 String s2=rs.getString(2);
                 
              //  System.out.println(s1+s2);
             }
        System.out.println("conexion validé");
        return true ;
         } catch (SQLException ex) {
            
             System.out.println("\nconnexion didn't pass "+ex);
        }
    
    return false;
    }
    
    
    
    @Override
    public void inscription(Users u)
           
    {
        try {
            String query="INSERT INTO USERS(username,password,nom,prenom,date_naiss)"
                    + " VALUES (?,?,?,?,?)" ;
          
   PreparedStatement ps= con.prepareStatement(query) ;
 
 ps.setString(1, u.getUsername());
  ps.setString(2, u.getPassword());
   ps.setString(3, u.getNom());
    ps.setString(4, u.getPrenom());
    ps.setDate(5, new java.sql.Date(u.getDateNaissance().getTime()));
    
 if(!ps.execute() )
 {
     String query2="Select max(user_id) from users" ;
 ResultSet rs = ps.executeQuery(query2) ;
 while(rs.next())
 {
 int id = rs.getInt("MAX(USER_ID)");
 

     System.out.println("ID"+id+"'a été ajouté");}
 }
     else
 {
     System.out.println("non ajotué ");
 }
        } catch (SQLException ex) {
            Logger.getLogger(Services_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
        
        
        
    }
    
    @Override
    public boolean authentifier(String u1,String p1)
    {  boolean test=false ;
       
        try {
            String query="Select * from users where  username='"+u1+"' and password='"+p1+"'" ; 
            // String query="Select * from users where  username=? and password=? " ; 
          PreparedStatement ps = con.prepareStatement(query) ;
         
          
  /*  ps.setString(1, u1);
          ps.setString(2, p1);
*/
            
          ResultSet rs=ps.executeQuery(query) ;
              
            
            if(rs.next())
            {
                System.out.println("Connected successfully");
                test= true ;
            }
            else
            {
                System.out.println("Check your credentials");
                test= false ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Services_user.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return test ;
        
    }
    @Override
    
    public String get_role(String u1) 
    {
        String role ="";
        try {
            String query="Select user_role from users where  username='"+u1+"'"  ;
                    PreparedStatement ps = con.prepareStatement(query) ;
              ResultSet rs=   ps.executeQuery(query) ;
              if(rs.next())
              {
                role =  rs.getString("user_role") ;
                System.out.println(rs.getString("user_role"));
                  System.out.println(role);
              }
                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(Services_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return role ;
    }

    @Override
    public void inscription_p(Patient p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int Random()
    {
        Random r = new Random();
 int val = r.nextInt((89999)+1)+10000 ;
return val ;
    }
    @Override
     public int Id_user(String s ) 
            
     {
         String query = "select user_id from users where username=?"; 
         PreparedStatement ps;
         int a =0;
        try {
            ps = con.prepareStatement(query );
             ps.setString(1, s);
         ResultSet rs=ps.executeQuery() ;
         if (rs.next())
         {
             a= rs.getInt("user_id") ;
         }
         
        } catch (SQLException ex) {
            Logger.getLogger(Services_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a ;
     }
     
   
    @Override
     public boolean check_user(String a) 
     {
         boolean test=false ;
         String Query="select username from users" ;
         
        try {
            PreparedStatement st = con.prepareStatement(Query);
         ResultSet rs ;
            rs = st.executeQuery();
         
       if(rs.next())
       {
                 if (a==rs.getString("username"))
                 { System.out.println("existe deja");
                     test=true ;
        }
                 else
                 {
                     test=false ;
                 }
       }
            
        } catch (SQLException ex) {
            Logger.getLogger(Services_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                 
         return test ;
         
        } 
         
     
 @Override
    public boolean validation(int id_user,int code) 
    {
        boolean test=false; 
        try {
            String query= "select code FROM tmp_validation INNER JOIN users WHERE tmp_validation.user_id=? LIMIT 1" ;
            String query2="update users set status='confirmed' where user_id=?" ;
           PreparedStatement ps ;
           PreparedStatement ps2 ;
           
           
          ps = con.prepareStatement(query );
          ps.setInt(1, id_user);
          ResultSet rs = ps.executeQuery() ;
             
             if(rs.next())
             {
             if(code==rs.getInt("code"))
             {
                 ps2 = con.prepareStatement(query2) ;
                 ps2.setInt(1, id_user);
                 ps2.execute() ;
                 
                 test=true ;
                 
             }
             else
             {
                 test=false; 
             }
             }
             
             
        } catch (SQLException ex) {
            Logger.getLogger(Services_user.class.getName()).log(Level.SEVERE, null, ex);
        }
           
          
           return test ;
 
        
    }
      @Override
     public String check_user_confirmation(String a) 
     { 
            
     
         String query = "select status from users where username=?"; 
         PreparedStatement ps;
         String b="" ;
        try {
            ps = con.prepareStatement(query );
             ps.setString(1, a);
         ResultSet rs=ps.executeQuery() ;
         if (rs.next())
         {
             b= rs.getString("status") ;
         }
         
        } catch (SQLException ex) {
            Logger.getLogger(Services_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return b;
     
     }
      @Override
    public int code_valid(int a)
    {
        
         int code=0 ;
        try {
            String query= "select code FROM tmp_validation INNER JOIN users WHERE tmp_validation.user_id=? LIMIT 1" ;
            
           PreparedStatement ps ;
     
           
           
          ps = con.prepareStatement(query );
          ps.setInt(1, a);
          ResultSet rs = ps.executeQuery() ;
             
             if(rs.next())
             {
             code=rs.getInt("code") ;
                 
             }
            
             
             
             
        } catch (SQLException ex) {
            Logger.getLogger(Services_user.class.getName()).log(Level.SEVERE, null, ex);
        }
           
          
           return code; 
    
}

    @Override
    public void inscription_b(Beaute b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
