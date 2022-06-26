/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import tableviewgames.*;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import entities.games;
import entities.gamesconnect;
import static entities.gamesconnect.getDatagames;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.beans.binding.Bindings.select;
import static javafx.beans.binding.Bindings.size;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;




public class FXMLDocumentController implements Initializable {
    

    @FXML
    private Button btn_update;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_add;
    
    @FXML
    private Button btn_edit;

    @FXML
    private TableView<games> table_games;

    @FXML
    private TableColumn<games, Integer> col_id;

    @FXML
    private TableColumn<games, String> col_name;

    @FXML
    private TableColumn<games, String> col_category;

    @FXML
    private TableColumn<games, Double> col_price;

    @FXML
    private TableColumn<games, String> col_release_year;

    @FXML
    private TableColumn<games, String> col_description;

    @FXML
    private TableColumn<games, String> col_img;

    @FXML
    private TableColumn<games, Integer> col_stock;
    
    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_price;

    @FXML
    private TextField txt_description;

    @FXML
    private TextField file_img;

    @FXML
    private TextField txt_stock;

    @FXML
    private ComboBox select_release_year;
    
    @FXML
    private TextField txt_id;
    
      
    @FXML
    private ComboBox select_category;
    
    @FXML
    private ImageView image_view;

    @FXML
    private Button btn_browse;

    @FXML
    private TextField image_path;
    
    @FXML
    private Button purchase_page;
    
    @FXML
    private AnchorPane home;
    
    @FXML
    private Image selected_img; 
 
    @FXML
    private Button btn_clear;
    
    @FXML
    private BufferedImage bf;
    
    @FXML
    private Label label_total;
    
        @FXML
    private TextField txt_search;
    
        
    
    
    //WORKSPACE
    private FileInputStream fis;
    private InputStream is;
    private OutputStream os;
    ObservableList<games> listG;
    private games g;
    
     
    
    
    
    
    int index = -1;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    //Instance 
    //USEDMETHODS
    
    //clear feilds
    @FXML
    
