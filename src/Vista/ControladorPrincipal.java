
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main {


    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/Login.fxml"));
        primaryStage.setTitle("aTEA - Iniciar sesión");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


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

}
