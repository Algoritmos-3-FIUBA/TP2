package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.Jugador;

public class MultiplicadorPorTres extends Multiplicador {

    private int factor = 2;

    public MultiplicadorPorTres(Jugador jugador){
        super(jugador);
    }

    @Override
    public void utilizarBeneficio(int puntos) {

        jugador.sumarPuntos(estadoMultiplicable.multiplicarPuntos(puntos, this));
        this.inutilizarMultiplicador();
    }

}
