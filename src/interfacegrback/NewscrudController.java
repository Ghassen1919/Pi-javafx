/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacegrback;
import edu.gestion.utils.DataBase;
import java.sql.SQLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import edu.gestion.utils.DataBase;
import edu.gestion.services.PostCrud;
import com.mysql.jdbc.Connection;
import edu.gestion.entities.Post;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.Cursor;
import javafx.scene.chart.PieChart;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;



/**
 * FXML Controller class
 *
 * @author Home
 */
public class NewscrudController implements Initializable {
    private java.sql.Connection con;
    private Statement ste;

    @FXML
    private TextField tftitre;
    @FXML
    private TextField tfauteur;
    @FXML
    private TextField tfimage;
    @FXML
    private TableView<Post> tvbooks;
    
    @FXML
    private TableColumn<Post, String> coltitre;
    @FXML
    private TableColumn<Post, String> colauteur;
    @FXML
    private TableColumn<Post, String> colimg;
    @FXML
    private TableColumn<Post, Date> coldate;
    
    public final ObservableList<Post> data =FXCollections.observableArrayList();
    @FXML
    private TextField tffiltre;
    @FXML
    private TableColumn<Post, Integer> colrate;
  
    PostCrud p= new PostCrud();
    @FXML
    private TextField imageFld;
    @FXML
    private PieChart pie;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        try {
            
           showPost();
        } catch (SQLException ex) {
            Logger.getLogger(NewscrudController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FilteredList<Post> filteredData = new FilteredList<>(data, b -> true);
        tffiltre.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Post -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Post.getTitre().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (Post.getAuteur().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
                                }
				     else  
				    	 return false; // Does not match.
			});
        
        
    }); 
    SortedList<Post> sortedData = new SortedList<>(filteredData);
    sortedData.comparatorProperty().bind(tvbooks.comparatorProperty());
    tvbooks.setItems(sortedData);
    
    ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data("ghassen", 6),
                        new PieChart.Data("adam", 3),
                       
                        new PieChart.Data("fatma", 2)
                );
