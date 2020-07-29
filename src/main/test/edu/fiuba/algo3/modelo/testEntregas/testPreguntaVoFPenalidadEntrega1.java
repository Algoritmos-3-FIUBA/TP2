package edu.fiuba.algo3.modelo.testEntregas;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testPreguntaVoFPenalidadEntrega1 {

        @Test
        public void CreoPreguntaVerdaderoFalsoConPenalidadIndicandoRespuestCorrecta(){
        Jugador jugador = new Jugador("Fernando");

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("El caballo blanco de San Martin es rojo");

        pregunta.setFalsoOpcionCorrecta();

        Respuesta respuesta = new Respuesta(pregunta.getOpcionFalsa(),jugador);

        LinkedList <Respuesta> listaRespuesta= new LinkedList<Respuesta>();

        listaRespuesta.add(respuesta);

        pregunta.evaluarRespuestas(listaRespuesta);

        Assertions.assertEquals(jugador.getPuntos(),1);

    }
    @Test
    public void PreguntaVerdaderoFalsoConPenalidadAsignaCorrectamenteLosPuntosALosJugadores(){
        Jugador jugador1 = new Jugador("Fernando");
        Jugador jugador2 = new Jugador("Lucas");
        Jugador jugador3 = new Jugador("Guido");

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad("Messi no es Argetino");

        pregunta.setFalsoOpcionCorrecta();

        Respuesta respuesta1 = new Respuesta(pregunta.getOpcionFalsa(),jugador1);
        Respuesta respuesta2 = new Respuesta(pregunta.getOpcionVerdadera(),jugador2);
        Respuesta respuesta3 = new Respuesta(pregunta.getOpcionFalsa(),jugador3);

        LinkedList <Respuesta> listaRespuesta= new LinkedList<Respuesta>();

        listaRespuesta.add(respuesta1);listaRespuesta.add(respuesta2);listaRespuesta.add(respuesta3);

        pregunta.evaluarRespuestas(listaRespuesta);

        Assertions.assertEquals(jugador1.getPuntos(),1);
        Assertions.assertEquals(jugador2.getPuntos(),-1);
        Assertions.assertEquals(jugador3.getPuntos(),1);
    }
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

        LinkedList<RespuestaMultipleChoice> respuestas = new LinkedList<RespuestaMultipleChoice>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<Opcion>();
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);
        opcionesSeleccionadas.add(primeraOpcion);

        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(opcionesSeleccionadas, Mati);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Mati.getPuntos(), 0);
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

        LinkedList<RespuestaMultipleChoice> respuestas = new LinkedList<RespuestaMultipleChoice>();

        HashSet<Opcion> opcionesSeleccionadasGuido = new HashSet<Opcion>();
        opcionesSeleccionadasGuido.add(terceraOpcion);
        opcionesSeleccionadasGuido.add(cuartaOpcion);
        opcionesSeleccionadasGuido.add(primeraOpcion);

        RespuestaMultipleChoice respuestaGuido = new RespuestaMultipleChoice(opcionesSeleccionadasGuido, Guido);

        HashSet<Opcion> opcionesSeleccionadasMati = new HashSet<Opcion>();
        opcionesSeleccionadasMati.add(terceraOpcion);
        opcionesSeleccionadasMati.add(cuartaOpcion);

        RespuestaMultipleChoice respuestaMati = new RespuestaMultipleChoice(opcionesSeleccionadasMati, Mati);

        respuestas.add(respuestaGuido);
        respuestas.add(respuestaMati);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos(), 0);
        assertEquals(Mati.getPuntos(), 1);
        assertTrue(pregunta.getOpcionesIncorrectas().contains(primeraOpcion));
        assertTrue(pregunta.getOpcionesIncorrectas().contains(segundaOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contains(terceraOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contains(cuartaOpcion));
    }
}
