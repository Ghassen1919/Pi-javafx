/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mega-PC
 */
public class MenuController implements Initializable {

    @FXML
    private Button gesuser;
    @FXML
    private Button gesdev;
    @FXML
    private Button gesgrp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private void userEvent(ActionEvent event) throws SQLException, IOException {
        scene = new Scene(FXMLLoader.load(getClass().getResource("AdminDashboard.fxml")));
                dialogStage.setScene(scene);
                dialogStage.show();
    }
    @FXML
    private void userdev(ActionEvent event) throws SQLException, IOException {
        scene = new Scene(FXMLLoader.load(getClass().getResource("admindash2.fxml")));
                dialogStage.setScene(scene);
                dialogStage.show();
    }
    
@FXML
    private void pdf(ActionEvent event) throws SQLException, IOException, DocumentException, ClassNotFoundException {
       
         Document document=new Document();
       PdfWriter.getInstance(document,new FileOutputStream("data.pdf"));
       document.open();
       PdfPTable table=new PdfPTable(4);
        table.addCell("grpname");
       table.addCell("fullname");
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion actualité", "root", "");
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("Select * from dev");
       while(rs.next()){
         
       table.addCell(rs.getString("grpname"));
       table.addCell(rs.getString("fullname"));
       table.addCell(rs.getString("mail"));
       table.addCell(rs.getString("gender"));
       
       }
       document.add(table);
       document.close();
   }
    @FXML
      private void excel(ActionEvent event) throws SQLException, IOException, DocumentException, ClassNotFoundException { 
           
  excel exporter = new excel();
        exporter.export("dev");
    
      }
    
}
    
