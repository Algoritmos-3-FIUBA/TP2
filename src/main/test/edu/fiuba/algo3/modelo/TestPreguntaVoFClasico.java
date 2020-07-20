package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestPreguntaVoFClasico {

    @Test
    public void CreoPreguntaVoFClasicoIndicoRespuestaCorrecta(){

        Jugador lucas = new Jugador("Lucas");

        PreguntaVoF pregunta = new PreguntaVoF("¿1+1 no es 3?");

        pregunta.verdaderoOpcionCorrecta();
        // Opcion 1 -> Verdadero -> Opcion Correcta
        // Opcion 2 -> Falso

        ArrayList respuestasDeJugadores = new ArrayList();

        //Respuesta de Jugadores -> Lista con los jugadores que han respondido.
        respuestasDeJugadores.add(lucas.responderPregunta(2));

        pregunta.evaluarRespuestasFinales(respuestasDeJugadores);

        Assertions.assertEquals(lucas.getPuntos(),0);
    }

    @Test
    public void CreoPreguntaVoFClasicoIndicoRespuestaCorrectayAsignoLosPuntos(){

        Jugador lucas = new Jugador("Lucas");
        Jugador mati = new Jugador("Mati");

        PreguntaVoF pregunta = new PreguntaVoF("¿2+2 no es 3?");

        pregunta.falsoOpcionCorrecta();
        // Opcion 1 -> Verdadero
        // Opcion 2 -> Falso    -> Opcion Correcta

        ArrayList respuestasDeJugadores = new ArrayList();

        //Respuesta de Jugadores -> Lista con los jugadores que han respondido.
        respuestasDeJugadores.add(lucas.responderPregunta(1));
        respuestasDeJugadores.add(mati.responderPregunta(2));

        pregunta.evaluarRespuestasFinales(respuestasDeJugadores);

        Assertions.assertEquals(lucas.getPuntos(),0);
        Assertions.assertEquals(mati.getPuntos(),1);


    }
}
