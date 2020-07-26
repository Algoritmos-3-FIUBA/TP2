package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaVerdaderoFalso {

    @Test
    public void CreoPreguntaVerdaderoFalsoClasicoConNombrePregunta1YObtengoNombrePregunta1(){

        PreguntaVerdaderoFalso preguntaPrueba = new PreguntaVerdaderoFalso("Pregunta1");
        preguntaPrueba.setVerdaderoOpcionCorrecta();

        assertEquals(preguntaPrueba.getNombrePregunta(), "Pregunta1");

    }

    @Test
    public void CreoPreguntaVerdaderoFalsoClasicoConVerdaderoCorrectaYVerdaderoSumaUnPunto(){

        PreguntaVerdaderoFalso preguntaPrueba = new PreguntaVerdaderoFalso("Pregunta");
        preguntaPrueba.setVerdaderoOpcionCorrecta();

        Opcion opcionVerdaderoCorrecta = preguntaPrueba.getOpcionVerdadera();

        assertEquals(opcionVerdaderoCorrecta.puntosObtenidos(), 1);

    }

    @Test
    public void CreoPreguntaVerdaderoFalsoClasicoConFalsoCorrectaYFalsoSumaUnPunto(){

        PreguntaVerdaderoFalso preguntaPrueba = new PreguntaVerdaderoFalso("Pregunta");
        preguntaPrueba.falsoOpcionCorrecta();

        Opcion opcionFalsoCorrecta = preguntaPrueba.getOpcionFalsa();

        assertEquals(opcionFalsoCorrecta.puntosObtenidos(), 1);

    }

    @Test
    public void CreoPreguntaVerdaderoFalsoClasicoConFalsoIncorrectoYFalsoSumaCeroPuntos(){

        PreguntaVerdaderoFalso preguntaPrueba = new PreguntaVerdaderoFalso("Pregunta");
        preguntaPrueba.setVerdaderoOpcionCorrecta();

        Opcion opcionVerdaderoCorrecta = preguntaPrueba.getOpcionFalsa();

        assertEquals(opcionVerdaderoCorrecta.puntosObtenidos(), 0);

    }

    @Test
    public void CreoPreguntaVerdaderoFalsoClasicoConVerdaderoIncorrectoYVerdaderoSumaCeroPuntos(){

        PreguntaVerdaderoFalso preguntaPrueba = new PreguntaVerdaderoFalso("Pregunta");
        preguntaPrueba.falsoOpcionCorrecta();

        Opcion opcionFalsoCorrecta = preguntaPrueba.getOpcionVerdadera();

        assertEquals(opcionFalsoCorrecta.puntosObtenidos(), 0);

    }

    @Test
    public void CreoPreguntaVerdaderoFalsoYJugadorRespondeMalAsignaPuntosCorrectamente(){

        Jugador Lucas = new Jugador("Lucas");
        PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new Respuesta(pregunta.getOpcionFalsa(),Lucas));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        Assertions.assertEquals(Lucas.getPuntos(),0);
    }

    @Test
    public void CreoPreguntaVerdaderoFalsoYJugadorRespondeBienAsignaPuntosCorrectamente(){

        Jugador Lucas = new Jugador("Lucas");
        PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new Respuesta(pregunta.getOpcionVerdadera(),Lucas));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        Assertions.assertEquals(Lucas.getPuntos(),1);
    }

}
