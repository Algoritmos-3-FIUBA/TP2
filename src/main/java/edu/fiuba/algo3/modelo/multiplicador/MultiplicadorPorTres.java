package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;

public class MultiplicadorPorTres extends Multiplicador {

    private int factor = 2;

    public MultiplicadorPorTres(Jugador jugador){
        super(jugador);
    }

    @Override
    public int getFactor() {
        return 0;
    }

    @Override
    public void utilizarBeneficio(Puntos puntos) {
        jugador.sumarPuntos(estadoMultiplicable.multiplicarPuntos(puntos, this));
        this.inutilizarMultiplicador();
    }

}
