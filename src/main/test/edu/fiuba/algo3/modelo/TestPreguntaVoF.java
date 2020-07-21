package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaVoF {

    @Test
    public void CreoPreguntaVoFClasicoConNombrePregunta1YObtengoNombrePregunta1(){

        PreguntaVoF preguntaPrueba = new PreguntaVoF("Pregunta1");
        assertEquals(preguntaPrueba.getNombrePregunta(), "Pregunta1");

    }

    @Test
    public void CreoPreguntaVoFClasicoConVerdaderoCorrectaYVerdaderoSumaUnPunto(){

        PreguntaVoF preguntaPrueba = new PreguntaVoF("Pregunta");
        preguntaPrueba.verdaderoOpcionCorrecta();

        Opcion opcionVerdaderoCorrecta = preguntaPrueba.getOpcionVerdadero();

        assertEquals(opcionVerdaderoCorrecta.puntosASumar(), 1);

    }

    @Test
    public void CreoPreguntaVoFClasicoConFalsoCorrectaYFalsoSumaUnPunto(){

        PreguntaVoF preguntaPrueba = new PreguntaVoF("Pregunta");
        preguntaPrueba.falsoOpcionCorrecta();

        Opcion opcionFalsoCorrecta = preguntaPrueba.getOpcionFalso();

        assertEquals(opcionFalsoCorrecta.puntosASumar(), 1);

    }

    @Test
    public void CreoPreguntaVoFClasicoConFalsoIncorrectoYFalsoSumaCeroPunto(){

        PreguntaVoF preguntaPrueba = new PreguntaVoF("Pregunta");
        preguntaPrueba.verdaderoOpcionCorrecta();

        Opcion opcionVerdaderoCorrecta = preguntaPrueba.getOpcionFalso();

        assertEquals(opcionVerdaderoCorrecta.puntosASumar(), 0);

    }

    @Test
    public void CreoPreguntaVoFClasicoConVerdaderoIncorrectoYVerdaderoSumaCeroPunto(){

        PreguntaVoF preguntaPrueba = new PreguntaVoF("Pregunta");
        preguntaPrueba.falsoOpcionCorrecta();

        Opcion opcionFalsoCorrecta = preguntaPrueba.getOpcionVerdadero();

        assertEquals(opcionFalsoCorrecta.puntosASumar(), 0);

    }


    @Test
    public void PreguntaVoFClasicoTieneDosOpciones(){

        PreguntaVoF preguntaPrueba = new PreguntaVoF("Pregunta");
        preguntaPrueba.verdaderoOpcionCorrecta();

        ArrayList opcionesDisponibles = preguntaPrueba.getOpcionesDisponibles();

        assertEquals(opcionesDisponibles.size(), 2);

    }

    @Test
    public void CreoPreguntaVoFYJugadorRespondeMalAsignaPuntosCorrectamente(){

        Jugador juan = new Jugador("Juan");
        PreguntaVoF pregunta = new PreguntaVoF("Pregunta");
        pregunta.verdaderoOpcionCorrecta();

        ArrayList respuestasDeJugadores = new ArrayList();
        respuestasDeJugadores.add(juan.responderPregunta(2));

        pregunta.evaluarRespuestasFinales(respuestasDeJugadores);

        Assertions.assertEquals(juan.getPuntos(),0);
    }

    @Test
    public void CreoPreguntaVoFYJugadorRespondeBienAsignaPuntosCorrectamente(){

        Jugador juan = new Jugador("Juan");
        PreguntaVoF pregunta = new PreguntaVoF("Pregunta");
        pregunta.verdaderoOpcionCorrecta();

        ArrayList respuestasDeJugadores = new ArrayList();
        respuestasDeJugadores.add(juan.responderPregunta(1));

        pregunta.evaluarRespuestasFinales(respuestasDeJugadores);

        Assertions.assertEquals(juan.getPuntos(),1);
    }

}
