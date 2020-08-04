package edu.fiuba.algo3.modelo;

public class MutiplicadorPorDos extends Multiplicador {

    private int factor = 2;

    public MutiplicadorPorDos(Jugador jugador){
        super(jugador);
    }

    @Override
    public void utilizarBeneficio(int puntos) {

        jugador.sumarPuntos(puntos * factor);
        this.inutilizarMultiplicador();

    }

}
