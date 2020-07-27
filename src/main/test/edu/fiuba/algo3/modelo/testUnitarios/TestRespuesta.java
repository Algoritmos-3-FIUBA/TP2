package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Respuesta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestRespuesta {
    private Opcion opcionVerdadero;
    private Opcion opcionFalso;

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaYObtienePuntaje(){
        opcionVerdadero = new OpcionCorrecta("Euler",1);

        Jugador jugador = new Jugador("Guido");
        Respuesta respuestaJugador = new Respuesta(opcionVerdadero, jugador);

        respuestaJugador.otorgarPuntos();

        Assertions.assertEquals(jugador.getPuntos(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaYNoObtienePuntaje(){
        opcionFalso = new OpcionCorrecta("Gauss",0);

        Jugador jugador = new Jugador("Guido");
        Respuesta respuestaJugador = new Respuesta(opcionFalso, jugador);

        respuestaJugador.otorgarPuntos();

        Assertions.assertEquals(jugador.getPuntos(),0);
    }
}
