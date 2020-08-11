package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.ColeccionOpciones;

public class OpcionIncorrecta extends Opcion {

    public OpcionIncorrecta(String NombreOpcion, int puntos) {
        super(NombreOpcion, puntos);
    }

    public void agregarseAlGrupoCorrespondiente(ColeccionOpciones opcionesCorrectas, ColeccionOpciones opcionesIncorrectas){
        opcionesIncorrectas.agregarOpcion(this);
    }

}
