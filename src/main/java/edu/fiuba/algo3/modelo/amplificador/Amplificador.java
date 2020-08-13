package edu.fiuba.algo3.modelo.amplificador;

import edu.fiuba.algo3.modelo.Puntos;

public class Amplificador {

    private int factor;
    private EstadoAmplificable estado;

    public Amplificador(int factor){
        this.estado = new EstadoAsigna();
        this.factor = factor;
    }

    public void inutilizar(){
        this.estado = new EstadoNoAsigna();
    }

    public void amplificarPuntos(Puntos puntos){
        estado.amplificarPuntos(puntos,this.factor);
    }

    public int getFactor(){
        return factor;
    }

    public void multiplicarFactor(int factor) {
        this.factor *= factor;
    }

    public void hayRespuestaCorrecta() {
        estado = estado.estadoSiguiente();
    }

    public void asignaSiempre() {
        this.estado = new EstadoAsignaSiempre();
    }
}