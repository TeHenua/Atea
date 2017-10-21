package Modelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario {

    private String nombre;
    private String dni;
    private String apellido1;
    private String apellido2;
    private Integer numSocio;
    private java.sql.Date fechaNac;
    private String direccion;
    private String localidad;
    private int codigoPos;
    private String provincia;
    private String colegio;
    private String ocupacion;
    private String diagnostico;
    private String gradoDiscapacidad;
    private String gradoDependencia;
    private String puntosMovilidad;
    private String demanda;
    private String numSs;
    private String tis;
    private String primeraEntrevista;
    private String alertaCustodia;
    private String alertaMedica;
    private String estado;
    //relaciones
    private ArrayList<Socio> socios;
    private Grupo grupo;
    private ArrayList<Consulta> consultas;
    private ArrayList<Contacto> contactos;

    public boolean guardarUsuario(){//aqui se guarda el usuario en la base de datos IMPORTANTE QUITAR ID AUTOINCREMENTAL

        ControladorBaseDatos.conectar();

        try {//FALTA EL SOCIO ID
            PreparedStatement ps = ControladorBaseDatos.getConexion().prepareStatement("INSERT INTO USUARIOS(" +
                    "ID,NOMBRE,APELLIDO1,APELLIDO2,NUM_SOCIO,FECHA_NAC,LUGAR_NAC,DIRECCION,LOCALIDAD,PROVINCIA,CODIGO_POS," +
                    "COLEGIO,OCUPACION,DIAGNOSTICO)" +
                    " VALUES((SELECT NVL(MAX(ID),0)+1 FROM USUARIOS),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
            ps.setString(1,nombre);
            ps.setString(2,apellido1);
            ps.setString(3,apellido2);
            ps.setInt(4,numSocio);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
