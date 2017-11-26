package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Trabajador {

    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String fechaNac;
    private String lugarNac;
    private String direccion;
    private String localidad;
    private String provincia;
    private int codigoPos;
    //TODO cambiar todos codigos postales a string porque la bbdd flipa
    private int fijo;
    private int movil;

    //relaciones
    private User user;


    public boolean guardarTrabajador() {
        ControladorBaseDatos.conectar();
        Connection con = ControladorBaseDatos.getConexion();
        try {
            PreparedStatement psu = ControladorBaseDatos.getConexion().prepareStatement(
                    "INSERT INTO USUARIOS_APP VALUES(?,?,ORA_HASH(?))");
            psu.setString(1,user.getEmail());
            psu.setString(2,user.getRol().toString());
            psu.setString(3,user.getPassword());
            psu.execute();

            PreparedStatement ps = ControladorBaseDatos.getConexion().prepareStatement(
                    "INSERT INTO TRABAJADORES VALUES((SELECT NVL(MAX(ID),0)+1 FROM TRABAJADORES),?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, nombre);
            ps.setString(2, apellido1);
            ps.setString(3, apellido2);
            ps.setString(4, dni);
            ps.setString(5, direccion);
            ps.setString(6, localidad);
            ps.setInt(7, codigoPos);
            ps.setString(8, provincia);
            ps.setInt(9, fijo);
            ps.setInt(10, movil);
            ps.setString(11,user.getEmail());
            //TODO fecha y lugar de nacimiento
            //ejecutamos la sentencia
            ps.execute();
            //cerramos la conexion
            ControladorBaseDatos.desconectar();
            return true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();

            return false;
        }

    }

        //***************************************//
    //              CONSTRUCTORES           //
    //*************************************//

    //aqui el constructo vacio//
    public Trabajador() {
    }

    //aqui el constructor con todos los campos obligatorios//
    public Trabajador(String dni, String nombre, String apellido1, String apellido2, String fechaNac, String lugarNac,
                      String direccion, String localidad, int codigoPos, int fijo, int movil, User user) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNac = fechaNac;
        this.lugarNac = lugarNac;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPos = codigoPos;
        this.fijo = fijo;
        this.movil = movil;
        this.user = user;
    }

    //***************************************//
    //        FIN DE CONSTRUCTORES           //
    //***************************************//

    //********************************************************//
    //AQUI LAS PUERTAS DE ENTRADA Y SALIDA CON GETTER Y SETTER//
    //********************************************************//

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getLugarNac() {
        return lugarNac;
    }

    public void setLugarNac(String lugarNac) {
        this.lugarNac = lugarNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCodigoPos() {
        return codigoPos;
    }

    public void setCodigoPos(int codigoPos) {
        this.codigoPos = codigoPos;
    }

    public int getFijo() {
        return fijo;
    }

    public void setFijo(int fijo) {
        this.fijo = fijo;
    }

    public int getMovil() {
        return movil;
    }

    public void setMovil(int movil) {
        this.movil = movil;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
