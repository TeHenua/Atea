package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Socio {
    private int id;
    private int numSocio;
    private String tipoSocio;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private java.sql.Date fechaNac;
    private String lugarNac;
    private String direccion;
    private String localidad;
    private int codigoPos;
    private String provincia;
    private int fjio;
    private int movil;
    private String email;
    private TipoContacto tipoComunicacion;
    private String numCuenta;
    private String ocupacion;
    private String estado;

    //relaciones
    private ArrayList<Usuario> usuarios;

    public boolean guardarSocio(){//aqui se guarda el socio en la base de datos IMPORTANTE QUITAR ID AUTOINCREMENTAL
        ControladorBaseDatos.conectar();
        try {
            PreparedStatement ps = ControladorBaseDatos.getConexion().prepareStatement(
                    "INSERT INTO SOCIOS VALUES((SELECT NVL(MAX(ID),0)+1 FROM SOCIOS),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,nombre);
            ps.setString(2,apellido1);
            ps.setString(3,apellido2);
            ps.setInt(4,numSocio);
            ps.setString(5,dni);
            ps.setDate(6,fechaNac);
            ps.setString(7,lugarNac);
            ps.setString(8,direccion);
            ps.setString(9,localidad);
            ps.setString(10,provincia);
            ps.setInt(11,codigoPos);
            ps.setInt(12,fjio);
            ps.setInt(13,movil);
            ps.setString(14,email);
            ps.setString(15,convertirTipoContacto(tipoComunicacion));
            ps.setString(16,ocupacion);
            ps.setString(17,tipoSocio);
            ps.setString(18,numCuenta);
            //ejecutamos la sentencia
            ps.execute();
            //cerramos la conexion
            ControladorBaseDatos.desconectar();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean modificarSocio(){
        ControladorBaseDatos.conectar();
        try {
            PreparedStatement ps = ControladorBaseDatos.getConexion().prepareStatement(
                    "UPDATE SOCIOS SET NOMBRE=?,APELLIDO1=?,APELLIDO2=?,NUM_SOCIO=?,DNI=?,FECHA_NAC=?,LUGAR_NAC=?," +
                        "DIRECCION=?,LOCALIDAD=?,PROVINCIA=?,COD_POSTAL=?,FIJO=?,MOVIL=?,EMAIL=?,TIPO_COMUNICACION=?," +
                        "OCUPACION=?,TIPO_SOCIO=?,NUM_CUENTA=? WHERE ID=?");
            ps.setString(1,nombre);
            ps.setString(2,apellido1);
            ps.setString(3,apellido2);
            ps.setInt(4,numSocio);
            ps.setString(5,dni);
            ps.setDate(6,fechaNac);
            ps.setString(7,lugarNac);
            ps.setString(8,direccion);
            ps.setString(9,localidad);
            ps.setString(10,provincia);
            ps.setInt(11,codigoPos);
            ps.setInt(12,fjio);
            ps.setInt(13,movil);
            ps.setString(14,email);
            ps.setString(15,convertirTipoContacto(tipoComunicacion));
            ps.setString(16,ocupacion);
            ps.setString(17,tipoSocio);
            ps.setString(18,numCuenta);
            //ejecutamos la sentencia
            ps.executeUpdate();
            //cerramos la conexion
            ControladorBaseDatos.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean borrarSocio(){
        try {
            ControladorBaseDatos.conectar();
            PreparedStatement ps = null;
            ps = ControladorBaseDatos.getConexion().prepareStatement("DELETE FROM SOCIOS WHERE ID=?");
            //ejecutamos la sentencia
            ps.execute();
            //cerramos la conexion
            ControladorBaseDatos.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    //TODO listar Usuarios desde la bbdd o añadirlos a la clase??

    public void añadirUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    //TODO PASAR ESTA FUNCION A CLASS UTILIDADES
    private String convertirTipoContacto(TipoContacto tipoContacto){
        switch (tipoContacto){
            case Carta:
                return "Carta";
            case Email:
                return "Email";
            case Carta_sin_remite:
                return "Carta sin remite";
            default:
                return "Error";
        }
    }

    public static ArrayList<Socio> todosLosSocios(){
        ArrayList<Socio> socios = new ArrayList<>();
        try {
            ControladorBaseDatos.conectar();
            PreparedStatement ps = ControladorBaseDatos.getConexion().prepareStatement("SELECT ID,NOMBRE,APELLIDO1," +
                    "APELLIDO FROM SOCIOS");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Socio socio = new Socio(rs.getInt("ID"),rs.getString("NOMBRE"),
                        rs.getString("APELLIDO1"),rs.getString("APELLIDO2"));
                socios.add(socio);
            }
            ControladorBaseDatos.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return socios;
    }

    public Socio(int id, String nombre, String apellido1, String apellido2) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public Socio(int id) {
        this.id = id;
    }

    public Socio(int numSocio, String tipoSocio, String dni, String nombre, String apellido1, String apellido2,
                 java.sql.Date fechaNac, String lugarNac, String direccion, String localidad, int codigoPos, String provincia,
                 int fjio, int movil, String email, TipoContacto tipoComunicacion, String numCuenta, String ocupacion){

        this.numSocio = numSocio;
        this.tipoSocio = tipoSocio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNac = fechaNac;
        this.lugarNac = lugarNac;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPos = codigoPos;
        this.provincia = provincia;
        this.fjio = fjio;
        this.movil = movil;
        this.email = email;
        this.tipoComunicacion = tipoComunicacion;
        this.numCuenta = numCuenta;
        this.ocupacion = ocupacion;
    }

    public int getNumSocio() {
        return numSocio;
    }

    public void setNumSocio(int numSocio) {
        this.numSocio = numSocio;
    }

    public String getTipoSocio() {
        return tipoSocio;
    }

    public void setTipoSocio(String tipoSocio) {
        this.tipoSocio = tipoSocio;
    }

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

    public java.sql.Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(java.sql.Date fechaNac) {
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getFjio() {
        return fjio;
    }

    public void setFjio(int fjio) {
        this.fjio = fjio;
    }

    public int getMovil() {
        return movil;
    }

    public void setMovil(int movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoContacto getTipoComunicacion() {
        return tipoComunicacion;
    }

    public void setTipoComunicacion(TipoContacto tipoComunicacion) {
        this.tipoComunicacion = tipoComunicacion;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
