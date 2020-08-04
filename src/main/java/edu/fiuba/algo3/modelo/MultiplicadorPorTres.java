package edu.fiuba.algo3.modelo;

public class MultiplicadorPorTres extends Multiplicador{

    private int factor = 2;

    public MultiplicadorPorTres(Jugador jugador){
        super(jugador);
    }

    @Override
    public void utilizarBeneficio(int puntos) {

        jugador.sumarPuntos(puntos * factor);
        this.inutilizarMultiplicador();

    }

}
