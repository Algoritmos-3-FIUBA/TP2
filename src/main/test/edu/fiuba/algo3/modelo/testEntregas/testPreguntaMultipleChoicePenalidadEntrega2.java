package edu.fiuba.algo3.modelo.testEntregas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorTres;
import edu.fiuba.algo3.modelo.multiplicador.MutiplicadorPorDos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoicePenalidad;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPreguntaMultipleChoicePenalidadEntrega2 {

    OpcionCorrecta primeraOpcion = new OpcionCorrecta("1896", 1);
    OpcionCorrecta segundaOpcion = new OpcionCorrecta("1936", 1);
    OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("1950", -1);
    OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("2002", -1);

    OpcionIncorrecta primeraOpcionDos = new OpcionIncorrecta("1896", -1);
    OpcionIncorrecta segundaOpcionDos = new OpcionIncorrecta("1936", -1);
    OpcionCorrecta terceraOpcionDos = new OpcionCorrecta("1950", 1);
    OpcionCorrecta cuartaOpcionDos = new OpcionCorrecta("2002", 1);

    @Test
    public void CreoPreguntaMultipleChoicePenalidadSinMultiplicadorYJugadorUnoGana(){

        Jugador jugadorUno = new Jugador("Pedro");
        Jugador jugadorDos = new Jugador("Carlos");

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugaron juegos olimpicos de verano?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        HashSet<Opcion> opcionesSeleccionadasJugadorUno = new HashSet<>();
        opcionesSeleccionadasJugadorUno.add(primeraOpcion);

        HashSet<Opcion> opcionesSeleccionadasJugadorDos = new HashSet<>();
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
    public void CreoPreguntaMultipleChoicePenalidadYJugadorUnoUsaMultiplicadorPorDos(){

        Jugador jugadorUno = new Jugador("Pedro");
        Jugador jugadorDos = new Jugador("Carlos");

        Multiplicador multiplicador = new MutiplicadorPorDos();

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugaron juegos olimpicos de verano?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        HashSet<Opcion> opcionesSeleccionadasJugadorUno = new HashSet<>();
        opcionesSeleccionadasJugadorUno.add(primeraOpcion);

        HashSet<Opcion> opcionesSeleccionadasJugadorDos = new HashSet<>();
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
    public void CreoPreguntaMultipleChoicePenalidadYJugadorDosUsaMultiplicadorPorTres(){

        Jugador jugadorUno = new Jugador("Pedro");
        Jugador jugadorDos = new Jugador("Carlos");

        Multiplicador multiplicador = new MultiplicadorPorTres();

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugaron juegos olimpicos de verano?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        HashSet<Opcion> opcionesSeleccionadasJugadorUno = new HashSet<>();
        opcionesSeleccionadasJugadorUno.add(primeraOpcion);

        HashSet<Opcion> opcionesSeleccionadasJugadorDos = new HashSet<>();
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
    public void CreoDosPreguntaMultipleChoicePenalidadYJugadorUnoNoPuedeUasrMultiplicadorPorDosEnLasDosPreguntas(){

        Jugador jugadorUno = new Jugador("Pedro");
        Jugador jugadorDos = new Jugador("Carlos");

        Multiplicador multiplicador = new MutiplicadorPorDos();

        HashSet<Opcion> opcionesPreguntaUno = new HashSet<Opcion>();

        opcionesPreguntaUno.add(primeraOpcion);
        opcionesPreguntaUno.add(segundaOpcion);
        opcionesPreguntaUno.add(terceraOpcion);
        opcionesPreguntaUno.add(cuartaOpcion);

        HashSet<Opcion> opcionesPreguntaDos = new HashSet<Opcion>();

        opcionesPreguntaDos.add(primeraOpcionDos);
        opcionesPreguntaDos.add(segundaOpcionDos);
        opcionesPreguntaDos.add(terceraOpcionDos);
        opcionesPreguntaDos.add(cuartaOpcionDos);

        PreguntaMultipleChoicePenalidad preguntaUno = new PreguntaMultipleChoicePenalidad("¿En que años se jugaron juegos olimpicos de verano?", opcionesPreguntaUno);
        PreguntaMultipleChoicePenalidad preguntaDos = new PreguntaMultipleChoicePenalidad("¿En que años NO se jugaron juegos olimpicos de verano?", opcionesPreguntaDos);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        HashSet<Opcion> opcionesSeleccionadasJugadorUno = new HashSet<>();
        opcionesSeleccionadasJugadorUno.add(primeraOpcion);

        HashSet<Opcion> opcionesSeleccionadasJugadorDos = new HashSet<>();
        opcionesSeleccionadasJugadorDos.add(cuartaOpcion);

        RespuestaMultiple respuestaJugadorUno = new RespuestaMultiple(opcionesSeleccionadasJugadorUno, jugadorUno, multiplicador);
        RespuestaMultiple respuestaJugadorDos = new RespuestaMultiple(opcionesSeleccionadasJugadorDos, jugadorDos);

        respuestas.add(respuestaJugadorUno);
        respuestas.add(respuestaJugadorDos);

        preguntaUno.evaluarRespuestas(respuestas);

        assertEquals(jugadorUno.getPuntos().getCantidad(),2);
        assertEquals(jugadorDos.getPuntos().getCantidad(),-1);

        LinkedList<Respuesta> respuestasDos = new LinkedList<Respuesta>();

        HashSet<Opcion> opcionesSeleccionadasJugadorUnoPreguntaDos = new HashSet<>();
        opcionesSeleccionadasJugadorUnoPreguntaDos.add(terceraOpcionDos);

        HashSet<Opcion> opcionesSeleccionadasJugadorDosPreguntaDos = new HashSet<>();
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
