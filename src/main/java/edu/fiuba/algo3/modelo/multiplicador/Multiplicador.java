package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.EstadoMultiplicable;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Multiplicable;
import edu.fiuba.algo3.modelo.NoMultiplicable;

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

    public abstract int utilizarBeneficio(int puntos);

}



