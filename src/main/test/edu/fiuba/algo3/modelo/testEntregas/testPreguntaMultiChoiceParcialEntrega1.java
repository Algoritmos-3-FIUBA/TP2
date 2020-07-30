package edu.fiuba.algo3.modelo.testEntregas;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPreguntaMultiChoiceParcialEntrega1 {

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

        assertEquals(Mati.getPuntos(),0);
        assertEquals(Lucas.getPuntos(),2);

    }
}
