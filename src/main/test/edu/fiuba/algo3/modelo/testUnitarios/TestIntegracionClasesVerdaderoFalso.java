package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoPenalidad;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
import org.junit.Test;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIntegracionClasesVerdaderoFalso {

    @Test
    public void testJugadorRespondeDiferentesTiposDePreguntasDeFormaCorrecta01(){
        // Creacion de Jugador
        Jugador juan = new Jugador("Juan");
        // Creacion de primer pregunta estilo VoF Clasica.
        PreguntaVerdaderoFalsoClasico preguntaClasica = new PreguntaVerdaderoFalsoClasico("10+10 es 20");
        preguntaClasica.setVerdaderoOpcionCorrecta();
        // Creacion de segunda pregunta estilo VoF Penalidad
        PreguntaVerdaderoFalsoPenalidad preguntaPenalidad = new PreguntaVerdaderoFalsoPenalidad("10+2 no es 20");
        preguntaPenalidad.setVerdaderoOpcionCorrecta();
        // Jugador Responde.
        RespuestaUnica respuestaPrimerPregunta = new RespuestaUnica(preguntaClasica.getOpcionVerdadera(),juan);
        RespuestaUnica respuestaSegundaPregunta = new RespuestaUnica(preguntaClasica.getOpcionVerdadera(),juan);

        LinkedList<Respuesta> listaRespuestaPrimerPregunta = new LinkedList<Respuesta>();
        LinkedList<Respuesta> listaRespuestaSegundaPregunta = new LinkedList<Respuesta>();

        listaRespuestaPrimerPregunta.add(respuestaPrimerPregunta);
        listaRespuestaSegundaPregunta.add(respuestaSegundaPregunta);

        // Cada pregunta evalua las respuestas.
        preguntaClasica.evaluarRespuestas(listaRespuestaPrimerPregunta);
        preguntaPenalidad.evaluarRespuestas(listaRespuestaSegundaPregunta);

        Puntos puntosJuan = juan.getPuntos();

        assertEquals(puntosJuan.getCantidad(),2);

    }
    @Test
    public void testJugadorRespondeDeFormaCorrectaPreguntaVoFClasicaEIncorrectaPreguntaVoFPenalidad02(){
        // Creacion de Jugador
        Jugador juan = new Jugador("Juan");
        // Creacion de primer pregunta estilo VoF Clasica.
        PreguntaVerdaderoFalsoClasico preguntaClasica = new PreguntaVerdaderoFalsoClasico("10+10 es 20");
        preguntaClasica.setVerdaderoOpcionCorrecta();
        // Creacion de segunda pregunta estilo VoF Penalidad
        PreguntaVerdaderoFalsoPenalidad preguntaPenalidad = new PreguntaVerdaderoFalsoPenalidad("10+2 no es 20");
        preguntaPenalidad.setVerdaderoOpcionCorrecta();
        // Jugador Responde.
        RespuestaUnica respuestaPrimerPregunta = new RespuestaUnica(preguntaClasica.getOpcionVerdadera(),juan);
        RespuestaUnica respuestaSegundaPregunta = new RespuestaUnica(preguntaPenalidad.getOpcionFalsa(),juan);

        LinkedList<Respuesta> listaRespuestaPrimerPregunta = new LinkedList<Respuesta>();
        LinkedList<Respuesta> listaRespuestaSegundaPregunta = new LinkedList<Respuesta>();

        listaRespuestaPrimerPregunta.add(respuestaPrimerPregunta);
        listaRespuestaSegundaPregunta.add(respuestaSegundaPregunta);

        // Cada pregunta evalua las respuestas.
        preguntaClasica.evaluarRespuestas(listaRespuestaPrimerPregunta);
        preguntaPenalidad.evaluarRespuestas(listaRespuestaSegundaPregunta);

        Puntos puntosJuan = juan.getPuntos();

        assertEquals(puntosJuan.getCantidad(),0);
    }

    @Test
    public void testJugadorRespondeDeFormaIncorrectaPreguntaVoFClasicaECorrectaPreguntaVoFPenalidad03(){
        // Creacion de Jugador
        Jugador juan = new Jugador("Juan");
        // Creacion de primer pregunta estilo VoF Clasica.
        PreguntaVerdaderoFalsoClasico preguntaClasica = new PreguntaVerdaderoFalsoClasico("10+10 es 20");
        preguntaClasica.setVerdaderoOpcionCorrecta();
        // Creacion de segunda pregunta estilo VoF Penalidad
        PreguntaVerdaderoFalsoPenalidad preguntaPenalidad = new PreguntaVerdaderoFalsoPenalidad("10+2 no es 20");
        preguntaPenalidad.setVerdaderoOpcionCorrecta();
        // Jugador Responde.
        RespuestaUnica respuestaPrimerPregunta = new RespuestaUnica(preguntaClasica.getOpcionFalsa(),juan);
        RespuestaUnica respuestaSegundaPregunta = new RespuestaUnica(preguntaPenalidad.getOpcionVerdadera(),juan);

        LinkedList<Respuesta> listaRespuestaPrimerPregunta = new LinkedList<Respuesta>();
        LinkedList<Respuesta> listaRespuestaSegundaPregunta = new LinkedList<Respuesta>();

        listaRespuestaPrimerPregunta.add(respuestaPrimerPregunta);
        listaRespuestaSegundaPregunta.add(respuestaSegundaPregunta);

        // Cada pregunta evalua las respuestas.
        preguntaClasica.evaluarRespuestas(listaRespuestaPrimerPregunta);
        preguntaPenalidad.evaluarRespuestas(listaRespuestaSegundaPregunta);

        Puntos puntosJuan = juan.getPuntos();

        assertEquals(puntosJuan.getCantidad(),1);
    }
}