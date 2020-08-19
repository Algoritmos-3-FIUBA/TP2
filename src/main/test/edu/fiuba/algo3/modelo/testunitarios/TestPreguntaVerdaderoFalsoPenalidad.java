package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorTres;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorDos;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoPenalidad;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaVerdaderoFalsoPenalidad {

    @Test
    public void testCreoPreguntaVerdaderoFalsoConPenalidad01(){
        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("El Sol Existe");

        assertEquals(pregunta.getNombrePregunta(),"El Sol Existe");
    }

    @Test
    public void testPreguntaRecibeRespuestaIncorrectaYAsignaLosPuntajesCorrespondientes02(){
        Jugador jugador = new Jugador("Ale");

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("Negro es un color");

        pregunta.setFalsoOpcionCorrecta();

        RespuestaUnica respuesta = new RespuestaUnica(pregunta.getOpcionVerdadera(),jugador);

        LinkedList<Respuesta> listaRespuetas= new LinkedList<Respuesta>();

        listaRespuetas.add(respuesta);

        pregunta.evaluarRespuestas(listaRespuetas);

        assertEquals(jugador.getPuntos().getCantidad(),-1);
    }

    @Test
    public void testPreguntaRecibeRespuestaCorrectaYAsignaLosPuntajesCorrespondientes03(){
        Jugador jugador = new Jugador("Pedro");

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("1+1 es 2");

        pregunta.setVerdaderoOpcionCorrecta();

        RespuestaUnica respuesta = new RespuestaUnica(pregunta.getOpcionVerdadera(),jugador, jugador.usarMultiplicadorPorDos());

        LinkedList <Respuesta> listaRespuetas= new LinkedList<Respuesta>();

        listaRespuetas.add(respuesta);

        pregunta.evaluarRespuestas(listaRespuetas);

        assertEquals(jugador.getPuntos().getCantidad(),2);
    }

    /*@Test
    public void testPreguntaRecibeRespuestaCorrectaYAsignaLosPuntajesCorrespondientes204(){
        Jugador jugador = new Jugador("Pedro");

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("1+1 es 2");
        PreguntaVerdaderoFalsoPenalidad pregunta2 = new PreguntaVerdaderoFalsoPenalidad("1+1 es 2");

        pregunta.setVerdaderoOpcionCorrecta();
        pregunta2.setVerdaderoOpcionCorrecta();

        RespuestaUnica respuesta = new RespuestaUnica(pregunta.getOpcionVerdadera(),jugador, jugador.usarMultiplicadorPorTres());
        RespuestaUnica respuesta2 = new RespuestaUnica(pregunta2.getOpcionVerdadera(),jugador, jugador.usarMultiplicadorPorTres());

        LinkedList <Respuesta> listaRespuetas= new LinkedList<Respuesta>();

        listaRespuetas.add(respuesta);

        LinkedList <Respuesta> listaRespuetas2= new LinkedList<Respuesta>();

        listaRespuetas.add(respuesta2);

        pregunta.evaluarRespuestas(listaRespuetas);

        pregunta.evaluarRespuestas(listaRespuetas2);

        assertEquals(jugador.getPuntos().getCantidad(),4);
    }*/
}