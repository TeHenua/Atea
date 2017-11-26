package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class User {

    private String email;
    private String password;
    private Rol rol;
    private int codigo;

    private Trabajador trabajador;
    private ArrayList<Consulta> consultas = new ArrayList<>();
    private ArrayList<Llamada> llamadas = new ArrayList<>();
    private ArrayList<Tarea> tareas = new ArrayList<>();

    public Rol login(){
        ControladorBaseDatos.conectar();
        Rol rol = null;
        try {
            PreparedStatement ps = ControladorBaseDatos.getConexion().prepareStatement(
                    "SELECT ROL FROM USUARIOS_APP WHERE EMAIL=? AND PASSWORD=ORA_HASH(?)");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                rol = Rol.valueOf(rs.getString("ROL"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            rol = null;
        }
        return rol;
    }

    public boolean recuperarPassw(String emailEscrito){
        ControladorBaseDatos.conectar();
        try {
            PreparedStatement ps = ControladorBaseDatos.getConexion().prepareStatement("SELECT EMAIL FROM USUARIOS_APP WHERE EMAIL=?");
            ps.setString(1,emailEscrito);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                email = rs.getString("email");
            }
            codigo = ThreadLocalRandom.current().nextInt(10000000, 99999999);
            ControladorBaseDatos.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, Rol rol) {
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public void añadirConsulta(Consulta consulta){
        consultas.add(consulta);
    }

    public void añadirLlamada(Llamada llamada){
        llamadas.add(llamada);
    }

    public void añadirTarea(Tarea tarea){
        tareas.add(tarea);
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public ArrayList<Llamada> getLlamadas() {
        return llamadas;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
        trabajador.setUser(this);
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean cambiarContraseña() {
        ControladorBaseDatos.conectar();

        try {
            PreparedStatement ps = ControladorBaseDatos.getConexion().prepareStatement("UPDATE USUARIOS_APP SET " +
                    "PASSWORD = ora_hash(?) WHERE EMAIL = ?");
            ps.setString(1,password);
            ps.setString(2, email);
            ps.executeUpdate();

            ControladorBaseDatos.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
