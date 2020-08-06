package edu.fiuba.algo3.modelo.testEntregas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testPreguntaMultiChoiceEntrega1 {
    @Test
    public void CreoPreguntaMultipleChoiceConDosRespuestasCorrectasYJugadorRespondeDosCorrectasYUnaIncorrecta() {

        Jugador Mati = new Jugador("Mati");

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1", 0);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1", 0);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2", 1);
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2", 1);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        //PreguntaMultipleChoice pregunta2 = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<Opcion>();
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);
        opcionesSeleccionadas.add(primeraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Mati);


        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Mati.getPuntos().getCantidad(), 0);
        assertTrue(pregunta.getOpcionesIncorrectas().contains(primeraOpcion));
        assertTrue(pregunta.getOpcionesIncorrectas().contains(segundaOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contains(terceraOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contains(cuartaOpcion));
    }
   @Test
    public void CreoPreguntaMultipleChoiceConDosJugadoreUnoSoloObtienePuntaje() {

        Jugador Mati = new Jugador("Mati");
        Jugador Guido = new Jugador("Guido");

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1", 0);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1", 0);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2", 1);
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2", 1);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        HashSet<Opcion> opcionesSeleccionadasGuido = new HashSet<Opcion>();
        opcionesSeleccionadasGuido.add(terceraOpcion);
        opcionesSeleccionadasGuido.add(cuartaOpcion);
        opcionesSeleccionadasGuido.add(primeraOpcion);

        RespuestaMultiple respuestaGuido = new RespuestaMultiple(opcionesSeleccionadasGuido, Guido);

        HashSet<Opcion> opcionesSeleccionadasMati = new HashSet<Opcion>();
        opcionesSeleccionadasMati.add(terceraOpcion);
        opcionesSeleccionadasMati.add(cuartaOpcion);

        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati);

        respuestas.add(respuestaGuido);
        respuestas.add(respuestaMati);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 0);
        assertEquals(Mati.getPuntos().getCantidad(), 1);
        assertTrue(pregunta.getOpcionesIncorrectas().contains(primeraOpcion));
        assertTrue(pregunta.getOpcionesIncorrectas().contains(segundaOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contains(terceraOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contains(cuartaOpcion));
    }
}
