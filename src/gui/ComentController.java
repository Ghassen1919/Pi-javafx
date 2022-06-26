/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import edu.gestion.entities.Post;
import edu.gestion.entities.Comentaire;
import edu.gestion.services.ComentaireCrud;
import edu.gestion.services.PostCrud;
import interfacegrback.CommentaireCrudController;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Home
 */
public class ComentController implements Initializable {

    @FXML
    private TextArea tfcom;
    
    
    
    //
    /*

    /**
     * Initializes the controller class.
     */
    Post p=new Post();
    @FXML
    private TableView<Comentaire> tvbooks;
    @FXML
    private TableColumn<Comentaire, String> colnom;
    @FXML
    private TableColumn<Comentaire, String> colcom;
    public final ObservableList<Comentaire> data =FXCollections.observableArrayList();
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ComentaireCrud p1 = new ComentaireCrud();
        try {

            showPost();

            System.out.println(p1.readAll1());
        } catch (SQLException ex) {
            Logger.getLogger(ComentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void showPost() throws SQLException{
        ComentaireCrud p1 = new ComentaireCrud();
       
        data.addAll(p1.postCommentaires(p.getTest()));
         
          colnom.setCellValueFactory(new PropertyValueFactory<>("nom_com"));
           colcom.setCellValueFactory(new PropertyValueFactory<>("descri_com"));
            
        
         tvbooks.setItems(data);
        
         
        
    }

    @FXML
    private void btmisert(ActionEvent event) throws SQLException {
          
       
       String descri_com = tfcom.getText();
         
      
       
          Comentaire r = new Comentaire (tfcom.getText(),p.getTest());
        
       ComentaireCrud pst11 = new ComentaireCrud();
        if((tfcom.getText()!=null &&!tfcom.getText().isEmpty())){
        pst11.ajouter(r);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Done");
        alert.setContentText("commentaire effectuee!");
        alert.show();
    }else{
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setContentText("veuillez saisir votre commentaire ou verifier le nom!");
                alert.show();
        }
   
}

}
