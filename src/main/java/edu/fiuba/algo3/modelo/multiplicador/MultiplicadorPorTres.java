package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;

public class MultiplicadorPorTres extends Multiplicador {

    private int factor = 2;

    public MultiplicadorPorTres(Jugador jugador){
        super(jugador);
    }

    @Override
    public Puntos utilizarBeneficio(Puntos puntos) {
        puntos.multiplicar(factor);
        jugador.sumarPuntos(puntos);
        this.inutilizarMultiplicador();

        return puntos;
    }

}
