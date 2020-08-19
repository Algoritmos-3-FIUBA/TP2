package edu.fiuba.algo3.modelo.testunitarios;

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

        Jugador juan = new Jugador("Juan");

        PreguntaVerdaderoFalsoClasico preguntaClasica = new PreguntaVerdaderoFalsoClasico("10+10 es 20");
        preguntaClasica.setVerdaderoOpcionCorrecta();

        PreguntaVerdaderoFalsoPenalidad preguntaPenalidad = new PreguntaVerdaderoFalsoPenalidad("10+2 no es 20");
        preguntaPenalidad.setVerdaderoOpcionCorrecta();

        RespuestaUnica respuestaPrimerPregunta = new RespuestaUnica(preguntaClasica.getOpcionVerdadera(),juan);
        RespuestaUnica respuestaSegundaPregunta = new RespuestaUnica(preguntaClasica.getOpcionVerdadera(),juan);

        LinkedList<Respuesta> listaRespuestaPrimerPregunta = new LinkedList<Respuesta>();
        LinkedList<Respuesta> listaRespuestaSegundaPregunta = new LinkedList<Respuesta>();

        listaRespuestaPrimerPregunta.add(respuestaPrimerPregunta);
        listaRespuestaSegundaPregunta.add(respuestaSegundaPregunta);

        preguntaClasica.evaluarRespuestas(listaRespuestaPrimerPregunta);
        preguntaPenalidad.evaluarRespuestas(listaRespuestaSegundaPregunta);

        Puntos puntosJuan = juan.getPuntos();

        assertEquals(puntosJuan.getCantidad(),2);

    }
    @Test
    public void testJugadorRespondeDeFormaCorrectaPreguntaVoFClasicaEIncorrectaPreguntaVoFPenalidad02(){

        Jugador juan = new Jugador("Juan");

        PreguntaVerdaderoFalsoClasico preguntaClasica = new PreguntaVerdaderoFalsoClasico("10+10 es 20");
        preguntaClasica.setVerdaderoOpcionCorrecta();

        PreguntaVerdaderoFalsoPenalidad preguntaPenalidad = new PreguntaVerdaderoFalsoPenalidad("10+2 no es 20");
        preguntaPenalidad.setVerdaderoOpcionCorrecta();

        RespuestaUnica respuestaPrimerPregunta = new RespuestaUnica(preguntaClasica.getOpcionVerdadera(),juan);
        RespuestaUnica respuestaSegundaPregunta = new RespuestaUnica(preguntaPenalidad.getOpcionFalsa(),juan);

        LinkedList<Respuesta> listaRespuestaPrimerPregunta = new LinkedList<Respuesta>();
        LinkedList<Respuesta> listaRespuestaSegundaPregunta = new LinkedList<Respuesta>();

        listaRespuestaPrimerPregunta.add(respuestaPrimerPregunta);
        listaRespuestaSegundaPregunta.add(respuestaSegundaPregunta);

        preguntaClasica.evaluarRespuestas(listaRespuestaPrimerPregunta);
        preguntaPenalidad.evaluarRespuestas(listaRespuestaSegundaPregunta);

        Puntos puntosJuan = juan.getPuntos();

        assertEquals(puntosJuan.getCantidad(),0);
    }

    @Test
    public void testJugadorRespondeDeFormaIncorrectaPreguntaVoFClasicaECorrectaPreguntaVoFPenalidad03(){

        Jugador juan = new Jugador("Juan");

        PreguntaVerdaderoFalsoClasico preguntaClasica = new PreguntaVerdaderoFalsoClasico("10+10 es 20");
        preguntaClasica.setVerdaderoOpcionCorrecta();

        PreguntaVerdaderoFalsoPenalidad preguntaPenalidad = new PreguntaVerdaderoFalsoPenalidad("10+2 no es 20");
        preguntaPenalidad.setVerdaderoOpcionCorrecta();

        RespuestaUnica respuestaPrimerPregunta = new RespuestaUnica(preguntaClasica.getOpcionFalsa(),juan);
        RespuestaUnica respuestaSegundaPregunta = new RespuestaUnica(preguntaPenalidad.getOpcionVerdadera(),juan);

        LinkedList<Respuesta> listaRespuestaPrimerPregunta = new LinkedList<Respuesta>();
        LinkedList<Respuesta> listaRespuestaSegundaPregunta = new LinkedList<Respuesta>();

        listaRespuestaPrimerPregunta.add(respuestaPrimerPregunta);
        listaRespuestaSegundaPregunta.add(respuestaSegundaPregunta);

        preguntaClasica.evaluarRespuestas(listaRespuestaPrimerPregunta);
        preguntaPenalidad.evaluarRespuestas(listaRespuestaSegundaPregunta);

        Puntos puntosJuan = juan.getPuntos();

        assertEquals(puntosJuan.getCantidad(),1);
    }
}