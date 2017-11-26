package Modelo;

import java.util.ArrayList;

public class Grupo {

    private int numero;
    private ArrayList<Usuario> usuarios;

    //***************************************//
    //              CONSTRUCTORES           //
    //*************************************//

    //aqui el constructo vacio//
    public Grupo() {

    }

    //aqui el constructor con todos los campos obligatorios//
    public Grupo(int numero, ArrayList<Usuario> usuarios) {
        this.numero = numero;
        this.usuarios = usuarios;
    }

    //***************************************//
    //        FIN DE CONSTRUCTORES           //
    //***************************************//

    //********************************************************//
    //AQUI LAS PUERTAS DE ENTRADA Y SALIDA CON GETTER Y SETTER//
    //********************************************************//

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
