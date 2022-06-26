package gui;
import interfacegr.*;
import edu.gestion.entities.Post;
import edu.gestion.services.PostCrud;
import edu.gestion.entities.Comentaire;
import edu.gestion.services.ComentaireCrud;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;


/**
 * FXML Controller class
 *
 * @author Home
 */
public class news1111Controller implements Initializable {

    @FXML
    private Label tftitre;
    @FXML
    private Label tfimg;
    public Post a;
    @FXML
    private Label tfidpost;
    @FXML
    private Rating postrating;
    @FXML
    private ImageView img;
    
   void setData(int id_post, String titre,String img_post,int rate,String image) {
    tftitre.setText(titre);
    tfimg.setText(img_post);
    tfidpost.setText(String.valueOf(id_post));
    postrating.setRating(rate);
    Image myImage = new Image(getClass().getResourceAsStream("/resources/" + image + ""));
        img.setImage(myImage);
    
                                  
    }
   void setData1(int id_post, String titre,String img_post,int rate) {
    tftitre.setText(titre);
    tfimg.setText(img_post);
    tfidpost.setText(String.valueOf(id_post));
    postrating.setRating(rate);
    
                                  
    }
   Post k=new Post();
   

   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
    }
    @FXML
    private void btminsert(ActionEvent event)  {
        
        
      
        
           k.setTest(Integer.parseInt(tfidpost.getText()));
                   try {
              Parent root = FXMLLoader.load(getClass().getResource("coment.fxml"));
          Stage stage = new Stage();
     
          stage.setTitle("comentaire");
                    stage.setScene(new Scene(root)); 
                    stage.show();
     
        } catch (IOException ex) {
               System.out.println("can't load coments");
        }
        
                    
        
            
        
    
}

    @FXML
    private void rate(ActionEvent event) {
        k.setTest(Integer.parseInt(tfidpost.getText()));
        Post A= new Post();
        PostCrud aS = new PostCrud();
        if (aS.updaterate( (int)postrating.getRating(),A.getTest())){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succées");
        alert.setHeaderText(null);
        alert.setContentText("La modification d'event a été effectué avec succées");
        alert.showAndWait();
        
      
        }else{
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("La modufication d'event n'a pas été effectué!");
        alert.showAndWait();   
     
    }

     

   
    
}
}

    
   

    
    


    
    