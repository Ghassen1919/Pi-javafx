/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class charts extends Application{
  NumberAxis xAxis = new NumberAxis();
     CategoryAxis yAxis = new CategoryAxis();
     static String itemA = "Attendance";
     static String itemB = "CT_Marks";
     static String itemC = "Assignment";
     static String itemD = "Others";
     Connection connection;
     Statement statement;
     int i=1;
     int j=2;
  XYChart.Data<String, Number> data =  new XYChart.Data<String, Number>();
 public void start(Stage stage){
  initializeDB();
  Pane pane=new Pane();
  pane.setPrefSize(600, 500);
  BarChart<String,Number> bchart=new BarChart<String,Number>(yAxis, xAxis);
  bchart.setPrefSize(550, 450);
  bchart.setTitle("Summary");
     xAxis.setLabel("Values");
     xAxis.setTickLabelRotation(45);
     yAxis.setTickLabelRotation(45);
     yAxis.setLabel("Menus");
     XYChart.Series series1 = new XYChart.Series();
     XYChart.Series series2 = new XYChart.Series();
     series1.setName("2016");
        try{
         String sql="SELECT\n" +
"    COUNT(IF(gender = 'male', 1, NULL)) count_male,\n" +
"    COUNT(IF(gender = 'female', 1, NULL)) count_female,\n" +
"    COUNT(IF(gender = 'male', 1, NULL))/COUNT(IF(gender = 'female', 1, NULL)) as ratio\n" +
"FROM\n" +
"    dev;";
         ResultSet rset=statement.executeQuery(sql);
         while(rset.next()){
           XYChart.Data<String, Number> data =  new XYChart.Data<String, Number>(rset.getString(i),rset.getDouble(j));
           series1.getData().add(data);
           data.nodeProperty().addListener(new ChangeListener<Node>(){
            public void changed(ObservableValue<? extends Node>ov,Node oldNode,final Node node){
             if(node!=null){
              if(data.getYValue().doubleValue()>15){
               node.setStyle("-fx-bar-fill:green");
              }else if(data.getYValue().doubleValue()>10){
               node.setStyle("-fx-bar-fill:navy");
              }else if(data.getYValue().doubleValue()>5){
               node.setStyle("-fx-bar-fill:red");
              }else if(data.getYValue().doubleValue()>0){
               node.setStyle("-fx-bar-fill:black");
              }
             }
            }
           });
          
          
         } i++;j++;
      
        }catch(Exception e){
        
        }
     bchart.getData().addAll(series1);
     pane.getChildren().add(bchart);
  Scene scene=new Scene(pane);
  //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
  stage.setScene(scene);
  stage.show();
 }

 private void initializeDB() {
  try{
   Class.forName("com.mysql.cj.jdbc.Driver");
   connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/pssss","root","");
   statement=connection.createStatement();  
 }
 catch(Exception ex){
  ex.printStackTrace();
  }
 }

 public static void main(String[] args) {
  launch(args);

 }

}