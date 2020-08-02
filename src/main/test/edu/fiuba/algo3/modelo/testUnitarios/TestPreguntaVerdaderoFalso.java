package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaVerdaderoFalso {

    @Test
    public void CreoPreguntaVerdaderoFalsoClasicoConNombrePregunta1YObtengoNombrePregunta1(){

        PreguntaVerdaderoFalsoClasico preguntaPrueba = new PreguntaVerdaderoFalsoClasico("Pregunta1");
        preguntaPrueba.setVerdaderoOpcionCorrecta();

        assertEquals(preguntaPrueba.getNombrePregunta(), "Pregunta1");

    }

    @Test
    public void CreoPreguntaVerdaderoFalsoClasicoConVerdaderoCorrectaYVerdaderoSumaUnPunto(){

        PreguntaVerdaderoFalsoClasico preguntaPrueba = new PreguntaVerdaderoFalsoClasico("Pregunta");
        preguntaPrueba.setVerdaderoOpcionCorrecta();

        Opcion opcionVerdaderoCorrecta = preguntaPrueba.getOpcionVerdadera();

        assertEquals(opcionVerdaderoCorrecta.puntosObtenidos(), 1);

    }

    @Test
    public void CreoPreguntaVerdaderoFalsoClasicoConFalsoCorrectaYFalsoSumaUnPunto(){

        PreguntaVerdaderoFalsoClasico preguntaPrueba = new PreguntaVerdaderoFalsoClasico("Pregunta");
        preguntaPrueba.setFalsoOpcionCorrecta();

        Opcion opcionFalsoCorrecta = preguntaPrueba.getOpcionFalsa();

        assertEquals(opcionFalsoCorrecta.puntosObtenidos(), 1);

    }

    @Test
    public void CreoPreguntaVerdaderoFalsoClasicoConFalsoIncorrectoYFalsoSumaCeroPuntos(){

        PreguntaVerdaderoFalsoClasico preguntaPrueba = new PreguntaVerdaderoFalsoClasico("Pregunta");
        preguntaPrueba.setVerdaderoOpcionCorrecta();

        Opcion opcionVerdaderoCorrecta = preguntaPrueba.getOpcionFalsa();

        assertEquals(opcionVerdaderoCorrecta.puntosObtenidos(), 0);

    }

    @Test
    public void CreoPreguntaVerdaderoFalsoClasicoConVerdaderoIncorrectoYVerdaderoSumaCeroPuntos(){

        PreguntaVerdaderoFalsoClasico preguntaPrueba = new PreguntaVerdaderoFalsoClasico("Pregunta");
        preguntaPrueba.setFalsoOpcionCorrecta();

        Opcion opcionFalsoCorrecta = preguntaPrueba.getOpcionVerdadera();

        assertEquals(opcionFalsoCorrecta.puntosObtenidos(), 0);

    }

    @Test
    public void CreoPreguntaVerdaderoFalsoYJugadorRespondeMalAsignaPuntosCorrectamente(){

        Jugador Lucas = new Jugador("Lucas");
        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<RespuestaVerdaderoFalso> respuestasDeJugadores = new LinkedList<RespuestaVerdaderoFalso>();

        respuestasDeJugadores.add(new RespuestaVerdaderoFalso(pregunta.getOpcionFalsa(),Lucas));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        assertEquals(Lucas.getPuntos(),0);
    }

    @Test
    public void CreoPreguntaVerdaderoFalsoYJugadorRespondeBienAsignaPuntosCorrectamente(){

        Jugador Lucas = new Jugador("Lucas");
        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<RespuestaVerdaderoFalso> respuestasDeJugadores = new LinkedList<RespuestaVerdaderoFalso>();

        respuestasDeJugadores.add(new RespuestaVerdaderoFalso(pregunta.getOpcionVerdadera(),Lucas));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        Assertions.assertEquals(Lucas.getPuntos(),1);
    }

}