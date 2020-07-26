package edu.fiuba.algo3.modelo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugador {

    @Test
    public void CreoJugadorLlamadoJuanObtengoNombreJuan(){
        Jugador Juan = new Jugador("Juan");
        assertEquals(Juan.getNombre(), "Juan");
    }

    @Test
    public void CreoJugadorLlamadoPedroNoTienePuntosInicialesObtengo0Puntos(){
        Jugador Pedro = new Jugador("Pedro");
        assertEquals(Pedro.getPuntos(), 0);
    }
    @Test
    public void CreoJugadorLlamadoPedroNoTienePuntosInicialesLeSumo1PuntoTiene1Punto() {
        Jugador Lionel = new Jugador("Lionel");
        Lionel.sumarPuntos(1);
        assertEquals(Lionel.getPuntos(), 1);
    }

}