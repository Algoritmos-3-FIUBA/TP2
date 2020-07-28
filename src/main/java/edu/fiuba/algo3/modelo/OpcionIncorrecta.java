package edu.fiuba.algo3.modelo;

import java.util.HashSet;

public class OpcionIncorrecta extends Opcion {

    public OpcionIncorrecta(String NombreOpcion, int puntos) {
        super(NombreOpcion, puntos);
    }

    public void agregarseALaListaCorrespondiente(HashSet<OpcionCorrecta> opcionesCorrectas, HashSet<OpcionIncorrecta> opcionesIncorrectas){
        opcionesIncorrectas.add(this);
    }

}
