/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;


import static gui.SignUpClientController.isValidPassword;
import interfaces.IUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;


import javafx.stage.Stage;
import javax.mail.MessagingException;
import services.SendingMail;

import services.UserService;

public class NewPasswordController implements Initializable {


    @FXML
    private PasswordField NewPasswordField;

    @FXML
    private Button Send;
    
    public static String mailUpdate="a";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Send(ActionEvent event) throws IOException, SQLException, MessagingException {
        if(
            NewPasswordField.getText().isEmpty())
        {   Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Field is empty ");
            alert.showAndWait();
        }
         else if (isValidPassword(NewPasswordField.getText())==false)
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Password must contain at least one digit [0-9].\n" +
        "at least one lowercase Latin character [a-z].\n" +
        "at least one uppercase Latin character [A-Z].\n" +
        "at least one special character like ! @ # & ( ).\n" +
        "a length of at least 8 characters and a maximum of 20 characters.");
        alert.showAndWait();
        }
        else
        { 
        String newPass = NewPasswordField.getText();
        IUser Iu = new UserService();
        mailUpdate=SendMailController.mail;
        Iu.UpdatePassword(mailUpdate, newPass);
        SendingMail.sendPasswordReset(mailUpdate);
        FXMLLoader loader = new FXMLLoader();
        NewPasswordField.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
        }
    }
            @FXML
    private void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
                NewPasswordField.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("Login.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
    }}
