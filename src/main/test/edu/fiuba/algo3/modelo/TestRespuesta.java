package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuesta {
    private Opcion opcionVerdadero;
    private Opcion opcionFalso;

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaYObtienePuntaje(){
        opcionVerdadero = new OpcionCorrecta("Verdadero",1);

        Jugador jugador = new Jugador("Guido");
        Respuesta respuestaJugador = new Respuesta(opcionVerdadero, jugador);

        respuestaJugador.otorgarPuntos();

        Assertions.assertEquals(jugador.getPuntos(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaYNoObtienePuntaje(){
        opcionFalso = new OpcionCorrecta("Falso",0);

        Jugador jugador = new Jugador("Guido");
        Respuesta respuestaJugador = new Respuesta(opcionFalso, jugador);

        respuestaJugador.otorgarPuntos();

        Assertions.assertEquals(jugador.getPuntos(),0);
    }
}
