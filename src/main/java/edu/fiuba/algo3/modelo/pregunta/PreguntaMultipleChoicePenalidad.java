package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import java.util.LinkedList;

public class PreguntaMultipleChoicePenalidad extends Pregunta {

    private final ColeccionOpciones opcionesCorrectas;
    private final ColeccionOpciones opcionesIncorrectas;

    public PreguntaMultipleChoicePenalidad(String nombre, ColeccionOpciones opciones) {

        this.nombre = nombre;

        opcionesCorrectas = new ColeccionOpciones();
        opcionesIncorrectas = new ColeccionOpciones();

        opciones.separarEnGruposCorrespondientes(opcionesCorrectas, opcionesIncorrectas);
    }

    public void evaluarRespuestas(LinkedList<Respuesta> respuestas) {
/*        for (Respuesta respuesta : respuestas) {
            Puntos puntosParciales = new Puntos(0);
            for (Opcion opcion : ((RespuestaMultiple) respuesta).getOpciones().getOpciones())
                puntosParciales.sumarPuntos(opcion.puntosObtenidos());
            respuesta.otorgarPuntos(puntosParciales);
        }*/

        corregirRespuestas(respuestas);

        for (Respuesta respuesta : respuestas) {
            Puntos puntosParciales = new Puntos(0);
            for (Opcion opcion : ((RespuestaMultiple) respuesta).getOpciones().getOpciones())
                puntosParciales.sumarPuntos(opcion.puntosObtenidos());
            respuesta.otorgarPuntos(puntosParciales);        }
    }

    private void corregirRespuestas(LinkedList<Respuesta> respuestas){
        for (Respuesta respuesta : respuestas) {
            if (((RespuestaMultiple)respuesta).getOpciones().tieneElementos(opcionesCorrectas))
                respuesta.setCorrecta();
        }
    }

    public String getNombrePregunta() { return nombre;
    }

}