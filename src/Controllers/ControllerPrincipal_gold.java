package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerPrincipal_gold {
    public void OpenDescontar_gold(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Interface/descontar_gold.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 350, 200);
            Stage stage = new Stage();
            stage.setTitle("Gold");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {

        }
    }
}
