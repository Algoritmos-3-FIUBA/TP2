package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static  org.junit.jupiter.api.Assertions.assertArrayEquals;

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
        jugador3.sumarPuntos(1);
        assertEquals(Lionel.getPuntos(), 1);
    }

}