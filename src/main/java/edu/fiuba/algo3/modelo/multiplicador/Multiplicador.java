package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.amplificador.FactorDefault;

public abstract class Multiplicador {

    protected Amplificador amplificador;

    public void inutilizarMultiplicador() {
        amplificador.setFactor(new FactorDefault(1));
    }

    public void utilizarBeneficio(Puntos puntos, Jugador jugador) {
        amplificador.amplificarPuntos(puntos);
        jugador.sumarPuntos(puntos);
        this.inutilizarMultiplicador();
    }

    public int getFactor() {
        return amplificador.getFactor().getFactor();
    }

    public Amplificador getAmplificador(){
        return amplificador;
    }
}



