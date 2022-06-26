/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfacegrback.NewscrudController;
import edu.gestion.entities.Post;
import edu.gestion.services.PostCrud;
import edu.gestion.entities.Comentaire;
import edu.gestion.services.ComentaireCrud;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author Home
 */
public class newsController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private TextField tffiltre;
    public ObservableList<Post> data = FXCollections.observableArrayList();

    private List<Post> postData = new ArrayList<>();
    private List<Post> post = new ArrayList<>();

    private List<Post> getData() {
        List<Post> postItem = new ArrayList<>();
        Post p1;

        for (Post p : postData) {
            p1 = new Post();
            p1.setTitre(p.getTitre());
            p1.setRate(p.getRate());
            p1.setImg_post(p.getImg_post());

            postItem.add(p1);
        }

        return postItem;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            showPost();
        } catch (SQLException ex) {
            Logger.getLogger(newsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PostCrud pcrud = new PostCrud();

            postData.addAll(pcrud.readAll());

            post.addAll(getData());

            /* System.out.println(post);*/
            int column = 0;
            int row = 1;

            for (int i = 0; i < data.size(); i++) {
                try {
                    FXMLLoader fxmlloader = new FXMLLoader();
                    fxmlloader.setLocation(getClass().getResource("news 1111.fxml"));
                    AnchorPane anchorPane = (AnchorPane) fxmlloader.load();
                    news1111Controller News1111Controller = fxmlloader.getController();
                    News1111Controller.setData(data.get(i).getId_post(), data.get(i).getTitre(), data.get(i).getImg_post(), data.get(i).getRate(), data.get(i).getImage());

                    if (column == 2) {
                        column = 0;
                        row++;
                    }

                    grid.add(anchorPane, column++, row);

                    grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                    grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                    grid.setMaxWidth(Region.USE_PREF_SIZE);

                    //set grid height
                    grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                    grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                    grid.setMaxHeight(Region.USE_PREF_SIZE);
                    GridPane.setMargin(anchorPane, new Insets(10));

                } // TODO
                /* }  */ catch (IOException ex) {
                    Logger.getLogger(newsController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(newsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showPost() throws SQLException {
        PostCrud p = new PostCrud();

        data.addAll(p.readAll());

    }

    @FXML
    private void btnsearch(ActionEvent event) {

        List<Post> filtredSearch = new ArrayList<>();
        if (tffiltre.getText().equals("")) {
            filtredSearch = postData;
        
        } else {
            for (Post p : postData) {
                if (p.getTitre().contains(tffiltre.getText())) {
                    filtredSearch.add(p);
                    
                }
            }
                System.out.println(filtredSearch);

        }

        System.out.println(filtredSearch);

        int column = 0;
        int row = 1;
        grid.getChildren().clear();
        for (int i = 0; i < filtredSearch.size(); i++) {
            try {

                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("news 1111.fxml"));
                AnchorPane anchorPane = (AnchorPane) fxmlloader.load();
                news1111Controller News1111Controller = fxmlloader.getController();
                News1111Controller.setData(filtredSearch.get(i).getId_post(), filtredSearch.get(i).getTitre(), filtredSearch.get(i).getImg_post(), filtredSearch.get(i).getRate(), filtredSearch.get(i).getImage());

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);

                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(10));

            } catch (IOException ex) {
                Logger.getLogger(newsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
