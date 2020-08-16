package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import java.util.LinkedList;

public class RespuestaMultiple extends Respuesta {

    private ColeccionOpciones opcionesElegidas;

    public RespuestaMultiple(LinkedList<Opcion> opciones, Jugador jugador){
        super(jugador);
        opcionesElegidas = new ColeccionOpciones(opciones);
    }

    public RespuestaMultiple (LinkedList<Opcion> opciones,Jugador jugador, Multiplicador multiplicador) {
        super(jugador, multiplicador);
        opcionesElegidas = new ColeccionOpciones(opciones);
    }

    public RespuestaMultiple (LinkedList<Opcion> opciones, Jugador jugador, Exclusividad exclusividad) {
        super(jugador, exclusividad);
        opcionesElegidas = new ColeccionOpciones(opciones);
    }

    public ColeccionOpciones getOpciones() {
        return opcionesElegidas;
    }

}