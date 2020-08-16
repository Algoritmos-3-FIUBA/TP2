package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.amplificador.FactorDefault;

public class MultiplicadorDefault extends Multiplicador {

    public MultiplicadorDefault(){
        this.amplificador = new Amplificador(new FactorDefault(1));
    }
}
