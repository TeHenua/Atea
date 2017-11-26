package Vista;

import Modelo.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RecuperarPasswControlador implements Initializable {

    public TextField tfCofigo;
    public TextField tfEmail;
    public PasswordField tfPassword;
    public Button bEnviar;
    private ControladorPrincipal controladorPrincipal;
    public User user;

    public void guardar(){
        User user = new User(tfEmail.getText(),tfPassword.getText());
        user.setCodigo(Integer.parseInt(tfCofigo.getText()));
    }
    public void setProgramaPrincipal(ControladorPrincipal programaPrincipal) {
        this.controladorPrincipal = programaPrincipal;
    }

    public void setUser(User user) {
       this.user = user;
    }

    public void setTfEmail(String email) {
        this.tfEmail.setText(email);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //tfEmail.setText(user.getEmail());
    }

    public void cambiar(ActionEvent actionEvent) {
        if(Integer.parseInt(tfCofigo.getText())== user.getCodigo()){
            user.setPassword(tfPassword.getText());
            boolean correcto = user.cambiarContraseña();
            System.out.println(correcto);
            controladorPrincipal.mostrarVentanaLogin();
        }

    }
}
