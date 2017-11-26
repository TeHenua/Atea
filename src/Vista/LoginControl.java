package Vista;

import Modelo.Correo;
import Modelo.Rol;
import Modelo.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.apache.commons.mail.EmailException;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class LoginControl implements Initializable{
    private ControladorPrincipal controladorPrincipal;
    public TextField tfUsuario;
    public PasswordField tfContrasena;


    public void logear(ActionEvent actionEvent) {

        String nome = tfUsuario.textProperty().get();//obtengo el valor del textfield al pulsar el boton
        String contrasinal = tfContrasena.textProperty().get();

        Rol rol = new User(nome,contrasinal).login();
        System.out.println("Estas LOegao");
        switch (rol){
            case ADMINISTRADOR:

                break;
            case PSICOLOGO:

                break;
            case ADMINISTRATIVO:

                break;
            case TRABAJADOR_SOCIAL:

                break;
        }

    }

    public void recuperar(ActionEvent actionEvent) {
        boolean correcto=false;
        User u = new User();
        correcto =  u.recuperarPassw(tfUsuario.getText());
        Correo c = null;
        try {
            ArrayList<String> a =  new ArrayList<>(){{add(u.getEmail());}};
            c = new Correo("Recuperación de contraseña",("Tu código de verificación es: "+u.getCodigo()),a);
        } catch (EmailException e) {
            correcto = false;
            e.printStackTrace();
        }
        if (correcto){
            correcto = c.enviarCorreo();
        }
        //TODO alert error

        //TODO SANTI llamar a otra ventana
        controladorPrincipal.mostrarVentanaContraseña(u);
        System.out.println(correcto+" \n"+u.getCodigo());
    }

    public void mostrarVentanaRecuperar(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void setProgramaPrincipal(ControladorPrincipal programaPrincipal) {
        this.controladorPrincipal = programaPrincipal;
    }
}

