package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.LinkedList;

public class TestPreguntaMultipleChoiceParcial {

    @Test
    public void CreoPreguntaMultipleChoiceParcialYTieneRespuestasCorrectas(){

        Jugador Juan = new Jugador("Juan");

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("1969",5);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("1974",0);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿En que año llego el hombre a la luna?",opciones);

        LinkedList<RespuestaMultipleChoiceParcial> respuestas = new LinkedList<RespuestaMultipleChoiceParcial>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<Opcion>();
        opcionesSeleccionadas.add(primeraOpcion);

        RespuestaMultipleChoiceParcial respuesta = new RespuestaMultipleChoiceParcial(opcionesSeleccionadas, Juan);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos(),5);
    }

    @Test
    public void CreoPreguntaMultipleChoiceParcialYTieneRespuestasIncorrectas(){

        Jugador Juan = new Jugador("Juan");

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("1969",5);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("1974",0);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿En que año llego el hombre a la luna?",opciones);

        LinkedList<RespuestaMultipleChoiceParcial> respuestas = new LinkedList<RespuestaMultipleChoiceParcial>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<Opcion>();
        opcionesSeleccionadas.add(segundaOpcion);

        RespuestaMultipleChoiceParcial respuesta = new RespuestaMultipleChoiceParcial(opcionesSeleccionadas, Juan);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos(),0);
    }

    @Test
    public void PreguntaEvaluaUnaRespuestaParcialmenteCorrectaYOtorgaLosPuntosEsperados(){

        Jugador Juan = new Jugador("Juan");

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("Paris",1);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("Francia",1);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("Europa",1);
        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("Argentina",0);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿Donde se encuentra la torre Eiffel?",opciones);

        LinkedList<RespuestaMultipleChoiceParcial> respuestas = new LinkedList<RespuestaMultipleChoiceParcial>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<Opcion>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);

        RespuestaMultipleChoiceParcial respuesta = new RespuestaMultipleChoiceParcial(opcionesSeleccionadas, Juan);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos(),2);
    }

    @Test
    public void PreguntaEvaluaUnaRespuestaQueTieneOpcionesCorrectasYUnaIncorrectaYNoOtorgaPuntos(){

        Jugador Juan = new Jugador("Juan");

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("C",1);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("Java",0);
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("Smalltalk",0);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿Cuales de los siguientes lenguajes no son orientados a objetos?",opciones);

        LinkedList<RespuestaMultipleChoiceParcial> respuestas = new LinkedList<RespuestaMultipleChoiceParcial>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<Opcion>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(terceraOpcion);

        RespuestaMultipleChoiceParcial respuesta = new RespuestaMultipleChoiceParcial(opcionesSeleccionadas, Juan);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos(),0);
    }

    @Test
    public void PreguntaEvaluaUnaRespuestaQueTieneTodasOpcionesCorrectasYDevuelveLosPuntosEsperados(){

        Jugador Juan = new Jugador("Juan");

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("Encapsulamiento",1);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("Polimorfismo",1);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("Ocultamiento de la informacio",1);
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("Herencia",1);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿Cuales de los siguientes conceptos son importantes en POO?",opciones);

        LinkedList<RespuestaMultipleChoiceParcial> respuestas = new LinkedList<RespuestaMultipleChoiceParcial>();

        HashSet<Opcion> opcionesSeleccionadas = new HashSet<Opcion>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);

        RespuestaMultipleChoiceParcial respuesta = new RespuestaMultipleChoiceParcial(opcionesSeleccionadas, Juan);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos(),4);
    }

    @Test
    public void PreguntaEvaluaLasRespuestasDeVariosJugadoresYOtorgaLosPuntosAdecuados(){

        Jugador Juan = new Jugador("Juan");
        Jugador Mati = new Jugador("Mati");
        Jugador Lucas = new Jugador("Lucas");

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("Sarmiento",5);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("Belgrano",5);
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("Saavedra",0);
        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("Liniers",0);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿Quien de los siguientes proceres aparece en un billete?",opciones);

        LinkedList <RespuestaMultipleChoiceParcial> respuestas = new LinkedList <RespuestaMultipleChoiceParcial>();

        HashSet<Opcion> opcionesSeleccionadasJuan = new HashSet<Opcion>();
        opcionesSeleccionadasJuan.add(primeraOpcion);
        opcionesSeleccionadasJuan.add(segundaOpcion);
        opcionesSeleccionadasJuan.add(terceraOpcion);

        HashSet<Opcion> opcionesSeleccionadasMati = new HashSet<Opcion>();
        opcionesSeleccionadasMati.add(primeraOpcion);

        HashSet<Opcion> opcionesSeleccionadasLucas = new HashSet<Opcion>();
        opcionesSeleccionadasLucas.add(primeraOpcion);
        opcionesSeleccionadasLucas.add(segundaOpcion);

        RespuestaMultipleChoiceParcial respuestaJuan = new RespuestaMultipleChoiceParcial(opcionesSeleccionadasJuan, Juan);
        RespuestaMultipleChoiceParcial respuestaMati = new RespuestaMultipleChoiceParcial(opcionesSeleccionadasMati, Mati);
        RespuestaMultipleChoiceParcial respuestaLucas = new RespuestaMultipleChoiceParcial(opcionesSeleccionadasLucas, Lucas);

        respuestas.add(respuestaJuan);
        respuestas.add(respuestaMati);
        respuestas.add(respuestaLucas);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos(),0);
        assertEquals(Mati.getPuntos(),5);
        assertEquals(Lucas.getPuntos(),10);
    }
}
