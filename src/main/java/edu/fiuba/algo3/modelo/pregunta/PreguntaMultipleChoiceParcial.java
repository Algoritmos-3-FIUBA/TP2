package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;

import java.util.LinkedList;

public class PreguntaMultipleChoiceParcial extends Pregunta{

    private final ColeccionOpciones opcionesCorrectas;
    private final ColeccionOpciones opcionesIncorrectas;

    public PreguntaMultipleChoiceParcial(String nombre, ColeccionOpciones opciones){

        this.nombre = nombre;

        opcionesCorrectas = new ColeccionOpciones();
        opcionesIncorrectas = new ColeccionOpciones();

        opciones.separarEnGruposCorrespondientes(opcionesCorrectas,opcionesIncorrectas);
    }

    public void evaluarRespuestas(LinkedList<Respuesta> listaRespuestas){
        for (Respuesta respuesta : listaRespuestas) {
            RespuestaMultiple cadaRespuesta = (RespuestaMultiple) respuesta;
            if (!cadaRespuesta.getOpciones().tieneElementos(opcionesIncorrectas)){
                for (Opcion opcion: (cadaRespuesta.getOpciones().getOpciones()))
                    cadaRespuesta.otorgarPuntos(opcion.puntosObtenidos());
            }
        }
    }
}
