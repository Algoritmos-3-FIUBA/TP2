package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.Jugador;

public class MultiplicadorPorTres extends Multiplicador {

    private int factor = 2;

    public MultiplicadorPorTres(Jugador jugador){
        super(jugador);
    }

    @Override
    public int utilizarBeneficio(int puntos) {

        jugador.sumarPuntos(puntos * factor);
        this.inutilizarMultiplicador();

        return puntos;
    }

}
