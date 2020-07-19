package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {

    String nombre;
    int puntos;
    //ArrayList<Respuesta> listaRespuestas;

    public Jugador(String unNombre) {
        nombre = unNombre;
        puntos = 0;
    }

//    public void responder(Pregunta pregunta,Opcion opcion){

//    }

    public void sumarPuntos(int puntosRecibidos){
        this.puntos += puntosRecibidos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }
}
