package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.excepciones.MasDeCincoOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
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
        verificarNumeroDeOpciones(opciones);
    }

    public RespuestaMultiple (LinkedList<Opcion> opciones,Jugador jugador, Multiplicador multiplicador) {
        super(jugador, multiplicador);
        opcionesElegidas = new ColeccionOpciones(opciones);
        verificarNumeroDeOpciones(opciones);
    }

    public RespuestaMultiple (LinkedList<Opcion> opciones, Jugador jugador, Exclusividad exclusividad) {
        super(jugador, exclusividad);
        opcionesElegidas = new ColeccionOpciones(opciones);
        verificarNumeroDeOpciones(opciones);
    }

    public ColeccionOpciones getOpciones() {
        return opcionesElegidas;
    }

    private void verificarNumeroDeOpciones(LinkedList<Opcion> opciones){
        if(opciones == null) {
            throw new NoHayOpcionesException();
        }

        if(opciones.size() > 5) {
            throw new MasDeCincoOpcionesException();
        }
    }
}