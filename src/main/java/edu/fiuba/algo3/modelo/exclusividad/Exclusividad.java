package edu.fiuba.algo3.modelo.exclusividad;

import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.amplificador.FactorExclusividad;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.LinkedList;

public class Exclusividad {

    protected Amplificador amplificador;
    protected EstadoExclusividad estado;

    public Exclusividad(){
        this.amplificador = new Amplificador(new FactorExclusividad(2));
        this.estado = new EstadoNoAsigna();
    }

    public void actualizarAmplificador(LinkedList<Respuesta> respuestas,Respuesta respuestaActual) {
        LinkedList<Respuesta> respuestasSinLaActual = new LinkedList<>(respuestas);
        respuestasSinLaActual.remove(respuestaActual);
        for (Respuesta respuesta : respuestasSinLaActual)
            respuesta.getAmplificadorExclusividad().multiplicarFactor(this.amplificador);
        for (Respuesta respuesta : respuestas)
            respuesta.setAmplificadorExclusividad();
    }

    public void establecerAmplificadorRequerido() {
        estado.establecerAmplificadorRequerido(this.amplificador);
    }

    public void hayRespuestaCorrecta() {
        estado = estado.estadoSiguiente();
    }

    public Amplificador getAmplificador() {
        return amplificador;
    }
}