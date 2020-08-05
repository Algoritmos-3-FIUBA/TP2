package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
import edu.fiuba.algo3.modelo.respuesta.RespuestaVerdaderoFalsoClasico;

import java.util.LinkedList;

public abstract class PreguntaVerdaderoFalso extends Pregunta {

    private String nombre;
    protected Opcion opcionVerdadero;
    protected Opcion opcionFalso;

    public PreguntaVerdaderoFalso(String nombrePregunta) { this.nombre = nombrePregunta; }

    public abstract void setVerdaderoOpcionCorrecta();
    public abstract void setFalsoOpcionCorrecta();

    public String getNombrePregunta() { return nombre; }
    public Opcion getOpcionVerdadera() { return opcionVerdadero; }
    public Opcion getOpcionFalsa() { return opcionFalso; }

    public void evaluarRespuestas(LinkedList<Respuesta> respuestasDeJugadores) {
        for (Respuesta respuestaDeJugador : respuestasDeJugadores)
            respuestaDeJugador.otorgarPuntos((((RespuestaUnica) respuestaDeJugador).getOpcion()).puntosObtenidos());
    }

}

