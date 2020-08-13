package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import java.util.LinkedList;

public class PreguntaOrderedChoice extends Pregunta{

    private Puntos puntosOtorgados;
    private ColeccionOpciones opcionesCorrectas;
    private ColeccionOpciones opcionesIncorrectas;

    public PreguntaOrderedChoice(String nombre, int puntos, ColeccionOpciones opciones) {

        this.nombre = nombre;

        puntosOtorgados = new Puntos(puntos);

        opcionesCorrectas = new ColeccionOpciones();
        opcionesIncorrectas = new ColeccionOpciones();

        opciones.separarEnGruposCorrespondientes(opcionesCorrectas,opcionesIncorrectas);
    }

    public void evaluarRespuestas(LinkedList<Respuesta> respuestas) {
        corregirRespuestas(respuestas);

        Amplificador amplificadorFinal = new Amplificador(1);
        amplificadorFinal.inutilizar();

        for (Respuesta respuesta : respuestas) {
            respuesta.actualizarEstadoAmplificador(amplificadorFinal);
            respuesta.calcularAmplificacionExclusividad(amplificadorFinal,respuestas);
        }

        for (Respuesta respuesta : respuestas) {
            respuesta.otorgarPuntos(new Puntos(puntosOtorgados.getCantidad()));
        }

    }

    public void corregirRespuestas(LinkedList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas)
            if(((RespuestaMultiple) respuesta).getOpciones().esIgual(opcionesCorrectas))
                respuesta.setCorrecta();
    }

}












    /*
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
     */