package edu.fiuba.algo3.modelo.testUnitarios;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorTres;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorDos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestRespuestaUnica {
   private Opcion opcionVerdadero;
    private Opcion opcionFalso;

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaYObtienePuntaje(){
        opcionVerdadero = new OpcionCorrecta("Euler",1);

        Jugador jugador = new Jugador("Guido");
        RespuestaUnica respuestaJugador = new RespuestaUnica(opcionVerdadero, jugador);

        respuestaJugador.otorgarPuntos(new Puntos(1));

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaYNoObtienePuntaje(){
        opcionFalso = new OpcionCorrecta("Gauss",0);

        Jugador jugador = new Jugador("Guido");
        RespuestaUnica respuestaJugador = new RespuestaUnica(opcionFalso, jugador);

        respuestaJugador.otorgarPuntos(new Puntos(0));

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),0);
    }


    @Test
    public void JugadorRealizaUnaRespuestaCorrectaConMultiplicador(){
        opcionFalso = new OpcionCorrecta("Gauss",0);

        MultiplicadorPorDos multiplicadorPorDos = new MultiplicadorPorDos();

        Jugador jugador = new Jugador("Guido");
        RespuestaUnica respuestaJugador = new RespuestaUnica(opcionFalso, jugador,multiplicadorPorDos);

        respuestaJugador.otorgarPuntos(new Puntos(1));

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),2);
    }

    @Test
    public void JugadorRespondeDosCorrectaIntentaUtilizarElMultiplicadorUnaVesUsado(){
        opcionFalso = new OpcionCorrecta("Gauss",0);

        MultiplicadorPorDos multiplicadorPorDos = new MultiplicadorPorDos();

        Jugador jugador = new Jugador("Guido");

        RespuestaUnica respuestaJugador = new RespuestaUnica(opcionFalso, jugador,multiplicadorPorDos);
        RespuestaUnica respuestaJugador2 = new RespuestaUnica(opcionFalso, jugador,multiplicadorPorDos);


        respuestaJugador.otorgarPuntos(new Puntos(1));
        respuestaJugador2.otorgarPuntos(new Puntos(1));

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),3);
    }
    @Test
    public void JugadorRespondeCorrectaEIncorrectaIntentaUtilizarElMultiplicadorUnaVesUsado(){
        opcionFalso = new OpcionCorrecta("Gauss",0);

        MultiplicadorPorDos multiplicadorPorDos = new MultiplicadorPorDos();

        Jugador jugador = new Jugador("Guido");

        RespuestaUnica respuestaJugador = new RespuestaUnica(opcionFalso, jugador,multiplicadorPorDos);
        RespuestaUnica respuestaJugador2 = new RespuestaUnica(opcionFalso, jugador,multiplicadorPorDos);


        respuestaJugador.otorgarPuntos(new Puntos(1));
        respuestaJugador2.otorgarPuntos(new Puntos(-1));

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),1);
    }
    @Test
    public void JugadorUtilizarSusDosMultiplicadores(){
        opcionFalso = new OpcionCorrecta("Gauss",0);

        MultiplicadorPorDos multiplicadorPorDos = new MultiplicadorPorDos();
        MultiplicadorPorTres multiplicadorPorTres = new MultiplicadorPorTres();

        Jugador jugador = new Jugador("Guido");

        RespuestaUnica respuestaJugador = new RespuestaUnica(opcionFalso, jugador,multiplicadorPorDos);
        RespuestaUnica respuestaJugador2 = new RespuestaUnica(opcionFalso, jugador,multiplicadorPorTres);


        respuestaJugador.otorgarPuntos(new Puntos(1));
        respuestaJugador2.otorgarPuntos(new Puntos(1));

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),5);
    }
}
