/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package gui;


import java.io.IOException;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.stage.Stage;




public class NewFXMain_Esports extends Application {

   
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Parent root =loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        Image image = new Image("/i/272837925_2375620082579032_5184045612527479214_n (1).png");
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("HUNTERS");
        
        primaryStage.show();

    }

   
    public static void main(String[] args) {
    Application.launch (args);
   


       
    }}
    

