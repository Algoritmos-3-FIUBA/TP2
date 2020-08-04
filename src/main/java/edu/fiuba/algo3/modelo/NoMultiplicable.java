package edu.fiuba.algo3.modelo;

public class NoMultiplicable implements EstadoMultiplicable {

    @Override

    int multiplicarPuntos(int cantidadDePuntos, Multiplicador multiplicador){
        return cantidadDePuntos;
    }

}
