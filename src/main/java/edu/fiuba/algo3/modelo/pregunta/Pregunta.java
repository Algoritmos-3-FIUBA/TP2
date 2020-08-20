package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.LinkedList;

public abstract class Pregunta {

    protected String nombre;

    public void evaluarRespuestas(LinkedList<Respuesta> listaRespuestas){
        corregirRespuestas(listaRespuestas);

        for (Respuesta respuesta : listaRespuestas) {
            respuesta.actualizarCondicionDeUsoExclusividad(listaRespuestas);
            respuesta.calcularAmplificacionExclusividad(listaRespuestas);
        }

        for (Respuesta respuesta : listaRespuestas)
            respuesta.establecerAmplificadorAdecuado();

        sumarPuntosJugadores(listaRespuestas);
    }

    public abstract void corregirRespuestas(LinkedList<Respuesta> listaRespuestas);

    public abstract void sumarPuntosJugadores(LinkedList<Respuesta> listaRespuestas);

    public String getNombre() {
        return nombre;
    }

    public abstract ColeccionOpciones getOpciones();
}