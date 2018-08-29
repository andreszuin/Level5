package Teste;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Principal extends Application {
    Conecta conex = new Conecta();
    @Override
    public void start(Stage primaryStage) throws Exception{
        conex.conexao();
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/principal.fxml"));
        primaryStage.setTitle("Pagina inicial");
        primaryStage.setScene(new Scene(root, 700, 450));
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                conex.desconnect();
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
