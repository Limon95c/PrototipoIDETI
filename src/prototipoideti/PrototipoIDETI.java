/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipoideti;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrototipoIDETI extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ViewIniciarSesion.fxml"));
        primaryStage.setTitle("Iniciar sesion");
        primaryStage.setScene(new Scene(root, 600, 375));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
