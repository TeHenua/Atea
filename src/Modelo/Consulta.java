package Modelo;

public class Consulta {

    private String titulo;
    private String texto;

    //relaciones
    private Usuario usuario;
    private User user;

    //Constructor vacio
    public Consulta() {
    }

    //Constructor con todos los campos obligatorios
    public Consulta(String titulo, String texto, Usuario usuario, User user) {
        this.titulo = titulo;
        this.texto = texto;
        this.usuario = usuario;
        this.user = user;
    }


  //AQUI LAS PUERTAS DE ENTRADA Y SALIDA CON GETTER Y SETTER//

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}