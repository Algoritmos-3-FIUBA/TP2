package edu.fiuba.algo3.modelo.testentregas;

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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPreguntaMultiChoiceEntrega01 {
    private final OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1");
    private final OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1");
    private final OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2");
    private final OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2");

    @Test
    public void testCreoPreguntaMultipleChoiceConDosRespuestasCorrectasYJugadorRespondeDosCorrectasYUnaIncorrecta01() {

        Jugador Mati = new Jugador("Mati");

        ColeccionOpciones opciones = new ColeccionOpciones();

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
        assertTrue(pregunta.getOpcionesIncorrectas().contiene(primeraOpcion));
        assertTrue(pregunta.getOpcionesIncorrectas().contiene(segundaOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contiene(terceraOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contiene(cuartaOpcion));
    }

    @Test
    public void testCreoPreguntaMultipleChoiceConDosJugadoreUnoSoloObtienePuntaje02() {

        Jugador Mati = new Jugador("Mati");
        Jugador Guido = new Jugador("Guido");

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasGuido = new LinkedList<Opcion>();
        opcionesSeleccionadasGuido.add(terceraOpcion);
        opcionesSeleccionadasGuido.add(cuartaOpcion);
        opcionesSeleccionadasGuido.add(primeraOpcion);

        RespuestaMultiple respuestaGuido = new RespuestaMultiple(opcionesSeleccionadasGuido, Guido);

        LinkedList<Opcion> opcionesSeleccionadasMati = new LinkedList<Opcion>();
        opcionesSeleccionadasMati.add(terceraOpcion);
        opcionesSeleccionadasMati.add(cuartaOpcion);

        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati);

        respuestas.add(respuestaGuido);
        respuestas.add(respuestaMati);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 0);
        assertEquals(Mati.getPuntos().getCantidad(), 1);
        assertTrue(pregunta.getOpcionesIncorrectas().contiene(primeraOpcion));
        assertTrue(pregunta.getOpcionesIncorrectas().contiene(segundaOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contiene(terceraOpcion));
        assertTrue(pregunta.getOpcionesCorrectas().contiene(cuartaOpcion));
    }
}