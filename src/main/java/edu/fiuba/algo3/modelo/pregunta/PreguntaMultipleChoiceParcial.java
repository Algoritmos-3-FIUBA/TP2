package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultipleChoiceParcial;

import java.util.HashSet;
import java.util.LinkedList;

public class PreguntaMultipleChoiceParcial {

    private String Nombre;
    private HashSet<OpcionCorrecta> opcionesCorrectas;
    private HashSet<OpcionIncorrecta> opcionesIncorrectas;

    public PreguntaMultipleChoiceParcial(String nombre, HashSet<Opcion> opciones){

        Nombre = nombre;

        opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesIncorrectas = new HashSet<OpcionIncorrecta>();

        for (Opcion opcion : opciones) {
            opcion.agregarseALaListaCorrespondiente(opcionesCorrectas,opcionesIncorrectas);
        }

    }

    public void evaluarRespuestas(LinkedList <RespuestaMultipleChoiceParcial> respuestas){

        for (RespuestaMultipleChoiceParcial respuesta : respuestas)
            respuesta.otorgarPuntos(opcionesCorrectas, opcionesIncorrectas);
    }
}
