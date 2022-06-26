/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfacegrback.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.gestion.entities.Post;
import edu.gestion.entities.Reclamation;

import edu.gestion.services.ReclamationCRUD;
import edu.gestion.utils.DataBase;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.Cursor;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Home
 */
public class ReclamationcrudController implements Initializable {

    private java.sql.Connection con;
    private Statement ste;

    
    @FXML
    private TableView<Reclamation> tvbooks1;
    
    @FXML
    private TableColumn<Reclamation, String> colnom;
    @FXML
    private TableColumn<Reclamation, Date> coldat;
    @FXML
    private TableColumn<Reclamation, String> coldescri;
    @FXML
    private TableColumn<Reclamation, String> coldat1;

    public final ObservableList<Reclamation> data = FXCollections.observableArrayList();
    @FXML
    private TextField tffiltre;
    @FXML
    private TextField tftraite;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            showREC();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationcrudController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FilteredList<Reclamation> filteredData = new FilteredList<>(data, b -> true);
        tffiltre.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Reclamation -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Reclamation.getNom_réc().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
                                }
				     else  
				    	 return false; // Does not match.
			});
        
        
    }); 
    SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
    sortedData.comparatorProperty().bind(tvbooks1.comparatorProperty());
    tvbooks1.setItems(sortedData);
        
        
    }

    public void showREC() throws SQLException {

        ReclamationCRUD r = new ReclamationCRUD();

        data.addAll(r.readAll1());
          
        
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom_réc"));
        coldat.setCellValueFactory(new PropertyValueFactory<>("date_réc"));
        coldescri.setCellValueFactory(new PropertyValueFactory<>("descri_réc"));
        coldat1.setCellValueFactory(new PropertyValueFactory<>("traite"));
        tvbooks1.setItems(data);
     
       

    }
   
    @FXML
    void click(MouseEvent event) {
        tftraite.setText(tvbooks1.getSelectionModel().getSelectedItem().getTraite());
        
       

    }

    

    @FXML
    private void btmupdat(ActionEvent event) throws SQLException {
       Reclamation A= tvbooks1.getSelectionModel().getSelectedItem();
           
if(tftraite.getText()!=null &&!tftraite.getText().isEmpty()){
        
        String traite = tftraite.getText();
        
        
       
       
       
        
        A.setTraite(traite);
         
         
         
        
        ReclamationCRUD aS = new ReclamationCRUD ();
        if (aS.update(A)){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succes");
        alert.setHeaderText(null);
        alert.setContentText("La modification d'event a ete effectue avec succees");
        alert.showAndWait();
        data.clear();
        showREC();
        }else{
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("La modification d'event n'a pas ete effectue!");
        alert.showAndWait(); 
        data.clear();
        showREC();
        }
    }
       else{
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setContentText("veuillez remplir tous les chapms!");
                alert.show();
                data.clear();
                 showREC();
                 }
    }
    

    @FXML
    private void btmdelet(ActionEvent event) throws SQLException {
      Reclamation A = tvbooks1.getSelectionModel().getSelectedItem();
      //tvbooks1.getItems().removeAll(tvbooks1.getSelectionModel().getSelectedItem());//
        ReclamationCRUD aS = new  ReclamationCRUD();
        if (aS.delete(A)){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succees");
        alert.setHeaderText(null);
        alert.setContentText("La suppression d'event a ete effectuee avec succees");
        alert.showAndWait();
        
         
        }else{
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("La supression d'event n'a pas ete effectuee!");
        alert.showAndWait();  
        
        
        }
    }
    @FXML
    
    void imprime(ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
          
         try {
              java.sql.Connection con = DataBase.getInstance().getConnection();
                          Statement stmt = con.createStatement();
              
 
                    /* Define the SQL query */
                    ResultSet query_set = stmt.executeQuery("SELECT * From reclamation");
                    /* Step-2: Initialize PDF documents - logical objects */
                    Document my_pdf_report = new Document();
                    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("ReclamationData.pdf"));
                    
                    my_pdf_report.open();
                    my_pdf_report.add(new Paragraph("                                   Reclamation Data",FontFactory.getFont("Arial", 20)));
                     my_pdf_report.add(new Paragraph("  "));
                     my_pdf_report.add(new Paragraph("  "));
                    
                    //we have four columns in our table
                    
                    PdfPTable my_report_table = new PdfPTable(4);
                   
                    //create a cell object
                    PdfPCell table_cell;
                    table_cell=new PdfPCell(new Phrase("nom"));
                                   my_report_table.addCell(table_cell);
                                   table_cell=new PdfPCell(new Phrase("date"));
                                   my_report_table.addCell(table_cell);
                                   table_cell=new PdfPCell(new Phrase("description"));
                                   my_report_table.addCell(table_cell);
                                   table_cell=new PdfPCell(new Phrase("traité ou non"));
                                   my_report_table.addCell(table_cell);
                                   

                    while (query_set.next()) {                
                                    String nom_réc = query_set.getString("nom_rec");
                                    table_cell=new PdfPCell(new Phrase(nom_réc));
                                   my_report_table.addCell(table_cell);
                                    String date_réc=query_set.getString("date_rec");
                                    table_cell=new PdfPCell(new Phrase(date_réc));
                                    my_report_table.addCell(table_cell);
                                    String descri_réc=query_set.getString("descri_rec");
                                    table_cell=new PdfPCell(new Phrase(descri_réc));
                                    my_report_table.addCell(table_cell);
                                   String traite=query_set.getString("traite");
                                    table_cell=new PdfPCell(new Phrase(traite));
                                    my_report_table.addCell(table_cell);
                                     
                                    
                                    }
                     Notifications notifications=Notifications.create();
        //notifications.graphic(new ImageView(image));//
        notifications.text("PDF genere avec succee");
        notifications.title("Notification");
        notifications.hideAfter(Duration.seconds(4));
        notifications.darkStyle();
       // notifications.position(Pos.BOTTOM_LEFT);
        notifications.show();
                    /* Attach report table to PDF */
                     my_pdf_report.addTitle("Reclamation Data");
                    my_pdf_report.add(my_report_table); 
                   
                  
                    
                    my_pdf_report.close();
                  

                    
                    



    } catch (FileNotFoundException e) {
   
    e.printStackTrace();
    } catch (DocumentException e) {
    
    e.printStackTrace();
     
      
   
          


    
                    }

    
    

}
}
