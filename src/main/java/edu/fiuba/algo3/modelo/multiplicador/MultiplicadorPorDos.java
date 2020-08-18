package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.amplificador.Amplificador;

public class MultiplicadorPorDos extends Multiplicador {

    public MultiplicadorPorDos(){
        this.amplificador = new Amplificador(2);
    }
}