package edu.fiuba.algo3.modelo;

import java.util.HashSet;
import java.util.Set;

public class RespuestaMultipleChoiceParcial {
    private HashSet<Opcion> opcionesEligidas;
    private Jugador jugador;

    public RespuestaMultipleChoiceParcial (HashSet<Opcion> opcionesEligidas, Jugador jugador) {
        this.opcionesEligidas = opcionesEligidas;
        this.jugador = jugador;
    }

    public void otorgarPuntos(HashSet<OpcionCorrecta> opcionesCorrectas, HashSet<OpcionIncorrecta> opcionesIncorrectas) {

        HashSet<Opcion> interseccion = new HashSet<Opcion>(opcionesEligidas);
        interseccion.retainAll(opcionesIncorrectas);
        if (interseccion.isEmpty()){
            sumarPuntos(opcionesEligidas);
        }
    }

    public void sumarPuntos(HashSet<Opcion> opcionesEligidas){
        for (Opcion opcion: opcionesEligidas) {
            jugador.sumarPuntos(opcion.puntosObtenidos());
        }
    }
}



