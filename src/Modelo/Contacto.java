package Modelo;

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

    public boolean guardarContacto(){//aqui se guarda el Contacto en la base de datos
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
        ps.setString(15,convertirTipoContacto(tipoComunicacion));
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
        ps.setString(15,convertirTipoContacto(tipoComunicacion));
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
}

