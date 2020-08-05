package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultipleChoiceParcial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class TestRespuestaMultipleChoiceParcial {
/*    private Opcion primeraOpcion = new OpcionCorrecta("Euler",1);
    private Opcion segundaOpcion = new OpcionCorrecta("Gauss",1);
    private Opcion terceraOpcion  = new OpcionCorrecta("Faraday",1);
    private Opcion cuartaOpcion = new OpcionCorrecta("Newton",1);
    private Opcion quintaOpcion = new OpcionCorrecta("Einstein",1);

    private Opcion sextaOpcion = new OpcionIncorrecta("Van Gogh",0);
    private Opcion septimaOpcion = new OpcionIncorrecta("Minujin",0);
    private Opcion octavaOpcion = new OpcionIncorrecta("Pollock",0);


    @Test
    public void JugadorRealizaUnaRespuestaCorrectaEligiendoUnaOpcionYObtienePuntaje(){
        Jugador jugador = new Jugador("Fernando");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        opcionesElegidas.add(primeraOpcion);

        RespuestaMultipleChoiceParcial respuestaJugador = new RespuestaMultipleChoiceParcial(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta) primeraOpcion);

        //Opciones Incorrectas
        HashSet<OpcionIncorrecta> opcionesIncorrectas = new HashSet<OpcionIncorrecta>();
        opcionesIncorrectas.add((OpcionIncorrecta)sextaOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, opcionesIncorrectas);

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaEligiendoDosOpcionesYObtiene2Puntos(){
        Jugador jugador = new Jugador("Fernando");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        //No importa el orden de opciones elegidas, siempre que sean correctas se asignará el puntaje
        opcionesElegidas.add(segundaOpcion);
        opcionesElegidas.add(primeraOpcion);

        RespuestaMultipleChoiceParcial respuestaJugador = new RespuestaMultipleChoiceParcial(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)primeraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)segundaOpcion);

        //Opciones Incorrectas
        HashSet<OpcionIncorrecta> opcionesIncorrectas = new HashSet<OpcionIncorrecta>();
        opcionesIncorrectas.add((OpcionIncorrecta)sextaOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, opcionesIncorrectas);

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),2);
    }

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaEligiendoTresOpcionesYObtienePuntaje() {
        Jugador jugador = new Jugador("Fernando");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        //No importa el orden de opciones elegidas, siempre que sean correctas se asignará el puntaje
        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(segundaOpcion);

        RespuestaMultipleChoiceParcial respuestaJugador = new RespuestaMultipleChoiceParcial(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)primeraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)segundaOpcion);
        opcionesCorrectas.add((OpcionCorrecta)terceraOpcion);

        //Opciones Incorrectas
        HashSet<OpcionIncorrecta> opcionesIncorrectas = new HashSet<OpcionIncorrecta>();
        opcionesIncorrectas.add((OpcionIncorrecta)sextaOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, opcionesIncorrectas);

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),3);
    }

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaEligiendoCuatroOpcionesYObtienePuntaje(){
        Jugador jugador = new Jugador("Fernando");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        //No importa el orden de opciones elegidas, siempre que sean correctas se asignará el puntaje
        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(cuartaOpcion);
        opcionesElegidas.add(segundaOpcion);

        RespuestaMultipleChoiceParcial respuestaJugador = new RespuestaMultipleChoiceParcial(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)primeraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)segundaOpcion);
        opcionesCorrectas.add((OpcionCorrecta)terceraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)cuartaOpcion);

        //Opciones Incorrectas
        HashSet<OpcionIncorrecta> opcionesIncorrectas = new HashSet<OpcionIncorrecta>();
        opcionesIncorrectas.add((OpcionIncorrecta)sextaOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, opcionesIncorrectas);

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),4);
    }

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaEligiendoCincoOpcionesYObtienePuntaje(){
        Jugador jugador = new Jugador("Fernando");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        //No importa el orden de opciones elegidas, siempre que sean correctas se asignará el puntaje
        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(quintaOpcion);
        opcionesElegidas.add(cuartaOpcion);
        opcionesElegidas.add(segundaOpcion);

        RespuestaMultipleChoiceParcial respuestaJugador = new RespuestaMultipleChoiceParcial(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)primeraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)segundaOpcion);
        opcionesCorrectas.add((OpcionCorrecta)terceraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)cuartaOpcion);
        opcionesCorrectas.add((OpcionCorrecta)quintaOpcion);

        //Opciones Incorrectas
        HashSet<OpcionIncorrecta> opcionesIncorrectas = new HashSet<OpcionIncorrecta>();
        opcionesIncorrectas.add((OpcionIncorrecta)sextaOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, opcionesIncorrectas);

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),5);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaEligiendoUnaOpcionYNoObtienePuntaje(){
        Jugador jugador = new Jugador("Fernando");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        opcionesElegidas.add(sextaOpcion);

        RespuestaMultipleChoiceParcial respuestaJugador = new RespuestaMultipleChoiceParcial(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)segundaOpcion);

        //Opciones Incorrectas
        HashSet<OpcionIncorrecta> opcionesIncorrectas = new HashSet<OpcionIncorrecta>();
        opcionesIncorrectas.add((OpcionIncorrecta)sextaOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, opcionesIncorrectas);

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),0);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaEligiendoOpcionesDeMenosYObtienePuntajeParcial(){
        Jugador jugador = new Jugador("Fernando");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        opcionesElegidas.add(segundaOpcion);

        RespuestaMultipleChoiceParcial respuestaJugador = new RespuestaMultipleChoiceParcial(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)primeraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)segundaOpcion);

        //Opciones Incorrectas
        HashSet<OpcionIncorrecta> opcionesIncorrectas = new HashSet<OpcionIncorrecta>();
        opcionesIncorrectas.add((OpcionIncorrecta)sextaOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, opcionesIncorrectas);

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaEligiendoOpcionesDeMasYNoObtienePuntaje(){
        Jugador jugador = new Jugador("Fernando");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        opcionesElegidas.add(segundaOpcion);
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(sextaOpcion);

        RespuestaMultipleChoiceParcial respuestaJugador = new RespuestaMultipleChoiceParcial(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)primeraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)segundaOpcion);

        //Opciones Incorrectas
        HashSet<OpcionIncorrecta> opcionesIncorrectas = new HashSet<OpcionIncorrecta>();
        opcionesIncorrectas.add((OpcionIncorrecta)sextaOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, opcionesIncorrectas);

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),0);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaEligiendoTodasLasOpcionesCorrectasYunaIncorrectaYNoObtienePuntaje(){
        Jugador jugador = new Jugador("Fernando");

        //Opciones que son eligidas
        HashSet<Opcion> opcionesElegidas = new HashSet<Opcion>();
        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(cuartaOpcion);
        opcionesElegidas.add(quintaOpcion);
        opcionesElegidas.add(sextaOpcion);

        RespuestaMultipleChoiceParcial respuestaJugador = new RespuestaMultipleChoiceParcial(opcionesElegidas, jugador);

        //Opciones Correctas
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<OpcionCorrecta>();
        opcionesCorrectas.add((OpcionCorrecta)terceraOpcion);
        opcionesCorrectas.add((OpcionCorrecta)cuartaOpcion);
        opcionesCorrectas.add((OpcionCorrecta)quintaOpcion);

        //Opciones Incorrectas
        HashSet<OpcionIncorrecta> opcionesIncorrectas = new HashSet<OpcionIncorrecta>();
        opcionesIncorrectas.add((OpcionIncorrecta)sextaOpcion);
        opcionesIncorrectas.add((OpcionIncorrecta)septimaOpcion);
        opcionesIncorrectas.add((OpcionIncorrecta)octavaOpcion);

        respuestaJugador.otorgarPuntos(opcionesCorrectas, opcionesIncorrectas);

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),0);
    }
*/
}
