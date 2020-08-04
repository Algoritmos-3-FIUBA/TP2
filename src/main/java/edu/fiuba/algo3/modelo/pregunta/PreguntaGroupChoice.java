package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Grupo;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGroupChoice;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultipleChoice;

import java.util.HashSet;
import java.util.LinkedList;

public class PreguntaGroupChoice {
    private String Nombre;
    private Puntos PuntosOtorgados;
    private LinkedList<Grupo> gruposCorrectos;


    public PreguntaGroupChoice(String nombre, int puntos, LinkedList<Grupo> gruposCorrectos) {

        Nombre = nombre;
        PuntosOtorgados = new Puntos(puntos);
        this.gruposCorrectos = gruposCorrectos;
    }

    public void evaluarRespuestas(LinkedList<RespuestaGroupChoice> respuestas) {

        for (RespuestaGroupChoice respuesta : respuestas)
            respuesta.otorgarPuntos(gruposCorrectos, PuntosOtorgados);
    }
}
