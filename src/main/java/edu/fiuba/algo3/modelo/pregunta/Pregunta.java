package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.LinkedList;

public abstract class Pregunta {

    protected String nombre;

    public abstract void evaluarRespuestas(LinkedList<Respuesta> listaRespuestas);
}