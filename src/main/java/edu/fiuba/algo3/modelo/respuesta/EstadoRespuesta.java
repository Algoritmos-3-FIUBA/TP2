package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;

import java.util.LinkedList;

public abstract class EstadoRespuesta {
    public abstract void actualizarCondicionDeUsoExclusividad(LinkedList<Respuesta> respuestas);

    public abstract void otorgarPuntos(Puntos puntosOtorgados, Jugador jugador);
}
