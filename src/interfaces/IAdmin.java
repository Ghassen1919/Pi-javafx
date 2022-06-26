/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import gui.dev;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import model.User;

/**
 *
 * @author sarawahada
 */
public interface IAdmin extends IUser {
    //addAdmin
    public void AddAdmin(User u,String PasswordUser);
    //ban user
    //public boolean Banned( int UserStatus);
    //update user role
    
        public void UpdateRole(String EmailUser, String UserRole) throws SQLException;
    //update user status (banned or allowed)
        public void UpdateUserStatus(int IDUser, int UserStatus ) throws SQLException;
        public ObservableList<User> GetListUsers() ;
           public boolean UpdateEmployee(User u,int id);

    public ObservableList<dev> GetListdevs();

    public boolean Updatedev(dev u, int id);

   
    
}
