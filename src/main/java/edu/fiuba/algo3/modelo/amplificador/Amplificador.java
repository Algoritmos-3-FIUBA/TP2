package edu.fiuba.algo3.modelo.amplificador;

import edu.fiuba.algo3.modelo.Puntos;

public class Amplificador {

    private int factor;

    public Amplificador(int factor){
        this.factor = factor;
    }

    public void amplificarPuntos(Puntos puntos){
        puntos.multiplicar(this.factor);
    }

    public int getFactor(){
        return this.factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public void multiplicarFactor(int factor) {
        this.factor *= factor;
    }

}