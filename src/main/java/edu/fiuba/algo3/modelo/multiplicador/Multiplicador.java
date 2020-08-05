package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.*;

public abstract class Multiplicador {

    protected EstadoMultiplicable estadoMultiplicable;

    public Multiplicador(){
        this.estadoMultiplicable = new Multiplicable();
    }

    public void inutilizarMultiplicador() {
        this.estadoMultiplicable = new NoMultiplicable();
    }

    public abstract void utilizarBeneficio(Puntos puntos, Jugador jugador);

    public abstract int getFactor();

}



