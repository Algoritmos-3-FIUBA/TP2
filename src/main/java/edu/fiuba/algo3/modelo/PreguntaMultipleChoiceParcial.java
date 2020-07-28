package edu.fiuba.algo3.modelo;

import java.util.HashSet;
import java.util.LinkedList;

public class PreguntaMultipleChoiceParcial {

    private String Nombre;
    HashSet<OpcionCorrecta> opcionesCorrectas;
    HashSet<OpcionIncorrecta> opcionesIncorrectas;

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
