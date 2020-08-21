package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
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

        LinkedList<Respuesta> listaRespuetas= new LinkedList<Respuesta>();

        listaRespuetas.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),jugador));

        pregunta.evaluarRespuestas(listaRespuetas);

        assertEquals(jugador.getPuntos().getCantidad(),-1);
    }

    @Test
    public void testPreguntaRecibeRespuestaCorrectaYAsignaLosPuntajesCorrespondientes03(){
        Jugador jugador = new Jugador("Pedro");

        Multiplicador multiplicador = new MultiplicadorPorDos();

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("1+1 es 2");

        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList <Respuesta> listaRespuetas= new LinkedList<Respuesta>();

        listaRespuetas.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),jugador, multiplicador));

        pregunta.evaluarRespuestas(listaRespuetas);

        assertEquals(jugador.getPuntos().getCantidad(),2);
    }

    @Test
    public void testPreguntaRecibeRespuestaCorrectaYAsignaLosPuntajesCorrespondientes204(){
        Jugador jugador = new Jugador("Pedro");

        Multiplicador multiplicador = new MultiplicadorPorTres();

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("1+1 es 2");
        PreguntaVerdaderoFalsoPenalidad pregunta2 = new PreguntaVerdaderoFalsoPenalidad("1+1 es 2");

        pregunta.setVerdaderoOpcionCorrecta();
        pregunta2.setVerdaderoOpcionCorrecta();

        RespuestaUnica respuesta = new RespuestaUnica(pregunta.getOpcionVerdadera(),jugador, multiplicador);
        RespuestaUnica respuesta2 = new RespuestaUnica(pregunta2.getOpcionVerdadera(),jugador, multiplicador);

        LinkedList <Respuesta> listaRespuetas= new LinkedList<Respuesta>();

        listaRespuetas.add(respuesta);

        LinkedList <Respuesta> listaRespuetas2= new LinkedList<Respuesta>();

        listaRespuetas.add(respuesta2);

        pregunta.evaluarRespuestas(listaRespuetas);
        pregunta.evaluarRespuestas(listaRespuetas2);

        assertEquals(jugador.getPuntos().getCantidad(),4);
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoPenalidadYVariosJugadoresRespondeEntoncesAsignaPuntos05(){
        Jugador Lucas = new Jugador("Lucas");
        Jugador Juan = new Jugador("Juan");
        Jugador Mati = new Jugador("Mati");
        Jugador Pablo = new Jugador("Pablo");

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("Todas las semanas tienen siete dias");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Lucas));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Mati));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Pablo));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Juan));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        assertEquals(Lucas.getPuntos().getCantidad(),1);
        assertEquals(Juan.getPuntos().getCantidad(),-1);
        assertEquals(Mati.getPuntos().getCantidad(),-1);
        assertEquals(Pablo.getPuntos().getCantidad(),1);
    }
}