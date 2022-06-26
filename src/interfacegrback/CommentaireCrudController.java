/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacegrback;

import edu.gestion.utils.DataBase;
import edu.gestion.services.ComentaireCrud;
import com.mysql.jdbc.Connection;
import edu.gestion.entities.Comentaire;
import java.net.URL;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.Cursor;

/**
 * FXML Controller class
 *
 * @author Home
 */
public class CommentaireCrudController implements Initializable {

    private java.sql.Connection con;
    private Statement ste;

    @FXML
    private TableView<Comentaire> tvbooks;

    @FXML
    private TableColumn<Comentaire, String> coltitre;
    @FXML
    
    private TableColumn<Comentaire, String> colauteur;
    @FXML
    private TableColumn<Comentaire, String> coldate;
    @FXML
    private TableColumn<Comentaire, Date> colimg;
   
    

    public final ObservableList<Comentaire> data = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComentaireCrud p = new ComentaireCrud();
        try {

            showcom();

            System.out.println(p.postCommentaire());
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireCrudController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @throws java.sql.SQLException
     */
    public void showcom() throws SQLException {
        ComentaireCrud p = new ComentaireCrud();

        data.addAll(p.postCommentaire());
         
        //System.out.println(data);//

        coltitre.setCellValueFactory(new PropertyValueFactory<>("nom_com"));
        colauteur.setCellValueFactory(new PropertyValueFactory<>("descri_com"));
       
        colimg.setCellValueFactory(new PropertyValueFactory<>("date_com"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("titre_post"));
        tvbooks.setItems(data);
        
        

    }

    @FXML
    private void btmdelete(ActionEvent event) throws SQLException {
        Comentaire A = tvbooks.getSelectionModel().getSelectedItem();
       // tvbooks.getItems().removeAll(tvbooks.getSelectionModel().getSelectedItem());
        ComentaireCrud aS = new ComentaireCrud();

        if (aS.delete(A)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succees");
            alert.setHeaderText(null);
            alert.setContentText("La suppression d'event a ete effectuee avec succees");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("La supression d'event n'a pas ete effectuee!");
            alert.showAndWait();

        }
    }

}
