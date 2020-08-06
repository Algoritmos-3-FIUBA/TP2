package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultipleChoiceParcial;

import java.util.HashSet;
import java.util.LinkedList;

public class PreguntaMultipleChoiceParcial extends Pregunta{

    private HashSet<OpcionCorrecta> opcionesCorrectas;
    private HashSet<OpcionIncorrecta> opcionesIncorrectas;

    public PreguntaMultipleChoiceParcial(String nombre, HashSet<Opcion> opciones){

        this.nombre = nombre;

        opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesIncorrectas = new HashSet<OpcionIncorrecta>();

        for (Opcion opcion : opciones) {
            opcion.agregarseALaListaCorrespondiente(opcionesCorrectas,opcionesIncorrectas);
        }

    }

    public void evaluarRespuestas(LinkedList<Respuesta> listaRespuestas){
        for (Object respuesta : listaRespuestas) {
            RespuestaMultiple cadaRespuesta = (RespuestaMultiple) respuesta;
            HashSet<Opcion> interseccion = new HashSet<Opcion>(cadaRespuesta.getOpciones());
            interseccion.retainAll(opcionesIncorrectas);
            if (interseccion.isEmpty()){
                for (Opcion opcion: cadaRespuesta.getOpciones()) {
                    cadaRespuesta.otorgarPuntos(opcion.puntosObtenidos());
                }
            }
        }
    }
}
