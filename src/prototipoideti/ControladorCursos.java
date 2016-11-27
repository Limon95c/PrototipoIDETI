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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorCursos implements Initializable {

    private Usuario Act;
    
    public Button btnCerrar;
    
    public TextField tfUser;
    public TextField tfNombreR;
    public TextField tfCorreo;
    
    public TableView<Curso> CursoTV;
    public TableColumn<Curso, String> claveCol;
    public TableColumn<Curso, String> nomCol;
    public TableColumn<Curso, String> fechaCol;
    public TableColumn<Curso, String> NivelCol;
    public TableColumn<Curso, String> DuracionCol;
    public ObservableList<Curso> CursoTableList;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
        String linea;
        BufferedReader fi = new BufferedReader(new FileReader("TFDB.txt"));
        linea = fi.readLine();
        tfUser.setText(fi.readLine());
        tfNombreR.setText(fi.readLine());
        linea = fi.readLine();
        tfCorreo.setText(fi.readLine());
        fi.close();
        
        } catch(Exception excep) {
            
        }
        
        ArrayList<Curso> curs = cargarcursos();
        // Columna de nombre de cursos
        CursoTableList = FXCollections.observableArrayList();
        for(Curso cur:curs) {
            CursoTableList.add(cur);
        }
        
        claveCol.setCellValueFactory(new PropertyValueFactory<>("clave"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        fechaCol.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        NivelCol.setCellValueFactory(new PropertyValueFactory<>("nivel"));
        DuracionCol.setCellValueFactory(new PropertyValueFactory<>("duracion"));

        CursoTV.setItems(CursoTableList);
        
        btnCerrar.setOnAction(e -> {
            try {
                Stage window = (Stage) btnCerrar.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("ViewIniciarSesion.fxml"));
                window.setTitle("Iniciar Sesion");
                window.setScene(new Scene(root, 600, 375));
                window.show();
            }
            catch(Exception excep) {
                    
            }
        });
    }

    private ArrayList<Curso> cargarcursos() {
        Oferta oferta = new Oferta();
        return oferta.cargar();
    }
}