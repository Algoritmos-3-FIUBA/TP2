package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.amplificador.Amplificador;

public abstract class Multiplicador {

    protected Amplificador amplificador;

    public void inutilizarMultiplicador() {
        amplificador.setFactor(1);
    }

    public int getFactor() {
        return amplificador.getFactor();
    }

    public Amplificador getAmplificador(){
        return amplificador;
    }

}



