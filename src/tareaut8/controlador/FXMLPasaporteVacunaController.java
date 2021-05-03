/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaut8.controlador;

import tareaut8.modelo.Usuario;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import tareaut8.modelo.*;

/**
 * FXML Controller class
 *
 * @author mac
 */
public class FXMLPasaporteVacunaController implements Initializable {

    //Contenedor de Usuario.
    @FXML
    private Pane pnUsuario;
    @FXML
    private Label lbNombre;
    @FXML
    private Label lbApellidos;
    @FXML
    private Label lbdni;
    @FXML
    private Label lbFechaNac;
    @FXML
    private Label lbGrupo;
    @FXML
    private Label lbSexo;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellidos;
    @FXML
    private TextField tfdni;
    @FXML
    private DatePicker dpFechaNac;
    @FXML
    private ComboBox<String> cbGrupo;
    @FXML
    private RadioButton rbHombre;
    @FXML
    private ToggleGroup rbSexo;
    @FXML
    private RadioButton rbMujer;
    @FXML
    private Button btLimpiar;
    @FXML
    private Button btInsertarUser;

    //Declaracion de un objeto Usuario.
    Usuario u1;

    @FXML
    private Label lbDDatosUsuario;
    @FXML
    private Label lbUsuarios;
    @FXML
    private Button btInsertarEvento;
    @FXML
    private Label lbDatosEventosCovid;
    @FXML
    private Label lbTipo;
    @FXML
    private Label lbFechaEve;
    @FXML
    private Label lbResultado;
    @FXML
    private Label lbTipoPrueba;
    @FXML
    private Label lbNumeroDeDosis;
    @FXML
    private Label lbNombreVacuna;
    @FXML
    private ToggleGroup rbTipo;
    @FXML
    private RadioButton rbVacunacion;
    @FXML
    private DatePicker dpFechaEvento;
    @FXML
    private TextField tfNumeroDosis;
    @FXML
    private Pane pnPruebaContagio;
    @FXML
    private RadioButton rbPositivo;
    @FXML
    private ToggleGroup rbResultado;
    @FXML
    private RadioButton rbNegativo;
    @FXML
    private ComboBox<String> cbTipoPrueba;
    @FXML
    private Pane pnVacunacion;
    @FXML
    private RadioButton rbPruebaDeContagio;
    @FXML
    private ComboBox<String> cbNombreVacuna;

    //Declaracion de un objeto Vacunacion.
    Vacunacion v1;

    //Declaracion de un objeto PruebaContagio
    PruebaContagio p1;
    
    @FXML
    private ListView<LinkedList> lvEventos;
    private ObservableList<LinkedList> Eventos;
    
    @FXML
    private TableView<Usuario> tvUsuario;
    @FXML
    private TableColumn<Usuario, String> tvNombre;
    @FXML
    private TableColumn<Usuario, String> tvApellidos;
    @FXML
    private TableColumn<Usuario, String> tvDni;
    @FXML
    private TableColumn<Usuario, String> tvFechaNacimiento;
    @FXML
    private TableColumn<Usuario, String> tvGrupo;
    @FXML
    private TableColumn<Usuario, String> tvSexo;
    
    private ObservableList<Usuario> elementosUsuario;
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        rbHombre.setSelected(true);
        cbGrupo.getItems().addAll("Sanidad", "Educación", "Mayores de 80", "Mayores de 65");
        cbGrupo.setPromptText("Elige un grupo");
        dpFechaNac.setPromptText("Fecha de Nacimiento");

        cbTipoPrueba.getItems().addAll("PCR", "ANTIGENOS", "SEROLOGICA");
        cbTipoPrueba.setPromptText("Elige el tipo de prueba");
        dpFechaEvento.setPromptText("Elige fecha del evento");
        
        cbNombreVacuna.getItems().addAll("Astrazeneca", "Janssen", "Pfizer", "Moderna");
        cbNombreVacuna.setPromptText("Elige el nombre de la vacuna");
        
        elementosUsuario= FXCollections.observableArrayList();
        
        tvNombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nombre"));
        tvApellidos.setCellValueFactory(new PropertyValueFactory<Usuario, String>("apellidos"));
        tvDni.setCellValueFactory(new PropertyValueFactory<Usuario, String>("dni"));
        tvFechaNacimiento.setCellValueFactory(new PropertyValueFactory<Usuario, String>("fechaNac"));
        tvGrupo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("grupo"));
        tvSexo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("sexo"));
        
        tvUsuario.setItems(elementosUsuario);
        
        Eventos =FXCollections.observableArrayList();
        
        lvEventos.setItems(Eventos);

    }

    @FXML
    private void limpiarDatos(ActionEvent event) {

        //Limpiamos los variables del usuario.
        tfNombre.clear();
        tfApellidos.clear();
        tfdni.clear();
        dpFechaNac.setValue(null);
        cbGrupo.getSelectionModel().clearSelection();

    }

    @FXML
    private void insertarUsuario(ActionEvent event) {

        //Inicializamos el objeto Usuario
        u1 = new Usuario();

        //Declarar una alerta de tipo Informacion.
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("Mensaje de errores");

        //Verificamos si todos los campos tenen valor y sino mostrar una alerta
        if (tfNombre.getText().isEmpty()) {

            alerta.setContentText("El campo NOMBRE no puede estar vacío");
            alerta.showAndWait();
        } else if (tfApellidos.getText().isEmpty()) {

            alerta.setContentText("El campo Apellidos no puede estar vacío");
            alerta.showAndWait();
        } else if (tfdni.getText().isEmpty()) {

            alerta.setContentText("El campo DNI no puede estar vacío");
            alerta.showAndWait();
        } else if (dpFechaNac.getValue() == null) {

            alerta.setContentText("El campo Fecha de nacimiento no puede estar vacío");
            alerta.showAndWait();
        } else if (cbGrupo.getSelectionModel().isEmpty()) {

            alerta.setContentText("El campo Grupo no puede estar vacío");
            alerta.showAndWait();
        } //Si todos los campos tienen valor.
        else {
            //Almacenamos el valor escogedo en un RadioButton.
            RadioButton rb = (RadioButton) rbSexo.getSelectedToggle();

            //Para comprobará que el campo DNI sigue el patrón de 8 números más unaletra.
            Pattern p = Pattern.compile("[0-9]{8}[a-zA-Z]{1}");
            Matcher m = p.matcher(tfdni.getText());
            //En el caso que el DNI sigue el patron.
            if (m.matches()) {

                int i = Integer.parseInt(tfdni.getText().substring(0, 8));

                int resto = i % 23;

                String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
                //En el caso que la lettra no es valida.
                if (letras.charAt(resto) != tfdni.getText().charAt(tfdni.getText().length() - 1)) {

                    alerta.setContentText("La letra del DNI no es valida");

                    alerta.showAndWait();
                    //Si el DNI es correcto.
                } else if (letras.charAt(resto) == tfdni.getText().charAt(tfdni.getText().length() - 1)) {

                    u1.setNombre(tfNombre.getText());
                    u1.setApellidos(tfApellidos.getText());
                    u1.setDni(tfdni.getText());
                    u1.setFechaNac(dpFechaNac.getValue().toString());
                    u1.setGrupo(cbGrupo.getSelectionModel().getSelectedItem());
                    u1.setSexo(rb.getText());
                    
                    elementosUsuario.add(u1);
                   
                }
                //En el caso que DNi no sigue el patron.
            } else {

                alerta.setContentText("DNI no es valido");

                alerta.showAndWait();

            }

        }
    }

    @FXML
    private void insertarEvento(ActionEvent event) {

        //Declarar una alerta de tipo Informacion.
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("Mensaje de errores");

        if (rbPruebaDeContagio.isSelected()) {

            //Inicializamos el objeto PruebaContagio
            p1 = new PruebaContagio();
            //Almacenamos el valor del rbResultado en rbresult
            RadioButton rbresult = (RadioButton) rbResultado.getSelectedToggle();

            //Si el campo Fecha evento esta vacio.
            if (dpFechaEvento.getValue() == null) {

                alerta.setContentText("El campo Fecha Evento no puede estar vacío");
                alerta.showAndWait();
            } //Si el campo resultado esta vacio.
            else if (rbPositivo.getText().isEmpty() && rbNegativo.getText().isEmpty()) {

                alerta.setContentText("Debe elegir si el resultado es Positivo o Negativo");
                alerta.showAndWait();
            } //Si el campo tipo de prueba esta vacio
            else if (cbTipoPrueba.getSelectionModel().isEmpty()) {

                alerta.setContentText("El campo tipo de prueba no puede estar vacío");
                alerta.showAndWait();
            } 
            //Si todos los campos tienen valor.
            else {
                
                p1.setFecha(dpFechaEvento.getValue().toString());
                p1.setPrueba(TipoPrueba.valueOf(cbTipoPrueba.getSelectionModel().getSelectedItem()));
                if(rbPositivo.isSelected()) p1.setPositivo(true);
                if(rbNegativo.isSelected()) p1.setPositivo(false);
                
                u1.añadirEventoCovid(p1);
                
               // u1.añadirEventoCovid(p1);
                Eventos.add(u1.getListaEventos());
                u1.eliminarEventoCovid(p1);
                
                
            }

        } else if (rbVacunacion.isSelected()) {
            
            //Inicializamos el objeto Vacunacion
            v1=new Vacunacion();
            
            //Si el campo Fecha evento esta vacio.
            if (dpFechaEvento.getValue() == null) {

                alerta.setContentText("El campo Fecha Evento no puede estar vacío");
                alerta.showAndWait();
            }
            //Si el campo numero de dosis esta vacio.
            else if(tfNumeroDosis.getText().isEmpty()){
                
                alerta.setContentText("El campo numero de dosis no puede estar vacío");
                alerta.showAndWait();
            }
            //Si el campo nombre vacuna esta vacio
            else if(cbNombreVacuna.getSelectionModel().isEmpty()){
                
                alerta.setContentText("El campo nombre de la vacuna no puede estar vacío");
                alerta.showAndWait();
            }
            //Si todos los campos tienen valor.
            else{
                v1.setFecha(dpFechaEvento.getValue().toString());
                v1.setNumDosis(Integer.parseInt(tfNumeroDosis.getText()));
                v1.setNombreVacuna(cbNombreVacuna.getSelectionModel().getSelectedItem());
                
                u1.añadirEventoCovid(v1);
                //u1.añadirEventoCovid(v1);
                Eventos.add(u1.getListaEventos());
                u1.eliminarEventoCovid(v1);
                
            }
        }

    }

    @FXML
    private void pruebaContagio(ActionEvent event) {

        pnVacunacion.setDisable(true);
        pnPruebaContagio.setDisable(false);
    }

    @FXML
    private void vacunacion(ActionEvent event) {

        pnPruebaContagio.setDisable(true);
        pnVacunacion.setDisable(false);
    }

    



}
