package edu.fiuba.algo3.modelo.exclusividad;

import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.LinkedList;

public class ExclusividadDefault extends Exclusividad {

    public ExclusividadDefault(){
        amplificador = new Amplificador(1);
        amplificador.asignaSiempre();
    }

    public void actualizarAmplificador(Amplificador amplificador, LinkedList<Respuesta> respuestas) { }
}
