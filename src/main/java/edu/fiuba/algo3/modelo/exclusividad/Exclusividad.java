package edu.fiuba.algo3.modelo.exclusividad;

import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.LinkedList;

public class Exclusividad {

    protected Amplificador amplificador;
    protected EstadoExclusividad estado;
    protected EstrategiaAumentoFactor estrategiaAumentoFactor;

    public Exclusividad(){
        this.amplificador = new Amplificador(2);
        this.estrategiaAumentoFactor = new EstrategiaMultiplicativa(amplificador);
        this.estado = new EstadoNoAsigna();
    }

    public void actualizarAmplificador(LinkedList<Respuesta> respuestas,Respuesta respuestaActual) {
        estrategiaAumentoFactor.aumentarFactoresDeExclusividades(respuestas,respuestaActual);
        notificarUsoDeExclusividad(respuestas);
    }

    private void notificarUsoDeExclusividad(LinkedList<Respuesta> respuestas){
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

    public void aumentarAmplificador(int factor) {
        estrategiaAumentoFactor.aumentarFactor(factor,amplificador);
    }
}