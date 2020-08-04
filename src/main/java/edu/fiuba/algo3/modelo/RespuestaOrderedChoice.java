package edu.fiuba.algo3.modelo;

import java.util.LinkedList;

public class RespuestaOrderedChoice {
    private LinkedList<Opcion> opcionesEligidas;
    private Jugador jugador;


    public RespuestaOrderedChoice (LinkedList<Opcion> opcionesEligidas, Jugador jugador) {
        this.opcionesEligidas = opcionesEligidas;
        this.jugador = jugador;
    }

    public void otorgarPuntos(LinkedList<OpcionCorrecta> opcionesCorrectas, int cantidadDePuntos) {
        if (opcionesEligidas.equals(opcionesCorrectas)){
            jugador.sumarPuntos(cantidadDePuntos);
        }
    }
}
