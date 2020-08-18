package edu.fiuba.algo3.modelo.exclusividad;

import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.LinkedList;

public class EstrategiaMultiplicativa extends EstrategiaAumentoFactor{

    private int factorBase;

    public EstrategiaMultiplicativa(Amplificador amplificador){
        factorBase = amplificador.getFactor();
    }

    @Override
    public void aumentarFactoresDeExclusividades(LinkedList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas)
            respuesta.actualizarFactorAmplificacion(factorBase);
    }

    @Override
    public void aumentarFactor(int factor, Amplificador amplificador) {
        amplificador.multiplicarFactor(factor);
    }
}
