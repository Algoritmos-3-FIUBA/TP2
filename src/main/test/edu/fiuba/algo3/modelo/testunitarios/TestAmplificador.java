package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAmplificador {

    @Test
    public void CreoUnAmplificadorConUnFactorYElFactorDevueltoEsElEsperado(){
        Amplificador amplificador = new Amplificador(5);

        assertEquals(5,amplificador.getFactor());
    }

    @Test
    public void CreoUnAmplificadorConUnFactorSeLoCambioYElFactorDevueltoEsElEsperado(){
        Amplificador amplificador = new Amplificador(5);

        amplificador.setFactor(2);

        assertEquals(2,amplificador.getFactor());
    }

    @Test
    public void UsoAmplificadorParaAmplificarPuntosYLoHaceCorrectamente(){
        Amplificador amplificador = new Amplificador(3);
        Puntos puntos = new Puntos(10);

        amplificador.amplificarPuntos(puntos);

        assertEquals(30,puntos.getCantidad());
    }

    @Test
    public void UsoOtroAmplificadorParaAmplificarOtrosPuntosYLoHaceCorrectamente(){
        Amplificador amplificador = new Amplificador(5);
        Puntos puntos = new Puntos(7);

        amplificador.amplificarPuntos(puntos);

        assertEquals(35,puntos.getCantidad());
    }

    @Test
    public void LeMultiplicoElFactorAUnAmplificadorYLoHaceCorrectamente(){
        Amplificador amplificador = new Amplificador(5);

        amplificador.multiplicarFactor(2);

        assertEquals(10,amplificador.getFactor());
    }
}
