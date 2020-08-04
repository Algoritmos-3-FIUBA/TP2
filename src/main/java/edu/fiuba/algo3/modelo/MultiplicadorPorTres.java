package edu.fiuba.algo3.modelo;

public class MutiplicadorPorDos extends Multiplicador {

    private int factor = 3;

    public MutiplicadorPorDos(Jugador jugador, EstadoMultiplicable estado) {

        this.jugador = jugador;
        this.estadoMultiplicable = estado;
    }

    @Override
    public void utilizarBeneficio(int puntos) {

        jugador.sumarPuntos(puntos * factor);
        this.inutilizarMultiplicador();

    }

}