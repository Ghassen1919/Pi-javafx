/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import gui.dev;
import services.AdminService;
import services.SendingMail;



public class AdminDash2Controller implements Initializable {

   @FXML
    private TableColumn<dev, String> Mail;

    @FXML
    private TableColumn<dev, Integer> Id;

    @FXML
    private TableColumn<dev, String> Grpname;

    @FXML
    private TableColumn<dev, String> Name;


    @FXML
    private TableColumn<dev, String> Gender;

   

    @FXML
    private TableView<dev> table;
    
    @FXML
    private ComboBox<String> Comboxgender;
    

    
    @FXML
    private TextField fullname;
    
    @FXML
    private TextField grpname;
    
    @FXML
    private TextField mail;
    
    @FXML
    private TextField id;
    
    @FXML
    private TextField Search;
    
        int index = -1;
    	ObservableList<dev> devs = FXCollections.observableArrayList();
        ObservableList<dev> dataList;
             
        public void GetListdevs() {
                IAdmin Ia = new AdminService();
                ObservableList<dev> devs = Ia.GetListdevs();
                Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
                Grpname.setCellValueFactory(new PropertyValueFactory<>("Grpname"));
               
		Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
                 Mail.setCellValueFactory(new PropertyValueFactory<>("Mail"));
		Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
		
		table.setItems (devs);
	}
   @FXML
    void getSelected(MouseEvent event) {
        
    index = table.getSelectionModel().getSelectedIndex();
    if (index <= -1){
        return;
    }
    id.setText(Id.getCellData(index).toString());
    fullname.setText(Name.getCellData(index).toString());
    grpname.setText(Grpname.getCellData(index).toString());
    mail.setText(Mail.getCellData(index).toString());
    //oleInput.setText(UserStatus.getCellData(index).toString());
    //StatusInput.setText(UserStatus.getCellData(index).toString());
       }
	@FXML
	void Adddev(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("adddev.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
                GetListdevs();
	}
        @FXML
        void Updatedev(ActionEvent event) throws SQLException, MessagingException {
        dev u = new dev();
        
        String gender = "";
        if (Comboxgender.getSelectionModel().getSelectedItem() != null){
        gender = Comboxgender.getSelectionModel().getSelectedItem();
        u.setgender(gender);
        IAdmin Ia = new AdminService();
        Ia.Updatedev(u,Ia.getIdbyMail(mail.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("developper  updated successfully!");
        alert.showAndWait();
        
        GetListdevs();
        
        }
        else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Select dev gender");
        alert.showAndWait();
        }
        
        search_dev();
        }
          @FXML
    void search_dev() {          
                Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
                Grpname.setCellValueFactory(new PropertyValueFactory<>("Grpname"));
                Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
		Mail.setCellValueFactory(new PropertyValueFactory<>("Mail"));
		Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
                IAdmin Ia = new AdminService();
                dataList = Ia.GetListdevs();
        table.setItems(dataList);
        FilteredList<dev> filteredData = new FilteredList<>(dataList, b -> true);  
        Search.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate((dev person) -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (person.getfullname().toLowerCase().contains(lowerCaseFilter) ) {
     return true; // Filter matches Name
    } else if (person.getgrpname().toLowerCase().contains(lowerCaseFilter)) {
     return true; // Filter matches LastName
    }else if (person.getgender().toLowerCase().contains(lowerCaseFilter)) {
     return true; // Filter matches role
    }
    
    else return String.valueOf(person.getmail()).contains(lowerCaseFilter); // Filter matches email   
   });
  });  
  SortedList<dev> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(table.comparatorProperty());  
  table.setItems(sortedData);      
  
    }
    @FXML
    private void logoutt(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        id.getScene().getWindow().hide();
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
       GetListdevs();
      search_dev();
        List<String> list = new ArrayList<>();
        list.add("male");
        list.add("female");
        list.add("other");
        
        ObservableList obList = FXCollections.observableList(list);
        Comboxgender.getItems().clear();
        Comboxgender.setItems(obList);
        
    }     
}
