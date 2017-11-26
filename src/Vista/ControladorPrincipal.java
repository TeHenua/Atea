package Vista;

import Modelo.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ControladorPrincipal extends Application{

    private Stage stagePrincipal;
    private AnchorPane panelPrincipal;

    public void start(Stage primaryStage) throws Exception{
        this.stagePrincipal = primaryStage;
        mostrarVentanaLogin();


        /*User u = new User("tehenua@gmail.com","pusverlus", Rol.ADMINISTRADOR);
        TODO combobox roles en ventana trabajador
        Trabajador t = new Trabajador();
        t.setNombre("Usue");
        t.setApellido1("Urruela");
        t.setApellido2("Del Piño"); t.setApellido2(tfApe2.getText());
        t.setDni("72747890V");
        t.setDireccion("Calle Santo Domingo 13, 1º izq");
        t.setLocalidad("Vitoria");
        t.setProvincia("Álava");
        t.setCodigoPos(01001);
        t.setFijo(949459459);
        t.setMovil(692353948);
        u.setTrabajador(t);
        boolean correcto = t.guardarTrabajador();
        System.out.println(correcto);*/


    }
    public void mostrarVentanaContraseña(User user){
        FXMLLoader loader = new FXMLLoader(ControladorPrincipal.class.getResource("RecuperarPassw.fxml"));
        try {
          panelPrincipal = (AnchorPane) loader.load();
            stagePrincipal.setTitle("Recuperar contraseña");
//            stagePrincipal.initOwner(stagePrincipal);
            Scene scene = new Scene(panelPrincipal);
            stagePrincipal.setScene(scene);
            RecuperarPasswControlador control = loader.getController();
            control.setProgramaPrincipal(this);
            control.setTfEmail(user.getEmail());
            control.setUser(user);
            stagePrincipal.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void mostrarVentanaLogin() {
        FXMLLoader loader = new FXMLLoader(ControladorPrincipal.class.getResource("Login.fxml"));
        try {
            panelPrincipal = (AnchorPane)loader.load();
            Scene scene = new Scene(panelPrincipal);
            stagePrincipal.setTitle("Login");
            stagePrincipal.setScene(scene);
            LoginControl control = loader.getController();
            control.setProgramaPrincipal(this);
            stagePrincipal.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main (String[] args){
        launch(args);
    }
}
