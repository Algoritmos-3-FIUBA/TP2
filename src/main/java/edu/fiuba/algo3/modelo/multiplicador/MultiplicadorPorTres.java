package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;

public class MultiplicadorPorTres extends Multiplicador {

    private final int factor = 3;

    @Override
    public int getFactor() {
        return factor;
    }

    @Override
    public void utilizarBeneficio(Puntos puntos, Jugador jugador) {
        jugador.sumarPuntos(estadoMultiplicable.multiplicarPuntos(puntos, this));
        this.inutilizarMultiplicador();
    }

}
