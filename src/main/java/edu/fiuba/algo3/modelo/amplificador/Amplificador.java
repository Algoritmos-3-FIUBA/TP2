package edu.fiuba.algo3.modelo.amplificador;

import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.exclusividad.EstadoAsigna;
import edu.fiuba.algo3.modelo.exclusividad.EstadoNoAsigna;

public class Amplificador {

    private Factor factor;

    public Amplificador(Factor factor){
        this.factor = factor;
    }

    public void amplificarPuntos(Puntos puntos){
        puntos.multiplicar(this.factor.getFactor());
    }

    public Factor getFactor(){
        return this.factor;
    }

    public void setFactor(Factor factor) {
        this.factor = factor;
    }

    private void multiplicarFactor(Factor factor) {
        this.factor.multiplicar(factor);
    }

    public void multiplicarFactor(Amplificador amplificador) {
        this.multiplicarFactor(amplificador.getFactor());
    }
}