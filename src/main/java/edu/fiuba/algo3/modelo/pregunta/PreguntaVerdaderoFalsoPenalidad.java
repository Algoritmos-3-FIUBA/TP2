package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;

public class PreguntaVerdaderoFalsoPenalidad extends PreguntaVerdaderoFalso {

    public PreguntaVerdaderoFalsoPenalidad(String nombrePregunta){ super(nombrePregunta); }

    @Override
    public void setVerdaderoOpcionCorrecta() {

        opcionFalso = new OpcionIncorrecta("Falso", -1);
        opcionVerdadero = new OpcionCorrecta("Verdadero", 1);

    }

    @Override
    public void setFalsoOpcionCorrecta() {

        opcionFalso = new OpcionCorrecta("Falso",1);
        opcionVerdadero = new OpcionIncorrecta("Verdadero",-1);

    }

}
