package edu.fiuba.algo3.modelo.testEntregas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoiceParcial;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultipleChoiceParcial;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPreguntaMultiChoiceParcialEntrega1 {

    @Test
    public void PreguntaMultipleChoiceParcialSeCreaIndicandoleCualesSonSusOpcionesCorrectas(){

        Jugador Juan = new Jugador("Juan");
        Jugador Fer = new Jugador("Fer");
        Jugador Guido = new Jugador("Guido");

        HashSet<Opcion> opciones = new HashSet<>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("Europa",5);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("Asia",5);
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("America",0);
        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("Marte",0);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿En qué lugar ocurrió la segunda guerra mundial?",opciones);

        HashSet<Opcion> opcionesJuan = new HashSet<>();

        opcionesJuan.add(primeraOpcion);
        opcionesJuan.add(segundaOpcion);

        RespuestaMultipleChoiceParcial respuestaJuan = new RespuestaMultipleChoiceParcial(opcionesJuan,Juan);

        HashSet<Opcion> opcionesFer = new HashSet<>();

        opcionesFer.add(primeraOpcion);

        RespuestaMultipleChoiceParcial respuestaFer = new RespuestaMultipleChoiceParcial(opcionesFer,Fer);

        HashSet<Opcion> opcionesGuido = new HashSet<>();

        opcionesGuido.add(segundaOpcion);

        RespuestaMultipleChoiceParcial respuestaGuido = new RespuestaMultipleChoiceParcial(opcionesGuido,Guido);

        LinkedList<RespuestaMultipleChoiceParcial> respuestas = new LinkedList<>();

        respuestas.add(respuestaJuan);
        respuestas.add(respuestaGuido);
        respuestas.add(respuestaFer);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),10);
        assertEquals(Guido.getPuntos().getCantidad(),5);
        assertEquals(Fer.getPuntos().getCantidad(),5);

    }


    @Test
    public void PreguntaMultipleChoiceParcialRecibeListaDeRespuestasYAsignaPuntosCorrectamenteALosJugadores(){


        Jugador Mati = new Jugador("Mati");
        Jugador Lucas = new Jugador("Lucas");

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("Enero",1);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("Octubre",1);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("Mayo",1);

        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("Febrero",0);
        OpcionIncorrecta quintaOpcion = new OpcionIncorrecta("Noviembre",0);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);
        opciones.add(quintaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿Cuales de los siguientes meses tienen 31 dias?",opciones);

        LinkedList<RespuestaMultipleChoiceParcial> respuestas = new LinkedList <RespuestaMultipleChoiceParcial>();

        HashSet<Opcion> opcionesSeleccionadasMati = new HashSet<Opcion>();
        opcionesSeleccionadasMati.add(primeraOpcion);
        opcionesSeleccionadasMati.add(segundaOpcion);
        opcionesSeleccionadasMati.add(terceraOpcion);
        opcionesSeleccionadasMati.add(cuartaOpcion);

        HashSet<Opcion> opcionesSeleccionadasLucas = new HashSet<Opcion>();
        opcionesSeleccionadasLucas.add(primeraOpcion);
        opcionesSeleccionadasLucas.add(segundaOpcion);

        RespuestaMultipleChoiceParcial respuestaMati = new RespuestaMultipleChoiceParcial(opcionesSeleccionadasMati, Mati);
        RespuestaMultipleChoiceParcial respuestaLucas = new RespuestaMultipleChoiceParcial(opcionesSeleccionadasLucas, Lucas);

        respuestas.add(respuestaMati);
        respuestas.add(respuestaLucas);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Mati.getPuntos().getCantidad(),0);
        assertEquals(Lucas.getPuntos().getCantidad(),2);

    }
}
