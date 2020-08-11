package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import java.util.HashSet;
import java.util.LinkedList;

public class PreguntaMultipleChoicePenalidad extends Pregunta {

    private ColeccionOpciones opcionesCorrectas;
    private ColeccionOpciones opcionesIncorrectas;

    public PreguntaMultipleChoicePenalidad (String nombre, ColeccionOpciones opciones) {

        this.nombre = nombre;

        opcionesCorrectas = new ColeccionOpciones();
        opcionesIncorrectas = new ColeccionOpciones();

        opciones.separarEnGruposCorrespondientes(opcionesCorrectas,opcionesIncorrectas);
    }

    public void evaluarRespuestas (LinkedList<Respuesta> listaRespuestas) {
        HashSet<Opcion> opcionesJugador;
        for (Respuesta respuesta : listaRespuestas) {

            opcionesJugador = new HashSet<>(((RespuestaMultiple) respuesta).getOpciones().getOpciones());

            Puntos puntosParciales = new Puntos(0);
            for (Opcion opcion : opcionesJugador){
                puntosParciales.sumarPuntos(opcion.puntosObtenidos());
            }

            respuesta.otorgarPuntos(puntosParciales);

        }

    };

}
