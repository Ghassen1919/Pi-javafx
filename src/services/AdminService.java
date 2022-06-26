
package services;

import gui.dev;
import interfaces.IAdmin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.User;
import util.BCrypt;

/**
 *
 * @author sarawahada
 */
public class AdminService extends UserService implements IAdmin {
     //addUser
       @Override
    public void AddAdmin(User u,String PasswordUser) {
        
       String Req = "INSERT INTO `user`(`first_name`, `last_name`, `email`, `roles`, `password`, `status`, `ProfilePicUser`) VALUES (?,?,?,?,?,?,?)";
        try {
            String hashedpw = BCrypt.hashpw(PasswordUser, BCrypt.gensalt(12));
            PreparedStatement su = cnx.prepareStatement(Req);
            su.setString(1, u.getNameUser());
            su.setString(2, u.getLastNameUser());
            su.setString(3, u.getEmailUser());
            su.setString(4,u.getProfilePicUser());
            su.setString(5, hashedpw);
            su.setString(6, u.getUserRole());
            su.setInt(7, u.getUserStatus());
            su.execute();
            System.out.println("admin added!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
}
        //update user
        @Override
            public boolean UpdateEmployee(User u,int IdUser){

        try {
           
            String sql = "UPDATE user SET roles=?,status=? WHERE id=?";

            PreparedStatement statement = cnx.prepareStatement(sql);

            statement.setString(1, u.getUserRole());
            statement.setInt(2, u.getUserStatus());
            statement.setInt(3, IdUser);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }       }
        catch (SQLException ex) {
               System.out.println(ex.getMessage());
 
        }
            return true;
            }
            //update user role
@Override
              public void UpdateRole(String EmailUser, String UserRole) throws SQLException{
        String sql= "UPDATE user SET roles='"+ UserRole +"'"+"WHERE email='"+ EmailUser+"'";
        PreparedStatement statement = cnx.prepareStatement(sql);
        statement.executeUpdate(sql);
    }
              //update user status
 @Override
             public void UpdateUserStatus(int IDUser, int UserStatus ) throws SQLException{
        System.out.println(UserStatus);
        String sql= "UPDATE user SET status='"+ UserStatus +"'"+"WHERE id='"+ IDUser +"'";
         PreparedStatement statement = cnx.prepareStatement(sql);
        statement.executeUpdate(sql);
    }
                 @Override
    public ObservableList<User> GetListUsers() {
        ObservableList<User> Users = FXCollections.observableArrayList();
        try {
            String sql = "SELECT id,first_name,last_name,email,roles,status FROM user";
             PreparedStatement statement = cnx.prepareStatement(sql);
              ResultSet rs = statement.executeQuery(sql);
            User user;
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"),rs.getString("roles"),rs.getInt("status"));
                Users.add(user);
            }

        } catch (SQLException ex) {
            
        }
        return Users;
    }

    
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
        //update user
   
            public boolean Updatedev(dev d,int id){

        try {
           
            String sql = "UPDATE dev SET grpname=?,gender=? WHERE id=?";

            PreparedStatement statement = cnx.prepareStatement(sql);

            statement.setString(1, d.getgrpname());
            statement.setString(2, d.getgender());
            statement.setInt(3, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing developper was updated successfully!");
            }       }
        catch (SQLException ex) {
               System.out.println(ex.getMessage());
 
        }
            return true;
            }
            //update user role
              public void Updategrpname(String mail, String grpname) throws SQLException{
        String sql= "UPDATE dev SET grpname='"+ grpname +"'"+"WHERE mail='"+ mail+"'";
        PreparedStatement statement = cnx.prepareStatement(sql);
        statement.executeUpdate(sql);
    }
              //update user status
 
             public void Updategender(int id, String gender ) throws SQLException{
        System.out.println(gender);
        String sql= "UPDATE dev SET gender='"+ gender +"'"+"WHERE id='"+ id +"'";
         PreparedStatement statement = cnx.prepareStatement(sql);
        statement.executeUpdate(sql);
    }
                
       @Override
    public ObservableList<dev> GetListdevs() {
        ObservableList<dev> devs = FXCollections.observableArrayList();
        try {
            String sql = "SELECT id,grpname,fullname,mail,gender FROM dev";
             PreparedStatement statement = cnx.prepareStatement(sql);
              ResultSet rs = statement.executeQuery(sql);
            dev dev;
            while (rs.next()) {
                dev = new dev(rs.getInt("id"), rs.getString("grpname"), rs.getString("fullname"), rs.getString("mail"),rs.getString("gender"));
                devs.add(dev);
            }

        } catch (SQLException ex) {
            
        }
        return devs; 
    }
    }

    

    

    
    

