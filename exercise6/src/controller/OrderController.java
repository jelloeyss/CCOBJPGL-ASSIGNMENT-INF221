package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;

public class OrderController implements Initializable {

    @FXML
    Label name1, name2, name3, qty1, qty2, qty3, lineamount1, lineamount2, lineamount3, totalamount;
    @FXML
    ImageView img1, img2, img3;
    
    public void initialize(URL location, ResourceBundle resources) {

         if (HomeController.blamp.getProductStatus()){
            name1.setText(HomeController.blamp.getProductName());
            qty1.setText(Double.toString(HomeController.blamp.getProductQuantity()));
            name1.setVisible(true);
            qty1.setVisible(true);
            lineamount1.setVisible(true);
            lineamount1.setText(Double.toString(HomeController.blamp.getProductPrice()*HomeController.blamp.getProductQuantity()));
  
         }
            if (HomeController.clamp.getProductStatus()){
             name2.setText(HomeController.clamp.getProductName());
             qty2.setText(Double.toString(HomeController.clamp.getProductQuantity()));
             name2.setVisible(true);
             qty2.setVisible(true);
             lineamount2.setVisible(true);
             lineamount2.setText(Double.toString(HomeController.clamp.getProductPrice()*HomeController.clamp.getProductQuantity()));

   
        }
            if (HomeController.wlamp.getProductStatus()){
            name3.setText(HomeController.wlamp.getProductName());
            qty3.setText(Double.toString(HomeController.wlamp.getProductQuantity()));
            name3.setVisible(true);
            qty3.setVisible(true);
            lineamount3.setVisible(true);
            lineamount3.setText(Double.toString(HomeController.wlamp.getProductPrice()*HomeController.wlamp.getProductQuantity()));

        }
            double amount1 = HomeController.blamp.getProductPrice() * HomeController.blamp.getProductQuantity();
            double amount2 = HomeController.clamp.getProductPrice() * HomeController.clamp.getProductQuantity();
            double amount3 = HomeController.wlamp.getProductPrice() * HomeController.wlamp.getProductQuantity();
            double finalamount = amount1 + amount2 + amount3;
            totalamount.setText(Double.toString(finalamount));
            totalamount.setVisible(true);
    }
    public void switchToCheckout(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Checkout.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
}