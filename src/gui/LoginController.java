package gui;

import interfaces.IUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import services.UserService;




public class LoginController implements Initializable {

    @FXML
     TextField EmailUser;
    @FXML
    private PasswordField PasswordUser;
    @FXML
    private Button SignUpButton;
    @FXML
    private Label label;

    
    public static int  codem;
    
    public static String password;
    
    public static String email;

  
     public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();} 
        catch (AddressException ex) {
            result = false;
        }
        return result;
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("NewPassword.fxml"));
        NewPasswordController ircc = loader.getController();
        String s="a";
        if (!ircc.mailUpdate.equals(s)){
            EmailUser.setText(ircc.mailUpdate);
        }
    } 

     @FXML
    private void login(ActionEvent event) throws Exception {
        IUser Iu = new UserService();
        
        email = EmailUser.getText();
        password = PasswordUser.getText();
        
        if (email.equals("")){
        EmailUser.setStyle("-fx-border-color: red");
        }
        else if(password.equals("")) { 
        EmailUser.setStyle("");
        PasswordUser.setStyle("-fx-border-color: red");  
        
        }
   
        else if (Iu.Login(email, password)) {
            String Role = Iu.getRolebyId(Iu.getIdbyMail(email));
            System.out.println(Role);
                  
            
               if (Role.equalsIgnoreCase("[\"ROLE_USER\"]")){ 
                        FXMLLoader loader = new FXMLLoader();
                        label.getScene().getWindow().hide();
                        Stage prStage1 = new Stage();
                        loader.setLocation(getClass().getResource("post1.fxml"));
                        Parent root1 = loader.load();
                        Scene scene = new Scene(root1);
                        prStage1.setScene(scene);
                        prStage1.setResizable(false);
                         Image image = new Image("/i/272837925_2375620082579032_5184045612527479214_n (1).png");
                          prStage1.getIcons().add(image);
                          prStage1.setTitle("HUNTERS");
                        prStage1.show();
                    }
               else if(Role.equalsIgnoreCase("[\"respoactu\"]") )               {
                        FXMLLoader loader = new FXMLLoader();
                        label.getScene().getWindow().hide();
                        Stage prStage2 = new Stage();
                        loader.setLocation(getClass().getResource("back.fxml"));
                        Parent root2 = loader.load();
                        Scene scene1 = new Scene(root2);
                        prStage2.setScene(scene1);
                        prStage2.setResizable(false);
                        Image image = new Image("/i/272837925_2375620082579032_5184045612527479214_n (1).png");
                          prStage2.getIcons().add(image);
                          prStage2.setTitle("HUNTERS");
                        prStage2.show();
                    }
               else if(Role.equalsIgnoreCase("[\"ROLE_ADMIN\"]")  )                    {
                        FXMLLoader loader = new FXMLLoader();
                        label.getScene().getWindow().hide();
                        Stage prStage = new Stage();
                        loader.setLocation(getClass().getResource("menu.fxml"));
                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        prStage.setScene(scene);
                        prStage.setResizable(false);
                        Image image = new Image("/i/272837925_2375620082579032_5184045612527479214_n (1).png");
                          prStage.getIcons().add(image);
                          prStage.setTitle("HUNTERS");
                        prStage.show();
                    }
              else if (Role.equalsIgnoreCase("[\"respoprod\"]"))  {
                    FXMLLoader loader = new FXMLLoader();
                    label.getScene().getWindow().hide();
                    Stage prStage = new Stage();
                    loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    prStage.setScene(scene);
                    prStage.setResizable(false);
                    Image image = new Image("/i/272837925_2375620082579032_5184045612527479214_n (1).png");
                          prStage.getIcons().add(image);
                          prStage.setTitle("HUNTERS");
                    prStage.show();
                }
               // default : { }
            }
        
        
        else if("blocked".equals(Iu.getStatusbyId(Iu.getIdbyMail(email)))){  
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("you were banned from using this app check your email for more information");
            alert.showAndWait();
        }
         
        else {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Password or Email is incorrect");
            alert.showAndWait();
        } 
   } 
       @FXML
    private void SignUp(ActionEvent event) throws IOException {
        
     FXMLLoader loader = new FXMLLoader();
                SignUpButton.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("SignUpClient.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                Image image = new Image("/i/272837925_2375620082579032_5184045612527479214_n (1).png");
                          prStage.getIcons().add(image);
                          prStage.setTitle("HUNTERS");
                prStage.show();
    }
    
  
    @FXML
    private void Forgotpwd(ActionEvent event) throws MessagingException, IOException {
       FXMLLoader loader = new FXMLLoader();
                SignUpButton.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("SendMail.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                Image image = new Image("/i/272837925_2375620082579032_5184045612527479214_n (1).png");
                          prStage.getIcons().add(image);
                          prStage.setTitle("HUNTERS");
                prStage.show();
    
        }    }
    

