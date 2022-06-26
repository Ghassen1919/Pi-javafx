/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;


import static gui.SendMailController.mail;
import interfaces.IUser;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
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


public class SignUpClientController implements Initializable {
    @FXML
    private Hyperlink BackToLoginButton;

    @FXML
    private TextField EmailSignUp;

    @FXML
    private TextField LastNameSignUp;

    @FXML
    private TextField NameUserSignUp;

    @FXML
    private PasswordField PasswordSignUp;
    
    @FXML
    private PasswordField PasswordConfirm;
    
    @FXML
    private ImageView imgClient;

    
    File file;
    
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    public boolean UserExists (String email) throws SQLException  {
       
            IUser Iu = new UserService();
            if (Iu.getIdbyMail(EmailSignUp.getText())!=Iu.getId()){
                mail=EmailSignUp.getText();
                return true;
    }
            return false;
    }
  
    public boolean isValidEmailAddress(String email) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           Pattern p = Pattern.compile(ePattern);
           Matcher m = p.matcher(email);
           return m.matches();
    }
  // validate first name
   public static boolean NameControl( String Name ) {
      return Name.matches( "[A-Z][a-z]*" );
   }
    // validate password
   public static boolean isValidPassword(String password) {
       String PASSWORD_PATTERN ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
       Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
       Matcher matcher = pattern.matcher(password);
       return matcher.matches();
    }
    @FXML
         void SignUpClient(ActionEvent event) throws IOException, SQLException, MessagingException {
        
        if(NameUserSignUp.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" Name Field empty");
        alert.showAndWait();}
        else if (NameControl(NameUserSignUp.getText())==false)
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Name can't containt numbers and should start with a capital letter");
        alert.showAndWait();
        }
        else if (LastNameSignUp.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Last Name Field empty");
        alert.showAndWait();}
         else if (NameControl(LastNameSignUp.getText())==false)
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Last name can't containt numbers and should start with a capital letter");
        alert.showAndWait();
        }
        else if (PasswordSignUp.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Password Field empty");
        alert.showAndWait();}
        else if (isValidPassword(PasswordSignUp.getText())==false)
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Password must contain at least one digit [0-9].\n" +
        "at least one lowercase Latin character [a-z].\n" +
        "at least one uppercase Latin character [A-Z].\n" +
        "at least one special character like ! @ # & ( ).\n" +
        "a length of at least 8 characters and a maximum of 20 characters.");
        alert.showAndWait();}
        else if(isValidEmailAddress(EmailSignUp.getText())==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Email is not valid");
        alert.showAndWait();     
        }
           else if(UserExists(EmailSignUp.getText())==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("email already exists");
        alert.showAndWait();     
        }
          else if (!PasswordConfirm.getText().equals(PasswordSignUp.getText()))
        { 
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Password confirmation does not match password");
        alert.showAndWait();
        }
        else
        { 
        User u = new User();
        u.setUserRole("[\"ROLE_USER\"]");
        u.setUserStatus(1);
        u.setNameUser(NameUserSignUp.getText());
        u.setLastNameUser(LastNameSignUp.getText());
        u.setPasswordUser(PasswordSignUp.getText());
        u.setEmailUser(EmailSignUp.getText());
        if (this.file==null){
        File file = new File("src/assets/avatar.png");
        u.setProfilePicUser(file.toURI().toString());
        UserService us = new UserService();
        us.AddUser(u,PasswordSignUp.getText());
        SendingMail.sendSignUp(EmailSignUp.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Account created successfully ");
        alert.showAndWait();
        FXMLLoader loader = new FXMLLoader();
        NameUserSignUp.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
        }
        else
        {
        u.setProfilePicUser(file.toURI().toString());
        UserService us = new UserService();
        us.AddUser(u,PasswordSignUp.getText());
        SendingMail.sendSignUp(EmailSignUp.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Account created successfully ");
        alert.showAndWait();
        FXMLLoader loader = new FXMLLoader();
        NameUserSignUp.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
        }
            }
         }

      @FXML
    void AddPictureClient(ActionEvent event) {
        FileChooser fileChooserr = new FileChooser();
        fileChooserr.setTitle("Select Image");
        //might need to be changed to c: in windows users
        fileChooserr.setInitialDirectory(new File("/"));
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fileChooserr.getExtensionFilters().add(imageFilter);
        file = fileChooserr.showOpenDialog(imgClient.getScene().getWindow());
        Image image = new Image(file.toURI().toString());
        imgClient.setImage(image);

    }
        @FXML
    void BackToLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        BackToLoginButton.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
    }

    }


