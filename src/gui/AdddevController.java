/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static gui.SendMailController.mail;
import static gui.SignUpClientController.NameControl;
import static gui.SignUpClientController.isValidPassword;
import interfaces.IUser;
import interfaces.Idev;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import model.User;
import services.SendingMail;
import services.UserService;
import services.devService;


public class AdddevController implements Initializable {


    @FXML
    private Hyperlink BackToLoginButton;

    @FXML
    private TextField Mail;

    @FXML
    private TextField Fullname;

    @FXML
    private TextField Grpname;

    

    @FXML
    private ComboBox<String> Comboxgender;
    
    File file;
    
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> list = new ArrayList<>();
        list.add("male");
        list.add("female");
        list.add("other");
       
        ObservableList obList = FXCollections.observableList(list);
        Comboxgender.getItems().clear();
        Comboxgender.setItems(obList);
       
    }  

    public boolean UserExists (String email) throws SQLException  {
       
            Idev Iu = new devService();
            if (Iu.getIdbyMail(Mail.getText())!=Iu.getId()){
                mail=Mail.getText();
                return true;
    }
            return false;
    }
  
    public boolean isValidEmailAddress(String email) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
    }
    @FXML
         void SignUpdev(ActionEvent event) throws IOException, SQLException, MessagingException {
        
        if(Fullname.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" Name Field empty");
        alert.showAndWait();}
        else if (NameControl(Fullname.getText())==false)
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Name can't containt numbers and should start with a capital letter");
        alert.showAndWait();
        }
        else if (Grpname.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Last Name Field empty");
        alert.showAndWait();}
         else if (NameControl(Grpname.getText())==false)
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Last name can't containt numbers and should start with a capital letter");
        alert.showAndWait();
        }
       
        else if(isValidEmailAddress(Mail.getText())==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Email is not valid");
        alert.showAndWait();     
        }
       
           else if(UserExists(Mail.getText())==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("email already exists");
        alert.showAndWait();     
        }
          
        else
        { 
        dev d = new dev();
        String gender = "";
        if (Comboxgender.getSelectionModel().getSelectedItem() != null){
       gender = Comboxgender.getSelectionModel().getSelectedItem().toString();
        d.setgender(gender);
        d.setfullname(Fullname.getText());
        d.setgrpname(Grpname.getText());
        d.setmail(Mail.getText());
        if (this.file==null){
        File file = new File("src/assets/avatar.png");
        devService us = new devService();
        us.Adddev(d);
        SendingMail.sendSignUp(Mail.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Account created successfully ");
        alert.showAndWait();
        FXMLLoader loader = new FXMLLoader();
        Fullname.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("admindash2.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
        }
        else
        {
       
        devService us = new devService();
        us.Adddev(d);
        SendingMail.sendSignUp(Mail.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("developper added successfully ");
        alert.showAndWait();
        FXMLLoader loader = new FXMLLoader();
        Fullname.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("admindash2.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
        }
            }}
         }

     
        @FXML
    void BackToLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        BackToLoginButton.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("admindash2.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
    }

    }