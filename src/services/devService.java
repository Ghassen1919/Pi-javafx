/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author Mega-PC
 */
import gui.dev;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import interfaces.Idev;
import model.User;
import util.maConnexion;
import util.BCrypt;


public class devService implements Idev{
    
    //var
    Connection cnx = maConnexion.getInstance().getCnx();

    @Override
     
    public void Adddev(dev d) {
        
       String Req = "INSERT INTO `dev`(`grpname`, `fullname`, `mail`, `gender`) VALUES (?,?,?,?)";
        try {
           
            PreparedStatement su = cnx.prepareStatement(Req);
            su.setString(1, d.getgrpname());
            su.setString(2, d.getfullname());
            su.setString(3, d.getmail());
            su.setString(4,d.getgender());
       
            su.execute();
            System.out.println("developper added!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
}
//ShowUser
    @Override
    public List<dev> Showdev() {
        List<dev> devs = new ArrayList<>();
        
        String query = "SELECT * FROM dev";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                devs.add(new dev(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return devs;
    }
    
//UpdateUser
    @Override
            public boolean Updatedev(dev d,int id){

        try {
            
            String sql = "UPDATE dev SET grpname =?, fullname=?, mail=?, gender=?  WHERE id=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setString(1, d.getgrpname());
            statement.setString(2, d.getfullname());
            statement.setString(3, d.getmail());
            statement.setString(4, d.getgender());
        
     statement.setInt(6, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing dev was updated successfully!");
            }       }
        catch (SQLException ex) {
               System.out.println(ex.getMessage());
 
        }
            return true;
            }
   //Update UserName  
            @Override
        public void Updatefullname(String mail, String fullname) throws SQLException{
        String sql= "UPDATE dev SET fullname='"+ fullname +"'"+"WHERE mail='"+ mail+"'";
        PreparedStatement statement = cnx.prepareStatement(sql);
        int rowsUpdated = statement.executeUpdate(sql);
        if (rowsUpdated > 0) {
             System.out.println("name updated successfully!");
         }
    }
    //Update Password
                
    
    
  //update profile picture
    

//DeleteUser
                   @Override
            public void Deletedev(int id){
                    
  try {
            String sql = "Delete FROM dev WHERE id=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("dev deleted!");
            }       }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        }
            }
            
        //search user by username
            @Override
               public dev getUserByfullname(String fullname) throws SQLException{
        String sql="SELECT * FROM dev WHERE fullname='"+fullname+"'";
        Statement statement = cnx.prepareStatement(sql);
        //statement.executeUpdate(sql);
        ResultSet rs = statement.executeQuery(sql);
        dev d = new dev();
       while(rs.next()){
                d.setid(rs.getInt("id"));
                d.setgrpname(rs.getString("grpname"));
                d.setfullname(rs.getString("fullname")); 
                d.setmail(rs.getString("mail"));
                d.setgender(rs.getString("gender"));
               
            }
       return d ;
    }
               
               //search user by mail 
        @Override
        public dev getdevbymail(String mail) throws SQLException{
        String sql="SELECT * FROM dev WHERE mail='"+mail+"'";
        Statement statement = cnx.prepareStatement(sql);
        //statement.executeUpdate(sql);
        ResultSet rs = statement.executeQuery(sql);
        dev d = new dev();
       while(rs.next()){
                d.setid(rs.getInt("id"));
                d.setgrpname(rs.getString("grpname"));
                d.setfullname(rs.getString("fullname")); 
                d.setmail(rs.getString("mail"));
                d.setgender(rs.getString("gender"));
                
               
            }
       return d ;
    }
        //search  id by mail used in SendMail to verify that the user has an account
          @Override
             public int getIdbyMail(String mail) throws SQLException {
            PreparedStatement st = cnx.prepareStatement("select id from dev where mail=?");
            st.setString(1, mail);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("id"); 
                           }
        return 0;
             }
                      @Override
             public int getId() throws SQLException  {
            String sql="SELECT id FROM dev ";
            Statement statement = cnx.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id =  rs.getInt("id"); 
                return id;
                           }
        return 0;
             }
             //search role by id used to determine role when logging in to determine dashboard to show

             

   //search  mail by id used in SendMail to verify that the user has an account
          @Override
             public String getMailbyId(int id) throws SQLException {
     
            PreparedStatement st = cnx.prepareStatement("select mail from dev where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
            return rs.getString("mail"); 
        }
return "";
}

    @Override
    public String getNamebyId(int id) throws SQLException {
               PreparedStatement st = cnx.prepareStatement("select fullname from dev where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
            return rs.getString("fullname"); 
        }
return "";
             
}
        @Override
    public String getgrpNamebyId(int id) throws SQLException {
               PreparedStatement st = cnx.prepareStatement("select grpname from dev where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
            return rs.getString("grpname"); 
        }
return "";
             
}

     //To change body of generated methods, choose Tools | Templates.
    }

    

    

    
        

    

