package Vista;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;


public class LoginControl{

    public TextField tfUsuario;
    public TextField tfContrasena;

    public void logear(ActionEvent actionEvent) {

        String nome = tfUsuario.textProperty().get();//obtengo el valor del textfield al pulsar el boton
        String contrasinal = tfContrasena.textProperty().get();

        System.out.println("usuario: "+ nome);
        System.out.println("contraseña: "+ contrasinal);
    }
}
