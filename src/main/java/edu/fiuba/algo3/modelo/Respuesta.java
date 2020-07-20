package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {
    private final Jugador jugadorActual;
    private final Opcion opcionElegida;

    public Respuesta(Jugador jugador, Opcion opcion) {
        this.jugadorActual = jugador;
        this.opcionElegida = opcion;
        return(Respuesta);
    }

    public Jugador getJugador() { return jugadorActual;}
    public Opcion getElegida() {return opcionElegida;}

    public void otorgarPuntos(int puntosRecibidos){
        jugadorActual.sumarPuntos(puntosRecibidos);
    }

}
