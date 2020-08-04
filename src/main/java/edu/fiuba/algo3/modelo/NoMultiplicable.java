package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;

public class NoMultiplicable implements EstadoMultiplicable {

    @Override

   public int multiplicarPuntos(int cantidadDePuntos, Multiplicador multiplicador){

        return cantidadDePuntos;
    }

}
