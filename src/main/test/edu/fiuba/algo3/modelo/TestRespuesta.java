package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuesta {
    private Opcion opcionVerdadero;
    private Opcion opcionFalso;

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaYObtienePuntaje(){
        opcionVerdadero = new OpcionCorrecta("Euler",1);

        private Jugador jugador = new Jugador("Guido");
        private Respuesta respuestaJugador = new Respuesta(opcionVerdadero, jugador);

        respuestaJugador.otorgarPuntos();

        Assertions.assertEquals(jugador.getPuntos(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaYNoObtienePuntaje(){
        opcionFalso = new OpcionCorrecta("Gauss",0);

        private Jugador jugador = new Jugador("Guido");
        private Respuesta respuestaJugador = new Respuesta(opcionFalso, jugador);

        respuestaJugador.otorgarPuntos();

        Assertions.assertEquals(jugador.getPuntos(),0);
    }
}
