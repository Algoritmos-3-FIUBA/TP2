package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.ColeccionOpciones;

public class OpcionCorrecta extends Opcion {

    public OpcionCorrecta(String NombreOpcion, int puntos) {
        super(NombreOpcion, puntos);
    }

    public void agregarseAlGrupoCorrespondiente(ColeccionOpciones opcionesCorrectas, ColeccionOpciones opcionesIncorrectas){
        opcionesCorrectas.agregarOpcion(this);
    }

}