import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {

        launch(args);
    }
    public void start(Stage stage) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(event -> {
                event.consume();
                logout(stage);
            
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

      //if the user clicks the "x" button, the message will still appear.
    public void logout (Stage stage) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You are about to exit page!");
        alert.setContentText("Do you wish to stop shopping?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You have successfully logged out");
            stage.close();
        } 
    }

}