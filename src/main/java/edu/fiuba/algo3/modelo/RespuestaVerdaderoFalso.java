package edu.fiuba.algo3.modelo;


public class RespuestaVerdaderoFalso implements Respuesta{

    private Opcion opcion;
    private Jugador jugador;

    public RespuestaVerdaderoFalso (Opcion opcion, Jugador jugador) {
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