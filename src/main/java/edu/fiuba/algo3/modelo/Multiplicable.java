package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;

public class Multiplicable implements EstadoMultiplicable {

    @Override
    public Puntos multiplicarPuntos(Puntos cantidadDePuntos, Multiplicador multiplicador){
        cantidadDePuntos.multiplicar(multiplicador.getFactor());
        return (cantidadDePuntos);
    }

}
