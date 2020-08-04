package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicador.MutiplicadorPorDos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaVerdaderoFalsoPenalidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRespuestaVerdaderoFalsoPenalidad {

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaSinMultiplicadorPorDosYObtienePuntaje(){

        Opcion opcionVerdadero = new OpcionCorrecta("Sabado",1);

        Jugador jugador = new Jugador("Guido");

        RespuestaVerdaderoFalsoPenalidad respuestaJugador = new RespuestaVerdaderoFalsoPenalidad(opcionVerdadero, jugador);

        respuestaJugador.otorgarPuntos();

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),1);
    }


    @Test
    public void JugadorRealizaUnaRespuestaCorrectaConMultiplicadorPorDosYObtienePuntaje(){

        Opcion opcionVerdadero = new OpcionCorrecta("Sabado",1);

        Jugador jugador = new Jugador("Guido");
        Multiplicador multiplicador = new MutiplicadorPorDos(jugador);

        RespuestaVerdaderoFalsoPenalidad respuestaJugador = new RespuestaVerdaderoFalsoPenalidad(opcionVerdadero, multiplicador);

        respuestaJugador.otorgarPuntos();

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),2);
    }

}
