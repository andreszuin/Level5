package Controllers;


import Teste.Conecta;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class ControllerPrincipal {

    public void OpenPrincipal_proj(){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Interface/principal_proj.fxml"));
                /*
                 * if "fx:controller" is not set in fxml
                 * fxmlLoader.setController(NewWindowController);
                 */
                Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
                Stage stage = new Stage();
                stage.setTitle("Projeto");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {

            }
    }
    public void OpenPrincipal_membros(){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Interface/principal_membros.fxml"));
                /*
                * if "fx:controller" is not set in fxml
                * fxmlLoader.setController(NewWindowController);
                */
                Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
                Stage stage = new Stage();
                stage.setTitle("Membros");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,"erro:"+e);
            }
    }
    public void OpenPrincipal_gold(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Interface/principal_gold.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 500, 600);
            Stage stage = new Stage();
            stage.setTitle("Gold");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {

        }
    }
}
