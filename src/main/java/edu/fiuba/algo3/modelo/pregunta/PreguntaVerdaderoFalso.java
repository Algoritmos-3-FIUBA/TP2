package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaVerdaderoFalsoClasico;

import java.util.LinkedList;

public abstract class PreguntaVerdaderoFalso {

    private String nombre;
    protected Opcion opcionVerdadero;
    protected Opcion opcionFalso;

    public PreguntaVerdaderoFalso(String nombrePregunta) { this.nombre = nombrePregunta; }

    public abstract void setVerdaderoOpcionCorrecta();

    public abstract void setFalsoOpcionCorrecta();

    public String getNombrePregunta() { return nombre; }

    public Opcion getOpcionVerdadera() { return opcionVerdadero; }

    public Opcion getOpcionFalsa() { return opcionFalso; }

}

