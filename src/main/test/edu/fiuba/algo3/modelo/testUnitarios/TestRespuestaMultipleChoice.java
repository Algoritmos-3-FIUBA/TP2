package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TestRespuestaMultipleChoice {
    private Opcion primeraOpcion = new OpcionCorrecta("Euler",0);
    private Opcion segundaOpcion = new OpcionCorrecta("Gauss",0);
    private Opcion terceraOpcion  = new OpcionCorrecta("Faraday",0);
    private Opcion cuartaOpcion = new OpcionCorrecta("Newton",0);
    private Opcion quintaOpcion = new OpcionCorrecta("Einstein",0);

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaEligiendoUnaOpcionYObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        opcionesElegidas.add(primeraOpcion);

        RespuestaMultipleChoice respuestaJugador = new RespuestaMultipleChoice(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)primeraOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, 1);

        Assertions.assertEquals(jugador.getPuntos(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaEligiendoDosOpcionesYObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        //No importa el orden de opciones elegidas, siempre que sean correctas se asignará el puntaje
        opcionesElegidas.add(segundaOpcion);
        opcionesElegidas.add(primeraOpcion);

        RespuestaMultipleChoice respuestaJugador = new RespuestaMultipleChoice(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)primeraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)segundaOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, 1);

        Assertions.assertEquals(jugador.getPuntos(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaEligiendoTresOpcionesYObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        //No importa el orden de opciones elegidas, siempre que sean correctas se asignará el puntaje
        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(segundaOpcion);

        RespuestaMultipleChoice respuestaJugador = new RespuestaMultipleChoice(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)primeraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)segundaOpcion);
        opcionesCorrectas.add((OpcionCorrecta)terceraOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, 1);

        Assertions.assertEquals(jugador.getPuntos(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaEligiendoCuatroOpcionesYObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        //No importa el orden de opciones elegidas, siempre que sean correctas se asignará el puntaje
        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(cuartaOpcion);
        opcionesElegidas.add(segundaOpcion);

        RespuestaMultipleChoice respuestaJugador = new RespuestaMultipleChoice(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)primeraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)segundaOpcion);
        opcionesCorrectas.add((OpcionCorrecta)terceraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)cuartaOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, 1);

        Assertions.assertEquals(jugador.getPuntos(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaEligiendoCincoOpcionesYObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        //No importa el orden de opciones elegidas, siempre que sean correctas se asignará el puntaje
        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(quintaOpcion);
        opcionesElegidas.add(cuartaOpcion);
        opcionesElegidas.add(segundaOpcion);

        RespuestaMultipleChoice respuestaJugador = new RespuestaMultipleChoice(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)primeraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)segundaOpcion);
        opcionesCorrectas.add((OpcionCorrecta)terceraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)cuartaOpcion);
        opcionesCorrectas.add((OpcionCorrecta)quintaOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, 1);

        Assertions.assertEquals(jugador.getPuntos(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaEligiendoUnaOpcionYNoObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        opcionesElegidas.add(primeraOpcion);

        RespuestaMultipleChoice respuestaJugador = new RespuestaMultipleChoice(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)segundaOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, 1);

        Assertions.assertEquals(jugador.getPuntos(),0);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaEligiendoOpcionesDeMenosYNoObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        opcionesElegidas.add(segundaOpcion);

        RespuestaMultipleChoice respuestaJugador = new RespuestaMultipleChoice(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)primeraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)segundaOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, 1);

        Assertions.assertEquals(jugador.getPuntos(),0);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaEligiendoOpcionesDeMasYNoObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        opcionesElegidas.add(segundaOpcion);
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(quintaOpcion);

        RespuestaMultipleChoice respuestaJugador = new RespuestaMultipleChoice(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)primeraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)segundaOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, 1);

        Assertions.assertEquals(jugador.getPuntos(),0);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaEligiendoTodasLasOpcionesIncorrectasYNoObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        opcionesElegidas.add(cuartaOpcion);
        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(quintaOpcion);

        RespuestaMultipleChoice respuestaJugador = new RespuestaMultipleChoice(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)primeraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)segundaOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, 1);

        Assertions.assertEquals(jugador.getPuntos(),0);
    }
}