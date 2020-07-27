package edu.fiuba.algo3.modelo;

import java.util.Set;

public class RespuestaMultipleChoice {
    private Set<Opcion> opcionesEligidas;
    private Jugador jugador;

    public RespuestaMultipleChoice (Set<Opcion> opcionesEligidas, Jugador jugador) {
        this.opcionesEligidas = opcionesEligidas;
        this.jugador = jugador;
    }

    public void otorgarPuntos(Set<Opcion> opcionesCorrectas, int cantidadDePuntos) {
        if (opcionesEligidas.equals(opcionesCorrectas)){
            jugador.sumarPuntos(cantidadDePuntos);
        }
    }
}