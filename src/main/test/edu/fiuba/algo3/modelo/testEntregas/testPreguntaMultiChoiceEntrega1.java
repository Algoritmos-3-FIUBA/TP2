package edu.fiuba.algo3.modelo.testEntregas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testPreguntaMultiChoiceEntrega1 {
/*    @Test
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

        PreguntaMultipleChoice pregunta2 = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        LinkedList<RespuestaMultipleChoice> respuestas = new LinkedList<RespuestaMultipleChoice>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<Opcion>();
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);
        opcionesSeleccionadas.add(primeraOpcion);

        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(opcionesSeleccionadas, Mati);


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

        assertEquals(Guido.getPuntos().getCantidad(), 0);
        assertEquals(Mati.getPuntos().getCantidad(), 1);
        assertTrue(pregunta.getOpcionesIncorrectas().contains(primeraOpcion));
        assertTrue(pregunta.getOpcionesIncorrectas().contains(segundaOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contains(terceraOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contains(cuartaOpcion));
    }*/
}
