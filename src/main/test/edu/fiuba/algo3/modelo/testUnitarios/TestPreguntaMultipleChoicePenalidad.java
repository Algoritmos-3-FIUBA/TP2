package edu.fiuba.algo3.modelo.testUnitarios;

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

public class TestPreguntaMultipleChoicePenalidad {

    @Test
    public void CreoPreguntaMultipleChoicePenalidadSinMultiplicadorYRespondoUnaOpcionesCorrecta(){

        Jugador jugador = new Jugador("Pedro");

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("2014",1);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("2010",1);
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("1902",-1);
        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("El año pasado",-1);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<>();
        opcionesSeleccionadas.add(primeraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void CreoPreguntaMultipleChoicePenalidadSinMultiplicadorYRespondoDosOpcionesCorrectas(){

        Jugador jugador = new Jugador("Pedro");

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("2014",1);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("2010",1);
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("1902",-1);
        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("El año pasado",-1);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),2);
    }

    @Test
    public void CreoPreguntaMultipleChoicePenalidadSinMultiplicadorYRespondoDosOpcionesCorrectasYUnaIncorrecta(){

        Jugador jugador = new Jugador("Pedro");

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("2014",1);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("2010",1);
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("1902",-1);
        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("El año pasado",-1);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);
        opcionesSeleccionadas.add(terceraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void CreoPreguntaMultipleChoicePenalidadSinMultiplicadorYRespondoDosOpcionesIncorrectas(){

        Jugador jugador = new Jugador("Pedro");

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("2014",1);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("2010",1);
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("1902",-1);
        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("El año pasado",-1);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<>();
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),-2);
    }

    @Test
    public void CreoPreguntaMultipleChoicePenalidadConMultiplicadorPorDosYRespondoDosOpcionesCorrectas(){

        Jugador jugador = new Jugador("Pedro");
        Multiplicador multiplicador = new MutiplicadorPorDos();

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("2014",1);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("2010",1);
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("1902",-1);
        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("El año pasado",-1);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador, multiplicador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),4);
    }

    @Test
    public void CreoPreguntaMultipleChoicePenalidadConMultiplicadorPorDosYRespondoDosOpcionesCorrectasYUnaIncorrecta(){

        Jugador jugador = new Jugador("Pedro");
        Multiplicador multiplicador = new MutiplicadorPorDos();

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("2014",1);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("2010",1);
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("1902",-1);
        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("El año pasado",-1);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);
        opcionesSeleccionadas.add(terceraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador, multiplicador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),2);
    }

    @Test
    public void CreoPreguntaMultipleChoicePenalidadConMultiplicadorPorDosYRespondoDosOpcionesIncorrectas(){

        Jugador jugador = new Jugador("Pedro");
        Multiplicador multiplicador = new MutiplicadorPorDos();

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("2014",1);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("2010",1);
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("1902",-1);
        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("El año pasado",-1);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<>();
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador, multiplicador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),-4);
    }

    @Test
    public void CreoPreguntaMultipleChoicePenalidadConMultiplicadorPorTresYRespondoDosOpcionesIncorrectas(){

        Jugador jugador = new Jugador("Pedro");
        Multiplicador multiplicador = new MultiplicadorPorTres();

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("2014",1);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("2010",1);
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("1902",-1);
        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("El año pasado",-1);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<>();
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador, multiplicador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),-6);
    }

    @Test
    public void CreoPreguntaMultipleChoicePenalidadConMultiplicadorPorTresYRespondoDosOpcionesIncorrectasYUnaCorrecta(){

        Jugador jugador = new Jugador("Pedro");
        Multiplicador multiplicador = new MultiplicadorPorTres();

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("2014",1);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("2010",1);
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("1902",-1);
        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("El año pasado",-1);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador, multiplicador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),-3);
    }

}
