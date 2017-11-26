package Modelo;

public class Llamada {

    private String motivo;
    private String nombre;
    private int telefono;
    private String otros;

    //relaciones
    private User user;

    //***************************************//
    //              CONSTRUCTORES           //
    //*************************************//

    //aqui el constructo vacio//
    public Llamada() {
    }

    public Llamada(String motivo, String nombre, int telefono, String otros, User user) {
        this.motivo = motivo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.otros = otros;
        this.user = user;
    }

    //***************************************//
    //        FIN DE CONSTRUCTORES           //
    //***************************************//

    //********************************************************//
    //AQUI LAS PUERTAS DE ENTRADA Y SALIDA CON GETTER Y SETTER//
    //********************************************************//
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
