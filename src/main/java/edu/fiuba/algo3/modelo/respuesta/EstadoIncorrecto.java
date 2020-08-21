package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;

import java.util.LinkedList;

public class EstadoIncorrecto extends EstadoRespuesta{
    @Override
    public void actualizarCondicionDeUsoExclusividad(LinkedList<Respuesta> respuestas){
        return;
    }

    @Override
    public void otorgarPuntos(Puntos puntosOtorgados, Jugador jugador) {
        if(puntosOtorgados.sonNegativos()) //Cuando la respuesta incorrecta penaliza
            jugador.sumarPuntos(puntosOtorgados);
    }
}