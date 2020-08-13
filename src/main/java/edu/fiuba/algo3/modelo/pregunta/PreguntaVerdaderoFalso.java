package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;

import java.util.LinkedList;

public abstract class PreguntaVerdaderoFalso extends Pregunta {

    protected Opcion opcionVerdadero;
    protected Opcion opcionFalso;

    public PreguntaVerdaderoFalso(String nombrePregunta) { this.nombre = nombrePregunta; }

    public abstract void setVerdaderoOpcionCorrecta();
    public abstract void setFalsoOpcionCorrecta();

    public String getNombrePregunta() { return nombre; }
    public Opcion getOpcionVerdadera() { return opcionVerdadero; }
    public Opcion getOpcionFalsa() { return opcionFalso; }

    public void evaluarRespuestas(LinkedList<Respuesta> respuestas) {
        corregirRespuestas(respuestas);

        Amplificador amplificadorFinal = new Amplificador(1);
        amplificadorFinal.inutilizar();

        for (Respuesta respuesta : respuestas) {
            respuesta.actualizarEstadoAmplificador(amplificadorFinal);
            respuesta.calcularAmplificacionExclusividad(amplificadorFinal,respuestas);
        }

        for (Respuesta respuesta : respuestas) {
            respuesta.otorgarPuntos(new Puntos(((RespuestaUnica)respuesta).getOpcion().getPuntos().getCantidad()));
        }
    }

    private void corregirRespuestas(LinkedList<Respuesta> respuestas){
        for (Respuesta respuestaDeJugador : respuestas)
            ((RespuestaUnica)respuestaDeJugador).corregir();
    }


}

