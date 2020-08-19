package edu.fiuba.algo3.modelo.testunitarios;

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

public class TestPreguntaMultipleChoicePenalidad {

    private final OpcionCorrecta primeraOpcion = new OpcionCorrecta("2014",1);
    private final OpcionCorrecta segundaOpcion = new OpcionCorrecta("2010",1);
    private final OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("1902",-1);
    private final OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("El año pasado",-1);

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadSinMultiplicadorYRespondoUnaOpcionesCorrecta01(){

        Jugador jugador = new Jugador("Pedro");

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadSinMultiplicadorYRespondoDosOpcionesCorrectas02(){

        Jugador jugador = new Jugador("Pedro");

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),2);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadSinMultiplicadorYRespondoDosOpcionesCorrectasYUnaIncorrecta03(){

        Jugador jugador = new Jugador("Pedro");

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);
        opcionesSeleccionadas.add(terceraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadSinMultiplicadorYRespondoDosOpcionesIncorrectas04(){

        Jugador jugador = new Jugador("Pedro");

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),-2);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadConMultiplicadorPorDosYRespondoDosOpcionesCorrectas05(){

        Jugador jugador = new Jugador("Pedro");

        Multiplicador multiplicador = new MultiplicadorPorDos();

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador, multiplicador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),4);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadConMultiplicadorPorDosYRespondoDosOpcionesCorrectasYUnaIncorrecta06(){

        Jugador jugador = new Jugador("Pedro");

        Multiplicador multiplicador = new MultiplicadorPorDos();

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);
        opcionesSeleccionadas.add(terceraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador, multiplicador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),2);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadConMultiplicadorPorDosYRespondoDosOpcionesIncorrectas07(){

        Jugador jugador = new Jugador("Pedro");

        Multiplicador multiplicador = new MultiplicadorPorDos();

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador, multiplicador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),-4);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadConMultiplicadorPorTresYRespondoDosOpcionesIncorrectas08(){

        Jugador jugador = new Jugador("Pedro");

        Multiplicador multiplicador = new MultiplicadorPorTres();

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador, multiplicador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),-6);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadConMultiplicadorPorTresYRespondoDosOpcionesIncorrectasYUnaCorrecta09(){

        Jugador jugador = new Jugador("Pedro");

        Multiplicador multiplicador = new MultiplicadorPorTres();

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador, multiplicador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),-3);
    }
}