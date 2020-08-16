package edu.fiuba.algo3.modelo.exclusividad;

import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.amplificador.FactorDefault;

public class EstadoNoAsignaMas extends EstadoExclusividad {

    @Override
    public EstadoExclusividad estadoSiguiente() {
        return this;
    }

    @Override
    public void establecerAmplificadorRequerido(Amplificador amplificador) {
        amplificador.setFactor(new FactorDefault(0));
    }
}
