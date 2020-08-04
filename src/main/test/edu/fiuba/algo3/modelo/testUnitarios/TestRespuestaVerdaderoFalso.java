package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaVerdaderoFalsoClasico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestRespuestaVerdaderoFalso {
    private Opcion opcionVerdadero;
    private Opcion opcionFalso;

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaYObtienePuntaje(){
        opcionVerdadero = new OpcionCorrecta("Euler",1);

        Jugador jugador = new Jugador("Guido");
        RespuestaVerdaderoFalsoClasico respuestaJugador = new RespuestaVerdaderoFalsoClasico(opcionVerdadero, jugador);

        respuestaJugador.otorgarPuntos();

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaYNoObtienePuntaje(){
        opcionFalso = new OpcionCorrecta("Gauss",0);

        Jugador jugador = new Jugador("Guido");
        RespuestaVerdaderoFalsoClasico respuestaJugador = new RespuestaVerdaderoFalsoClasico(opcionFalso, jugador);

        respuestaJugador.otorgarPuntos();

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),0);
    }
}
