package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;

public class MutiplicadorPorDos extends Multiplicador {

    private int factor = 2;

    public MutiplicadorPorDos(Jugador jugador){
        super(jugador);
    }

    public int getFactor() {return factor;}

    @Override
    public void utilizarBeneficio(Puntos puntos) {
        jugador.sumarPuntos(estadoMultiplicable.multiplicarPuntos(puntos, this));
        this.inutilizarMultiplicador();
    }

}
