package Modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Contacto {

    private int id;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private java.sql.Date fechaNac;
    private String lugarNac;
    private String direccion;
    private String localidad;
    private String provincia;
    private int codigoPos;
    private int fijo;
    private int movil;
    private String email;
    private TipoContacto tipoComunicacion;
    private String parentesco;
    //relaciones
    private Usuario usuario;

    //************************************************************************************//
    //aqui se guarda el Contacto en la base de datos IMPORTANTE QUITAR ID AUTOINCREMENTAL//
    //**********************************************************************************//

    public boolean guardarContacto(){
      ControladorBaseDatos.conectar();
      try {//TODO FALTA EL CONTACTO ID
        PreparedStatement ps = ControladorBaseDatos.getConexion().prepareStatement(
                "INSERT INTO CONTACTOS VALUES((SELECT NVL(MAX(ID),0)+1 FROM CONTACTOS),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,dni);
        ps.setString(2,nombre);
        ps.setString(3,apellido1);
        ps.setString(4,apellido2);
        ps.setDate(5,fechaNac);
        ps.setString(6,lugarNac);
        ps.setString(7,direccion);
        ps.setString(8,localidad);
        ps.setString(9,provincia);
        ps.setInt(10,codigoPos);
        ps.setString(11,parentesco);
        ps.setInt(12,fijo);
        ps.setInt(13,movil);
        ps.setString(14,email);
        ps.setString(15,Utilidades.convertirTipoContacto(tipoComunicacion));
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

    public boolean modificarContacto(){
      ControladorBaseDatos.conectar();
      try{
        PreparedStatement ps = ControladorBaseDatos.getConexion().prepareStatement(
                "UPDATE CONTACTOS SET DNI=? ,NOMBRE=? ,APELLIDO1=? ,APELLIDO2=? ,FECHA_NAC=? ,LUGAR_NAC=? ,DIRECCION=?,"+
                    "LOCALIDAD=? ,PROVINCIA=? ,COD_POSTAL=? ,PARENTESCO=? ,FIJO=? ,MOVIL=? ,EMAIL=? ,TIPO_COMUNICACION=?");
        ps.setString(1,dni);
        ps.setString(2,nombre);
        ps.setString(3,apellido1);
        ps.setString(4,apellido2);
        ps.setDate(5,fechaNac);
        ps.setString(6,lugarNac);
        ps.setString(7,direccion);
        ps.setString(8,localidad);
        ps.setString(9,provincia);
        ps.setInt(10,codigoPos);
        ps.setString(11,parentesco);
        ps.setInt(12,fijo);
        ps.setInt(13,movil);
        ps.setString(14,email);
        ps.setString(15,Utilidades.convertirTipoContacto(tipoComunicacion));
        //ejecutamos la sentencia
        ps.execute();
        //cerramos la conexion
        ControladorBaseDatos.desconectar();
        return true;
      } catch (SQLException e){
        e.printStackTrace();
        return false;
      }
    }

    public boolean borrarContacto(){
      try{
        ControladorBaseDatos.conectar();
        PreparedStatement ps = null;
        ps = ControladorBaseDatos.getConexion().prepareStatement("DELETE FROM CONTACTOS WHERE ID=?");
        ps.setInt(1,id);
        //ejecutamos la sentencia
        ps.execute();
        //cerramos la conexion
        ControladorBaseDatos.desconectar();
        return true;
      } catch (SQLException e){
        e.printStackTrace();
        return false;
      }
    }

  //***************************************//
  //              CONSTRUCTORES           //
  //*************************************//

  //aqui el constructo vacio//
  public Contacto() {
  }

  //aqui el constructor con todos los campos obligatorios//
  public Contacto(int id, String dni, String nombre, String apellido1, String apellido2, Date fechaNac, String lugarNac,
                  String direccion, String localidad, String provincia, int codigoPos, int fijo, int movil, String email,
                  TipoContacto tipoComunicacion, String parentesco, Usuario usuario) {
    this.id = id;
    this.dni = dni;
    this.nombre = nombre;
    this.apellido1 = apellido1;
    this.apellido2 = apellido2;
    this.fechaNac = fechaNac;
    this.lugarNac = lugarNac;
    this.direccion = direccion;
    this.localidad = localidad;
    this.provincia = provincia;
    this.codigoPos = codigoPos;
    this.fijo = fijo;
    this.movil = movil;
    this.email = email;
    this.tipoComunicacion = tipoComunicacion;
    this.parentesco = parentesco;
    this.usuario = usuario;
  }

  //***************************************//
  //        FIN DE CONSTRUCTORES           //
  //***************************************//

  //********************************************************//
  //AQUI LAS PUERTAS DE ENTRADA Y SALIDA CON GETTER Y SETTER//
  //********************************************************//
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public Date getFechaNac() {
    return fechaNac;
  }

  public void setFechaNac(Date fechaNac) {
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

  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
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

  public String getParentesco() {
    return parentesco;
  }

  public void setParentesco(String parentesco) {
    this.parentesco = parentesco;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}

