package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.PreguntaVerdaderoFalsoPenalidad;
import edu.fiuba.algo3.modelo.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class TestPreguntaVerdaderoFalsoPenalidad {

    @Test
    public void CreoPreguntaVerdaderoFalsoConPenalidad(){

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("El Sol Existe");

        Assertions.assertEquals(pregunta.getNombrePregunta(),"El Sol Existe");
    }

    @Test
    public void PreguntaRecibeRespuestaIncorrectaYAsignaLosPuntajesCorrespondientes(){
        Jugador jugador = new Jugador("Ale");

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("Negro es un color");

        pregunta.setFalsoOpcionCorrecta();

        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso(pregunta.getOpcionVerdadera(),jugador);

        LinkedList <RespuestaVerdaderoFalso> listaRespuetas= new LinkedList<RespuestaVerdaderoFalso>();

        listaRespuetas.add(respuesta);

        pregunta.evaluarRespuestas(listaRespuetas);

        Assertions.assertEquals(jugador.getPuntos(),-1);

    }

    @Test
    public void PreguntaRecibeRespuestaCorrectaYAsignaLosPuntajesCorrespondientes(){
        Jugador jugador = new Jugador("Pedro");

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("1+1 es 2");

        pregunta.setVerdaderoOpcionCorrecta();

        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso(pregunta.getOpcionVerdadera(),jugador);

        LinkedList <RespuestaVerdaderoFalso> listaRespuetas= new LinkedList<RespuestaVerdaderoFalso>();

        listaRespuetas.add(respuesta);

        pregunta.evaluarRespuestas(listaRespuetas);

        Assertions.assertEquals(jugador.getPuntos(),1);

    }
}
