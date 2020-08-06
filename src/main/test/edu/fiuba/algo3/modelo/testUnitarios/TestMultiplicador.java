package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorDefault;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorDos;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorTres;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMultiplicador {

    @Test
    public void CreoMultiplicadorDefaultYSuFactorEsUno() {

        MultiplicadorDefault multiplicador = new MultiplicadorDefault();
        assertEquals(multiplicador.getFactor(),1);

    }

    @Test
    public void CreoMultiplicadorPorDostYSuFactorEsDos() {

        MultiplicadorPorDos multiplicador = new MultiplicadorPorDos();
        assertEquals(multiplicador.getFactor(),2);

    }

    @Test
    public void CreoMultiplicadorPorTrestYSuFactorEsTres() {

        MultiplicadorPorTres multiplicador = new MultiplicadorPorTres();
        assertEquals(multiplicador.getFactor(),3);

    }

    @Test
    public void CreoMultiplicadorPorDosConEstadoMultiplicableYDevuelveLosPuntosMultiplicados() {

        MultiplicadorPorDos multiplicador = new MultiplicadorPorDos();

        Jugador jugador = new Jugador("Carlos");
        Puntos puntosAux = new Puntos(5);

        multiplicador.utilizarBeneficio(puntosAux, jugador);

        assertEquals((jugador.getPuntos()).getCantidad(), 10);

    }

    @Test
    public void CreoMultiplicadorPorTresConEstadoMultiplicableYDevuelveLosPuntosMultiplicados() {

        MultiplicadorPorTres multiplicador = new MultiplicadorPorTres();

        Jugador jugador = new Jugador("Carlos");
        Puntos puntosAux = new Puntos(5);

        multiplicador.utilizarBeneficio(puntosAux, jugador);

        assertEquals((jugador.getPuntos()).getCantidad(), 15);

    }

    @Test
    public void CreoMultiplicadorPorDefaultYDevuelveLosPuntosDelJugador() {

        MultiplicadorDefault multiplicador = new MultiplicadorDefault();

        Jugador jugador = new Jugador("Carlos");
        Puntos puntosAux = new Puntos(5);

        multiplicador.utilizarBeneficio(puntosAux, jugador);

        assertEquals((jugador.getPuntos()).getCantidad(), 5);

    }

    @Test
    public void CreoMultiplicadorPorDosYLoPuedoUtilizarUnaSolaVez() {

        MultiplicadorPorDos multiplicador = new MultiplicadorPorDos();

        Jugador jugador = new Jugador("Carlos");
        Puntos puntosAux = new Puntos(5);

        multiplicador.utilizarBeneficio(puntosAux, jugador);

        assertEquals((jugador.getPuntos()).getCantidad(), 10);

        multiplicador.utilizarBeneficio(puntosAux, jugador);

        assertEquals((jugador.getPuntos()).getCantidad(), 20);

    }

}