package edu.fiuba.algo3.modelo.exclusividad;

import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.LinkedList;

public class Exclusividad {
    protected Amplificador amplificador;

    public Exclusividad(){
        this.amplificador = new Amplificador(2);
        this.amplificador.inutilizar();
    }

    public void actualizarAmplificador(Amplificador amplificador, LinkedList<Respuesta> respuestas) {
        amplificador.multiplicarFactor(this.amplificador.getFactor());
        for (Respuesta respuesta : respuestas)
            respuesta.setAmplificador(amplificador);
    }
}