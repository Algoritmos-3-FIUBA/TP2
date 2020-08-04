package edu.fiuba.algo3.modelo;

import java.util.LinkedList;

public class PreguntaOrderedChoice {
    private String Nombre;
    private int PuntosOtorgados;
    LinkedList<OpcionCorrecta> opcionesCorrectas;
    LinkedList<OpcionIncorrecta> opcionesIncorrectas;

    public PreguntaOrderedChoice(String nombre, int puntos, LinkedList<Opcion> opciones) {

        Nombre = nombre;
        PuntosOtorgados = puntos;

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
