/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Mega-PC
 */
import gui.dev;
import java.sql.SQLException;
import java.util.List;
import model.User;

public interface Idev {
    //Add
    public void Adddev(dev d);
    //List
    public List<dev> Showdev();
    //Update user except status and role
    public boolean Updatedev(dev d,int id);
   //Delete 
    public void Deletedev( int id);
    //login 
   
    //BanUser
    //public boolean Banned( int UserStatus);
    //Update username
    public void Updatefullname(String mail, String fullname) throws SQLException;
    //Update password
  
  
    //search user by username
     public dev getUserByfullname(String NameUser) throws SQLException;
    //search user by mail
     public dev getdevbymail(String EmailUser)throws SQLException;
     //search role by mail
     public int getIdbyMail(String mail) throws SQLException;
      //search role by Id
  
     //search mail by id
     public String getMailbyId(int id) throws SQLException;
     //search name using id
     public String getNamebyId(int id) throws SQLException;
     //search last name using id
     public String getgrpNamebyId(int id) throws SQLException;
      //search status using id
  
      //display all users id
     public int getId() throws SQLException;} 