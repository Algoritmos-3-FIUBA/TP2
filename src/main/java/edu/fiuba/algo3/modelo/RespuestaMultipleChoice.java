package edu.fiuba.algo3.modelo;

import java.util.HashSet;

public class RespuestaMultipleChoice implements  Respuesta {
    private HashSet<Opcion> opcionesEligidas;
    private Jugador jugador;

    public RespuestaMultipleChoice (HashSet<Opcion> opcionesEligidas, Jugador jugador) {
        this.opcionesEligidas = opcionesEligidas;
        this.jugador = jugador;
    }

    public void otorgarPuntos(HashSet<OpcionCorrecta> opcionesCorrectas, int cantidadDePuntos) {
        if (opcionesEligidas.equals(opcionesCorrectas)){
            jugador.sumarPuntos(cantidadDePuntos);
        }
    }
}