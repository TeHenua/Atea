package Vista;

import Modelo.TipoContacto;
import Modelo.TipoSocio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class SocioControl implements Initializable{
    
    public TextField tfNumero;
    public TextField tfDni;
    public TextField tfNombre;
    public TextField tfApellido1;
    public TextField tfApellido2;
    public TextField tfFechaNac;
    public TextField tfLugarNac;
    public TextField tfOcupacion;
    public TextField tfIban;
    public TextField tfDireccion;
    public TextField tfLocalidad;
    public TextField tfCp;
    public TextField tfProvincia;
    public TextField tfFijo;
    public TextField tfMovil;
    public TextField tfEmail;
    @FXML
    public ComboBox<TipoSocio> cbTipoSocio;
    public ComboBox<TipoContacto> cbTipoContacto;

    ObservableList<TipoSocio> listaTipoSocio = FXCollections.observableArrayList(TipoSocio.Ordinario,TipoSocio.Honorario,
            TipoSocio.Protector,TipoSocio.Voluntario,TipoSocio.Colaborador);//creo la lista del combobox

    ObservableList<TipoContacto> listaTipoComunicacion = FXCollections.observableArrayList(TipoContacto.Email,
            TipoContacto.Carta,TipoContacto.Carta_sin_remite);

    @Override
    public void initialize(URL location, ResourceBundle resources) {//cargo los valores en el combobox
        cbTipoSocio.setItems(listaTipoSocio);
        cbTipoContacto.setItems(listaTipoComunicacion);

    }
    public void guardar(ActionEvent actionEvent) {

        String numero = tfNumero.getText();//obtengo el valor del textfield al pulsar el boton
        String dni = tfDni.getText();
        TipoSocio tipoSocio = cbTipoSocio.getValue();
        String nome = tfNombre.getText();
        String apelidoUn = tfApellido1.getText();
        String apelidoDous = tfApellido2.getText();
        String naceu = tfFechaNac.getText();
        String lugar = tfLugarNac.getText();
        String ocupacion = tfOcupacion.getText();
        String iban = tfIban.getText();
        String direccion = tfDireccion.getText();
        String localidad = tfLocalidad.getText();
        String cp = tfCp.getText();
        String provincia = tfProvincia.getText();
        String fijo = tfFijo.getText();
        String movil = tfMovil.getText();
        String email = tfEmail.getText();
        TipoContacto tipoComunicacion = cbTipoContacto.getValue();

    }
}
