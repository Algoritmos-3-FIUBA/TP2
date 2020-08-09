package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

public class TestRespuestaMultiple {

    //Actualizar a la nueva version en la que pregunta evalua la respuesta
    /*
    private Opcion primeraOpcion = new OpcionCorrecta("Euler",0);
    private Opcion segundaOpcion = new OpcionCorrecta("Gauss",0);
    private Opcion terceraOpcion  = new OpcionCorrecta("Faraday",0);
    private Opcion cuartaOpcion = new OpcionCorrecta("Newton",0);
    private Opcion quintaOpcion = new OpcionCorrecta("Einstein",0);

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaEligiendoUnaOpcionYObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<>();
        opcionesElegidas.add(primeraOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);

        respuestaJugador.otorgarPuntos(new Puntos(1));

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaEligiendoDosOpcionesYObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();

        opcionesElegidas.add(segundaOpcion);
        opcionesElegidas.add(primeraOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);

        respuestaJugador.otorgarPuntos(new Puntos(1));

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaEligiendoTresOpcionesYObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();

        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(segundaOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);

        respuestaJugador.otorgarPuntos(new Puntos(1));

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaEligiendoCuatroOpcionesYObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();
        //No importa el orden de opciones elegidas, siempre que sean correctas se asignará el puntaje
        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(cuartaOpcion);
        opcionesElegidas.add(segundaOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);

        respuestaJugador.otorgarPuntos(new Puntos(1));

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaEligiendoCincoOpcionesYObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();

        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(quintaOpcion);
        opcionesElegidas.add(cuartaOpcion);
        opcionesElegidas.add(segundaOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);

        respuestaJugador.otorgarPuntos(new Puntos(1));

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaEligiendoUnaOpcionYNoObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();
        opcionesElegidas.add(primeraOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);

        respuestaJugador.otorgarPuntos(new Puntos(1));

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),0);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaEligiendoOpcionesDeMenosYNoObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();
        opcionesElegidas.add(segundaOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);

        respuestaJugador.otorgarPuntos(new Puntos(1));

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),0);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaEligiendoOpcionesDeMasYNoObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();
        opcionesElegidas.add(segundaOpcion);
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(quintaOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);

        respuestaJugador.otorgarPuntos(new Puntos(1));

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),0);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaEligiendoTodasLasOpcionesIncorrectasYNoObtienePuntaje(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();
        opcionesElegidas.add(cuartaOpcion);
        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(quintaOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);

        respuestaJugador.otorgarPuntos(new Puntos(1));

        Assertions.assertEquals(jugador.getPuntos().getCantidad(),0);
    }*/
}