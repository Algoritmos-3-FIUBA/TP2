package edu.fiuba.algo3.modelo.opcion;

import java.util.HashSet;

public class OpcionIncorrecta extends Opcion {

    public OpcionIncorrecta(String NombreOpcion, int puntos) {
        super(NombreOpcion, puntos);
    }

    public void agregarseALaListaCorrespondiente(HashSet<OpcionCorrecta> opcionesCorrectas, HashSet<OpcionIncorrecta> opcionesIncorrectas){
        opcionesIncorrectas.add(this);
    }

   /* public void agregarseALaListaCorrespondienteOrdenada(LinkedList<OpcionCorrecta> opcionesCorrectas, LinkedList<OpcionIncorrecta> opcionesIncorrectas){
        opcionesIncorrectas.add(this);
    }*/

}
