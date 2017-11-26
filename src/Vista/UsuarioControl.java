package Vista;

import Modelo.Socio;
import Modelo.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
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
    public TextField tfDiagnostico;
    public TextField tfGradoDis;
    public TextField tfGradoDep;
    public TextField tfPuntosMovilidad;
    public TextField tfDemanda;
    public CheckBox ckMedica;
    public CheckBox ckCustodia;
    public Button btGuardar;
    public Button btLimpiar;

    ObservableList<String> lista;
    ArrayList<Socio> socios = Socio.todosLosSocios();

    @Override
    public void initialize(URL location, ResourceBundle resources) {//cargo los valores en el combobox

        ArrayList<String> sociosNombres = new ArrayList<>();

        for (Socio socio: socios) {
            sociosNombres.add(socio.getNombre() + " " + socio.getApellido1() + " " + socio.getApellido2());
        }

        lista  = FXCollections.observableArrayList(sociosNombres);
        cbSocio.setItems(lista);
    }

    //

    public void ventanaNueva() throws IOException {

    }

    public void guardar(ActionEvent actionEvent) {

        String nome = tfNombre.getText();//obtengo el valor del textfield al pulsar el boton
        String apelidoUn = tfApellido1.getText();
        String apelidoDous = tfApellido2.getText();
        String dni = tfDni.getText();
        int numSocio = Integer.parseInt(tfSocio.getText());
        String tipoSocio = cbSocio.getValue();
        LocalDate naceu = dpFechaNac.getValue();
        java.sql.Date fechaNac = Date.valueOf(naceu);
        String lugar = tfLugarNac.getText();
        String direccion = tfDireccion.getText();
        String localidad = tfLocalidad.getText();
        int cp = Integer.parseInt(tfCp.getText());
        String provincia = tfProvincia.getText();
        String colegio = tfColegio.getText();
        String ocupacion = tfOcupacion.getText();
        String diagnostico = tfDiagnostico.getText();
        int idSocio = cbSocio.getSelectionModel().getSelectedIndex();
        String gradoDiscapacidad  = tfGradoDis.getText();
        String gradoDependencia = tfGradoDep.getText();
        String puntosMovilidad = tfPuntosMovilidad.getText();
        String demanda = tfDemanda.getText();
        LocalDate primeraEntrevista = tfEntrevista.getValue();
        java.sql.Date primeraEntrev = Date.valueOf(primeraEntrevista);
        boolean alertaCustodia = ckCustodia.isSelected();
        boolean alertaMedica = ckMedica.isSelected();
        String segSocial = tfSegSocial.getText();
        int tis = Integer.parseInt(tfTis.getText());

        Usuario usuario = new Usuario(nome,dni,apelidoUn,apelidoDous,numSocio,fechaNac,lugar,direccion,localidad,cp
                ,provincia,colegio,ocupacion,diagnostico, gradoDiscapacidad, gradoDependencia,puntosMovilidad, demanda,
                segSocial,tis,primeraEntrev,alertaCustodia,alertaMedica);

        boolean correcto = usuario.guardarUsuario(idSocio);
        //TODO alert correcto

    }
}
