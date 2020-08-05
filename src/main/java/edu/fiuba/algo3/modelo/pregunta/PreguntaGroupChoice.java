package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Grupo;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGrupos;

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

    public void evaluarRespuestas(LinkedList<RespuestaGrupos> respuestas) {
        for (RespuestaGrupos respuesta : respuestas) {
            verificarlosGruposDeLaRespuesta(respuesta);
        }
    }

    public void verificarlosGruposDeLaRespuesta(RespuestaGrupos respuesta){
        Puntos puntosAsignar;
        LinkedList<Grupo> gruposElegidos;
        gruposElegidos = respuesta.getGruposElegidos();
        for (int i=0; i<gruposCorrectos.size(); i++){
            //Pregunta le delega a cada grupo correcto que se evalue, antes esa delegación la hacia Respuesta


            puntosAsignar = gruposCorrectos.get(i).evaluarGrupo(gruposElegidos.get(i).getOpcionesDelGrupo(), PuntosOtorgados);

            // puntosAsignar = gruposElegidos.get(i).evaluarGrupo(gruposCorrectos.get(i).getOpcionesDelGrupo(), PuntosOtorgados);
            respuesta.otorgarPuntos(puntosAsignar);
        }
    }
}
