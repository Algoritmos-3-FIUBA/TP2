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


}