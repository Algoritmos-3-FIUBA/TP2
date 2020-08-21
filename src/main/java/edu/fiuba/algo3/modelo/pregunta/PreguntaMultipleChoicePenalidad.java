package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.excepciones.MasDeCincoOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import java.util.LinkedList;

public class PreguntaMultipleChoicePenalidad extends Pregunta{

    private ColeccionOpciones opcionesCorrectas;
    private ColeccionOpciones opcionesIncorrectas;
    private ColeccionOpciones opciones;

    public PreguntaMultipleChoicePenalidad(String nombre, ColeccionOpciones opciones) {

        if(opciones.cantidadElementos() == 0)
            throw new NoHayOpcionesException();

        if(opciones.cantidadElementos() > 5)
            throw new MasDeCincoOpcionesException();

        this.nombre = nombre;
        this.opciones = opciones;

        opcionesCorrectas = new ColeccionOpciones();
        opcionesIncorrectas = new ColeccionOpciones();

        opciones.separarEnGruposCorrespondientes(opcionesCorrectas, opcionesIncorrectas);
    }

    @Override
    public ColeccionOpciones getOpciones() {
        return opciones;
    }

    @Override
    public void sumarPuntosJugadores(LinkedList<Respuesta> respuestas) {
        sumarPuntosMultiplceChoiceConCadaOpcion(respuestas);
    }

    @Override
    public void corregirRespuestas(LinkedList<Respuesta> respuestas){
        for (Respuesta respuesta : respuestas) {
            if (((RespuestaMultiple)respuesta).getColeccionDeOpciones().tieneElementos(opcionesCorrectas))
                respuesta.esCorrecta();
        }
    }

}