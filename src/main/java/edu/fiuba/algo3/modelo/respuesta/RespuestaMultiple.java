package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.opcion.Opcion;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class RespuestaMultiple extends Respuesta {

    private HashSet<Opcion> opcionesElegidas;

    public RespuestaMultiple(HashSet<Opcion> opcions, Jugador jugador){
        super(jugador);
        this.opcionesElegidas = opcions;
    }

    public RespuestaMultiple (HashSet<Opcion> opciones,Jugador jugador, Multiplicador multiplicador) {
        super(jugador, multiplicador);
        this.opcionesElegidas = opciones;
    }

    public HashSet<Opcion> getOpciones() {
        return opcionesElegidas;
    }
}