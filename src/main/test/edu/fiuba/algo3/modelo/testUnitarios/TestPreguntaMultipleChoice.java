package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaMultipleChoice {

    @Test
    public void CreoPreguntaMultipleChoiceConDosRespuestasCorrectasYSeAsignanCorrectamente() {

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(new OpcionIncorrecta("1 + 1", 0));
        opciones.agregarOpcion(new OpcionIncorrecta("3 - 1", 0));
        opciones.agregarOpcion(new OpcionCorrecta("2 + 2", 1));
        opciones.agregarOpcion(new OpcionCorrecta("2 * 2", 1));

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        assertEquals((pregunta.getOpcionesCorrectas()).cantidadElementos(), 2);
    }

    @Test
    public void CreoPreguntaMultipleChoiceConDosRespuestasIncorrectasYSeAsignanCorrectamente() {

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(new OpcionIncorrecta("1 + 1", 0));
        opciones.agregarOpcion(new OpcionIncorrecta("3 - 1", 0));
        opciones.agregarOpcion(new OpcionCorrecta("2 + 2", 1));
        opciones.agregarOpcion(new OpcionCorrecta("2 * 2", 1));

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        assertEquals((pregunta.getOpcionesIncorrectas()).cantidadElementos(), 2);
    }

    @Test
        public void CreoPreguntaMultipleChoiceConDosRespuestasCorrectasYJugadorEligeDosCorrectas() {

            Jugador Mati = new Jugador("Mati");

            ColeccionOpciones opciones = new ColeccionOpciones();

            OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1", 0);
            OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1", 0);
            OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2", 1);
            OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2", 1);

            opciones.agregarOpcion(primeraOpcion);
            opciones.agregarOpcion(segundaOpcion);
            opciones.agregarOpcion(terceraOpcion);
            opciones.agregarOpcion(cuartaOpcion);

            PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

            LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

            LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
            opcionesSeleccionadas.add(terceraOpcion);
            opcionesSeleccionadas.add(cuartaOpcion);

            RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Mati);

            respuestas.add(respuesta);

            pregunta.evaluarRespuestas(respuestas);

            assertEquals(Mati.getPuntos().getCantidad(), 1);
        }

        @Test
        public void CreoPreguntaMultipleChoiceConDosRespuestasCorrectasYJugadorRespondeUnaCorrecta() {

            Jugador Mati = new Jugador("Mati");

            ColeccionOpciones opciones = new ColeccionOpciones();

            OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1", 0);
            OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1", 0);
            OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2", 1);
            OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2", 1);

            opciones.agregarOpcion(primeraOpcion);
            opciones.agregarOpcion(segundaOpcion);
            opciones.agregarOpcion(terceraOpcion);
            opciones.agregarOpcion(cuartaOpcion);

            PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

            LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

            LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<Opcion>();
            opcionesSeleccionadas.add(terceraOpcion);

            RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Mati);

            respuestas.add(respuesta);

            pregunta.evaluarRespuestas(respuestas);

            assertEquals(Mati.getPuntos().getCantidad(), 0);
        }

        @Test
        public void CreoPreguntaMultipleChoiceConDosRespuestasCorrectasYJugadorRespondeDosCorrectasYUnaIncorrecta() {

            Jugador Mati = new Jugador("Mati");

            ColeccionOpciones opciones = new ColeccionOpciones();

            OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1", 0);
            OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1", 0);
            OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2", 1);
            OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2", 1);

            opciones.agregarOpcion(primeraOpcion);
            opciones.agregarOpcion(segundaOpcion);
            opciones.agregarOpcion(terceraOpcion);
            opciones.agregarOpcion(cuartaOpcion);

            PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

            LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

            LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<Opcion>();
            opcionesSeleccionadas.add(terceraOpcion);
            opcionesSeleccionadas.add(cuartaOpcion);
            opcionesSeleccionadas.add(primeraOpcion);

            RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Mati);

            respuestas.add(respuesta);

            pregunta.evaluarRespuestas(respuestas);

            assertEquals(Mati.getPuntos().getCantidad(), 0);
        }

        @Test
        public void CreoPreguntaMultipleChoiceConDosRespuestasCorrectasYJugadorRespondeDosIncorrectas() {

            Jugador Mati = new Jugador("Mati");

            ColeccionOpciones opciones = new ColeccionOpciones();

            OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1", 0);
            OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1", 0);
            OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2", 1);
            OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2", 1);

            opciones.agregarOpcion(primeraOpcion);
            opciones.agregarOpcion(segundaOpcion);
            opciones.agregarOpcion(terceraOpcion);
            opciones.agregarOpcion(cuartaOpcion);

            PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

            LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

            LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<Opcion>();
            opcionesSeleccionadas.add(primeraOpcion);
            opcionesSeleccionadas.add(segundaOpcion);

            RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Mati);

            respuestas.add(respuesta);

            pregunta.evaluarRespuestas(respuestas);

            assertEquals(Mati.getPuntos().getCantidad(), 0);
        }

        @Test
        public void CreoPreguntaMultipleChoiceConDosRespuestasCorrectasYEvaluaVariasRespuestas() {

            Jugador Mati = new Jugador("Mati");
            Jugador Juan = new Jugador("Juan");
            Jugador Guido = new Jugador("Guido");

            ColeccionOpciones opciones = new ColeccionOpciones();

            OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1", 0);
            OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1", 0);
            OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2", 1);
            OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2", 1);

            opciones.agregarOpcion(primeraOpcion);
            opciones.agregarOpcion(segundaOpcion);
            opciones.agregarOpcion(terceraOpcion);
            opciones.agregarOpcion(cuartaOpcion);

            PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

            LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

            LinkedList<Opcion> opcionesSeleccionadasMati = new LinkedList<Opcion>();
            opcionesSeleccionadasMati.add(primeraOpcion);
            opcionesSeleccionadasMati.add(segundaOpcion);

            LinkedList<Opcion> opcionesSeleccionadasGuido = new LinkedList<Opcion>();
            opcionesSeleccionadasGuido.add(segundaOpcion);
            opcionesSeleccionadasGuido.add(cuartaOpcion);

            LinkedList<Opcion> opcionesSeleccionadasJuan = new LinkedList<Opcion>();
            opcionesSeleccionadasJuan.add(terceraOpcion);
            opcionesSeleccionadasJuan.add(cuartaOpcion);

            RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati);
            RespuestaMultiple respuestaGuido = new RespuestaMultiple(opcionesSeleccionadasGuido, Guido);
            RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan);

            respuestas.add(respuestaMati);
            respuestas.add(respuestaGuido);
            respuestas.add(respuestaJuan);

            pregunta.evaluarRespuestas(respuestas);

            assertEquals(Mati.getPuntos().getCantidad(), 0);
            assertEquals(Guido.getPuntos().getCantidad(), 0);
            assertEquals(Juan.getPuntos().getCantidad(), 1);
        }
}
