/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import interfaces.IAdmin;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import model.User;
import services.AdminService;
import services.SendingMail;



public class AdminDashboardController implements Initializable {

   @FXML
    private TableColumn<User, String> EmailUser;

    @FXML
    private TableColumn<User, Integer> IdUser;

    @FXML
    private TableColumn<User, String> LastNameUser;

    @FXML
    private TableColumn<User, String> NameUser;


    @FXML
    private TableColumn<User, String> UserRole;

    @FXML
    private TableColumn<User, Integer> UserStatus;

    @FXML
    private TableView<User> table;
    
    @FXML
    private ComboBox<String> ComboxRole;
    
    @FXML
    private ComboBox<String> StatusCombo;
    
    @FXML
    private TextField NameInput;
    
    @FXML
    private TextField LastNameInput;
    
    @FXML
    private TextField EmailInput;
    
    @FXML
    private TextField IdInput;
    
    @FXML
    private TextField Search;
    
        int index = -1;
    	ObservableList<User> users = FXCollections.observableArrayList();
        ObservableList<User> dataList;
             
        public void GetListUsers() {
                IAdmin Ia = new AdminService();
                ObservableList<User> users = Ia.GetListUsers();
                IdUser.setCellValueFactory(new PropertyValueFactory<>("IdUser"));
                NameUser.setCellValueFactory(new PropertyValueFactory<>("NameUser"));
                LastNameUser.setCellValueFactory(new PropertyValueFactory<>("LastNameUser"));
		EmailUser.setCellValueFactory(new PropertyValueFactory<>("EmailUser"));
		UserRole.setCellValueFactory(new PropertyValueFactory<>("UserRole"));
		UserStatus.setCellValueFactory(new PropertyValueFactory<>("UserStatus"));
		table.setItems (users);
	}
   @FXML
    void getSelected(MouseEvent event) {
        
    index = table.getSelectionModel().getSelectedIndex();
    if (index <= -1){
        return;
    }
    IdInput.setText(IdUser.getCellData(index).toString());
    NameInput.setText(NameUser.getCellData(index).toString());
    LastNameInput.setText(LastNameUser.getCellData(index).toString());
    EmailInput.setText(EmailUser.getCellData(index).toString());
    //oleInput.setText(UserStatus.getCellData(index).toString());
    //StatusInput.setText(UserStatus.getCellData(index).toString());
       }
	@FXML
	void AddUser(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddUser.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
                GetListUsers();
	}
        @FXML
        void UpdateUser(ActionEvent event) throws SQLException, MessagingException {
        User u = new User();
        if (StatusCombo.getSelectionModel().getSelectedItem() != null){
        int UserStatus = Integer.valueOf(StatusCombo.getSelectionModel().getSelectedItem().toString());
        u.setUserStatus(UserStatus);
        String UserRole = "";
        if (ComboxRole.getSelectionModel().getSelectedItem() != null){
        UserRole = ComboxRole.getSelectionModel().getSelectedItem();
        u.setUserRole(UserRole);
        IAdmin Ia = new AdminService();
        Ia.UpdateEmployee(u,Ia.getIdbyMail(EmailInput.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("User updated successfully!");
        alert.showAndWait();
        if(UserStatus==0){
        SendingMail.sendBanned(EmailInput.getText());
        }
        GetListUsers();
        
        }
        else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Select user status");
        alert.showAndWait();
        }
        }
         else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Select user role");
        alert.showAndWait();
        }
        search_user();
        }
          @FXML
    void search_user() {          
                IdUser.setCellValueFactory(new PropertyValueFactory<>("IdUser"));
                NameUser.setCellValueFactory(new PropertyValueFactory<>("NameUser"));
                LastNameUser.setCellValueFactory(new PropertyValueFactory<>("LastNameUser"));
		EmailUser.setCellValueFactory(new PropertyValueFactory<>("EmailUser"));
		UserRole.setCellValueFactory(new PropertyValueFactory<>("UserRole"));
		UserStatus.setCellValueFactory(new PropertyValueFactory<>("UserStatus"));
                IAdmin Ia = new AdminService();
                dataList = Ia.GetListUsers();
        table.setItems(dataList);
        FilteredList<User> filteredData = new FilteredList<>(dataList, b -> true);  
        Search.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate((User person) -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (person.getNameUser().toLowerCase().contains(lowerCaseFilter) ) {
     return true; // Filter matches Name
    } else if (person.getLastNameUser().toLowerCase().contains(lowerCaseFilter)) {
     return true; // Filter matches LastName
    }else if (person.getUserRole().toLowerCase().contains(lowerCaseFilter)) {
     return true; // Filter matches role
    }
    
    else return String.valueOf(person.getEmailUser()).contains(lowerCaseFilter); // Filter matches email   
   });
  });  
  SortedList<User> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(table.comparatorProperty());  
  table.setItems(sortedData);      
  
    }
    @FXML
    private void logoutt(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        IdInput.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       GetListUsers();
      search_user();
        List<String> list = new ArrayList<>();
        list.add("admin");
        list.add("chef");
        list.add("delivery guy");
        list.add("client");
        ObservableList obList = FXCollections.observableList(list);
        ComboxRole.getItems().clear();
        ComboxRole.setItems(obList);
        List<String> list2 = new ArrayList<>();
        list2.add("0");
        list2.add("1");
        ObservableList obList2 = FXCollections.observableList(list2);
        StatusCombo.getItems().clear();
        StatusCombo.setItems(obList2);
    }     
}
