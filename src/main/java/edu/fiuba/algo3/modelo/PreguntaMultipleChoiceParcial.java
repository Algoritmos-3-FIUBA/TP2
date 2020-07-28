package edu.fiuba.algo3.modelo;

import java.util.HashSet;

public class PreguntaMultipleChoiceParcial {

    private String Nombre;
    private int PuntosOtorgados;
    HashSet<OpcionCorrecta> opcionesCorrectas;
    HashSet<OpcionIncorrecta> opcionesIncorrectas;

    public PreguntaMultipleChoiceParcial(String nombre, int puntos, HashSet<Opcion> opciones){

        Nombre = nombre;
        PuntosOtorgados = puntos;

        for (Opcion opcion : opciones) {
            opcion.agregarseALaListaCorrespondiente(opcionesCorrectas,opcionesIncorrectas);
        }

    }

    public void evaluarRespuestas(LinkedList <RespuestaMultipleChoiceParcial> respuestas){

        for (RespuestaMultipleChoiceParcial respuesta : respuestas)
            respuesta.otorgarPuntos(opcionesCorrectas, opcionesIncorrectas, PuntosOtorgados);

    }
}
