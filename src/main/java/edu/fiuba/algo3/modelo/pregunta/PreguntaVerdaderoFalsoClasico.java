package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
import edu.fiuba.algo3.modelo.respuesta.RespuestaVerdaderoFalsoClasico;

import java.util.LinkedList;

public class PreguntaVerdaderoFalsoClasico extends PreguntaVerdaderoFalso {

    public PreguntaVerdaderoFalsoClasico(String nombrePregunta) {
        super(nombrePregunta);
    }

    @Override
    public void setVerdaderoOpcionCorrecta() {

        opcionFalso = new OpcionIncorrecta("Falso", 0);
        opcionVerdadero = new OpcionCorrecta("Verdadero", 1);

    }

    @Override
    public void setFalsoOpcionCorrecta() {

        opcionFalso = new OpcionCorrecta("Falso",1);
        opcionVerdadero = new OpcionIncorrecta("Verdadero",0);

    }

}
