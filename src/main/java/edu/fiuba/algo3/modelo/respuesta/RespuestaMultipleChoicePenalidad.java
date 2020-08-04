package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;

import java.util.HashSet;

public class RespuestaMultipleChoicePenalidad implements Respuesta {

    private HashSet<Opcion> opcionesEligidas;
    private Multiplicador multiplicador;
    private Jugador jugador;

    public RespuestaMultipleChoicePenalidad (HashSet<Opcion> opcionesEligidas, Multiplicador multiplicador) {
        this.opcionesEligidas = opcionesEligidas;
        this.multiplicador = multiplicador;
    }

    public RespuestaMultipleChoicePenalidad (HashSet<Opcion> opcionesEligidas, Jugador jugador) {
        this.opcionesEligidas = opcionesEligidas;
        this.jugador = jugador;
    }

    /*public void otorgarPuntos(HashSet<OpcionCorrecta> opcionesCorrectas, HashSet<OpcionIncorrecta> opcionesIncorrectas) {

    }*/
}
