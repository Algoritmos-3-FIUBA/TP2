package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import java.util.LinkedList;

public abstract class Pregunta {

    protected String nombre;

    public void evaluarRespuestas(LinkedList<Respuesta> listaRespuestas){
        corregirRespuestas(listaRespuestas);
        prepararAmplificadorExclusividad(listaRespuestas);
        sumarPuntosJugadores(listaRespuestas);
    }

    private void prepararAmplificadorExclusividad(LinkedList<Respuesta> listaRespuestas){
        for (Respuesta respuesta : listaRespuestas) {
            respuesta.actualizarCondicionDeUsoExclusividad(listaRespuestas);
            respuesta.actualizarAmplificacionExclusividad(listaRespuestas);
        }

        for (Respuesta respuesta : listaRespuestas)
            respuesta.establecerUsoDeExclusividadSiEsNecesario();
    }

    public abstract void corregirRespuestas(LinkedList<Respuesta> listaRespuestas);

    public abstract void sumarPuntosJugadores(LinkedList<Respuesta> listaRespuestas);

    public String getNombre() {
        return nombre;
    }

    public abstract ColeccionOpciones getOpciones();

    //Para evitar codigo repetido
    protected void sumarPuntosMultiplceChoiceConCadaOpcion(LinkedList<Respuesta> respuestas){
        for (Respuesta respuesta : respuestas) {
            Puntos puntosParciales = new Puntos(0);
            for (Opcion opcion : ((RespuestaMultiple) respuesta).getColeccionDeOpciones().getOpciones())
                puntosParciales.sumarPuntos(opcion.puntosObtenidos());
            respuesta.otorgarPuntos(puntosParciales);
        }
    }
}