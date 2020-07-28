package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaMultipleChoice {

        @Test
        public void CreoPreguntaMultipleChoiceConDosRespuestasCorrectasYJugadorEligeDosCorrectas() {

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

            RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(opcionesSeleccionadas, Mati);

            respuestas.add(respuesta);

            pregunta.evaluarRespuestas(respuestas);

            assertEquals(Mati.getPuntos(), 1);
        }

        @Test
        public void CreoPreguntaMultipleChoiceConDosRespuestasCorrectasYJugadorRespondeUnaCorrecta() {

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

            RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(opcionesSeleccionadas, Mati);

            respuestas.add(respuesta);

            pregunta.evaluarRespuestas(respuestas);

            assertEquals(Mati.getPuntos(), 0);
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
        }

        @Test
        public void CreoPreguntaMultipleChoiceConDosRespuestasCorrectasYJugadorRespondeDosIncorrectas() {

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
            opcionesSeleccionadas.add(primeraOpcion);
            opcionesSeleccionadas.add(segundaOpcion);

            RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(opcionesSeleccionadas, Mati);

            respuestas.add(respuesta);

            pregunta.evaluarRespuestas(respuestas);

            assertEquals(Mati.getPuntos(), 0);
        }

        @Test
        public void CreoPreguntaMultipleChoiceConDosRespuestasCorrectasYEvaluaVariasRespuestas() {

            Jugador Mati = new Jugador("Mati");
            Jugador Juan = new Jugador("Juan");
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

            HashSet<Opcion> opcionesSeleccionadasMati = new HashSet<Opcion>();
            opcionesSeleccionadasMati.add(primeraOpcion);
            opcionesSeleccionadasMati.add(segundaOpcion);

            HashSet<Opcion> opcionesSeleccionadasGuido = new HashSet<Opcion>();
            opcionesSeleccionadasGuido.add(segundaOpcion);
            opcionesSeleccionadasGuido.add(cuartaOpcion);

            HashSet<Opcion> opcionesSeleccionadasJuan = new HashSet<Opcion>();
            opcionesSeleccionadasJuan.add(terceraOpcion);
            opcionesSeleccionadasJuan.add(cuartaOpcion);

            RespuestaMultipleChoice respuestaMati = new RespuestaMultipleChoice(opcionesSeleccionadasMati, Mati);
            RespuestaMultipleChoice respuestaGuido = new RespuestaMultipleChoice(opcionesSeleccionadasGuido, Guido);
            RespuestaMultipleChoice respuestaJuan = new RespuestaMultipleChoice(opcionesSeleccionadasJuan, Juan);

            respuestas.add(respuestaMati);
            respuestas.add(respuestaGuido);
            respuestas.add(respuestaJuan);

            pregunta.evaluarRespuestas(respuestas);

            assertEquals(Mati.getPuntos(), 0);
            assertEquals(Guido.getPuntos(), 0);
            assertEquals(Juan.getPuntos(), 1);
        }
}
