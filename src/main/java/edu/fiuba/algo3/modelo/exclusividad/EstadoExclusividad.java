package edu.fiuba.algo3.modelo.exclusividad;

import edu.fiuba.algo3.modelo.amplificador.Amplificador;

public abstract class EstadoExclusividad {

    public abstract EstadoExclusividad estadoSiguiente();

    public abstract void establecerAmplificadorRequerido(Amplificador amplificador);
}
