package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Puntos;
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

    @Override
    public void sumarPuntosJugadores(LinkedList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas)
            respuesta.otorgarPuntos(new Puntos(((RespuestaUnica)respuesta).getOpcion().getPuntos()));
    }

    @Override
    public void corregirRespuestas(LinkedList<Respuesta> respuestas){
        for (Respuesta respuestaDeJugador : respuestas)
            ((RespuestaUnica)respuestaDeJugador).corregir();
    }

    @Override
    public ColeccionOpciones getColeccionDeOpciones(){
        ColeccionOpciones opciones = new ColeccionOpciones();
        opciones.agregarOpcion(opcionVerdadero);
        opciones.agregarOpcion(opcionFalso);
        return opciones;
    }

}