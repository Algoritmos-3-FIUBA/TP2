package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;

import java.util.LinkedList;

public class PreguntaMultipleChoice extends Pregunta {

    private final Puntos puntosOtorgados;
    private final ColeccionOpciones opcionesCorrectas;
    private final ColeccionOpciones opcionesIncorrectas;

    public PreguntaMultipleChoice(String nombre, int puntos, ColeccionOpciones opciones) {

        this.nombre = nombre;
        puntosOtorgados = new Puntos(puntos);

        opcionesCorrectas = new ColeccionOpciones();
        opcionesIncorrectas = new ColeccionOpciones();

        opciones.separarEnGruposCorrespondientes(opcionesCorrectas,opcionesIncorrectas);
    }

    public void evaluarRespuestas(LinkedList<Respuesta> respuestas) {

        for (Respuesta respuesta : respuestas){
            if(((RespuestaMultiple) respuesta).getOpciones().tieneMismosElementos(opcionesCorrectas))
                respuesta.otorgarPuntos(puntosOtorgados);
        }
    }

    public ColeccionOpciones getOpcionesCorrectas(){
        return opcionesCorrectas;
    }

    public ColeccionOpciones getOpcionesIncorrectas(){
        return opcionesIncorrectas;
    }
}