package Modelo;

public class Tarea {

    private String titulo;

    //relaciones
    private User user;

    //***************************************//
    //              CONSTRUCTORES           //
    //*************************************//

    //aqui el constructo vacio//
    public Tarea() {
    }

    //aqui el constructor con todos los campos obligatorios//
    public Tarea(String titulo, User user) {
        this.titulo = titulo;
        this.user = user;
    }
    //***************************************//
    //        FIN DE CONSTRUCTORES           //
    //***************************************//

    //********************************************************//
    //AQUI LAS PUERTAS DE ENTRADA Y SALIDA CON GETTER Y SETTER//
    //********************************************************//

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
