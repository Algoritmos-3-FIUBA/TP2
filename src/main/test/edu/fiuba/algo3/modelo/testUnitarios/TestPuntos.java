package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Puntos;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPuntos {

    @Test
    public void testPuntosCreadosTieneLaCantidadEsperada01(){
        Puntos puntos = new Puntos(1);
        assertEquals(puntos.getCantidad(), 1);
    }

    @Test
    public void testOtrosPuntosCreadosTieneLaCantidadEsperada02(){
        Puntos puntos = new Puntos(5);
        assertEquals(puntos.getCantidad(), 5);
    }

    @Test
    public void testPuntosCreadosConCantidadNegativaTieneLaCantidadEsperada03(){
        Puntos puntos = new Puntos(-2);
        assertEquals(puntos.getCantidad(), -2);
    }

    @Test
    public void testLeSumoAUnosPuntosOtrosPuntosYSuValorEsElEsperado04(){
        Puntos puntos = new Puntos(1);
        Puntos otrosPuntos = new Puntos(1);

        puntos.sumarPuntos(otrosPuntos);

        assertEquals(puntos.getCantidad(), 2);
    }

    @Test
    public void testLeSumoAOtrosPuntosOtrosPuntosMasYSuValorEsElEsperado05(){
        Puntos puntos = new Puntos(5);
        Puntos otrosPuntos = new Puntos(16);

        puntos.sumarPuntos(otrosPuntos);

        assertEquals(puntos.getCantidad(), 21);
    }

    @Test
    public void testAUnosPuntosLesSumoOtrosNegativosYLaCantidadEsCorrecta06(){
        Puntos puntos = new Puntos(-2);
        Puntos otrosPuntos = new Puntos(2);

        puntos.sumarPuntos(otrosPuntos);

        assertEquals(puntos.getCantidad(), 0);
    }

    @Test
    public void testAlMultiplicarUnosPuntosDevuelveElValorEsperado07(){
        Puntos puntos = new Puntos(1);

        puntos.multiplicar(5);

        assertEquals(puntos.getCantidad(), 5);
    }

    @Test
    public void testAlMultiplicarOtrosPuntosDevuelveElValorEsperado08(){
        Puntos puntos = new Puntos(5);

        puntos.multiplicar(7);

        assertEquals(puntos.getCantidad(), 35);
    }
}