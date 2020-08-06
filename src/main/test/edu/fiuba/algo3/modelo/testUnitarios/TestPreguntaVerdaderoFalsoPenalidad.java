package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorTres;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorDos;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoPenalidad;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
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

        RespuestaUnica respuesta = new RespuestaUnica(pregunta.getOpcionVerdadera(),jugador);

        LinkedList<Respuesta> listaRespuetas= new LinkedList<Respuesta>();

        listaRespuetas.add(respuesta);

        pregunta.evaluarRespuestas(listaRespuetas);

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),-1);

    }

    @Test
    public void PreguntaRecibeRespuestaCorrectaYAsignaLosPuntajesCorrespondientes(){
        Jugador jugador = new Jugador("Pedro");

        MultiplicadorPorDos multiplicador = new MultiplicadorPorDos();

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("1+1 es 2");

        pregunta.setVerdaderoOpcionCorrecta();

        RespuestaUnica respuesta = new RespuestaUnica(pregunta.getOpcionVerdadera(),jugador,multiplicador);

        LinkedList <Respuesta> listaRespuetas= new LinkedList<Respuesta>();

        listaRespuetas.add(respuesta);

        pregunta.evaluarRespuestas(listaRespuetas);

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),2);
    }
    @Test
    public void PreguntaRecibeRespuestaCorrectaYAsignaLosPuntajesCorrespondientes2(){
        Jugador jugador = new Jugador("Pedro");

        MultiplicadorPorTres multiplicador = new MultiplicadorPorTres();

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("1+1 es 2");
        PreguntaVerdaderoFalsoPenalidad pregunta2 = new PreguntaVerdaderoFalsoPenalidad("1+1 es 2");

        pregunta.setVerdaderoOpcionCorrecta();
        pregunta2.setVerdaderoOpcionCorrecta();

        RespuestaUnica respuesta = new RespuestaUnica(pregunta.getOpcionVerdadera(),jugador,multiplicador);
        RespuestaUnica respuesta2 = new RespuestaUnica(pregunta2.getOpcionVerdadera(),jugador,multiplicador);

        LinkedList <Respuesta> listaRespuetas= new LinkedList<Respuesta>();

        listaRespuetas.add(respuesta);

        LinkedList <Respuesta> listaRespuetas2= new LinkedList<Respuesta>();

        listaRespuetas.add(respuesta2);

        pregunta.evaluarRespuestas(listaRespuetas);

        pregunta.evaluarRespuestas(listaRespuetas2);

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),4);
    }
}
