package Vista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UsuarioControl implements Initializable{

    @FXML
    public TextField tfNombre;
    public TextField tfApellido1;
    public TextField tfApellido2;
    public TextField tfDni;
    public TextField tfSocio;
    public TextField tfLugarNac;
    public TextField tfDireccion;
    public TextField tfLocalidad;
    public TextField tfCp;
    public TextField tfProvincia;
    public ComboBox<String> cbSocio;
    public DatePicker dpFechaNac;
    public TextField tfColegio;
    public TextField tfOcupacion;
    public TextField tfSegSocial;
    public TextField tfTis;
    public DatePicker tfEntrevista;

    ObservableList<String> lista = FXCollections.observableArrayList("Fulanito", "Menganito","Zutanito");

    @Override
    public void initialize(URL location, ResourceBundle resources) {//cargo los valores en el combobox
        cbSocio.setItems(lista);
    }

    public void guardar(ActionEvent actionEvent) {

        String nome = tfNombre.getText();//obtengo el valor del textfield al pulsar el boton
        String apelidoUn = tfApellido1.getText();
        String apelidoDous = tfApellido2.getText();
        String dni = tfDni.getText();
        String socio = tfSocio.getText();
        String tipoSocio = cbSocio.getValue();
        LocalDate naceu = dpFechaNac.getValue();
        java.sql.Date fechaNac = Date.valueOf(naceu);
        String lugar = tfLugarNac.getText();
        String direccion = tfDireccion.getText();
        String localidad = tfLocalidad.getText();
        String cp = tfCp.getText();
        String provincia = tfProvincia.getText();

    }
}
