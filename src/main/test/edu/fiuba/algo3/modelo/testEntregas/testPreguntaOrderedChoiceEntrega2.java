package edu.fiuba.algo3.modelo.testEntregas;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaOrderedChoice;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPreguntaOrderedChoiceEntrega2 {
    OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1");
    OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1");
    OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2");
    OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2");

    @Test
    public void testCreoPreguntaOrderedChoiceConDosRespuestasCorrectasYJugadorRespondeCorrectamente01() {

        Jugador Guido = new Jugador("Guido");

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<Opcion>();
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Guido);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 1);
    }
    @Test
    public void testCreoPreguntaOrderedChoiceConDosRespuestasCorrectasYJugadorRespondeEnOrdenIncorrecto02() {

        Jugador Fernando = new Jugador("Fernando");

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<Opcion>();

        opcionesSeleccionadas.add(cuartaOpcion);
        opcionesSeleccionadas.add(terceraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Fernando);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Fernando.getPuntos().getCantidad(), 0);
    }
}