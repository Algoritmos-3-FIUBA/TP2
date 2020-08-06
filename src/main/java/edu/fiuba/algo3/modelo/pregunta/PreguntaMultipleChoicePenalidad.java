package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;

import java.util.HashSet;
import java.util.LinkedList;

public class PreguntaMultipleChoicePenalidad extends Pregunta {

    private HashSet<OpcionCorrecta> opcionesCorrectas;
    private HashSet<OpcionIncorrecta> opcionesIncorrectas;

    public PreguntaMultipleChoicePenalidad (String nombre, HashSet<Opcion> opciones) {

        opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesIncorrectas = new HashSet<OpcionIncorrecta>();

        this.nombre = nombre;

        for (Opcion opcion : opciones){
            opcion.agregarseALaListaCorrespondiente(opcionesCorrectas, opcionesIncorrectas);
        }

    }

    public void evaluarRespuestas (LinkedList<Respuesta> listaRespuestas) {
        HashSet<Opcion> opcionesJugador;
        for (Respuesta respuesta : listaRespuestas) {

            opcionesJugador = new HashSet<Opcion>(((RespuestaMultiple) respuesta).getOpciones());

            Puntos puntosParciales = new Puntos(0);
            for (Opcion opcion : opcionesJugador){
                puntosParciales.sumarPuntos(opcion.puntosObtenidos());
            }

            respuesta.otorgarPuntos(puntosParciales);

        }

    };

}
