package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.excepciones.MasDeCincoOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestRespuestaMultiple {

    //Actualizar a la nueva version en la que pregunta evalua la respuesta

    private final Opcion primeraOpcion = new OpcionCorrecta("Euler");
    private final Opcion segundaOpcion = new OpcionCorrecta("Gauss");
    private final Opcion terceraOpcion  = new OpcionCorrecta("Faraday");
    private final Opcion cuartaOpcion = new OpcionCorrecta("Newton");
    private final Opcion quintaOpcion = new OpcionCorrecta("Einstein");
    private final Opcion sextaOpcion = new OpcionCorrecta("Curie");

    @Test
    public void testJugadorRealizaUnaRespuestaCorrectaEligiendoUnaOpcionYObtienePuntaje01(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<>();
        opcionesElegidas.add(primeraOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);
        respuestaJugador.esCorrecta();

        respuestaJugador.otorgarPuntos(new Puntos(1));

        assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void testJugadorRealizaUnaRespuestaCorrectaEligiendoDosOpcionesYObtienePuntaje02(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();

        opcionesElegidas.add(segundaOpcion);
        opcionesElegidas.add(primeraOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);
        respuestaJugador.esCorrecta();

        respuestaJugador.otorgarPuntos(new Puntos(1));

        assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void testJugadorRealizaUnaRespuestaCorrectaEligiendoTresOpcionesYObtienePuntaje03(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();

        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(segundaOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);
        respuestaJugador.esCorrecta();

        respuestaJugador.otorgarPuntos(new Puntos(1));

        assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void testJugadorRealizaUnaRespuestaCorrectaEligiendoCuatroOpcionesYObtienePuntaje04(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();
        //No importa el orden de opciones elegidas, siempre que sean correctas se asignará el puntaje
        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(cuartaOpcion);
        opcionesElegidas.add(segundaOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);
        respuestaJugador.esCorrecta();

        respuestaJugador.otorgarPuntos(new Puntos(1));

        assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void testJugadorRealizaUnaRespuestaCorrectaEligiendoCincoOpcionesYObtienePuntaje05(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();

        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(quintaOpcion);
        opcionesElegidas.add(cuartaOpcion);
        opcionesElegidas.add(segundaOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);
        respuestaJugador.esCorrecta();

        respuestaJugador.otorgarPuntos(new Puntos(1));

        assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void testJugadorRealizaUnaRespuestaIncorrectaEligiendoUnaOpcionYNoObtienePuntaje06(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();
        opcionesElegidas.add(primeraOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);

        respuestaJugador.otorgarPuntos(new Puntos(1));

        assertEquals(jugador.getPuntos().getCantidad(),0);
    }

    @Test
    public void testJugadorRealizaUnaRespuestaIncorrectaEligiendoOpcionesDeMenosYNoObtienePuntaje07(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();
        opcionesElegidas.add(segundaOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);

        respuestaJugador.otorgarPuntos(new Puntos(1));

        assertEquals(jugador.getPuntos().getCantidad(),0);
    }

    @Test
    public void testJugadorRealizaUnaRespuestaIncorrectaEligiendoOpcionesDeMasYNoObtienePuntaje08(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();
        opcionesElegidas.add(segundaOpcion);
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(quintaOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);

        respuestaJugador.otorgarPuntos(new Puntos(1));

        assertEquals(jugador.getPuntos().getCantidad(),0);
    }

    @Test
    public void testJugadorRealizaUnaRespuestaIncorrectaEligiendoTodasLasOpcionesIncorrectasYNoObtienePuntaje09(){
        Jugador jugador = new Jugador("Guido");

        //Opciones que son eligidas
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();
        opcionesElegidas.add(cuartaOpcion);
        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(quintaOpcion);

        RespuestaMultiple respuestaJugador = new RespuestaMultiple(opcionesElegidas, jugador);

        respuestaJugador.otorgarPuntos(new Puntos(1));

        assertEquals(jugador.getPuntos().getCantidad(),0);
    }

    @Test
    public void testJugadorRealizaUnaRespuestaMultipleConMasDeCincoOpciones10() {
        Jugador jugador = new Jugador("Guido");
        LinkedList<Opcion> opcionesElegidas = new LinkedList<Opcion>();
        opcionesElegidas.add(primeraOpcion);
        opcionesElegidas.add(segundaOpcion);
        opcionesElegidas.add(terceraOpcion);
        opcionesElegidas.add(cuartaOpcion);
        opcionesElegidas.add(quintaOpcion);
        opcionesElegidas.add(sextaOpcion);
        assertThrows(MasDeCincoOpcionesException.class,
                ()->{
                    new RespuestaMultiple(opcionesElegidas,jugador);
                });
    }
}