package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.PreguntaVerdaderoFalsoPenalidad;
import edu.fiuba.algo3.modelo.RespuestaVerdaderoFalso;
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
        RespuestaVerdaderoFalso respuestaPrimerPregunta = new RespuestaVerdaderoFalso(preguntaClasica.getOpcionVerdadera(),juan);
        RespuestaVerdaderoFalso respuestaSegundaPregunta = new RespuestaVerdaderoFalso(preguntaClasica.getOpcionVerdadera(),juan);

        LinkedList<RespuestaVerdaderoFalso> listaRespuestaPrimerPregunta = new LinkedList<RespuestaVerdaderoFalso>();
        LinkedList<RespuestaVerdaderoFalso> listaRespuestaSegundaPregunta = new LinkedList<RespuestaVerdaderoFalso>();

        listaRespuestaPrimerPregunta.add(respuestaPrimerPregunta);
        listaRespuestaSegundaPregunta.add(respuestaSegundaPregunta);

        // Cada pregunta evalua las respuestas.
        preguntaClasica.evaluarRespuestas(listaRespuestaPrimerPregunta);
        preguntaPenalidad.evaluarRespuestas(listaRespuestaSegundaPregunta);

        Assertions.assertEquals(juan.getPuntos(),2);

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
        RespuestaVerdaderoFalso respuestaPrimerPregunta = new RespuestaVerdaderoFalso(preguntaClasica.getOpcionVerdadera(),juan);
        RespuestaVerdaderoFalso respuestaSegundaPregunta = new RespuestaVerdaderoFalso(preguntaPenalidad.getOpcionFalsa(),juan);

        LinkedList<RespuestaVerdaderoFalso> listaRespuestaPrimerPregunta = new LinkedList<RespuestaVerdaderoFalso>();
        LinkedList<RespuestaVerdaderoFalso> listaRespuestaSegundaPregunta = new LinkedList<RespuestaVerdaderoFalso>();

        listaRespuestaPrimerPregunta.add(respuestaPrimerPregunta);
        listaRespuestaSegundaPregunta.add(respuestaSegundaPregunta);

        // Cada pregunta evalua las respuestas.
        preguntaClasica.evaluarRespuestas(listaRespuestaPrimerPregunta);
        preguntaPenalidad.evaluarRespuestas(listaRespuestaSegundaPregunta);

        Assertions.assertEquals(juan.getPuntos(),0);

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
        RespuestaVerdaderoFalso respuestaPrimerPregunta = new RespuestaVerdaderoFalso(preguntaClasica.getOpcionFalsa(),juan);
        RespuestaVerdaderoFalso respuestaSegundaPregunta = new RespuestaVerdaderoFalso(preguntaPenalidad.getOpcionVerdadera(),juan);

        LinkedList<RespuestaVerdaderoFalso> listaRespuestaPrimerPregunta = new LinkedList<RespuestaVerdaderoFalso>();
        LinkedList<RespuestaVerdaderoFalso> listaRespuestaSegundaPregunta = new LinkedList<RespuestaVerdaderoFalso>();

        listaRespuestaPrimerPregunta.add(respuestaPrimerPregunta);
        listaRespuestaSegundaPregunta.add(respuestaSegundaPregunta);

        // Cada pregunta evalua las respuestas.
        preguntaClasica.evaluarRespuestas(listaRespuestaPrimerPregunta);
        preguntaPenalidad.evaluarRespuestas(listaRespuestaSegundaPregunta);

        Assertions.assertEquals(juan.getPuntos(),1);

    }
}
