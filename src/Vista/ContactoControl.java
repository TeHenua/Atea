package Vista;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ContactoControl {


    public TextField tfNombre;
    public TextField tfApellido1;
    public TextField tfApellido2;
    public TextField tfDni;
    public TextField tfFechaNac;
    public TextField tfLugarNac;
    public ComboBox cbUsuario;
    public TextField tfRelacion;
    public TextField tfDireccion;
    public TextField tfLocalidad;
    public TextField tfCp;
    public TextField tfProvincia;
    public TextField tfFijo;
    public TextField tfMovil;
    public TextField tfEmail;

    public void gardar(ActionEvent actionEvent) {

        String nome = tfNombre.textProperty().get();//obtengo el valor del textfield al pulsar el boton
        String apelidoUn = tfApellido1.textProperty().get();
        String apelidoDous = tfApellido2.textProperty().get();
        String dni = tfDni.textProperty().get();
        String naceu = tfFechaNac.textProperty().get();
        String lugar = tfLugarNac.textProperty().get();
        //tengo que averiguar como obtener el valor de un combobox y ponerlo aqui para usuario
        String relacion = tfRelacion.textProperty().get();
        String direccion = tfDireccion.textProperty().get();
        String localidad = tfLocalidad.textProperty().get();
        String cp = tfCp.textProperty().get();
        String provincia = tfProvincia.textProperty().get();
        String fijo = tfFijo.textProperty().get();
        String movil = tfMovil.textProperty().get();
        String email = tfEmail.textProperty().get();

    }
}
