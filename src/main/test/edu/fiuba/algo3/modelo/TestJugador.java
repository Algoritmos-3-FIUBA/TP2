package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static  org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestJugador {

    @Test
   public void CreoJugadorLlamadoJuanObtengoNombreJuan(){
        Jugador jugador1 = new Jugador("Juan");
        assertEquals(jugador1.getNombre(), "Juan");
    }

    @Test
    public void CreoJugadorLlamadoPedroNoTienePuntosInicialesObtengo0Puntos(){
        Jugador jugador2 = new Jugador("Pedro");
        assertEquals(jugador2.getPuntos(), 0);
    }
    @Test
    public void CreoJugadorLlamadoJulianLePreguntoYEligeOpcion2FalsoEsCorrectaSuma1Punto(){

        Jugador jugador3 = new Jugador("Julian");

        PreguntaVoF pregunta = new PreguntaVoF("¿2+2 no es 3?");

        pregunta.falsoOpcionCorrecta();
        // Opcion 1 -> Verdadero
        // Opcion 2 -> Falso    -> Opcion Correcta


        ArrayList respuestasDeJugador = new ArrayList();

        //Respuesta de Jugadores -> Lista con los jugadores que han respondido.
        respuestasDeJugador.add(jugador3.responderPregunta(2));

        pregunta.evaluarRespuestasFinales(respuestasDeJugador);

        assertEquals(jugador3.getPuntos(), 1);

    }
    @Test
    public void CreoJugadorLlamadoFrancoLePreguntoYEligeOpcion1VerdaderoEsCorrectaSuma0Puntos(){

        Jugador jugador3 = new Jugador("Franco");

        PreguntaVoF pregunta = new PreguntaVoF("¿2+2 no es 3?");

        pregunta.falsoOpcionCorrecta();
        // Opcion 1 -> Verdadero
        // Opcion 2 -> Falso    -> Opcion Correcta


        ArrayList respuestasDeJugador = new ArrayList();

        //Respuesta de Jugadores -> Lista con los jugadores que han respondido.
        respuestasDeJugador.add(jugador3.responderPregunta(1));

        pregunta.evaluarRespuestasFinales(respuestasDeJugador);

        assertEquals(jugador3.getPuntos(), 0);

    }
}