//
//        pieChartData.forEach(data
//                -> data.nameProperty().bind(
//                        Bindings.concat(
//                                data.getName(), " amount: ", data.pieValueProperty()
//                        )
//                )
//        );

        pie.getData().addAll(pieChartData);
        
    }  
    

    
    
        
        
    
    
    
    /**
     *
     * @throws java.sql.SQLException
     */
   
        
    
    public void showPost() throws SQLException{
        PostCrud p = new PostCrud();
        
        data.addAll(p.readAll());
         
          coltitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
           colauteur.setCellValueFactory(new PropertyValueFactory<>("auteur"));
            colimg.setCellValueFactory(new PropertyValueFactory<>("img_post"));
             coldate.setCellValueFactory(new PropertyValueFactory<>("date_post"));
             colrate.setCellValueFactory(new PropertyValueFactory<>("rate"));
        
         tvbooks.setItems(data);
         
         
        
    }
    
        
    @FXML
    private void btminsert(ActionEvent event) throws SQLException {
        String titre = tftitre.getText();
        String auteur = tfauteur.getText();
        String img_post = tfimage.getText();
        String image=imageFld.getText();
       
        
          Post p = new Post(tftitre.getText(),tfauteur.getText(),tfimage.getText(),imageFld.getText());
        
       PostCrud pst = new PostCrud();
        if((tftitre.getText()!=null &&!tftitre.getText().isEmpty())&&(tfauteur.getText()!=null && !tfauteur.getText().isEmpty() )&& (tfimage.getText()!=null&&!tfimage.getText().isEmpty()))//||(tfauteur.getText()!=null &&!tfauteur.getText().isEmpty())||(tfimage.getText()!=null &&!tfimage.getText().isEmpty());
        {
        pst.ajouter(p);
        
         try {
              
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Done");
                alert.setContentText("Added!");
                alert.show();
                data.clear();
                showPost();
                        
               
                
               
            } catch (SQLException ee) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.show();
                data.clear();
                 showPost();

            }
        }
         else{
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setContentText("veuillez remplir tous les chapms!");
                alert.show();
                data.clear();
                 showPost();
                 }
    }

    
    @FXML
    void click(MouseEvent event) {
        tftitre.setText(tvbooks.getSelectionModel().getSelectedItem().getTitre());
        tfauteur.setText(tvbooks.getSelectionModel().getSelectedItem().getAuteur());
        tfimage.setText(tvbooks.getSelectionModel().getSelectedItem().getImg_post());

    }
    @FXML
    private void btmupdate(ActionEvent event) throws SQLException {
        Post A= tvbooks.getSelectionModel().getSelectedItem();
        
           
        System.out.println(tvbooks.getSelectionModel().getSelectedItem());
        
        String titre = tftitre.getText();
        String image = tfimage.getText();
        String auteur = tfauteur.getText();
        
       
      
       
        if((tftitre.getText()!=null &&!tftitre.getText().isEmpty())&&(tfauteur.getText()!=null && !tfauteur.getText().isEmpty() )&& (tfimage.getText()!=null&&!tfimage.getText().isEmpty()))
        {A.setTitre(titre);
         A.setAuteur(auteur);
         A.setImg_post(image);
         A.setImage(imageFld.getText());
         A.setImag(imageFld.getText());
        
        PostCrud aS = new PostCrud();
        
       if (aS.update(A)){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succes");
        alert.setHeaderText(null);
        alert.setContentText("La modification d'event a ete effectue avec succees");
        alert.showAndWait();
        data.clear();
        showPost();
        }else{
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("La modification d'event n'a pas ete effectue!");
        alert.showAndWait();
        data.clear();
        showPost();
        }
    }else{
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setContentText("veuillez remplir tous les chapms!");
                alert.show();
                data.clear();
                 showPost();
                 }
    }
        
    
    

    @FXML
    private void btmdelete(ActionEvent event)throws SQLException {
       Post A= tvbooks.getSelectionModel().getSelectedItem();
//       tvbooks.getItems().removeAll(tvbooks.getSelectionModel().getSelectedItem());
       PostCrud aS = new PostCrud();

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
    
    void Imprimer(ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
          
         try {
              java.sql.Connection con = DataBase.getInstance().getConnection();
                          Statement stmt = con.createStatement();
              
 
                    /* Define the SQL query */
                    ResultSet query_set = stmt.executeQuery("SELECT * From post");
                    /* Step-2: Initialize PDF documents - logical objects */
                    Document my_pdf_report = new Document();
                    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("NewsData.pdf"));
                    
                    my_pdf_report.open();
                    my_pdf_report.add(new Paragraph("                                      News Data",FontFactory.getFont("Arial", 20)));
                     my_pdf_report.add(new Paragraph("  "));
                     my_pdf_report.add(new Paragraph("  "));
                    
                    //we have four columns in our table
                    
                    PdfPTable my_report_table = new PdfPTable(5);
                   
                    //create a cell object
                    PdfPCell table_cell;
                    table_cell=new PdfPCell(new Phrase("titre"));
                                   my_report_table.addCell(table_cell);
                                   table_cell=new PdfPCell(new Phrase("auteur"));
                                   my_report_table.addCell(table_cell);
                                   table_cell=new PdfPCell(new Phrase("description"));
                                   my_report_table.addCell(table_cell);
                                   table_cell=new PdfPCell(new Phrase("date"));
                                   my_report_table.addCell(table_cell);
                                    table_cell=new PdfPCell(new Phrase("rate"));
                                   my_report_table.addCell(table_cell);

                    while (query_set.next()) {                
                                    String titre = query_set.getString("titre");
                                    table_cell=new PdfPCell(new Phrase(titre));
                                   my_report_table.addCell(table_cell);
                                    String auteur=query_set.getString("auteur");
                                    table_cell=new PdfPCell(new Phrase(auteur));
                                    my_report_table.addCell(table_cell);
                                    String img_post=query_set.getString("img_post");
                                    table_cell=new PdfPCell(new Phrase(img_post));
                                    my_report_table.addCell(table_cell);
                                   String date_post=query_set.getString("date_post");
                                    table_cell=new PdfPCell(new Phrase(date_post));
                                    my_report_table.addCell(table_cell);
                                     String rate = query_set.getString("rate");
                                    table_cell=new PdfPCell(new Phrase(rate));
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
                     my_pdf_report.addTitle("News Data");
                    my_pdf_report.add(my_report_table); 
                   
                  
                    
                    my_pdf_report.close();
                  

                    
                    



    } catch (FileNotFoundException e) {
   
    e.printStackTrace();
    } catch (DocumentException e) {
    
    e.printStackTrace();
     
      
   
          


    
                    }

    
    

    
    }

    @FXML
    private void upload(ActionEvent event) {
         FileChooser fc = new FileChooser();
        String imageFile = "";
        File f = fc.showOpenDialog(null);

        if (f != null) {
            imageFile = f.getAbsolutePath();
            String newimageFile = imageFile.replace("C:\\Users\\Home\\Downloads\\pidev\\G-actualite\\src\\resources\\","");

            imageFld.setText(newimageFile);
    }

   

    
    }
}
    

    
    


