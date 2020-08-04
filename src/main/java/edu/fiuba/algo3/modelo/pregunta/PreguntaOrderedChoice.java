package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaOrderedChoice;

import java.util.LinkedList;

public class PreguntaOrderedChoice {
    private String Nombre;
    private Puntos PuntosOtorgados;
    LinkedList<OpcionCorrecta> opcionesCorrectas;
    LinkedList<OpcionIncorrecta> opcionesIncorrectas;

    public PreguntaOrderedChoice(String nombre, int puntos, LinkedList<Opcion> opciones) {

        Nombre = nombre;
        PuntosOtorgados = new Puntos(puntos);

        opcionesCorrectas = new LinkedList<OpcionCorrecta>();
        opcionesIncorrectas = new LinkedList<OpcionIncorrecta>();

        for (Opcion opcion : opciones)
            opcion.agregarseALaListaCorrespondienteOrdenada(opcionesCorrectas, opcionesIncorrectas);
    }

    public void evaluarRespuestas(LinkedList<RespuestaOrderedChoice> respuestas) {

        for (RespuestaOrderedChoice respuesta : respuestas)
            respuesta.otorgarPuntos(opcionesCorrectas, PuntosOtorgados);
    }

    public LinkedList<OpcionCorrecta> getOpcionesCorrectas(){
        return opcionesCorrectas;
    }

    public LinkedList<OpcionIncorrecta> getOpcionesIncorrectas(){
        return opcionesIncorrectas;
    }
}
