package edu.fiuba.algo3.modelo;

import java.util.HashSet;
import java.util.LinkedList;

public class PreguntaMultipleChoice {

    private String Nombre;
    private int PuntosOtorgados;
    HashSet<OpcionCorrecta> opcionesCorrectas;
    HashSet<OpcionIncorrecta> opcionesIncorrectas;

    public PreguntaMultipleChoice(String nombre, int puntos, HashSet<Opcion> opciones) {

        Nombre = nombre;
        PuntosOtorgados = puntos;

        opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesIncorrectas = new HashSet<OpcionIncorrecta>();

        for (Opcion opcion : opciones)
            opcion.agregarseALaListaCorrespondiente(opcionesCorrectas, opcionesIncorrectas);
    }

    public HashSet<OpcionCorrecta> getOpcionesCorrectas(){
        return opcionesCorrectas;
    }

    public HashSet<OpcionIncorrecta> getOpcionesIncorrectas(){
        return opcionesIncorrectas;
    }

    public void evaluarRespuestas(LinkedList<RespuestaMultipleChoice> respuestas) {

        for (RespuestaMultipleChoice respuesta : respuestas)
            respuesta.otorgarPuntos(opcionesCorrectas, PuntosOtorgados);
    }
}