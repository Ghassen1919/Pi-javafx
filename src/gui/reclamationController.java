/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.gestion.entities.Reclamation;
import edu.gestion.services.ReclamationCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Home
 */
public class reclamationController implements Initializable {

    @FXML
    private TextArea tfdesri;
    
    

   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btminsert(MouseEvent event) throws SQLException {
        
        
        String descri_réc = tfdesri.getText();
        
       
       
          Reclamation r = new Reclamation (tfdesri.getText());
        
       ReclamationCRUD pst11 = new ReclamationCRUD();
        if((tfdesri.getText()!=null && !tfdesri.getText().isEmpty() ))
        {pst11.ajouter(r);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Done");
        alert.setContentText("Reclamation envoyee!");
        alert.show();
        }else{
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setContentText("veuillez remplir tous les chapms ou redefinir le nom!");
                alert.show();
        }
    }
    }
    

    
    

