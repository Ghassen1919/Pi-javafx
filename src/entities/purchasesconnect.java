
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.mysql.jdbc.Connection;
import static entities.gamesconnect.ConnectDb;
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
public class purchasesconnect {
    


    
    public static ObservableList<purchases> getDatapur(){
         
        Connection conn = ConnectDb();
        ObservableList<purchases> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement("select id,rib from achat");
            ResultSet rs = ps.executeQuery();        
                  
            while(rs.next()){
       
                list.add(new purchases(rs.getInt(1),rs.getInt(2)));
            }
            
        }catch(Exception e){
            
        }   
        
        return list;
    }
    
}
