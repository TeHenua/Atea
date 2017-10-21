package Vista;

import Modelo.Socio;
import Modelo.TipoContacto;
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

public class SocioControl implements Initializable{
    
    public TextField tfNumero;
    public TextField tfDni;
    public TextField tfNombre;
    public TextField tfApellido1;
    public TextField tfApellido2;
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
    public ComboBox<String> cbTipoSocio;
    public ComboBox<TipoContacto> cbTipoContacto;
    public DatePicker dpFechaNac;

    ObservableList<String> listaTipoSocio = FXCollections.observableArrayList("Ordinario","Honorario",
            "Protector","Voluntario","Colaborador");//creo la lista del combobox

    ObservableList<TipoContacto> listaTipoComunicacion = FXCollections.observableArrayList(TipoContacto.Email,
            TipoContacto.Carta,TipoContacto.Carta_sin_remite);

    @Override
    public void initialize(URL location, ResourceBundle resources) {//cargo los valores en el combobox
        cbTipoSocio.setItems(listaTipoSocio);
        cbTipoContacto.setItems(listaTipoComunicacion);

    }
    public void guardar(ActionEvent actionEvent) {

        String numeroString = tfNumero.getText();//obtengo el valor del textfield al pulsar el boton
        int numero = Integer.parseInt(numeroString);
        String dni = tfDni.getText();
        String tipoSocio = cbTipoSocio.getValue();
        String nome = tfNombre.getText();
        String apelidoUn = tfApellido1.getText();
        String apelidoDous = tfApellido2.getText();
        LocalDate naceu = dpFechaNac.getValue();
        java.sql.Date fechaNac = Date.valueOf(naceu);
        String lugar = tfLugarNac.getText();
        String ocupacion = tfOcupacion.getText();
        String iban = tfIban.getText();
        String direccion = tfDireccion.getText();
        String localidad = tfLocalidad.getText();
        String codPos = tfCp.getText();
        int cp = Integer.parseInt(codPos);
        String provincia = tfProvincia.getText();
        String tFijo = tfFijo.getText();
        int fijo = Integer.parseInt(tFijo);
        String tMovil = tfMovil.getText();
        int movil = Integer.parseInt(tMovil);
        String email = tfEmail.getText();
        TipoContacto tipoComunicacion = cbTipoContacto.getValue();

        Socio socio = new Socio(numero,tipoSocio,dni,nome,apelidoUn,apelidoDous,fechaNac,lugar,direccion,
                localidad,cp,provincia,fijo,movil,email,tipoComunicacion,iban,ocupacion);

        boolean correcto = socio.guardarSocio();

        System.out.println(correcto);
    }
}
