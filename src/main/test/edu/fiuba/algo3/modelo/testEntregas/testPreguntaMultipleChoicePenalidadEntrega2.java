package edu.fiuba.algo3.modelo.testEntregas;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorTres;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorDos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoicePenalidad;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPreguntaMultipleChoicePenalidadEntrega2 {

    private final OpcionCorrecta primeraOpcion = new OpcionCorrecta("1896", 1);
    private final OpcionCorrecta segundaOpcion = new OpcionCorrecta("1936", 1);
    private final OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("1950", -1);
    private final OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("2002", -1);

    private final OpcionIncorrecta primeraOpcionDos = new OpcionIncorrecta("1896", -1);
    private final OpcionIncorrecta segundaOpcionDos = new OpcionIncorrecta("1936", -1);
    private final OpcionCorrecta terceraOpcionDos = new OpcionCorrecta("1950", 1);
    private final OpcionCorrecta cuartaOpcionDos = new OpcionCorrecta("2002", 1);

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadSinMultiplicadorYJugadorUnoGana01(){

        Jugador jugadorUno = new Jugador("Pedro");
        Jugador jugadorDos = new Jugador("Carlos");

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugaron juegos olimpicos de verano?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJugadorUno = new LinkedList<>();
        opcionesSeleccionadasJugadorUno.add(primeraOpcion);

        LinkedList<Opcion> opcionesSeleccionadasJugadorDos = new LinkedList<>();
        opcionesSeleccionadasJugadorDos.add(terceraOpcion);
        opcionesSeleccionadasJugadorDos.add(cuartaOpcion);

        RespuestaMultiple respuestaJugadorUno = new RespuestaMultiple(opcionesSeleccionadasJugadorUno, jugadorUno);
        RespuestaMultiple respuestaJugadorDos = new RespuestaMultiple(opcionesSeleccionadasJugadorDos, jugadorDos);

        respuestas.add(respuestaJugadorUno);
        respuestas.add(respuestaJugadorDos);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugadorUno.getPuntos().getCantidad(),1);
        assertEquals(jugadorDos.getPuntos().getCantidad(),-2);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadYJugadorUnoUsaMultiplicadorPorDos02(){

        Jugador jugadorUno = new Jugador("Pedro");
        Jugador jugadorDos = new Jugador("Carlos");

        Multiplicador multiplicador = new MultiplicadorPorDos();

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugaron juegos olimpicos de verano?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJugadorUno = new LinkedList<>();
        opcionesSeleccionadasJugadorUno.add(primeraOpcion);

        LinkedList<Opcion> opcionesSeleccionadasJugadorDos = new LinkedList<>();
        opcionesSeleccionadasJugadorDos.add(primeraOpcion);

        RespuestaMultiple respuestaJugadorUno = new RespuestaMultiple(opcionesSeleccionadasJugadorUno, jugadorUno, multiplicador);
        RespuestaMultiple respuestaJugadorDos = new RespuestaMultiple(opcionesSeleccionadasJugadorDos, jugadorDos);

        respuestas.add(respuestaJugadorUno);
        respuestas.add(respuestaJugadorDos);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugadorUno.getPuntos().getCantidad(),2);
        assertEquals(jugadorDos.getPuntos().getCantidad(),1);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadYJugadorDosUsaMultiplicadorPorTres03(){

        Jugador jugadorUno = new Jugador("Pedro");
        Jugador jugadorDos = new Jugador("Carlos");

        Multiplicador multiplicador = new MultiplicadorPorTres();

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugaron juegos olimpicos de verano?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJugadorUno = new LinkedList<>();
        opcionesSeleccionadasJugadorUno.add(primeraOpcion);

        LinkedList<Opcion> opcionesSeleccionadasJugadorDos = new LinkedList<>();
        opcionesSeleccionadasJugadorDos.add(cuartaOpcion);

        RespuestaMultiple respuestaJugadorUno = new RespuestaMultiple(opcionesSeleccionadasJugadorUno, jugadorUno);
        RespuestaMultiple respuestaJugadorDos = new RespuestaMultiple(opcionesSeleccionadasJugadorDos, jugadorDos, multiplicador);

        respuestas.add(respuestaJugadorUno);
        respuestas.add(respuestaJugadorDos);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugadorUno.getPuntos().getCantidad(),1);
        assertEquals(jugadorDos.getPuntos().getCantidad(),-3);
    }

    @Test
    public void testCreoDosPreguntaMultipleChoicePenalidadYJugadorUnoNoPuedeUasrMultiplicadorPorDosEnLasDosPreguntas04(){

        Jugador jugadorUno = new Jugador("Pedro");
        Jugador jugadorDos = new Jugador("Carlos");

        Multiplicador multiplicador = new MultiplicadorPorDos();

        ColeccionOpciones opcionesPreguntaUno = new ColeccionOpciones();

        opcionesPreguntaUno.agregarOpcion(primeraOpcion);
        opcionesPreguntaUno.agregarOpcion(segundaOpcion);
        opcionesPreguntaUno.agregarOpcion(terceraOpcion);
        opcionesPreguntaUno.agregarOpcion(cuartaOpcion);

        ColeccionOpciones opcionesPreguntaDos = new ColeccionOpciones();

        opcionesPreguntaDos.agregarOpcion(primeraOpcionDos);
        opcionesPreguntaDos.agregarOpcion(segundaOpcionDos);
        opcionesPreguntaDos.agregarOpcion(terceraOpcionDos);
        opcionesPreguntaDos.agregarOpcion(cuartaOpcionDos);

        PreguntaMultipleChoicePenalidad preguntaUno = new PreguntaMultipleChoicePenalidad("¿En que años se jugaron juegos olimpicos de verano?", opcionesPreguntaUno);
        PreguntaMultipleChoicePenalidad preguntaDos = new PreguntaMultipleChoicePenalidad("¿En que años NO se jugaron juegos olimpicos de verano?", opcionesPreguntaDos);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJugadorUno = new LinkedList<>();
        opcionesSeleccionadasJugadorUno.add(primeraOpcion);

        LinkedList<Opcion> opcionesSeleccionadasJugadorDos = new LinkedList<>();
        opcionesSeleccionadasJugadorDos.add(cuartaOpcion);

        RespuestaMultiple respuestaJugadorUno = new RespuestaMultiple(opcionesSeleccionadasJugadorUno, jugadorUno, multiplicador);
        RespuestaMultiple respuestaJugadorDos = new RespuestaMultiple(opcionesSeleccionadasJugadorDos, jugadorDos);

        respuestas.add(respuestaJugadorUno);
        respuestas.add(respuestaJugadorDos);

        preguntaUno.evaluarRespuestas(respuestas);

        assertEquals(jugadorUno.getPuntos().getCantidad(),2);
        assertEquals(jugadorDos.getPuntos().getCantidad(),-1);

        LinkedList<Respuesta> respuestasDos = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJugadorUnoPreguntaDos = new LinkedList<>();
        opcionesSeleccionadasJugadorUnoPreguntaDos.add(terceraOpcionDos);

        LinkedList<Opcion> opcionesSeleccionadasJugadorDosPreguntaDos = new LinkedList<>();
        opcionesSeleccionadasJugadorDosPreguntaDos.add(primeraOpcionDos);

        RespuestaMultiple respuestaJugadorUnoPreguntaDos = new RespuestaMultiple(opcionesSeleccionadasJugadorUnoPreguntaDos, jugadorUno, multiplicador);
        RespuestaMultiple respuestaJugadorDosPreguntaDos = new RespuestaMultiple(opcionesSeleccionadasJugadorDosPreguntaDos, jugadorDos);

        respuestasDos.add(respuestaJugadorUnoPreguntaDos);
        respuestasDos.add(respuestaJugadorDosPreguntaDos);

        preguntaDos.evaluarRespuestas(respuestasDos);

        assertEquals(jugadorUno.getPuntos().getCantidad(),3);
        assertEquals(jugadorDos.getPuntos().getCantidad(),-2);

    }
}