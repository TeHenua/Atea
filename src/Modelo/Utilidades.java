package Modelo;

public class Utilidades {

  public static String convertirTipoContacto(TipoContacto tipoContacto){
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
