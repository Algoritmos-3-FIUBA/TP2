package edu.fiuba.algo3.modelo.testEntregas;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class testPreguntaVoFPenalidadEntrega1 {

        @Test
        public void CreoPreguntaVerdaderoFalsoConPenalidadIndicandoRespuestCorrecta(){
        Jugador jugador = new Jugador("Fernando");

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("El caballo blanco de San Martin es rojo");

        pregunta.setFalsoOpcionCorrecta();

        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso(pregunta.getOpcionFalsa(),jugador);

        LinkedList <RespuestaVerdaderoFalso> listaRespuesta= new LinkedList<RespuestaVerdaderoFalso>();

        listaRespuesta.add(respuesta);

        pregunta.evaluarRespuestas(listaRespuesta);

        Assertions.assertEquals(jugador.getPuntos(),1);

    }
    @Test
    public void PreguntaVerdaderoFalsoConPenalidadAsignaCorrectamenteLosPuntosALosJugadores(){
        Jugador jugador1 = new Jugador("Fernando");
        Jugador jugador2 = new Jugador("Lucas");
        Jugador jugador3 = new Jugador("Guido");

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("Messi no es Argetino");

        pregunta.setFalsoOpcionCorrecta();

        RespuestaVerdaderoFalso respuesta1 = new RespuestaVerdaderoFalso(pregunta.getOpcionFalsa(),jugador1);
        RespuestaVerdaderoFalso respuesta2 = new RespuestaVerdaderoFalso(pregunta.getOpcionVerdadera(),jugador2);
        RespuestaVerdaderoFalso respuesta3 = new RespuestaVerdaderoFalso(pregunta.getOpcionFalsa(),jugador3);

        LinkedList <RespuestaVerdaderoFalso> listaRespuesta= new LinkedList<RespuestaVerdaderoFalso>();

        listaRespuesta.add(respuesta1);listaRespuesta.add(respuesta2);listaRespuesta.add(respuesta3);

        pregunta.evaluarRespuestas(listaRespuesta);

        Assertions.assertEquals(jugador1.getPuntos(),1);
        Assertions.assertEquals(jugador2.getPuntos(),-1);
        Assertions.assertEquals(jugador3.getPuntos(),1);
    }
}
