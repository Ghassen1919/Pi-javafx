/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import interfaces.IUser;
import model.User;
import util.maConnexion;
import util.BCrypt;


public class UserService implements IUser{
    
    //var
    Connection cnx = maConnexion.getInstance().getCnx();

    @Override
     public boolean Login(String EmailUser, String PasswordUser ) throws Exception  {
        if (!EmailUser.isEmpty() && !PasswordUser.isEmpty() ) {
            String requete = "SELECT password, status FROM user WHERE email = '" + EmailUser +"'";      
            Statement s = maConnexion.getInstance().getCnx().createStatement();
            ResultSet rs = s.executeQuery(requete);
                    if (rs.next()){
                        if(BCrypt.checkpw(PasswordUser,rs.getString("password")))
                                { 
                                    if (rs.getInt("status")==1)
                                        {                        
                            System.out.println("login success");
                            return true;
                                        }
                                
                                else{ 
                                    System.out.println("you were banned from using this app check your email for more information");
                                    return false;
                                }      
                        }
                    else {
                        System.out.println("Please enter correct Email or Password"); 
                        return false;
                    }   
                    }
                    else{
                        System.out.println("Please enter correct Email or Password");  
                        return false;
                    } 
        }
        else {
            System.out.println("fill missing infos!");
            return false;
           
        }
        
        }
  
       
     //addUser
       @Override
    public void AddUser(User u,String PasswordUser) {
        
       String Req = "INSERT INTO `user`(`first_name`, `Last_name`, `email`, `roles`,`password`,`ProfilePicUser`) VALUES (?,?,?,?,?,?)";
        try {
            String hashedpw = BCrypt.hashpw(PasswordUser, BCrypt.gensalt(12));
            PreparedStatement su = cnx.prepareStatement(Req);
            su.setString(1, u.getNameUser());
            su.setString(2, u.getLastNameUser());
            su.setString(3, u.getEmailUser());
            su.setString(4, u.getUserRole());
            su.setString(5, hashedpw);
            su.setString(6,u.getProfilePicUser());
            su.execute();
            System.out.println("User added!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
}
//ShowUser
    @Override
    public List<User> ShowUser() {
        List<User> users = new ArrayList<>();
        
        String query = "SELECT * FROM user";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return users;
    }
    
//UpdateUser
    @Override
            public boolean UpdateUser(User u,int IdUser){

        try {
            String cpass=BCrypt.hashpw(u.getPasswordUser(), BCrypt.gensalt(12));
            String sql = "UPDATE user SET first_name =?, last_name=?, email=?, password=?, ProfilePicUser=? WHERE id=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setString(1, u.getNameUser());
            statement.setString(2, u.getLastNameUser());
            statement.setString(3, u.getEmailUser());
            statement.setString(4, cpass);
            statement.setString(5, u.getProfilePicUser());
            statement.setInt(6, IdUser);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }       }
        catch (SQLException ex) {
               System.out.println(ex.getMessage());
 
        }
            return true;
            }
   //Update UserName  
            @Override
        public void UpdateUsername(String EmailUser, String NameUser) throws SQLException{
        String sql= "UPDATE user SET first_name='"+ NameUser +"'"+"WHERE email='"+ EmailUser+"'";
        PreparedStatement statement = cnx.prepareStatement(sql);
        int rowsUpdated = statement.executeUpdate(sql);
        if (rowsUpdated > 0) {
             System.out.println("username updated successfully!");
         }
    }
    //Update Password
                @Override
       public void UpdatePassword(String EmailUser, String PasswordUser) throws SQLException{
       String cpass=BCrypt.hashpw(PasswordUser, BCrypt.gensalt(12));
       String sql= "UPDATE user SET password='"+ cpass +"'"+"WHERE email='"+ EmailUser+"'";
       PreparedStatement statement = cnx.prepareStatement(sql);
       int rowsUpdated = statement.executeUpdate(sql);
       if (rowsUpdated > 0) {
             System.out.println("password updated successfully!");
         }
    }
    
    
  //update profile picture
    @Override
        public void UpdateProfilePicUser(String EmailUser, String ProfilePicUser) throws SQLException{
        String sql= "UPDATE user SET ProfilePicUser='"+ ProfilePicUser +"'"+"WHERE email='"+ EmailUser+"'";
        PreparedStatement statement = cnx.prepareStatement(sql);
        int rowsUpdated = statement.executeUpdate(sql);
         if (rowsUpdated > 0) {
             System.out.println("profile picture updated successfully!");
         }
    }

//DeleteUser
                   @Override
            public void DeleteUser(int IdUser){
                    
  try {
            String sql = "Delete FROM user WHERE id=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setInt(1, IdUser);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User deleted!");
            }       }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        }
            }
            
        //search user by username
            @Override
               public User getUserByNameUser(String NameUser) throws SQLException{
        String sql="SELECT * FROM user WHERE first_name='"+NameUser+"'";
        Statement statement = cnx.prepareStatement(sql);
        //statement.executeUpdate(sql);
        ResultSet rs = statement.executeQuery(sql);
        User u = new User();
       while(rs.next()){
                u.setIdUser(rs.getInt("id"));
                u.setNameUser(rs.getString("first_name"));
                u.setLastNameUser(rs.getString("last_name")); 
                u.setEmailUser(rs.getString("email"));
                u.setUserRole(rs.getString("roles"));
                u.setUserStatus(rs.getInt("status")); 
                u.setProfilePicUser(rs.getString("ProfilePicUser"));
              
               
            }
       return u ;
    }
               
               //search user by mail 
        @Override
        public User getUserByMail(String EmailUser) throws SQLException{
        String sql="SELECT * FROM user WHERE email='"+EmailUser+"'";
        Statement statement = cnx.prepareStatement(sql);
        //statement.executeUpdate(sql);
        ResultSet rs = statement.executeQuery(sql);
        User u = new User();
       while(rs.next()){
                u.setIdUser(rs.getInt("id"));
                u.setNameUser(rs.getString("first_name"));
                u.setLastNameUser(rs.getString("last_name")); 
                u.setEmailUser(rs.getString("email"));
                 u.setUserRole(rs.getString("roles"));
                u.setUserStatus(rs.getInt("status"));
                u.setProfilePicUser(rs.getString("ProfilePicUser"));
                
               
            }
       return u ;
    }
        //search  id by mail used in SendMail to verify that the user has an account
          @Override
             public int getIdbyMail(String EmailUser) throws SQLException {
            PreparedStatement st = cnx.prepareStatement("select id from user where email=?");
            st.setString(1, EmailUser);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("id"); 
                           }
        return 0;
             }
                      @Override
             public int getId() throws SQLException  {
            String sql="SELECT id FROM user ";
            Statement statement = cnx.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id =  rs.getInt("id"); 
                return id;
                           }
        return 0;
             }
             //search role by id used to determine role when logging in to determine dashboard to show

             @Override
             public String getRolebyId(int IdUser) throws SQLException {
     
            PreparedStatement st = cnx.prepareStatement("select roles from user where id=?");
            st.setInt(1, IdUser);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("roles");
            
        }
        return "";
             }

   //search  mail by id used in SendMail to verify that the user has an account
          @Override
             public String getMailbyId(int IdUser) throws SQLException {
     
            PreparedStatement st = cnx.prepareStatement("select EmailUser from user where IdUser=?");
            st.setInt(1, IdUser);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
            return rs.getString("email"); 
        }
