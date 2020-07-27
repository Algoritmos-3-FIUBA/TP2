package edu.fiuba.algo3.modelo.testEntregas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Respuesta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

public class TestPreguntaVoFClasicoEntrega0 {

    @Test
    public void CreoPreguntaVoFClasicoIndicoRespuestaCorrecta(){

        Jugador Lucas = new Jugador("Lucas");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");

        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        //Respuesta de Jugadores -> Lista con los jugadores que han respondido.
        respuestasDeJugadores.add(new Respuesta(pregunta.getOpcionVerdadera(),Lucas));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        Assertions.assertEquals(Lucas.getPuntos(),1);
    }

    @Test
    public void CreoPreguntaVoFClasicoIndicoRespuestaCorrectayAsignoLosPuntos(){

        Jugador Lucas = new Jugador("Lucas");
        Jugador Mati = new Jugador("Mati");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿2+2 no es 3?");

        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        //Respuesta de Jugadores -> Lista con los jugadores que han respondido.
        respuestasDeJugadores.add(new Respuesta(pregunta.getOpcionFalsa(),Lucas));
        respuestasDeJugadores.add(new Respuesta(pregunta.getOpcionVerdadera(),Mati));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        Assertions.assertEquals(Lucas.getPuntos(),0);
        Assertions.assertEquals(Mati.getPuntos(),1);
    }
}
