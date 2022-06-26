/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacegr;



import static com.itextpdf.text.pdf.PdfFileSpecification.url;
import com.sun.prism.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;


import javafx.util.Duration;
import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author Home
 */
public class Post1Controller implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;
    @FXML
    private AnchorPane paneMain;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleSwitch buttom=new ToggleSwitch();
        SimpleBooleanProperty isOn = buttom.switchOnProperty();
        isOn.addListener((observable, oldValue, newValue)-> {
            if(newValue){
                buttom.getScene().getRoot().getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toString());
                
            }else{
             buttom.getScene().getRoot().getStylesheets().remove(getClass().getResource("newCascadeStyleSheet.css").toString());   
            }
        });
        paneMain.getChildren().add(buttom);
        // TODO
    }    

    @FXML
    private void home(MouseEvent event) {
        bp.setCenter(ap);
    }

    @FXML
    private void news(MouseEvent event) {
        loadpage("news");
    }

    @FXML
    private void store(MouseEvent event) {
        loadpage("reclamation");
    }

    @FXML
    private void reclamation(MouseEvent event) {
         loadpage("help");
    }
    
    
    private void loadpage(String page){
        Parent root= null ; 
        try {
            root=FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Post1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(root);
    }

    @FXML
    private void btminsert1(ActionEvent event) {
        
         Notifications notifications=Notifications.create();
        //notifications.graphic(new ImageView(image));//
        notifications.text("Hello user welcome to Hunters");
        notifications.title("hi!!!!!!!!!");
        notifications.hideAfter(Duration.seconds(4));
        //notifications.darkStyle();
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();
    
    }

    @FXML
    private void btminsert2(ActionEvent event) {
         Notifications notifications=Notifications.create();
        //notifications.graphic(new ImageView(image));//
        notifications.text("new games will be available soon stay tuned");
        notifications.title("!!!!!!!!!");
        notifications.hideAfter(Duration.seconds(4));
        notifications.darkStyle();
        notifications.position(Pos.BOTTOM_LEFT);
        notifications.show();
    }

    
    }
    

