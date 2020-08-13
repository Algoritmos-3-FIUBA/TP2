package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.respuesta.EstadoCorrecto;
import edu.fiuba.algo3.modelo.respuesta.EstadoRespuesta;

public class OpcionCorrecta extends Opcion {

    public OpcionCorrecta(String NombreOpcion, int puntos) {
        super(NombreOpcion, puntos);
    }

    public void agregarseAlGrupoCorrespondiente(ColeccionOpciones opcionesCorrectas, ColeccionOpciones opcionesIncorrectas){
        opcionesCorrectas.agregarOpcion(this);
    }

    @Override
    public EstadoRespuesta asignarEstado() {
        return new EstadoCorrecto();
    }


}