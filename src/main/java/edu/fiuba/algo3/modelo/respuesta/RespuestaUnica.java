package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Exclusividad;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.opcion.Opcion;

import java.util.LinkedList;

public class RespuestaUnica extends Respuesta {

    private Opcion opcion;

    public RespuestaUnica(Opcion opcion,Jugador jugador) {
        super(jugador);
        this.opcion = opcion;
    }

    public RespuestaUnica(Opcion opcion,Jugador jugador, Multiplicador multiplicador) {
        super(jugador, multiplicador);
        this.opcion = opcion;
    }

    public RespuestaUnica (Opcion opcion, Jugador jugador, Exclusividad exclusividad) {
        super(jugador, exclusividad);
        this.opcion = opcion;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void corregir() {
        this.estado = opcion.asignarEstado();
    }
}
