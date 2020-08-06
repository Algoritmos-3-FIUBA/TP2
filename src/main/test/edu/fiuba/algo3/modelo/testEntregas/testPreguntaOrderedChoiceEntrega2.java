package edu.fiuba.algo3.modelo.testEntregas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.pregunta.PreguntaOrderedChoice;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testPreguntaOrderedChoiceEntrega2 {
    @Test
    public void CreoPreguntaOrderedChoiceConDosRespuestasCorrectasYJugadorRespondeCorrectamente() {

        Jugador Guido = new Jugador("Guido");

        LinkedList<OpcionCorrecta> opcionesCorrectas = new LinkedList<OpcionCorrecta>();
        LinkedList<OpcionIncorrecta> opcionesIncorrectas = new LinkedList<OpcionIncorrecta>();


        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1", 0);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1", 0);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2", 1);
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2", 1);

        opcionesIncorrectas.add(primeraOpcion);
        opcionesIncorrectas.add(segundaOpcion);
        opcionesCorrectas.add(terceraOpcion);
        opcionesCorrectas.add(cuartaOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opcionesCorrectas ,opcionesIncorrectas);

        LinkedList<RespuestaMultiple> respuestas = new LinkedList<RespuestaMultiple>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<Opcion>();
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);


        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Guido);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 1);
    }
    @Test
    public void CreoPreguntaOrderedChoiceConDosRespuestasCorrectasYJugadorRespondeEnOrdenIncorrecto() {

        Jugador Fernando = new Jugador("Fernando");

        LinkedList<OpcionCorrecta> opcionesCorrectas = new LinkedList<OpcionCorrecta>();
        LinkedList<OpcionIncorrecta> opcionesIncorrectas = new LinkedList<OpcionIncorrecta>();


        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1", 0);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1", 0);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2", 1);
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2", 1);

        opcionesIncorrectas.add(primeraOpcion);
        opcionesIncorrectas.add(segundaOpcion);
        opcionesCorrectas.add(terceraOpcion);
        opcionesCorrectas.add(cuartaOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opcionesCorrectas ,opcionesIncorrectas);

        LinkedList<RespuestaMultiple> respuestas = new LinkedList<RespuestaMultiple>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<Opcion>();

        opcionesSeleccionadas.add(cuartaOpcion);
        opcionesSeleccionadas.add(terceraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Fernando);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Fernando.getPuntos().getCantidad(), 0);
    }
}
