package Vista;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeControl implements Initializable{

    public AnchorPane miscojones;
    private ControladorPrincipal controladorPrincipal;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setControladorPrincipal(ControladorPrincipal controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
    }

    public void ventanaNuevoUsu(ActionEvent actionEvent) {

    }

    public void ventanaNuevoSoc(ActionEvent actionEvent) {
    }

    public void ventanaNuevoCon(ActionEvent actionEvent) {
    }
}
