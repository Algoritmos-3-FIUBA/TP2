package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Multiplicable;
import edu.fiuba.algo3.modelo.Puntos;

public class MultiplicadorDefault extends Multiplicador {

    private int factor = 1;

    public MultiplicadorDefault(Jugador jugador){
        super(jugador);
        this.estadoMultiplicable = new Multiplicable();
    }

    public int getFactor() {return factor;}

    @Override
    public void utilizarBeneficio(Puntos puntos) {
        jugador.sumarPuntos(estadoMultiplicable.multiplicarPuntos(puntos, this));
    }

}