return "";
}

    @Override
    public String getNamebyId(int IdUser) throws SQLException {
               PreparedStatement st = cnx.prepareStatement("select first_name from user where id=?");
            st.setInt(1, IdUser);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
            return rs.getString("first_name"); 
        }
return "";
             
}
        @Override
    public String getLastNamebyId(int IdUser) throws SQLException {
               PreparedStatement st = cnx.prepareStatement("select last_name from user where id=?");
            st.setInt(1, IdUser);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
            return rs.getString("last_name"); 
        }
return "";
             
}

    @Override
    public String getStatusbyId(int IdUser) throws SQLException {
            PreparedStatement st = cnx.prepareStatement("select status from user where id=?");
            st.setInt(1, IdUser);
            ResultSet rs = st.executeQuery();
            if (rs.next()) { 
            if( "1".equals(rs.getString("status"))){
                return "allowed";
            } 
         else if ("0".equals(rs.getString("satus"))){
            return "blocked";
                    }
            }
return "";
             
}

    @Override
    public String getProfilePicbyId(int IdUser) throws SQLException {
              PreparedStatement st = cnx.prepareStatement("select ProfilePicUser from user where id=?");
            st.setInt(1, IdUser);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
            return rs.getString("ProfilePicUser"); 
        }
return "";
    
}
        @Override
    public String getPasswordbyMail(String EmailUser) throws SQLException {
            PreparedStatement st = cnx.prepareStatement("select password from user where email=?");
            st.setString(1, EmailUser);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
            return rs.getString("password"); 
        }
return "";
    
}

    
}
