package edu.fiuba.algo3.modelo;

import java.util.HashSet;

public class OpcionCorrecta extends Opcion {

    public OpcionCorrecta(String NombreOpcion, int puntos) {
        super(NombreOpcion, puntos);
    }

    public void agregarseALaListaCorrespondiente(HashSet<OpcionCorrecta> opcionesCorrectas, HashSet<OpcionIncorrecta> opcionesIncorrectas){
        opcionesCorrectas.add(this);
    }

}