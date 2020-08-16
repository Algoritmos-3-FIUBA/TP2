package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGrupos;

import java.util.LinkedList;

public class PreguntaGroupChoice extends Pregunta{

    private final Puntos PuntosOtorgados;
    private final LinkedList<ColeccionOpciones> gruposCorrectos;

    public PreguntaGroupChoice(String nombre, int puntos, LinkedList<ColeccionOpciones> gruposCorrectos) {

        this.nombre = nombre;

        PuntosOtorgados = new Puntos(puntos);

        this.gruposCorrectos = gruposCorrectos;
    }

    public void evaluarRespuestas(LinkedList<Respuesta> respuestas) {
        corregirRespuestas(respuestas);

        for (Respuesta respuesta : respuestas) {
            respuesta.actualizarCondicionDeUsoExclusividad(respuestas);
            respuesta.calcularAmplificacionExclusividad(respuestas);
        }

        for (Respuesta respuesta : respuestas)
            respuesta.establecerAmplificadorAdecuado();

        for (Respuesta respuesta : respuestas) {
            respuesta.otorgarPuntos(puntosAOtorgar(respuesta));
        }
    }

    private Puntos puntosAOtorgar(Respuesta respuesta){
        Puntos puntosParciales = new Puntos(0);
        for (int i = 0; i < gruposCorrectos.size(); i++)
            if (((RespuestaGrupos) respuesta).getGruposElegidos().get(i).tieneMismosElementos(gruposCorrectos.get(i)))
                puntosParciales.sumarPuntos(PuntosOtorgados);
        return puntosParciales;
    }

    private void corregirRespuestas(LinkedList<Respuesta> respuestas){
        for (Respuesta respuesta : respuestas)
            for (int i = 0; i < gruposCorrectos.size(); i++)
                if (((RespuestaGrupos) respuesta).getGruposElegidos().get(i).tieneMismosElementos(gruposCorrectos.get(i)))
                    respuesta.setCorrecta();
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