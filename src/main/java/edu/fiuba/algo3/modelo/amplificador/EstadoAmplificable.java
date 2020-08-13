package edu.fiuba.algo3.modelo.amplificador;

import edu.fiuba.algo3.modelo.Puntos;

public abstract class EstadoAmplificable {
    public abstract void amplificarPuntos(Puntos puntos, int factor);

    public abstract EstadoAmplificable estadoSiguiente();
}
