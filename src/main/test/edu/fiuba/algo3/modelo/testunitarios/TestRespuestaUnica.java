package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorTres;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorDos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuestaUnica {

    @Test
    public void testJugadorRealizaUnaRespuestaCorrectaYObtienePuntaje01(){
        Opcion opcionVerdadero = new OpcionCorrecta("Euler");

        Jugador jugador = new Jugador("Guido");
        RespuestaUnica respuestaJugador = new RespuestaUnica(opcionVerdadero, jugador);

        respuestaJugador.esCorrecta();
        respuestaJugador.otorgarPuntos(new Puntos(1));

        assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void testJugadorRealizaUnaRespuestaIncorrectaYNoObtienePuntaje02(){
        Opcion opcionFalso = new OpcionCorrecta("Gauss");

        Jugador jugador = new Jugador("Guido");
        RespuestaUnica respuestaJugador = new RespuestaUnica(opcionFalso, jugador);

        respuestaJugador.otorgarPuntos(new Puntos(0));

        assertEquals(jugador.getPuntos().getCantidad(),0);
    }

    @Test
    public void testJugadorRealizaUnaRespuestaCorrectaConMultiplicador03(){
        Opcion opcionFalso = new OpcionCorrecta("Gauss");

        MultiplicadorPorDos multiplicadorPorDos = new MultiplicadorPorDos();

        Jugador jugador = new Jugador("Guido");
        RespuestaUnica respuestaJugador = new RespuestaUnica(opcionFalso, jugador,multiplicadorPorDos);

        respuestaJugador.esCorrecta();
        respuestaJugador.otorgarPuntos(new Puntos(1));

        assertEquals(jugador.getPuntos().getCantidad(),2);
    }

    @Test
    public void testJugadorRespondeDosCorrectaIntentaUtilizarElMultiplicadorUnaVezUsado04(){
        Opcion opcionFalso = new OpcionCorrecta("Gauss");

        MultiplicadorPorDos multiplicadorPorDos = new MultiplicadorPorDos();

        Jugador jugador = new Jugador("Guido");

        RespuestaUnica respuestaJugador = new RespuestaUnica(opcionFalso, jugador,multiplicadorPorDos);
        RespuestaUnica respuestaJugador2 = new RespuestaUnica(opcionFalso, jugador,multiplicadorPorDos);

        respuestaJugador.esCorrecta();
        respuestaJugador.otorgarPuntos(new Puntos(1));
        respuestaJugador2.esCorrecta();
        respuestaJugador2.otorgarPuntos(new Puntos(1));

        assertEquals(jugador.getPuntos().getCantidad(),3);
    }

    @Test
    public void testJugadorRespondeCorrectaEIncorrectaIntentaUtilizarElMultiplicadorUnaVezUsado05(){
        Opcion opcionFalso = new OpcionCorrecta("Gauss");

        MultiplicadorPorDos multiplicadorPorDos = new MultiplicadorPorDos();

        Jugador jugador = new Jugador("Guido");

        RespuestaUnica respuestaJugador = new RespuestaUnica(opcionFalso, jugador,multiplicadorPorDos);
        RespuestaUnica respuestaJugador2 = new RespuestaUnica(opcionFalso, jugador,multiplicadorPorDos);

        respuestaJugador.esCorrecta();
        respuestaJugador.otorgarPuntos(new Puntos(1));
        respuestaJugador2.esCorrecta();
        respuestaJugador2.otorgarPuntos(new Puntos(-1));

        assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void testCreoLaRespuestaMultipleYSuAmplificadorTieneElFactorEsperado() {
        Jugador jugador = new Jugador("Guido");

        Opcion opcionFalso = new OpcionCorrecta("Gauss");

        RespuestaUnica respuestaJugador = new RespuestaUnica(opcionFalso, jugador);

        assertEquals(respuestaJugador.getAmplificador().getFactor(), 1);
    }

    @Test
    public void testCreoLaRespuestaGroupChoiceYModificoSuAmplificadorYTieneElFactorNuevoEsperado() {
        Jugador jugador = new Jugador("Guido");

        Opcion opcionFalso = new OpcionCorrecta("Gauss");

        RespuestaUnica respuestaJugador = new RespuestaUnica(opcionFalso, jugador);

        respuestaJugador.getAmplificador().setFactor(2);

        assertEquals(respuestaJugador.getAmplificador().getFactor(), 2);
    }

    @Test
    public void testJugadorUtilizarSusDosMultiplicadores06(){
        Opcion opcionFalso = new OpcionCorrecta("Gauss");

        MultiplicadorPorDos multiplicadorPorDos = new MultiplicadorPorDos();
        MultiplicadorPorTres multiplicadorPorTres = new MultiplicadorPorTres();

        Jugador jugador = new Jugador("Guido");

        RespuestaUnica respuestaJugador = new RespuestaUnica(opcionFalso, jugador,multiplicadorPorDos);
        RespuestaUnica respuestaJugador2 = new RespuestaUnica(opcionFalso, jugador,multiplicadorPorTres);

        respuestaJugador.esCorrecta();
        respuestaJugador.otorgarPuntos(new Puntos(1));
        respuestaJugador2.esCorrecta();
        respuestaJugador2.otorgarPuntos(new Puntos(1));

        assertEquals(jugador.getPuntos().getCantidad(),5);
    }
}