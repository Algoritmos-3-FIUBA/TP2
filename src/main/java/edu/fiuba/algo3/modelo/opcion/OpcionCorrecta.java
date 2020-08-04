package edu.fiuba.algo3.modelo.opcion;

import java.util.HashSet;
import java.util.LinkedList;

public class OpcionCorrecta extends Opcion {

    public OpcionCorrecta(String NombreOpcion, int puntos) {
        super(NombreOpcion, puntos);
    }

    public void agregarseALaListaCorrespondiente(HashSet<OpcionCorrecta> opcionesCorrectas, HashSet<OpcionIncorrecta> opcionesIncorrectas){
        opcionesCorrectas.add(this);
    }

    public void agregarseALaListaCorrespondienteOrdenada(LinkedList<OpcionCorrecta> opcionesCorrectas, LinkedList<OpcionIncorrecta> opcionesIncorrectas){
        opcionesCorrectas.add(this);
    }

}