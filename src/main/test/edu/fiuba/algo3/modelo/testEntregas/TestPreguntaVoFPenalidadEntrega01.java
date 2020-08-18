package edu.fiuba.algo3.modelo.testEntregas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoPenalidad;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaVoFPenalidadEntrega01 {

    @Test
        public void testCreoPreguntaVerdaderoFalsoConPenalidadIndicandoRespuestCorrecta01(){

        Jugador jugador = new Jugador("Fernando");

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("El caballo blanco de San Martin es rojo");

        pregunta.setFalsoOpcionCorrecta();

        RespuestaUnica respuesta =  new RespuestaUnica(pregunta.getOpcionFalsa(), jugador);

        LinkedList<Respuesta> listaRespuesta = new LinkedList<>();

        listaRespuesta.add(respuesta);

        pregunta.evaluarRespuestas(listaRespuesta);

        assertEquals(jugador.getPuntos().getCantidad(),1);

    }

    @Test
    public void testPreguntaVerdaderoFalsoConPenalidadAsignaCorrectamenteLosPuntosALosJugadores02(){
        Jugador jugador1 = new Jugador("Fernando");
        Jugador jugador2 = new Jugador("Lucas");
        Jugador jugador3 = new Jugador("Guido");

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("Messi no es Argetino");

        pregunta.setFalsoOpcionCorrecta();

        RespuestaUnica respuesta1 = new RespuestaUnica(pregunta.getOpcionFalsa(),jugador1);
        RespuestaUnica respuesta2 = new RespuestaUnica(pregunta.getOpcionVerdadera(),jugador2);
        RespuestaUnica respuesta3 = new RespuestaUnica(pregunta.getOpcionFalsa(),jugador3);

        LinkedList<Respuesta> listaRespuesta= new LinkedList<>();

        listaRespuesta.add(respuesta1);listaRespuesta.add(respuesta2);listaRespuesta.add(respuesta3);

        pregunta.evaluarRespuestas(listaRespuesta);

        assertEquals(jugador1.getPuntos().getCantidad(),1);
        assertEquals(jugador2.getPuntos().getCantidad(),-1);
        assertEquals(jugador3.getPuntos().getCantidad(),1);
    }
}