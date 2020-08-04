package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;

import java.util.HashSet;

public class RespuestaMultipleChoiceParcial implements  Respuesta{
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



