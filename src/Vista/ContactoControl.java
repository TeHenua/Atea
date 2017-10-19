package Vista;

import Modelo.TipoContacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ContactoControl implements Initializable{

    public TextField tfNombre;
    public TextField tfApellido1;
    public TextField tfApellido2;
    public TextField tfDni;
    public TextField tfFechaNac;
    public TextField tfLugarNac;
    public TextField tfRelacion;
    public TextField tfDireccion;
    public TextField tfLocalidad;
    public TextField tfCp;
    public TextField tfProvincia;
    public TextField tfFijo;
    public TextField tfMovil;
    public TextField tfEmail;
    @FXML
    public ComboBox<String> cbUsuario;
    public ComboBox<TipoContacto> cbContacto;

    ObservableList<String> listaUsuario = FXCollections.observableArrayList("Fulanito","Menganito","Zutanito");

    ObservableList<TipoContacto> listaTipoComunicacion = FXCollections.observableArrayList(TipoContacto.Email,
            TipoContacto.Carta,TipoContacto.Carta_sin_remite);

    @Override
    public void initialize(URL location, ResourceBundle resources) {//Cargo los valores en el combobox
        cbUsuario.setItems(listaUsuario);
        cbContacto.setItems(listaTipoComunicacion);
    }

    public void guardar(ActionEvent actionEvent) {

        String nome = tfNombre.getText();//obtengo el valor del textfield al pulsar el boton
        String apelidoUn = tfApellido1.getText();
        String apelidoDous = tfApellido2.getText();
        String dni = tfDni.getText();
        String naceu = tfFechaNac.getText();
        String lugar = tfLugarNac.getText();
        String usuario = cbUsuario.getValue();
        String relacion = tfRelacion.getText();
        String direccion = tfDireccion.getText();
        String localidad = tfLocalidad.getText();
        String cp = tfCp.getText();
        String provincia = tfProvincia.getText();
        String fijo = tfFijo.getText();
        String movil = tfMovil.getText();
        String email = tfEmail.getText();

    }

}
