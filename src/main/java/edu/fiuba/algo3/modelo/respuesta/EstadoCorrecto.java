package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.amplificador.Amplificador;

public class EstadoCorrecto extends EstadoRespuesta{
    @Override
    public void actualizarEstadoAmplificador(Amplificador amplificadorFinal) {
        amplificadorFinal.hayRespuestaCorrecta();
    }

    @Override
    public void otorgarPuntos(Puntos puntosOtorgados, Jugador jugador) {
        jugador.sumarPuntos(puntosOtorgados);
    }
}
