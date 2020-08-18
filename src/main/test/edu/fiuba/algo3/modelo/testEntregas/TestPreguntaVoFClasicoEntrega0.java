package edu.fiuba.algo3.modelo.testEntregas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

public class TestPreguntaVoFClasicoEntrega0 {

    @Test
    public void testCreoPreguntaVoFClasicoIndicoRespuestaCorrecta01(){

        Jugador Lucas = new Jugador("Lucas");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");

        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        //Respuesta de Jugadores -> Lista con los jugadores que han respondido.
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Lucas));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        Assertions.assertEquals(Lucas.getPuntos().getCantidad(),1);
    }

    @Test
    public void testCreoPreguntaVoFClasicoIndicoRespuestaCorrectayAsignoLosPuntos02(){

        Jugador Lucas = new Jugador("Lucas");
        Jugador Mati = new Jugador("Mati");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿2+2 no es 3?");

        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        //Respuesta de Jugadores -> Lista con los jugadores que han respondido.
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Lucas));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Mati));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        Assertions.assertEquals(Lucas.getPuntos().getCantidad(),0);
        Assertions.assertEquals(Mati.getPuntos().getCantidad(),1);
    }
}