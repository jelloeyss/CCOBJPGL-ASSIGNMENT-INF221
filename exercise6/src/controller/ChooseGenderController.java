package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChooseGenderController {
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    //Selects the StoreName men scene
    public void switchToHome(ActionEvent event) throws IOException {
       root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
       stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }



}
