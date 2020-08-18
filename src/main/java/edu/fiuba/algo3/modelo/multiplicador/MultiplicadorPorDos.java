package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.amplificador.FactorDefault;

public class MultiplicadorPorDos extends Multiplicador {

    public MultiplicadorPorDos(){
        this.amplificador = new Amplificador(new FactorDefault(2));
    }
}