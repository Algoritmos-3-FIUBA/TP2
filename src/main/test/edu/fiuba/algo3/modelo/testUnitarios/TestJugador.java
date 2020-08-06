package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugador {

    @Test
    public void CreoJugadorLlamadoJuanObtengoNombreJuan(){
        Jugador Juan = new Jugador("Juan");
        assertEquals(Juan.getNombre(), "Juan");
    }

    @Test
    public void CreoJugadorLlamadoJuanObtengoNombreLucas(){
        Jugador Juan = new Jugador("Lucas");
        assertEquals(Juan.getNombre(), "Lucas");
    }


    @Test
    public void CreoJugadorLlamadoPedroNoTienePuntosInicialesObtengo0Puntos(){
        Jugador Pedro = new Jugador("Pedro");
        Puntos puntos = Pedro.getPuntos();
        assertEquals(puntos.getCantidad(), 0);
    }
    @Test
    public void CreoJugadorLlamadoPedroNoTienePuntosInicialesLeSumo1PuntoTiene1Punto() {
        Jugador Pedro = new Jugador("Pedro");
        Pedro.sumarPuntos(new Puntos(1));
        assertEquals(Pedro.getPuntos().getCantidad(), 1);
    }

    @Test
    public void CreoJugadorLlamadoLucasSumaPuntos() {
        Jugador Lucas = new Jugador("Lucas");
        Lucas.sumarPuntos(new Puntos(1));
        Lucas.sumarPuntos(new Puntos(3));
        assertEquals(Lucas.getPuntos().getCantidad(), 4);
        Lucas.sumarPuntos(new Puntos(-1));
        assertEquals(Lucas.getPuntos().getCantidad(), 3);
    }
}