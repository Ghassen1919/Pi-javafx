/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import entities.games;
import com.mysql.jdbc.Connection;
import static java.lang.Class.forName;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI GL-65
 */
public class gamesconnect {

    Connection conn = null;
    
    public static Connection ConnectDb()         {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion actualité","root","");
            JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public static ObservableList<games> getDatagames(){
         
        Connection conn = ConnectDb();
        ObservableList<games> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from games;");
            ResultSet rs = ps.executeQuery();        
                  
            while(rs.next()){
       
                list.add(new games(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
            
        }catch(Exception e){
            
        }   
        
        return list;
    }
  
}