         private void clearTextFeild () {
         txt_id.clear();
         txt_name.clear();
         select_category.setValue(null);
         select_release_year.setValue(null);
         txt_price.clear();
         txt_description.clear();
         image_view.setImage(null);
         txt_stock.clear();   
         image_path.clear();
         
         
     }
    // show data on text file on mouse click
    @FXML
    void getSelected(MouseEvent event) throws SQLException {
        games G = table_games.getSelectionModel().getSelectedItem();
        index= table_games.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
    txt_id.setText(col_id.getCellData(index).toString());
    txt_name.setText(col_name.getCellData(index).toString());
    select_category.setValue(col_category.getCellData(index).toString());
    select_release_year.setValue(col_release_year.getCellData(index).toString());
    txt_price.setText(col_price.getCellData(index).toString());
    txt_description.setText(col_description.getCellData(index).toString());
    image_path.setText(col_img.getCellData(index).toString());
 
    String picture = "file:"+ G.getImg();
    Image image = new Image(picture, 185 ,170, false , true);
    image_view.setImage(image);
    
    txt_stock.setText(col_stock.getCellData(index).toString());
    }
    

 
 /**   private void displayImage() throws SQLException, FileNotFoundException, IOException {
  
    pst = conn.prepareStatement("select img from games where id =?");
    pst.setInt(1, g.getId());
    rs = pst.executeQuery();
    if(rs.next()){
         is = rs.getBinaryStream("img");
         os = new FileOutputStream(new File("image.jpg"));
         byte[] content = new byte[1024];
         int size = 0;
         while ((size = is.read(content)) != -1){
             os.write(content, 0, size);
         }
         os.close();
         is.close();
         
       selected_img = new Image("file:photo.jpg", image_view.getFitWidth(),image_view.getFitHeight(),true,true);
       image_view.setImage(selected_img);
         
    }
    }    
   **/ 
    // scene changer with button
    @FXML 
    public void changeScreen(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLPurchases.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
    //attaching img
    
    @FXML
    public void Attach_img(){
    FileChooser chooser = new FileChooser();
    chooser.getExtensionFilters().add( new ExtensionFilter("Image Files","*jpg","*png"));
    File f = chooser.showOpenDialog(null);
    if (f != null){
        
        image_path.setText(f.getAbsolutePath());
        Image selected_image = new Image(f.toURI().toString(),185,170,false,true);
        
        image_view.setImage(selected_image);
        try {
            fis = new FileInputStream(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }
    
    
    //CRUD
    @FXML
    public void Add_games (){
       
        conn = gamesconnect.ConnectDb();
       
        String sql = "insert into games (name,category,release_year,price,description,img,stock) values (?,?,?,?,?,?,?)";              
        try{
            if(       txt_name.getText().isEmpty()
                    | select_category.getSelectionModel().isEmpty()
                    | select_release_year.getSelectionModel().isEmpty()
                    | txt_price.getText().isEmpty()
                    | txt_description.getText().isEmpty()
                    | image_path.getText().isEmpty()
                    | txt_stock.getText().isEmpty()
                    | image_view.getImage() == null) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setContentText("Don't leave empty fields!");
                alert.show();
            }
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_name.getText());
            pst.setString(2, select_category.getSelectionModel().getSelectedItem().toString());
            pst.setString(3, select_release_year.getSelectionModel().getSelectedItem().toString());
            pst.setDouble(4, Double.valueOf(txt_price.getText()));
            pst.setString(5, txt_description.getText());
            pst.setString(6, image_path.getText());
            pst.setString(7, txt_stock.getText());
            
            pst.execute();
            UpdateTable();
            //
            totalStock();

            JOptionPane.showMessageDialog(null, "Game Add succes");
        }catch(Exception e){
            
        } 
    }
    
    @FXML
    public void Delete(){
        conn = gamesconnect.ConnectDb();
        String sql = "delete from games where id = ? ";
        try{
            
              Alert alert = new Alert(AlertType.CONFIRMATION);
            Optional<ButtonType> buttonType = alert.showAndWait();
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Delete will be permenant \n"
                    + "Continue?");
            if (buttonType.get() == ButtonType.OK){         
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            pst.execute();
            UpdateTable();
            clearTextFeild ();
            //
            totalStock();
            
            JOptionPane.showMessageDialog(null, "Game Delete succes");
            }else return;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "failed to delete (ID Does not exist)");
        }
    }
     @FXML
     public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_category.setCellValueFactory(new PropertyValueFactory<>("category"));
        col_release_year.setCellValueFactory(new PropertyValueFactory<>("release_year"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_img.setCellValueFactory(new PropertyValueFactory<>("img"));
        col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        listG = gamesconnect.getDatagames();
        table_games.setItems(listG);
    }
     

 
     @FXML
     private void editGame() throws SQLException {
         conn = gamesconnect.ConnectDb();
         String sql ="Update games set name =?,category =?, release_year =?, price =?, description=?, img=?, stock= ? where id =? ";
     
    
             pst = conn.prepareStatement(sql);
             pst.setString(1, txt_name.getText());
             pst.setString(2, select_category.getSelectionModel().getSelectedItem().toString());
             pst.setString(3, select_release_year.getSelectionModel().getSelectedItem().toString());
             pst.setDouble(4, Double.valueOf(txt_price.getText()));
             pst.setString(5, txt_description.getText());
             pst.setString(6, image_path.getText());
             pst.setString(7, txt_stock.getText());
             pst.setString(8, txt_id.getText());

             pst.executeUpdate();
             UpdateTable();
             clearTextFeild ();
             //
             totalStock();
             JOptionPane.showMessageDialog(null, "Game Updated succes");

     }
     

     @FXML
     public void search(){


		FilteredList<games> filteredData = new FilteredList<>(listG, p -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		txt_search.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(games -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (g.getName().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches first name.
				} else if (g.getCategory().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches last name.
				}
				return false; // Does not match.
			});
		});
     }

     
     
     //METIERS
     @FXML 
     private void totalStock() {
         int total = 0;
         for (games g : listG ){
             total+=g.getStock();
         } 
         label_total.textProperty().bind(new SimpleIntegerProperty(total).asString());

     }
     @FXML
    private void logoutt(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        txt_name.getScene().getWindow().hide();
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

        UpdateTable(); 
        ObservableList<String> box = FXCollections.observableArrayList("Battle Royale","Action","Role-playing","Adventure","Racing","Fighting","Strategy","Simulator");
        select_category.setItems(box);    
     
        ObservableList<String> box_year = FXCollections.observableArrayList("2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012",
                "2013","2014","2015","2016","2017","2018","2019","2020");
        select_release_year.setItems(box_year);    
        totalStock();
        search();

    
}



}