package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.excepciones.MasDeCincoOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import java.util.LinkedList;

public class PreguntaOrderedChoice extends Pregunta{

    private final Puntos puntosOtorgados;
    private final ColeccionOpciones opcionesCorrectas;
    private final ColeccionOpciones opciones;

    public PreguntaOrderedChoice(String nombre, int puntos, ColeccionOpciones opciones) {

        if(opciones.cantidadElementos() == 0)
            throw new NoHayOpcionesException();

        if(opciones.cantidadElementos() > 5)
            throw new MasDeCincoOpcionesException();

        this.nombre = nombre;
        this.opciones = opciones;

        puntosOtorgados = new Puntos(puntos);

        opcionesCorrectas = new ColeccionOpciones();
        ColeccionOpciones opcionesIncorrectas = new ColeccionOpciones();

        opciones.separarEnGruposCorrespondientes(opcionesCorrectas, opcionesIncorrectas);
    }

    @Override
    public void sumarPuntosJugadores(LinkedList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas)
            respuesta.otorgarPuntos(new Puntos(puntosOtorgados.getCantidad()));
    }

    @Override
    public void corregirRespuestas(LinkedList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas)
            if(((RespuestaMultiple) respuesta).getColeccionDeOpciones().esIgual(opcionesCorrectas))
                respuesta.esCorrecta();
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public ColeccionOpciones getColeccionDeOpciones() {
        return opciones;
    }
}