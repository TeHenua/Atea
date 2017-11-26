package Modelo;

public class Trabajador {

    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String fechaNac;
    private String lugarNac;
    private String direccion;
    private String localidad;
    private int codigoPos;
    private int fijo;
    private int movil;
    private String email;

    //relaciones
    private User user;

    //***************************************//
    //              CONSTRUCTORES           //
    //*************************************//

    //aqui el constructo vacio//
    public Trabajador() {
    }

    //aqui el constructor con todos los campos obligatorios//
    public Trabajador(String dni, String nombre, String apellido1, String apellido2, String fechaNac, String lugarNac,
                      String direccion, String localidad, int codigoPos, int fijo, int movil, String email, User user) {
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
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
