package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.amplificador.Amplificador;

public abstract class Multiplicador {

    protected Amplificador amplificador;

    public void inutilizarMultiplicador() {
        amplificador.setFactor(1);
    }

    public void utilizarBeneficio(Puntos puntos, Jugador jugador) {
        amplificador.amplificarPuntos(puntos);
        jugador.sumarPuntos(puntos);
        this.inutilizarMultiplicador();
    }

    public int getFactor() {
        return amplificador.getFactor();
    }

    public Amplificador getAmplificador(){
        return amplificador;
    }

}



