package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {

    private Opcion opcion;
    private Jugador jugador;

    public Respuesta (Opcion opcion, Jugador jugador) {
        this.opcion = opcion;
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void otorgarPuntos() {
        jugador.sumarPuntos(opcion.puntosObtenidos());
    }
}
