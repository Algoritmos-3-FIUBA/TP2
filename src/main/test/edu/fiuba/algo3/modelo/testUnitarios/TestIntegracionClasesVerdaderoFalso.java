package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoPenalidad;
import edu.fiuba.algo3.modelo.respuesta.RespuestaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.respuesta.RespuestaVerdaderoFalsoPenalidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class TestIntegracionClasesVerdaderoFalso {

    @Test
    public void JugadorRespondeDiferentesTiposDePreguntasDeFormaCorrecta(){
        // Creacion de Jugador
        Jugador juan = new Jugador("Juan");
        // Creacion de primer pregunta estilo VoF Clasica.
        PreguntaVerdaderoFalsoClasico preguntaClasica = new PreguntaVerdaderoFalsoClasico("10+10 es 20");
        preguntaClasica.setVerdaderoOpcionCorrecta();
        // Creacion de segunda pregunta estilo VoF Penalidad
        PreguntaVerdaderoFalsoPenalidad preguntaPenalidad = new PreguntaVerdaderoFalsoPenalidad("10+2 no es 20");
        preguntaPenalidad.setVerdaderoOpcionCorrecta();
        // Jugador Responde.
        RespuestaVerdaderoFalsoClasico respuestaPrimerPregunta = new RespuestaVerdaderoFalsoClasico(preguntaClasica.getOpcionVerdadera(),juan);
        RespuestaVerdaderoFalsoPenalidad respuestaSegundaPregunta = new RespuestaVerdaderoFalsoPenalidad(preguntaClasica.getOpcionVerdadera(),juan);

        LinkedList<RespuestaVerdaderoFalsoClasico> listaRespuestaPrimerPregunta = new LinkedList<RespuestaVerdaderoFalsoClasico>();
        LinkedList<RespuestaVerdaderoFalsoPenalidad> listaRespuestaSegundaPregunta = new LinkedList<RespuestaVerdaderoFalsoPenalidad>();

        listaRespuestaPrimerPregunta.add(respuestaPrimerPregunta);
        listaRespuestaSegundaPregunta.add(respuestaSegundaPregunta);

        // Cada pregunta evalua las respuestas.
        preguntaClasica.evaluarRespuestas(listaRespuestaPrimerPregunta);
        preguntaPenalidad.evaluarRespuestas(listaRespuestaSegundaPregunta);

        Puntos puntosJuan = juan.getPuntos();

        Assertions.assertEquals(puntosJuan.getCantidad(),2);

    }
    @Test
    public void JugadorRespondeDeFormaCorrectaPreguntaVoFClasicaEIncorrectaPreguntaVoFPenalidad(){
        // Creacion de Jugador
        Jugador juan = new Jugador("Juan");
        // Creacion de primer pregunta estilo VoF Clasica.
        PreguntaVerdaderoFalsoClasico preguntaClasica = new PreguntaVerdaderoFalsoClasico("10+10 es 20");
        preguntaClasica.setVerdaderoOpcionCorrecta();
        // Creacion de segunda pregunta estilo VoF Penalidad
        PreguntaVerdaderoFalsoPenalidad preguntaPenalidad = new PreguntaVerdaderoFalsoPenalidad("10+2 no es 20");
        preguntaPenalidad.setVerdaderoOpcionCorrecta();
        // Jugador Responde.
        RespuestaVerdaderoFalsoClasico respuestaPrimerPregunta = new RespuestaVerdaderoFalsoClasico(preguntaClasica.getOpcionVerdadera(),juan);
        RespuestaVerdaderoFalsoPenalidad respuestaSegundaPregunta = new RespuestaVerdaderoFalsoPenalidad(preguntaPenalidad.getOpcionFalsa(),juan);

        LinkedList<RespuestaVerdaderoFalsoClasico> listaRespuestaPrimerPregunta = new LinkedList<RespuestaVerdaderoFalsoClasico>();
        LinkedList<RespuestaVerdaderoFalsoPenalidad> listaRespuestaSegundaPregunta = new LinkedList<RespuestaVerdaderoFalsoPenalidad>();

        listaRespuestaPrimerPregunta.add(respuestaPrimerPregunta);
        listaRespuestaSegundaPregunta.add(respuestaSegundaPregunta);

        // Cada pregunta evalua las respuestas.
        preguntaClasica.evaluarRespuestas(listaRespuestaPrimerPregunta);
        preguntaPenalidad.evaluarRespuestas(listaRespuestaSegundaPregunta);

        Puntos puntosJuan = juan.getPuntos();

        Assertions.assertEquals(puntosJuan.getCantidad(),0);
    }

    @Test
    public void JugadorRespondeDeFormaIncorrectaPreguntaVoFClasicaECorrectaPreguntaVoFPenalidad(){
        // Creacion de Jugador
        Jugador juan = new Jugador("Juan");
        // Creacion de primer pregunta estilo VoF Clasica.
        PreguntaVerdaderoFalsoClasico preguntaClasica = new PreguntaVerdaderoFalsoClasico("10+10 es 20");
        preguntaClasica.setVerdaderoOpcionCorrecta();
        // Creacion de segunda pregunta estilo VoF Penalidad
        PreguntaVerdaderoFalsoPenalidad preguntaPenalidad = new PreguntaVerdaderoFalsoPenalidad("10+2 no es 20");
        preguntaPenalidad.setVerdaderoOpcionCorrecta();
        // Jugador Responde.
        RespuestaVerdaderoFalsoClasico respuestaPrimerPregunta = new RespuestaVerdaderoFalsoClasico(preguntaClasica.getOpcionFalsa(),juan);
        RespuestaVerdaderoFalsoPenalidad respuestaSegundaPregunta = new RespuestaVerdaderoFalsoPenalidad(preguntaPenalidad.getOpcionVerdadera(),juan);

        LinkedList<RespuestaVerdaderoFalsoClasico> listaRespuestaPrimerPregunta = new LinkedList<RespuestaVerdaderoFalsoClasico>();
        LinkedList<RespuestaVerdaderoFalsoPenalidad> listaRespuestaSegundaPregunta = new LinkedList<RespuestaVerdaderoFalsoPenalidad>();

        listaRespuestaPrimerPregunta.add(respuestaPrimerPregunta);
        listaRespuestaSegundaPregunta.add(respuestaSegundaPregunta);

        // Cada pregunta evalua las respuestas.
        preguntaClasica.evaluarRespuestas(listaRespuestaPrimerPregunta);
        preguntaPenalidad.evaluarRespuestas(listaRespuestaSegundaPregunta);

        Puntos puntosJuan = juan.getPuntos();

        Assertions.assertEquals(puntosJuan.getCantidad(),1);

    }
}
