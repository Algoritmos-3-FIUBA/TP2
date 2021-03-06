package edu.fiuba.algo3.modelo.testunitarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.excepciones.MasDeCincoOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

public class TestPreguntaMultipleChoice {

    @Test
    public void testCreoPreguntaMultipleChoiceConDosRespuestasCorrectasYSeAsignanCorrectamente01() {

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(new OpcionIncorrecta("1 + 1"));
        opciones.agregarOpcion(new OpcionIncorrecta("3 - 1"));
        opciones.agregarOpcion(new OpcionCorrecta("2 + 2"));
        opciones.agregarOpcion(new OpcionCorrecta("2 * 2"));

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        assertEquals((pregunta.getOpcionesCorrectas()).cantidadElementos(), 2);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceConDosRespuestasIncorrectasYSeAsignanCorrectamente02() {

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(new OpcionIncorrecta("1 + 1"));
        opciones.agregarOpcion(new OpcionIncorrecta("3 - 1"));
        opciones.agregarOpcion(new OpcionCorrecta("2 + 2"));
        opciones.agregarOpcion(new OpcionCorrecta("2 * 2"));

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        assertEquals((pregunta.getOpcionesIncorrectas()).cantidadElementos(), 2);
    }

    @Test
        public void testCreoPreguntaMultipleChoiceConDosRespuestasCorrectasYJugadorEligeDosCorrectas03() {

            Jugador Mati = new Jugador("Mati");

            ColeccionOpciones opciones = new ColeccionOpciones();

            OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1");
            OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1");
            OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2");
            OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2");

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
    public void testCreoPreguntaMultipleChoiceConDosOpcionesCorrectasYJugadorRespondeUnaCorrecta04() {

        Jugador Mati = new Jugador("Mati");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1");
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2");

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
    public void testCreoPreguntaMultipleChoiceYLasOpcionesCargadasSonLasEsperadas() {

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1");
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2");

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        ColeccionOpciones coleccionDeOpciones = pregunta.getColeccionDeOpciones();

        assertEquals(coleccionDeOpciones, opciones);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceConDosOpcionesCorrectasYJugadorRespondeDosCorrectasYUnaIncorrecta05() {

        Jugador Mati = new Jugador("Mati");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1");
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2");

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
    public void testCreoPreguntaMultipleChoiceConDosRespuestasCorrectasYJugadorRespondeDosIncorrectas06() {

        Jugador Mati = new Jugador("Mati");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1");
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2");

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
    public void testCreoPreguntaMultipleChoiceConDosOpcionesCorrectasYEvaluaVariasRespuestas07() {

        Jugador Mati = new Jugador("Mati");
        Jugador Juan = new Jugador("Juan");
        Jugador Guido = new Jugador("Guido");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1");
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2");

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

    @Test
    public void testCreoPreguntaMultipleChoiceYRespondeSoloUnJugadorCorrectamenteConExclusividad08() {

        Jugador Mati = new Jugador("Mati");
        Jugador Juan = new Jugador("Juan");
        Jugador Guido = new Jugador("Guido");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1874");
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("2020");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("1912");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1989");

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cual de los siguientes años pertenece al siglo XX?", 1, opciones);

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
        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan, new Exclusividad());

        respuestas.add(respuestaMati);
        respuestas.add(respuestaGuido);
        respuestas.add(respuestaJuan);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Mati.getPuntos().getCantidad(), 0);
        assertEquals(Guido.getPuntos().getCantidad(), 0);
        assertEquals(Juan.getPuntos().getCantidad(), 2);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceYRespondeSoloUnJugadorCorrectamenteConLaExclusividadDeOtro09() {

        Jugador Mati = new Jugador("Mati");
        Jugador Juan = new Jugador("Juan");
        Jugador Guido = new Jugador("Guido");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1874");
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("2020");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("1912");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1989");

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cual de los siguientes años pertenece al siglo XX?", 1, opciones);

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

        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati, new Exclusividad());
        RespuestaMultiple respuestaGuido = new RespuestaMultiple(opcionesSeleccionadasGuido, Guido);
        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan);

        respuestas.add(respuestaMati);
        respuestas.add(respuestaGuido);
        respuestas.add(respuestaJuan);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Mati.getPuntos().getCantidad(), 0);
        assertEquals(Guido.getPuntos().getCantidad(), 0);
        assertEquals(Juan.getPuntos().getCantidad(), 2);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceYRespondenDosJugadoresCorrectamenteConUnaExclusividad10() {

        Jugador Mati = new Jugador("Mati");
        Jugador Juan = new Jugador("Juan");
        Jugador Guido = new Jugador("Guido");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1874");
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("2020");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("1912");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1989");

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cual de los siguientes años pertenece al siglo XX?", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasMati = new LinkedList<Opcion>();
        opcionesSeleccionadasMati.add(primeraOpcion);
        opcionesSeleccionadasMati.add(segundaOpcion);

        LinkedList<Opcion> opcionesSeleccionadasGuido = new LinkedList<Opcion>();
        opcionesSeleccionadasGuido.add(terceraOpcion);
        opcionesSeleccionadasGuido.add(cuartaOpcion);

        LinkedList<Opcion> opcionesSeleccionadasJuan = new LinkedList<Opcion>();
        opcionesSeleccionadasJuan.add(terceraOpcion);
        opcionesSeleccionadasJuan.add(cuartaOpcion);

        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati, new Exclusividad());
        RespuestaMultiple respuestaGuido = new RespuestaMultiple(opcionesSeleccionadasGuido, Guido);
        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan);

        respuestas.add(respuestaMati);
        respuestas.add(respuestaGuido);
        respuestas.add(respuestaJuan);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Mati.getPuntos().getCantidad(), 0);
        assertEquals(Guido.getPuntos().getCantidad(), 0);
        assertEquals(Juan.getPuntos().getCantidad(), 0);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceYRespondenUnJugadorCorrectamenteConDosExclusividades11() {

        Jugador Mati = new Jugador("Mati");
        Jugador Juan = new Jugador("Juan");
        Jugador Guido = new Jugador("Guido");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1874");
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("2020");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("1912");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1989");

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cual de los siguientes años pertenece al siglo XX?", 1, opciones);

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

        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati, new Exclusividad());
        RespuestaMultiple respuestaGuido = new RespuestaMultiple(opcionesSeleccionadasGuido, Guido, new Exclusividad());
        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan);

        respuestas.add(respuestaMati);
        respuestas.add(respuestaGuido);
        respuestas.add(respuestaJuan);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Mati.getPuntos().getCantidad(), 0);
        assertEquals(Guido.getPuntos().getCantidad(), 0);
        assertEquals(Juan.getPuntos().getCantidad(), 4);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceYRespondenVariosJugadorCorrectamenteConVariasExclusividades12() {

        Jugador Mati = new Jugador("Mati");
        Jugador Juan = new Jugador("Juan");
        Jugador Guido = new Jugador("Guido");
        Jugador Fer = new Jugador("Fer");
        Jugador Lucas = new Jugador("Lucas");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1874");
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("2020");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("1912");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1989");

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cual de los siguientes años pertenece al siglo XX?", 1, opciones);

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

        LinkedList<Opcion> opcionesSeleccionadasFer = new LinkedList<Opcion>();
        opcionesSeleccionadasFer.add(terceraOpcion);
        opcionesSeleccionadasFer.add(cuartaOpcion);

        LinkedList<Opcion> opcionesSeleccionadasLucas = new LinkedList<Opcion>();
        opcionesSeleccionadasLucas.add(primeraOpcion);
        opcionesSeleccionadasLucas.add(terceraOpcion);

        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati, new Exclusividad());
        RespuestaMultiple respuestaGuido = new RespuestaMultiple(opcionesSeleccionadasGuido, Guido, new Exclusividad());
        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan);
        RespuestaMultiple respuestaFer = new RespuestaMultiple(opcionesSeleccionadasFer, Fer, new Exclusividad());
        RespuestaMultiple respuestaLucas = new RespuestaMultiple(opcionesSeleccionadasLucas, Lucas);

        respuestas.add(respuestaMati);
        respuestas.add(respuestaGuido);
        respuestas.add(respuestaJuan);
        respuestas.add(respuestaFer);
        respuestas.add(respuestaLucas);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Mati.getPuntos().getCantidad(), 0);
        assertEquals(Guido.getPuntos().getCantidad(), 0);
        assertEquals(Juan.getPuntos().getCantidad(), 0);
        assertEquals(Fer.getPuntos().getCantidad(), 0);
        assertEquals(Lucas.getPuntos().getCantidad(), 0);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceYRespondeUnJugadorCorrectamenteConVariasExclusividades13() {

        Jugador Mati = new Jugador("Mati");
        Jugador Juan = new Jugador("Juan");
        Jugador Guido = new Jugador("Guido");
        Jugador Fer = new Jugador("Fer");
        Jugador Lucas = new Jugador("Lucas");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1874");
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("2020");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("1912");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1989");

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cual de los siguientes años pertenece al siglo XX?", 1, opciones);

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

        LinkedList<Opcion> opcionesSeleccionadasFer = new LinkedList<Opcion>();
        opcionesSeleccionadasFer.add(terceraOpcion);
        opcionesSeleccionadasFer.add(segundaOpcion);

        LinkedList<Opcion> opcionesSeleccionadasLucas = new LinkedList<Opcion>();
        opcionesSeleccionadasLucas.add(primeraOpcion);
        opcionesSeleccionadasLucas.add(terceraOpcion);

        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati, new Exclusividad());
        RespuestaMultiple respuestaGuido = new RespuestaMultiple(opcionesSeleccionadasGuido, Guido, new Exclusividad());
        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan, new Exclusividad());
        RespuestaMultiple respuestaFer = new RespuestaMultiple(opcionesSeleccionadasFer, Fer, new Exclusividad());
        RespuestaMultiple respuestaLucas = new RespuestaMultiple(opcionesSeleccionadasLucas, Lucas);

        respuestas.add(respuestaMati);
        respuestas.add(respuestaGuido);
        respuestas.add(respuestaJuan);
        respuestas.add(respuestaFer);
        respuestas.add(respuestaLucas);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Mati.getPuntos().getCantidad(), 0);
        assertEquals(Guido.getPuntos().getCantidad(), 0);
        assertEquals(Juan.getPuntos().getCantidad(), 16);
        assertEquals(Fer.getPuntos().getCantidad(), 0);
        assertEquals(Lucas.getPuntos().getCantidad(), 0);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceConSieteOpcionesYDevuelveExcepcion14() {

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(new OpcionCorrecta("España"));
        opciones.agregarOpcion(new OpcionIncorrecta("Brasil"));
        opciones.agregarOpcion(new OpcionIncorrecta("Angola"));
        opciones.agregarOpcion(new OpcionCorrecta("Reino Unido"));
        opciones.agregarOpcion(new OpcionCorrecta("Croacia"));
        opciones.agregarOpcion(new OpcionIncorrecta("China"));
        opciones.agregarOpcion(new OpcionCorrecta("Grecia"));

        assertThrows(MasDeCincoOpcionesException.class,
                ()->{
                    new PreguntaMultipleChoice("¿Cuales de los siguientes paises son europeos?", 5, opciones);
                });
    }

    @Test
    public void testCreoPreguntaMultipleChoiceConNingunaOpcionYDevuelveExcepcion15() {

        assertThrows(NoHayOpcionesException.class,
                ()->{
                    new PreguntaMultipleChoice("¿Como se llama la calle donde se ubica la facultad de ingenieria?", 7, new ColeccionOpciones());
                });
    }

    //Agrego este test (aunque sea un getter) para aumentar cobertura
    @Test
    public void testCreoPreguntaMultipleChoiceYTieneNombreCorrecto16(){

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("1969");
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("1974");

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿En que año llego el hombre a la luna?",1,opciones);

        assertEquals(pregunta.getNombre(),"¿En que año llego el hombre a la luna?");
    }
}