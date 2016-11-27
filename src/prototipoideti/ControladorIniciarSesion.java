/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipoideti;

import Entidades.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class ControladorIniciarSesion implements Initializable {

    // ELEMENTOS ViewIniciarSesion
    public TextField tfUsuario;
    public PasswordField pfContra;
    public Button btnIniciarSesion;
    public Button btnNuevoUsuario;

    // Lector y escritor
    private static BufferedReader fi;
    private static PrintWriter fo;

    // Usuario actual
    private static Usuario act;

    public Stage stage;

    @FXML
    public BorderPane root;
    public VBox rootlogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        act = new Usuario();
        try {
            fi = new BufferedReader(new FileReader("UFDB.txt"));
            fi.close();
        } catch(Exception excep) {
            try {
                fo = new PrintWriter("UFDB.txt");
                fo.close();
            } catch(Exception except) {

            }
        }

        btnIniciarSesion.setOnAction(e -> {
            try {
                //Usuario temp = new Usuario();
                //temp = temp.getUsuario(tfUsuario.getText());
                stage = (Stage) btnIniciarSesion.getScene().getWindow();
                //if(temp != null) {
                //    Usuario.actual = new Usuario(temp.getClave(), temp.getNombreUsuario(), temp.getNombreReal(), temp.getContrasenia(), temp.getCorreo());
                //}
                if(act.inicioDeSesionExitosa(tfUsuario.getText(), pfContra.getText())) {
                    fo = new PrintWriter("TFDB.txt");
                    Usuario temp = act.getUsuario(tfUsuario.getText());
                    fo.println(temp.getClave());
                    fo.println(temp.getNombreUsuario());
                    fo.println(temp.getNombreReal());
                    fo.println(temp.getContrasenia());
                    fo.println(temp.getCorreo());
                    fo.close();
                    Stage window = (Stage) btnIniciarSesion.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("ViewCurso.fxml"));
                    window.setTitle("IDETI - Oferta de cursos");
                    window.setScene(new Scene(root, 900, 550));
                    //Parent root = FXMLLoader.load(getClass().getResource("ViewIniciarSesion.fxml"));
                    //primaryStage.setTitle("Iniciar sesión");
                    //primaryStage.setScene(new Scene(root, 600, 375));
                    window.show();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        btnNuevoUsuario.setOnAction(e -> {
            ControladorIniciarSesion.AgregarUsuario();
        });

    }

    public static void AgregarUsuario() {
        //ArrayList<String> lineas = new ArrayList<>();
        //int i = 0;
        Stage window = new Stage();

        // Crear ventana
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Agregar usuario...");
        window.setMinWidth(250);

        // Crear Mensaje
        Label labeli = new Label();
        labeli.setText("Llenar datos del usuario...");

        // Crear mensaje para nombre de usuario
        Label lbNom = new Label();
        lbNom.setText("Usuario:");
        // Crear campo para elegir el nombre de usuario
        TextField Nom = new TextField();
        // Crear espacio para poner nombre de usuario
        HBox HBoxA = new HBox(2);
        HBoxA.setAlignment(Pos.CENTER);
        HBoxA.setSpacing(5);
        HBoxA.getChildren().addAll(lbNom, Nom);

        // Crear mensaje para nombre real
        Label lbNomR = new Label();
        lbNomR.setText("Nombre real:");
        // Crear campo para nombre real
        TextField NomR = new TextField();
        // Crear espacio para poner nombre de usuario
        HBox HBoxB = new HBox(2);
        HBoxB.setAlignment(Pos.CENTER);
        HBoxB.setSpacing(5);
        HBoxB.getChildren().addAll(lbNomR, NomR);

        // Crear mensaje para correo
        Label lbCorr = new Label();
        lbCorr.setText("Correo:");
        // Crear campo para correo
        TextField Corr = new TextField();
        // Crear espacio para correo
        HBox HBoxCorr = new HBox(2);
        HBoxCorr.setAlignment(Pos.CENTER);
        HBoxCorr.setSpacing(5);
        HBoxCorr.getChildren().addAll(lbCorr, Corr);

        // Crear mensaje para contrasenia
        Label lbC = new Label();
        lbC.setText("Contraseña:");
        // Crear campo para contrasenia
        PasswordField Contra = new PasswordField();
        // Crear espacio para contrasenia
        HBox HBoxC = new HBox(2);
        HBoxC.setAlignment(Pos.CENTER);
        HBoxC.setSpacing(5);
        HBoxC.getChildren().addAll(lbC, Contra);

        // Crear boton de submit
        Button button = new Button("Agregar usuario");
        button.setOnAction(e -> {
            if(act.getUsuario(lbNom.getText()) != null) {
                labeli.setText("Nombre de usuario ocupado");
            }
            else {
                act.nuevo(Nom.getText(), NomR.getText(), Contra.getText(), Corr.getText());
                window.close();
            }
        });

        // Agregar a la escena
        VBox layout = new VBox(10);
        layout.getChildren().addAll(labeli, HBoxA, HBoxB, HBoxCorr, HBoxC, button);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
