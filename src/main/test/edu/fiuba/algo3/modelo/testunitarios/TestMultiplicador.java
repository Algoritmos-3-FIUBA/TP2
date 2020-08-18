package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorDefault;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorDos;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorTres;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMultiplicador {

    @Test
    public void testCreoMultiplicadorDefaultYSuFactorEsUno01() {
        MultiplicadorDefault multiplicador = new MultiplicadorDefault();
        assertEquals(multiplicador.getFactor(),1);
    }

    @Test
    public void testCreoMultiplicadorPorDostYSuFactorEsDos02() {
        MultiplicadorPorDos multiplicador = new MultiplicadorPorDos();
        assertEquals(multiplicador.getFactor(),2);
    }

    @Test
    public void testCreoMultiplicadorPorTrestYSuFactorEsTres03() {
        MultiplicadorPorTres multiplicador = new MultiplicadorPorTres();
        assertEquals(multiplicador.getFactor(),3);
    }

    @Test
    public void testCreoMultiplicadorPorDosConEstadoMultiplicableYDevuelveLosPuntosMultiplicados04() {
        MultiplicadorPorDos multiplicador = new MultiplicadorPorDos();

        Jugador jugador = new Jugador("Carlos");
        Puntos puntosAux = new Puntos(5);

        multiplicador.utilizarBeneficio(puntosAux, jugador);

        assertEquals((jugador.getPuntos()).getCantidad(), 10);
    }

    @Test
    public void testCreoMultiplicadorPorTresConEstadoMultiplicableYDevuelveLosPuntosMultiplicados05() {
        MultiplicadorPorTres multiplicador = new MultiplicadorPorTres();

        Jugador jugador = new Jugador("Carlos");
        Puntos puntosAux = new Puntos(5);

        multiplicador.utilizarBeneficio(puntosAux, jugador);

        assertEquals((jugador.getPuntos()).getCantidad(), 15);
    }

    @Test
    public void testCreoMultiplicadorPorDefaultYDevuelveLosPuntosDelJugador06() {
        MultiplicadorDefault multiplicador = new MultiplicadorDefault();

        Jugador jugador = new Jugador("Carlos");
        Puntos puntosAux = new Puntos(5);

        multiplicador.utilizarBeneficio(puntosAux, jugador);

        assertEquals((jugador.getPuntos()).getCantidad(), 5);
    }

    @Test
    public void testCreoMultiplicadorPorDosYLoPuedoUtilizarUnaSolaVez07() {
        MultiplicadorPorDos multiplicador = new MultiplicadorPorDos();

        Jugador jugador = new Jugador("Carlos");
        Puntos puntosAux = new Puntos(5);

        multiplicador.utilizarBeneficio(puntosAux, jugador);

        assertEquals((jugador.getPuntos()).getCantidad(), 10);

        multiplicador.utilizarBeneficio(puntosAux, jugador);

        assertEquals((jugador.getPuntos()).getCantidad(), 20);
    }
}