package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;

import java.util.HashSet;
import java.util.LinkedList;

public class PreguntaMultipleChoice extends Pregunta {

    //private String Nombre;
    private Puntos puntosOtorgados;
    HashSet<OpcionCorrecta> opcionesCorrectas;
    HashSet<OpcionIncorrecta> opcionesIncorrectas;

    public PreguntaMultipleChoice(String nombre, int puntos, HashSet<Opcion> opciones) {

        this.nombre = nombre;
        puntosOtorgados = new Puntos(puntos);

        opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesIncorrectas = new HashSet<OpcionIncorrecta>();

        for (Opcion opcion : opciones)
            opcion.agregarseALaListaCorrespondiente(opcionesCorrectas, opcionesIncorrectas);
    }

    public void evaluarRespuestas(LinkedList<Respuesta> respuestas) {

        HashSet<Opcion> opcionesJugador;

        for (Respuesta respuesta : respuestas){

            opcionesJugador = new HashSet<Opcion>(((RespuestaMultiple) respuesta).getOpciones());

            if(opcionesJugador.equals(opcionesCorrectas))
                respuesta.otorgarPuntos(puntosOtorgados);
        }
    }

    public HashSet<OpcionCorrecta> getOpcionesCorrectas(){
        return opcionesCorrectas;
    }

    public HashSet<OpcionIncorrecta> getOpcionesIncorrectas(){
        return opcionesIncorrectas;
    }
}