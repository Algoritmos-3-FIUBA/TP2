package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Grupo;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGrupos;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;

import java.util.HashSet;
import java.util.LinkedList;

public class PreguntaOrderedChoice {
    private String Nombre;
    private Puntos PuntosOtorgados;
    LinkedList<Grupo> grupoCorrecto;

    public PreguntaOrderedChoice(String nombre, int puntos, LinkedList<Grupo> grupoCorrecto) {

        Nombre = nombre;
        PuntosOtorgados = new Puntos(puntos);

        this.grupoCorrecto = grupoCorrecto;
    }

    public void evaluarRespuestas(LinkedList<RespuestaGrupos> respuestas) {

        for (RespuestaGrupos respuesta : respuestas) {
            Puntos puntosAsignar;
            LinkedList<Grupo> gruposElegidos;
            gruposElegidos = respuesta.getGruposElegidos();
            //Pregunta le delega a cada grupo correcto que se evalue, antes esa delegación la hacia Respuesta
            puntosAsignar = grupoCorrecto.get(1).evaluarGrupo(gruposElegidos.get(1).getOpcionesDelGrupo(), PuntosOtorgados);
            respuesta.otorgarPuntos(puntosAsignar);

        }
    }
}