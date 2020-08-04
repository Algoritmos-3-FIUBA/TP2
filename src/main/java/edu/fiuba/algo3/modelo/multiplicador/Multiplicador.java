package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.*;

public abstract class Multiplicador {

    protected Jugador jugador;
    protected EstadoMultiplicable estadoMultiplicable;

    public Multiplicador(Jugador jugador) {
        this.jugador = jugador;
        this.estadoMultiplicable = new Multiplicable();
    }

    public void inutilizarMultiplicador() {
        this.estadoMultiplicable = new NoMultiplicable();
    }

    public abstract void utilizarBeneficio(Puntos puntos);

    public abstract int getFactor();

}



