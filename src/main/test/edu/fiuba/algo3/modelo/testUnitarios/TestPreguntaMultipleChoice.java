package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
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

        opciones.agregarOpcion(new OpcionIncorrecta("1 + 1"));
        opciones.agregarOpcion(new OpcionIncorrecta("3 - 1"));
        opciones.agregarOpcion(new OpcionCorrecta("2 + 2"));
        opciones.agregarOpcion(new OpcionCorrecta("2 * 2"));

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        assertEquals((pregunta.getOpcionesCorrectas()).cantidadElementos(), 2);
    }

    @Test
    public void CreoPreguntaMultipleChoiceConDosRespuestasIncorrectasYSeAsignanCorrectamente() {

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(new OpcionIncorrecta("1 + 1"));
        opciones.agregarOpcion(new OpcionIncorrecta("3 - 1"));
        opciones.agregarOpcion(new OpcionCorrecta("2 + 2"));
        opciones.agregarOpcion(new OpcionCorrecta("2 * 2"));

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        assertEquals((pregunta.getOpcionesIncorrectas()).cantidadElementos(), 2);
    }

    @Test
        public void CreoPreguntaMultipleChoiceConDosRespuestasCorrectasYJugadorEligeDosCorrectas() {

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
    public void CreoPreguntaMultipleChoiceConDosRespuestasCorrectasYJugadorRespondeUnaCorrecta() {

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
    public void CreoPreguntaMultipleChoiceConDosRespuestasCorrectasYJugadorRespondeDosCorrectasYUnaIncorrecta() {

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
    public void CreoPreguntaMultipleChoiceConDosRespuestasCorrectasYJugadorRespondeDosIncorrectas() {

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
    public void CreoPreguntaMultipleChoiceConDosRespuestasCorrectasYEvaluaVariasRespuestas() {

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
    public void CreoPreguntaMultipleChoiceYRespondeSoloUnJugadorCorrectamenteConExclusividad() {

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
        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan,new Exclusividad());

        respuestas.add(respuestaMati);
        respuestas.add(respuestaGuido);
        respuestas.add(respuestaJuan);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Mati.getPuntos().getCantidad(), 0);
        assertEquals(Guido.getPuntos().getCantidad(), 0);
        assertEquals(Juan.getPuntos().getCantidad(), 2);
    }

    @Test
    public void CreoPreguntaMultipleChoiceYRespondeSoloUnJugadorCorrectamenteConLaExclusividadDeOtro() {

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

        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati,new Exclusividad());
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
    public void CreoPreguntaMultipleChoiceYRespondenDosJugadoresCorrectamenteConUnaExclusividad() {

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

        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati,new Exclusividad());
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
    public void CreoPreguntaMultipleChoiceYRespondenUnJugadorCorrectamenteConDosExclusividades() {

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

        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati,new Exclusividad());
        RespuestaMultiple respuestaGuido = new RespuestaMultiple(opcionesSeleccionadasGuido, Guido,new Exclusividad());
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
    public void CreoPreguntaMultipleChoiceYRespondenVariosJugadorCorrectamenteConVariasExclusividades() {

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

        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati,new Exclusividad());
        RespuestaMultiple respuestaGuido = new RespuestaMultiple(opcionesSeleccionadasGuido, Guido,new Exclusividad());
        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan);
        RespuestaMultiple respuestaFer = new RespuestaMultiple(opcionesSeleccionadasFer, Fer,new Exclusividad());
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
    public void CreoPreguntaMultipleChoiceYRespondeUnJugadorCorrectamenteConVariasExclusividades() {

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

        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati,new Exclusividad());
        RespuestaMultiple respuestaGuido = new RespuestaMultiple(opcionesSeleccionadasGuido, Guido,new Exclusividad());
        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan,new Exclusividad());
        RespuestaMultiple respuestaFer = new RespuestaMultiple(opcionesSeleccionadasFer, Fer,new Exclusividad());
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
}
