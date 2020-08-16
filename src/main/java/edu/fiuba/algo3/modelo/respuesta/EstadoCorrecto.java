package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;

import java.util.LinkedList;

public class EstadoCorrecto extends EstadoRespuesta{
    @Override
    public void actualizarCondicionDeUsoExclusividad(LinkedList<Respuesta> respuestas) {
        for(Respuesta respuesta : respuestas)
            respuesta.notificarExclusividadQueHayRespuestaCorrecta();
    }

    @Override
    public void otorgarPuntos(Puntos puntosOtorgados, Jugador jugador) {
        jugador.sumarPuntos(puntosOtorgados);
    }
}
