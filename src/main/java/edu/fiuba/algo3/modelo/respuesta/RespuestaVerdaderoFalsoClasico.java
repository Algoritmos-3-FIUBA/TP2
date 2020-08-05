package edu.fiuba.algo3.modelo.respuesta;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;

public class RespuestaVerdaderoFalsoClasico{

    private Opcion opcion;
    private Jugador jugador;

    public RespuestaVerdaderoFalsoClasico(Opcion opcion, Jugador jugador) {
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