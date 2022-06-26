/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import entities.games;
import entities.gamesconnect;
import static entities.gamesconnect.ConnectDb;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI GL-65
 */
public class UserInterfaceController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btn_add_cart;


    @FXML
    private ImageView image_cover;

    @FXML
    private Label game_name;

    @FXML
    private Label game_category;

    @FXML
    private Label game_release_year;

    @FXML
    private Label game_price;

    @FXML
    private Label game_description;

    @FXML
    private Label game_stock;

    @FXML
    private Button btn_next;

    @FXML
    private Button btn_previous;
    
    
    @FXML
    private ComboBox sort_by_category;
    
   //CART


    @FXML
    private Button btn_clear_cart;

    @FXML
    private Button btn_order;

    @FXML
    private TableView<games> cart_table;

    @FXML
    private TableColumn<games, String> col_cart_name;

    @FXML
    private TableColumn<games, Double> col_cart_price;

    @FXML
    private Label cart_total;
    private Label pprice;
    
    
    
    
    private games G;
    
        
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ObservableList<games> listC;
    @FXML
    private AnchorPane am;
    @FXML
    private Button category_next;
    @FXML
    private Button category_back;

    @FXML
    public void Next() {
       String name = game_name.getText();
       String sql= "select id from games where name = '"+name+"' ";
       int position=0;
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                position = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        double price =0;
        int stock =0;
       String sql2 = "select name ,category, release_year ,price , description ,stock , img from games where id > '"+position+"' ";
        try {
            pst = conn.prepareStatement(sql2);
            rs = pst.executeQuery();
            if(rs.next()){
                game_name.setText(rs.getString("name"));
                game_category.setText(rs.getString("category"));
                game_release_year.setText(rs.getString("release_year"));
                price = rs.getDouble("price");
                game_price.setText(Double.toString(price));
                game_description.setText(rs.getString("description"));
                stock = rs.getInt("stock");
                if (stock> 0){
                    game_stock.setText("Disponible");
                }else
                game_stock.setText("Indisponible");
                String  img = rs.getString("img");
                String picture = "file:"+ img;
                Image image = new Image(picture, 350 ,350, false , true);
                image_cover.setImage(image);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    @FXML    
    public void Previous() {

       String name = game_name.getText();
       String sql= "select id from games where name = '"+name+"' ";
       int position=0;
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                position = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        double price =0;
        int stock =0;
       String sql2 = "select name ,category, release_year ,price , description ,stock , img from games where id < '"+position+"' ";
        try {
            pst = conn.prepareStatement(sql2);
            rs = pst.executeQuery();
            if(rs.next()){
                game_name.setText(rs.getString("name"));
                game_category.setText(rs.getString("category"));
                game_release_year.setText(rs.getString("release_year"));
                price = rs.getDouble("price");
                game_price.setText(Double.toString(price));
                game_description.setText(rs.getString("description"));
                stock = rs.getInt("stock");
                if (stock> 0){
                    game_stock.setText("Disponible");
                }else
                game_stock.setText("Indisponible");
                String  img = rs.getString("img");
                String picture = "file:"+ img;
                Image image = new Image(picture, 350 ,350, false , true);
                image_cover.setImage(image);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void displayAll() {
        conn = gamesconnect.ConnectDb();
        String  sql = "select name ,category, release_year ,price , description ,stock , img from games ";
        double price=0;
        int stock= 0;
        String img;
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                game_name.setText(rs.getString("name"));
                game_category.setText(rs.getString("category"));
                game_release_year.setText(rs.getString("release_year"));
                price = rs.getDouble("price");
                game_price.setText(Double.toString(price));
                game_description.setText(rs.getString("description"));
                stock = rs.getInt("stock");
                if (stock> 0){
                    game_stock.setText("Disponible");
                }else
                    game_stock.setText("Indisponible");
                img = rs.getString("img");
                  String picture = "file:"+ img;
                  Image image = new Image(picture, 350 ,350, false , true);
                  image_cover.setImage(image);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
        
     }   
     
    public void showCart(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("userCart.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    //SORT BY CATEGORY
    @FXML
    
    public void categoryPicker(){

        String ChoosenCategory = sort_by_category.getSelectionModel().getSelectedItem().toString();
        String  sqll = "select name ,category, release_year ,price , description ,stock , img from games where category = '"+ChoosenCategory+"' ";
        double price=0;
        int stock= 0;
        String img;
        try {
            pst = conn.prepareStatement(sqll);
            rs = pst.executeQuery();
            if(rs.next()){
                game_name.setText(rs.getString("name"));
                game_category.setText(rs.getString("category"));
                game_release_year.setText(rs.getString("release_year"));
                price = rs.getDouble("price");
                pprice.setText(Double.toString(price));
                game_description.setText(rs.getString("description"));
                stock = rs.getInt("stock");
                if (stock> 0){
                    game_stock.setText("Disponible");
                }else
                    game_stock.setText("Indisponible");
                img = rs.getString("img");
                  String picture = "file:"+ img;
                  Image image = new Image(picture, 350 ,350, false , true);
                  image_cover.setImage(image);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //WORKING HERE 
    @FXML
    public void categoryPickerNext() {
               String ChoosenCategory = sort_by_category.getSelectionModel().getSelectedItem().toString();

               String name = game_name.getText();
               String sql= "select id from games where name = '"+name+"' ";
               int position=0;
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                position = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String mySql = "select name ,category, release_year ,price , description ,stock , img from games where id > '"+position+"' AND category = '"+ChoosenCategory+"' ";
        double price=0;
        int stock= 0;
        String img;
        try {
            pst = conn.prepareStatement(mySql);
            rs = pst.executeQuery();
            if(rs.next()){
                game_name.setText(rs.getString("name"));
                game_category.setText(rs.getString("category"));
                game_release_year.setText(rs.getString("release_year"));
                price = rs.getDouble("price");
                game_price.setText(Double.toString(price));
                game_description.setText(rs.getString("description"));
                stock = rs.getInt("stock");
                if (stock> 0){
                    game_stock.setText("Disponible");
                }else
                    game_stock.setText("Indisponible");
                img = rs.getString("img");
                  String picture = "file:"+ img;
                  Image image = new Image(picture, 350 ,350, false , true);
                  image_cover.setImage(image);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }

               
    }
    
    @FXML
        public void categoryPickerPrevious() {
               String ChoosenCategory = sort_by_category.getSelectionModel().getSelectedItem().toString();

               String name = game_name.getText();
               String sql= "select id from games where name = '"+name+"' ";
               int position=0;
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                position = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String mySql = "select name ,category, release_year ,price , description ,stock , img from games where id < '"+position+"' AND category = '"+ChoosenCategory+"' ";
        double price=0;
        int stock= 0;
        String img;
        try {
            pst = conn.prepareStatement(mySql);
            rs = pst.executeQuery();
            if(rs.next()){
                game_name.setText(rs.getString("name"));
                game_category.setText(rs.getString("category"));
                game_release_year.setText(rs.getString("release_year"));
                price = rs.getDouble("price");
                game_price.setText(Double.toString(price));
                game_description.setText(rs.getString("description"));
                stock = rs.getInt("stock");
                if (stock> 0){
                    game_stock.setText("Disponible");
                }else
                    game_stock.setText("Indisponible");
                img = rs.getString("img");
                  String picture = "file:"+ img;
                  Image image = new Image(picture, 350 ,350, false , true);
                  image_cover.setImage(image);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }

               
    }
        
        

        

    @FXML
        public void addCart() {
           double tot=0;
            double gprice=0;
            games GG = new games();
            String gname = game_name.getText();
            GG.setName(gname);
            gprice = Double.parseDouble(game_price.getText());
            GG.setPrice(gprice);
            col_cart_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_cart_price.setCellValueFactory(new PropertyValueFactory<>("price"));
            cart_table.getItems().add(GG);

            
        }
     

        

     private void totalStock() {
        double total = 0;
         for (games g : cart_table.getSelectionModel().getSelectedItems()){
             total+=g.getStock();
         } 
     }

   
 
        
        


    
    
    @Override    
    public void initialize(URL url, ResourceBundle rb) {
        displayAll();
        ObservableList<String> box = FXCollections.observableArrayList("Battle Royale","Action","Role-playing","Adventure","Racing","Fighting","Strategy","Simulator");
        sort_by_category.setItems(box); 
    }    
    @FXML
    public void Clear(){
     for ( int i = 0; i<cart_table.getItems().size(); i++) {
    cart_table.getItems().clear();
}
        
    }

    @FXML
    private void Hom(ActionEvent event) {
    }
}
