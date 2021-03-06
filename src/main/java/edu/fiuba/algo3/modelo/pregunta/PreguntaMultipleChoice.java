package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.excepciones.MasDeCincoOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;

import java.util.LinkedList;

public class PreguntaMultipleChoice extends Pregunta {

    private Puntos puntosOtorgados;
    private ColeccionOpciones opcionesCorrectas;
    private ColeccionOpciones opcionesIncorrectas;
    private ColeccionOpciones opciones;

    public PreguntaMultipleChoice(String nombre, int puntos, ColeccionOpciones opciones) {

        if(opciones.cantidadElementos() == 0)
            throw new NoHayOpcionesException();

        if(opciones.cantidadElementos() > 5)
            throw new MasDeCincoOpcionesException();

        this.nombre = nombre;
        this.puntosOtorgados = new Puntos(puntos);
        this.opciones = opciones;

        opcionesCorrectas = new ColeccionOpciones();
        opcionesIncorrectas = new ColeccionOpciones();

        opciones.separarEnGruposCorrespondientes(opcionesCorrectas,opcionesIncorrectas);
    }

    @Override
    public ColeccionOpciones getColeccionDeOpciones() {
        return opciones;
    }

    @Override
    public void sumarPuntosJugadores(LinkedList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas)
            respuesta.otorgarPuntos(new Puntos(puntosOtorgados));
    }

    @Override
    public void corregirRespuestas(LinkedList<Respuesta> respuestas){
        for (Respuesta respuesta : respuestas)
            if(((RespuestaMultiple) respuesta).getColeccionDeOpciones().tieneMismosElementos(opcionesCorrectas))
                respuesta.esCorrecta();
    }

    public ColeccionOpciones getOpcionesCorrectas(){
        return opcionesCorrectas;
    }

    public ColeccionOpciones getOpcionesIncorrectas(){
        return opcionesIncorrectas;
    }
}