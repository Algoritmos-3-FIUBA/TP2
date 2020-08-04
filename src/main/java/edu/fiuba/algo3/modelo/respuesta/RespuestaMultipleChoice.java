package edu.fiuba.algo3.modelo.respuesta;

import java.util.HashSet;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.opcion.*;

public class RespuestaMultipleChoice implements  Respuesta {
    private HashSet<Opcion> opcionesEligidas;
    private Jugador jugador;

    public RespuestaMultipleChoice (HashSet<Opcion> opcionesEligidas, Jugador jugador) {
        this.opcionesEligidas = opcionesEligidas;
        this.jugador = jugador;
    }

    public void otorgarPuntos(HashSet<OpcionCorrecta> opcionesCorrectas, Puntos cantidadDePuntos) {
        if (opcionesEligidas.equals(opcionesCorrectas)){
            jugador.sumarPuntos(cantidadDePuntos);
        }
    }
}