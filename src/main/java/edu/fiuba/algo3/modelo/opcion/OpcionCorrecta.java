package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.respuesta.EstadoCorrecto;
import edu.fiuba.algo3.modelo.respuesta.EstadoRespuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;

public class OpcionCorrecta extends Opcion {

    public OpcionCorrecta(String NombreOpcion) {
        super(NombreOpcion);
    }

    public OpcionCorrecta(String NombreOpcion, int puntos) {
        super(NombreOpcion, puntos);
    }

    public void agregarseAlGrupoCorrespondiente(ColeccionOpciones opcionesCorrectas, ColeccionOpciones opcionesIncorrectas){
        opcionesCorrectas.agregarOpcion(this);
    }

    @Override
    public void corregirRespuesta(RespuestaUnica respuestaUnica) {
        respuestaUnica.esCorrecta();
    }
}