package edu.fiuba.algo3.modelo;

public class Respuesta {
    Jugador jugadorActual;
    Opcion opcionElegida;

    public void responderPregunta(Jugador jugador, Opcion opcion){
        this.jugadorActual = jugador;
        this.opcionElegida = opcion;
    }

    public Jugador getJugador() { return jugadorActual;}
    public Opcion getElegida() {return opcionElegida;}

}
