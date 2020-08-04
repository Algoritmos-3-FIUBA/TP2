package edu.fiuba.algo3.modelo.testEntregas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaOrderedChoice;
import edu.fiuba.algo3.modelo.respuesta.RespuestaOrderedChoice;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testPreguntaOrderedChoiceEntrega2 {
    @Test
    public void CreoPreguntaOrderedChoiceConDosRespuestasCorrectasYJugadorRespondeCorrectamente() {

        Jugador Guido = new Jugador("Guido");

        LinkedList<Opcion> opciones = new LinkedList<Opcion>();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1", 0);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1", 0);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2", 1);
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2", 1);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        LinkedList<RespuestaOrderedChoice> respuestas = new LinkedList<RespuestaOrderedChoice>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<Opcion>();
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);


        RespuestaOrderedChoice respuesta = new RespuestaOrderedChoice(opcionesSeleccionadas, Guido);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 1);
        assertTrue(pregunta.getOpcionesIncorrectas().contains(primeraOpcion));
        assertTrue(pregunta.getOpcionesIncorrectas().contains(segundaOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contains(terceraOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contains(cuartaOpcion));
    }

    @Test
    public void CreoPreguntaOrderedChoiceConDosRespuestasCorrectasYJugadorRespondeIncorrectamenteEnOtroOrden() {

        Jugador Guido = new Jugador("Guido");

        LinkedList<Opcion> opciones = new LinkedList<Opcion>();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1", 0);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1", 0);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2", 1);
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2", 1);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        LinkedList<RespuestaOrderedChoice> respuestas = new LinkedList<RespuestaOrderedChoice>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<Opcion>();
        opcionesSeleccionadas.add(cuartaOpcion);
        opcionesSeleccionadas.add(terceraOpcion);


        RespuestaOrderedChoice respuesta = new RespuestaOrderedChoice(opcionesSeleccionadas, Guido);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 0);
        assertTrue(pregunta.getOpcionesIncorrectas().contains(primeraOpcion));
        assertTrue(pregunta.getOpcionesIncorrectas().contains(segundaOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contains(terceraOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contains(cuartaOpcion));
    }

    @Test
    public void CreoPreguntaMultipleChoiceConDosJugadoreUnoSoloObtienePuntaje() {

        Jugador Guido = new Jugador("Guido");
        Jugador Juanchi = new Jugador("Juanchi");

        LinkedList<Opcion> opciones = new LinkedList<Opcion>();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1", 0);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1", 0);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2", 1);
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2", 1);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        LinkedList<RespuestaOrderedChoice> respuestas = new LinkedList<RespuestaOrderedChoice>();

        LinkedList<Opcion> opcionesSeleccionadasGuido = new LinkedList<Opcion>();
        opcionesSeleccionadasGuido.add(cuartaOpcion);
        opcionesSeleccionadasGuido.add(terceraOpcion);

        RespuestaOrderedChoice respuestaGuido = new RespuestaOrderedChoice(opcionesSeleccionadasGuido, Guido);

        LinkedList<Opcion> opcionesSeleccionadasJuachi = new LinkedList<Opcion>();
        opcionesSeleccionadasJuachi.add(terceraOpcion);
        opcionesSeleccionadasJuachi.add(cuartaOpcion);

        RespuestaOrderedChoice respuestaJuachi = new RespuestaOrderedChoice(opcionesSeleccionadasJuachi, Juanchi);

        respuestas.add(respuestaGuido);
        respuestas.add(respuestaJuachi);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 0);
        assertEquals(Juanchi.getPuntos().getCantidad(), 1);
        assertTrue(pregunta.getOpcionesIncorrectas().contains(primeraOpcion));
        assertTrue(pregunta.getOpcionesIncorrectas().contains(segundaOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contains(terceraOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contains(cuartaOpcion));
    }
}
