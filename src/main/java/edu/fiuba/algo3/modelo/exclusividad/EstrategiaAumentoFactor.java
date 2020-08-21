package edu.fiuba.algo3.modelo.exclusividad;

import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.LinkedList;

public abstract class EstrategiaAumentoFactor {
    public abstract void aumentarFactoresDeExclusividades(LinkedList<Respuesta> respuestas, Respuesta respuestaActual);

    public abstract void aumentarFactor(int factor, Amplificador amplificador);
}
