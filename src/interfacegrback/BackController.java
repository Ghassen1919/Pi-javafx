/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacegrback;
import edu.gestion.services.PostCrud;
import interfacegrback.NewscrudController;
import interfacegr.Post1Controller;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Home
 */
public class BackController implements Initializable {

    @FXML
    private BorderPane bp1;
    @FXML
    private AnchorPane ap1;
    @FXML
    private AnchorPane paneMain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         interfacegr.ToggleSwitch buttom=new interfacegr.ToggleSwitch();
        SimpleBooleanProperty isOn = buttom.switchOnProperty();
        isOn.addListener((observable, oldValue, newValue)-> {
            if(newValue){
                buttom.getScene().getRoot().getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toString());
                
            }else{
             buttom.getScene().getRoot().getStylesheets().remove(getClass().getResource("newCascadeStyleSheet.css").toString());   
            }
        });
        paneMain.getChildren().add(buttom);
         Rectangle r = new Rectangle();
        r.setHeight(25);
        r.setWidth(25); 
        r.setRotate(45);
        r.setFill(Color.PURPLE);
        r.setLayoutX(200);
        r.setLayoutX(320);
        TranslateTransition t= new TranslateTransition();
        t.setDuration(Duration.seconds(2));
        t.setAutoReverse(true);
        t.setCycleCount(1000);
        t.setToX(200);
        
        t.setNode(r);
        t.play();
        Rectangle r1 = new Rectangle();
        r1.setHeight(25);
        r1.setWidth(25); 
        r1.setRotate(45);
        r1.setFill(Color.GREY);
        r1.setLayoutX(200);
        r1.setLayoutX(320);
        TranslateTransition t1= new TranslateTransition();
        t1.setDuration(Duration.seconds(2));
        t1.setAutoReverse(true);
        t1.setCycleCount(500);
       
        t1.setToY(200);
        t1.setNode(r1);
        t1.play();
        Rectangle r2 = new Rectangle();
        r2.setHeight(25);
        r2.setWidth(25); 
        r2.setRotate(45);
        r2.setFill(Color.GREY);
        r2.setLayoutX(200);
        r2.setLayoutX(320);
        TranslateTransition t2= new TranslateTransition();
        t2.setDuration(Duration.seconds(2));
        t2.setAutoReverse(true);
        t2.setCycleCount(500);
        t2.setToX(300);
        
        t2.setNode(r2);
        t2.play();
        Rectangle r3 = new Rectangle();
        r3.setHeight(25);
        r3.setWidth(25); 
        r3.setRotate(45);
        r3.setFill(Color.PURPLE);
        r3.setLayoutX(-200);
        r3.setLayoutX(320);
        TranslateTransition t3= new TranslateTransition();
        t3.setDuration(Duration.seconds(2));
        t3.setAutoReverse(true);
        t3.setCycleCount(500);
        
        t3.setToY(300);
        t3.setNode(r3);
        t3.play();
        
         
        
        
        
        
       ap1.getChildren().add(r);
       ap1.getChildren().add(r1);
        ap1.getChildren().add(r2);
       ap1.getChildren().add(r3);
       
    }    

    @FXML
    private void home(MouseEvent event) {
        bp1.setCenter(ap1);
    }

    @FXML
    private void newscrud(MouseEvent event) {
        loadpage("newscrud");
    }

    @FXML
    private void reclamationcrud(MouseEvent event) {
        loadpage("reclamationcrud");
    }
    @FXML
    private void coomentaireCrud(MouseEvent event) {
        loadpage("commentaireCrud");
    }
    private void loadpage(String page){
        Parent root= null ; 
        try {
            root=FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Post1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp1.setCenter(root);
    }
    
}
