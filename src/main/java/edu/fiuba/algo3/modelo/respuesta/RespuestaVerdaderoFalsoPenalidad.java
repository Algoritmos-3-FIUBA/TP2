package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoice;

public class RespuestaVerdaderoFalsoPenalidad extends Respuesta {

    private Opcion opcion;
    private Multiplicador multiplicador;

    public RespuestaVerdaderoFalsoPenalidad (Opcion opcion, Multiplicador multiplicador) {
        this.opcion = opcion;
        this.multiplicador = multiplicador;
    }

    public void otorgarPuntos() {
        multiplicador.utilizarBeneficio(opcion.puntosObtenidos());
    }

}
