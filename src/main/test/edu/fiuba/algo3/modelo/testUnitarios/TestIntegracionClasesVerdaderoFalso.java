package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.PreguntaVerdaderoFalsoPenalidad;
import edu.fiuba.algo3.modelo.Respuesta;
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
        Respuesta respuestaPrimerPregunta = new Respuesta(preguntaClasica.getOpcionVerdadera(),juan);
        Respuesta respuestaSegundaPregunta = new Respuesta(preguntaClasica.getOpcionVerdadera(),juan);

        LinkedList<Respuesta> listaRespuestaPrimerPregunta = new LinkedList<Respuesta>();
        LinkedList<Respuesta> listaRespuestaSegundaPregunta = new LinkedList<Respuesta>();

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
        Respuesta respuestaPrimerPregunta = new Respuesta(preguntaClasica.getOpcionVerdadera(),juan);
        Respuesta respuestaSegundaPregunta = new Respuesta(preguntaPenalidad.getOpcionFalsa(),juan);

        LinkedList<Respuesta> listaRespuestaPrimerPregunta = new LinkedList<Respuesta>();
        LinkedList<Respuesta> listaRespuestaSegundaPregunta = new LinkedList<Respuesta>();

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
        Respuesta respuestaPrimerPregunta = new Respuesta(preguntaClasica.getOpcionFalsa(),juan);
        Respuesta respuestaSegundaPregunta = new Respuesta(preguntaPenalidad.getOpcionVerdadera(),juan);

        LinkedList<Respuesta> listaRespuestaPrimerPregunta = new LinkedList<Respuesta>();
        LinkedList<Respuesta> listaRespuestaSegundaPregunta = new LinkedList<Respuesta>();

        listaRespuestaPrimerPregunta.add(respuestaPrimerPregunta);
        listaRespuestaSegundaPregunta.add(respuestaSegundaPregunta);

        // Cada pregunta evalua las respuestas.
        preguntaClasica.evaluarRespuestas(listaRespuestaPrimerPregunta);
        preguntaPenalidad.evaluarRespuestas(listaRespuestaSegundaPregunta);

        Assertions.assertEquals(juan.getPuntos(),1);

    }
}