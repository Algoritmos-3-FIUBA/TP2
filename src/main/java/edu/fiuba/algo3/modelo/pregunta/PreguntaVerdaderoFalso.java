package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
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

    public void evaluarRespuestas(LinkedList<Respuesta> respuestas) {
        corregirRespuestas(respuestas);

        for (Respuesta respuesta : respuestas) {
            respuesta.actualizarCondicionDeUsoExclusividad(respuestas);
            respuesta.calcularAmplificacionExclusividad(respuestas);
        }

        for (Respuesta respuesta : respuestas)
            respuesta.establecerAmplificadorAdecuado();

        for (Respuesta respuesta : respuestas) {
            respuesta.otorgarPuntos(new Puntos(((RespuestaUnica)respuesta).getOpcion().getPuntos().getCantidad()));
        }
    }

    private void corregirRespuestas(LinkedList<Respuesta> respuestas){
        for (Respuesta respuestaDeJugador : respuestas)
            ((RespuestaUnica)respuestaDeJugador).corregir();
    }

    @Override
    public ColeccionOpciones getOpciones(){
        ColeccionOpciones opciones = new ColeccionOpciones();
        opciones.agregarOpcion(opcionFalso);
        opciones.agregarOpcion(opcionVerdadero);
        return opciones;
    }

}