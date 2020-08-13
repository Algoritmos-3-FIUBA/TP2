package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.LinkedList;

public class Exclusividad {
    protected Amplificador amplificador;

    public void actualizarAmplificador(Amplificador amplificador, LinkedList<Respuesta> respuestas) {
        amplificador.multiplicarFactor(amplificador.getFactor());
        for (Respuesta respuesta : respuestas)
            respuesta.setAmplificador(amplificador);
    }
}