package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

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
    public void CreoJugadorLlamadoPedroNoTienePuntosInicialesAciertaUnaRespuestaTiene1Punto(){
/*
        Jugador jugador3 = new Jugador("Lionel");

                PreguntaVoF pregunta = new PreguntaVoF("¿2+2 no es 3?");

        pregunta.falsoOpcionCorrecta();
        // Opcion 1 -> Verdadero
        // Opcion 2 -> Falso    -> Opcion Correcta

        ArrayList respuestasDeJugadores = new ArrayList();

        //Respuesta de Jugadores -> Lista con los jugadores que han respondido.
        respuestasDeJugadores.add(lucas.responderPregunta(1));

        pregunta.evaluarRespuestasFinales(respuestasDeJugadores);




        jugador3.sumarPuntos(2);
        assertEquals(jugador3.getPuntos(), 20);
 */
    }
    /*
    @Test
    public void CreoJugadorLlamadoPedroNoTienePuntosInicialesLeSumo0PuntosObtengo0Puntos(){
        Jugador jugador3 = new Jugador("Lionel");
        //jugador3.sumarPuntos(0);
        //    assertEquals(jugador3.getPuntos(), 0);
    }
    @Test
    public void CreoJugadorLlamadoPedroNoTienePuntosInicialesLeSumo0PuntosObtengo0Puntos(){
        //       falso = new OpcionCorrecta();
//        verdadero = new OpcionIncorrecta();
 //       opcionesDisponibles
    }

     */
}
