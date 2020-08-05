package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.opcion.Opcion;

public class RespuestaUnica extends Respuesta {

    private Opcion opcion;

    public RespuestaUnica(Opcion opcion,Jugador jugador) {
        super(jugador);
        this.opcion = opcion;
    }

    public RespuestaUnica(Jugador jugador, Multiplicador multiplicador) {
        super(jugador, multiplicador);
    }

    public Opcion getOpcion() {
        return opcion;
    }

}
