package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;

import java.util.LinkedList;

public class PreguntaMultipleChoice extends Pregunta {

    private Puntos puntosOtorgados;
    private ColeccionOpciones opcionesCorrectas;
    private ColeccionOpciones opcionesIncorrectas;

    public PreguntaMultipleChoice(String nombre, int puntos, ColeccionOpciones opciones) {

        this.nombre = nombre;
        puntosOtorgados = new Puntos(puntos);

        opcionesCorrectas = new ColeccionOpciones();
        opcionesIncorrectas = new ColeccionOpciones();

        opciones.separarEnGruposCorrespondientes(opcionesCorrectas,opcionesIncorrectas);
    }

    public void evaluarRespuestas(LinkedList<Respuesta> respuestas) {
        corregirRespuestas(respuestas);

        Amplificador amplificadorFinal = new Amplificador(1);

        for (Respuesta respuesta : respuestas) {
            respuesta.actualizarEstadoAmplificador(amplificadorFinal);
            respuesta.calcularAmplificacionExclusividad(amplificadorFinal,respuestas);
        }

        for (Respuesta respuesta : respuestas) {
            respuesta.otorgarPuntos(puntosOtorgados);
        }
    }

    private void corregirRespuestas(LinkedList<Respuesta> respuestas){
        for (Respuesta respuesta : respuestas)
            if(((RespuestaMultiple) respuesta).getOpciones().tieneMismosElementos(opcionesCorrectas))
                respuesta.setCorrecta();
    }

    public ColeccionOpciones getOpcionesCorrectas(){
        return opcionesCorrectas;
    }

    public ColeccionOpciones getOpcionesIncorrectas(){
        return opcionesIncorrectas;
    }
}