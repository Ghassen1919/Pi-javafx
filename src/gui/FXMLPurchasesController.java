/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import tableviewgames.*;
import entities.games;
import entities.gamesconnect;
import entities.purchases;
import entities.purchasesconnect;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MSI GL-65
 */
public class FXMLPurchasesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private TableView<purchases> purchase_table;

    @FXML
    private TableColumn<purchases, Integer> pcol_id;

    @FXML
    private TableColumn<purchases, Integer> pcol_client_rib;

    @FXML
    private Button games_page;

    @FXML
    private TextField ptext_id;

    @FXML
    private TextField ptext_order_date;

    @FXML
    private TextField pgame_id;

    @FXML
    private TextField ptext_client_id;

    @FXML
    private TextField ptext_client_rib;

    @FXML
    private Button btn_addp;

    @FXML
    private Button btn_updatep;

    @FXML
    private Button btn_deletep;
        @FXML
    private TableColumn<purchases, Integer> RIB;


    
    
    int index = -1;
    ObservableList<purchases> listP;

    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    

    //USEDMETHODS
    @FXML 
    public void changeScreenBack(ActionEvent event) throws IOException{
        Parent root2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene2 = new Scene(root2);
        Stage stage2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage2.setScene(scene2);
        stage2.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UpdateP();
    }    
    
    
    
    //showData
 @FXML
     public void UpdateP(){
        pcol_id.setCellValueFactory(new PropertyValueFactory<purchases, Integer>("id"));
        RIB.setCellValueFactory(new PropertyValueFactory<purchases, Integer>("client_rib"));
        listP = purchasesconnect.getDatapur();
        purchase_table.setItems(listP);

    }
     
     
       /**  @FXML
    public void Add_p () throws SQLException{
       
        conn = gamesconnect.ConnectDb();
       
        String sql = "insert into achat rib value ? )";              
 
            
            pst = conn.prepareStatement(sql);
            pst.setString(2, ptext_client_rib.getText());
          
            pst.execute();
            UpdateP();
            //
            JOptionPane.showMessageDialog(null, "Game Add succes");
            
    }**/

      
     

}
