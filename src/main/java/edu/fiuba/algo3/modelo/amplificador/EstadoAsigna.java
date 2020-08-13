package edu.fiuba.algo3.modelo.amplificador;

import edu.fiuba.algo3.modelo.Puntos;

public class EstadoAsigna extends EstadoAmplificable{

    @Override
    public void amplificarPuntos(Puntos puntos, int factor){
        puntos.multiplicar(factor);
    }

    @Override
    public EstadoAmplificable estadoSiguiente() {
        return new EstadoNoAsignaMas();
    }

}
