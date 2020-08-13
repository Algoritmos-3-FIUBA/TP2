package edu.fiuba.algo3.modelo.amplificador;

import edu.fiuba.algo3.modelo.Puntos;

public class EstadoNoAsignaMas extends EstadoAmplificable{
    @Override
    public void amplificarPuntos(Puntos puntos, int factor){
        puntos.multiplicar(0);
    }

    @Override
    public EstadoAmplificable estadoSiguiente() {
        return this;
    }
}
