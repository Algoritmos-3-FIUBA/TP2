package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.excepciones.MasDeCincoOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;

import java.util.LinkedList;

public class PreguntaMultipleChoiceParcial extends Pregunta{

    private final ColeccionOpciones opcionesCorrectas;
    private final ColeccionOpciones opcionesIncorrectas;
    private ColeccionOpciones opciones;

    public PreguntaMultipleChoiceParcial(String nombre, ColeccionOpciones opciones){

        if(opciones.cantidadElementos() == 0) {
            throw new NoHayOpcionesException();
        }

        if(opciones.cantidadElementos() > 5) {
            throw new MasDeCincoOpcionesException();
        }

        this.nombre = nombre;
        this.opciones = opciones;

        opcionesCorrectas = new ColeccionOpciones();
        opcionesIncorrectas = new ColeccionOpciones();

        opciones.separarEnGruposCorrespondientes(opcionesCorrectas,opcionesIncorrectas);
    }

    /*public void evaluarRespuestas(LinkedList<Respuesta> respuestas){
        corregirRespuestas(respuestas);

        for (Respuesta respuesta : respuestas) {
            respuesta.actualizarCondicionDeUsoExclusividad(respuestas);
            respuesta.calcularAmplificacionExclusividad(respuestas);
        }

        for (Respuesta respuesta : respuestas)
            respuesta.establecerAmplificadorAdecuado();

        for (Respuesta respuesta : respuestas) {
            Puntos puntosParciales = new Puntos(0);
            for (Opcion opcion: (((RespuestaMultiple) respuesta).getOpciones().getOpciones()))
                puntosParciales.sumarPuntos(opcion.puntosObtenidos());
            respuesta.otorgarPuntos(puntosParciales);
        }
    }*/

    @Override
    public ColeccionOpciones getOpciones() {
        return opciones;
    }

    @Override
    public void sumarPuntosJugadores(LinkedList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            Puntos puntosParciales = new Puntos(0);
            for (Opcion opcion : (((RespuestaMultiple) respuesta).getOpciones().getOpciones()))
                puntosParciales.sumarPuntos(opcion.puntosObtenidos());
            respuesta.otorgarPuntos(puntosParciales);
        }
    }

    @Override
    public void corregirRespuestas(LinkedList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            RespuestaMultiple cadaRespuesta = (RespuestaMultiple) respuesta;
            if (!cadaRespuesta.getOpciones().tieneElementos(opcionesIncorrectas))
                cadaRespuesta.setCorrecta();
        }
    }

    public String getNombrePregunta() { return nombre;
    }
}