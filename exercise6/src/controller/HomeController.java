package controller;

import model.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import alert.AlertMaker;

public class HomeController implements Initializable {

    @FXML
    Label name1, name2, name3, price1, price2, price3, namelabel;

    @FXML
    ImageView img1, img2, img3;

    @FXML
    Button button1, button2, button3, cartbutton;

    @FXML
    private Button logoutbutton;

    @FXML
    private AnchorPane scenepane;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root = null;

    FXMLLoader loader;

    @FXML
    CheckoutController checkoutController = null;

    static BedroomLamp blamp = new BedroomLamp();
    static CeilingLamp clamp = new CeilingLamp();
    static WallLamp wlamp = new WallLamp();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // ============== BEDROOM LAMP ==================//
        blamp.setProductName("Bedroom Lamp");
        name1.setText(blamp.getProductName());

        blamp.setProductPrice(5.00);
        price1.setText(Double.toString(blamp.getProductPrice()));

        blamp.setProductImage("images/lamp1.jpg");
        Image bedroomLamp = new Image(blamp.getProductImage());
        img1.setImage(bedroomLamp);

        // ============== CEILING LAMP ==================//

        clamp.setProductName("Ceiling Lamp");
        name2.setText(clamp.getProductName());

        clamp.setProductPrice(10.00);
        price2.setText(Double.toString(clamp.getProductPrice()));

        clamp.setProductImage("images/lamp2.jpg");
        Image ceilingLamp = new Image(clamp.getProductImage());
        img2.setImage(ceilingLamp);

        // ============== WALL LAMP ==================//
        wlamp.setProductName("Wall Lamp");
        name3.setText(wlamp.getProductName());

        wlamp.setProductPrice(15.00);
        price3.setText(Double.toString(wlamp.getProductPrice()));

        wlamp.setProductImage("images/lamp3.jpg");
        Image wallLamp = new Image(wlamp.getProductImage());
        img3.setImage(wallLamp);

        try {
            loader = new FXMLLoader(getClass().getResource("/view/Checkout.fxml"));
            root = loader.load();
        } catch (Exception e) {
            System.out.println("Oops!, there is a problem at " + e);
        }

        // Clears all items in Checkout.fxml
        checkoutController = loader.getController();
        checkoutController.myvbox.getChildren().removeAll(checkoutController.myvbox.getChildren());
    }

        //Says the name of the user
    public void displayName(String username) {
        namelabel.setText("Hello, " + username + "!");
    }


    public void buy(ActionEvent event) throws IOException {

        AlertMaker.showSimpleAlert("hello", "item added");

        Button sourceButton = (Button) event.getSource();

        // If addtocart button is pressed, set product status to true
        if (sourceButton.equals(button1)) {
            blamp.setProductStatus(true);
            checkoutController.addItem(checkoutController.pane1);
        }

        else if (sourceButton == button2) {
            clamp.setProductStatus(true);
            checkoutController.addItem(checkoutController.pane2);
        }

        else if (sourceButton == button3) {
            wlamp.setProductStatus(true);
            checkoutController.addItem(checkoutController.pane3);
        }
    }

    // Goes to Checkout.fxml
    public void gotocart(ActionEvent event) throws IOException {

        Scene scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //Goes back to ChooseGender
        public void switchToGenderPref(ActionEvent event) throws IOException {
       root = FXMLLoader.load(getClass().getResource("/view/ChooseGender.fxml"));
       stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }

    //logs out the program
    public void logout (ActionEvent event) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You are about to exit page!");
        alert.setContentText("Do you wish to stop shopping?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenepane.getScene().getWindow();
            System.out.println("You have successfully logged out");
            stage.close();
        } 
    }
}
