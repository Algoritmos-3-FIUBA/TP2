package edu.fiuba.algo3.modelo.exclusividad;

import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.amplificador.FactorExclusividad;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.LinkedList;

public class ExclusividadDefault extends Exclusividad {

    public ExclusividadDefault(){
        amplificador = new Amplificador(new FactorExclusividad(1));
        estado = new EstadoNoAsigna();
    }

    public void actualizarAmplificador(LinkedList<Respuesta> respuestas,Respuesta respuestaActual) {
    }
}