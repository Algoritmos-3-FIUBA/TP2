package edu.fiuba.algo3.modelo.multiplicador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.amplificador.Amplificador;

public class MultiplicadorPorTres extends Multiplicador {

    public MultiplicadorPorTres(){
        amplificador = new Amplificador(3);
    }

}
