package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGrupos;

import java.util.LinkedList;

public class PreguntaGroupChoice extends Pregunta{

    private Puntos PuntosOtorgados;
    private LinkedList<ColeccionOpciones> gruposCorrectos;

    public PreguntaGroupChoice(String nombre, int puntos, LinkedList<ColeccionOpciones> gruposCorrectos) {

        this.nombre = nombre;

        PuntosOtorgados = new Puntos(puntos);

        this.gruposCorrectos = gruposCorrectos;
    }

    public void evaluarRespuestas(LinkedList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas)
            for(int i = 0; i < gruposCorrectos.size(); i++)
                if(((RespuestaGrupos)respuesta).getGruposElegidos().get(i).tieneMismosElementos(gruposCorrectos.get(i)))
                    respuesta.otorgarPuntos(PuntosOtorgados);
    }

    //Version anterior
    /*
    public void verificarlosGruposDeLaRespuesta(RespuestaGrupos respuesta){
        Puntos puntosAsignar;
        LinkedList<Grupo> gruposElegidos;
        gruposElegidos = respuesta.getGruposElegidos();
        for (int i=0; i<gruposCorrectos.size(); i++){
            //Pregunta le delega a cada grupo correcto que se evalue, antes esa delegación la hacia Respuesta


            //puntosAsignar = gruposCorrectos.get(i).evaluarGrupo(gruposElegidos.get(i).getOpcionesDelGrupo(), PuntosOtorgados);

            // puntosAsignar = gruposElegidos.get(i).evaluarGrupo(gruposCorrectos.get(i).getOpcionesDelGrupo(), PuntosOtorgados);
            //respuesta.otorgarPuntos(puntosAsignar);
        }
    }*/
}