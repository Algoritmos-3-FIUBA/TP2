package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static  org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestJugador {
    @Test
   public void CreoJugadorLlamadoJuanObtengoNombreJuan(){
        Jugador jugador1 = new Jugador("Juan");
        assertEquals(jugador1.getNombre(), "Juan");
    }
    @Test
    public void CreoJugadorLlamadoPedroNoTienePuntosInicialesObtengo0Puntos(){
        Jugador jugadorPedro = new Jugador("Pedro");
        assertEquals(jugadorPedro.getPuntos(), 0);
    }

}
