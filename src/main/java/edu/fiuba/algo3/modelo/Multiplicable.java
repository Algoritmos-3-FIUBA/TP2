package edu.fiuba.algo3.modelo;

public class Multiplicable implements EstadoMultiplicable {

    @Override

    int multiplicarPuntos(int cantidadDePuntos, Multiplicador multiplicador){
        return multiplicador.utilizarBeneficio(cantidadDePuntos);
    }

}
