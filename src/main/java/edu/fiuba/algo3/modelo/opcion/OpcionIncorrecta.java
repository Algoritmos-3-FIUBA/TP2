package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.respuesta.EstadoIncorrecto;
import edu.fiuba.algo3.modelo.respuesta.EstadoRespuesta;

public class OpcionIncorrecta extends Opcion {

    public OpcionIncorrecta(String NombreOpcion) {
        super(NombreOpcion);
    }

    public OpcionIncorrecta(String NombreOpcion, int puntos) {
        super(NombreOpcion, puntos);
    }

    public void agregarseAlGrupoCorrespondiente(ColeccionOpciones opcionesCorrectas, ColeccionOpciones opcionesIncorrectas){
        opcionesIncorrectas.agregarOpcion(this);
    }

    @Override
    public EstadoRespuesta asignarEstado() {
        return new EstadoIncorrecto();
    }
}