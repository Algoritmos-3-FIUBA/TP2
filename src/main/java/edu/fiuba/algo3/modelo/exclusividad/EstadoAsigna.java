package edu.fiuba.algo3.modelo.exclusividad;

import edu.fiuba.algo3.modelo.amplificador.Amplificador;

public class EstadoAsigna extends EstadoExclusividad {

    @Override
    public EstadoExclusividad estadoSiguiente() {
        return new EstadoNoAsignaMas();
    }

    @Override
    public void establecerAmplificadorRequerido(Amplificador amplificador) {

    }
}