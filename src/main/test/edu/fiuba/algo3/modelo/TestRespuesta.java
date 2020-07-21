package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuesta {
    private Opcion verdadero;
    private Opcion falso;
    private ArrayList opcionesDisponibles = new ArrayList();

    private Jugador jugador = new Jugador("Guido");
    private Respuesta respuestaJugador = new Respuesta(jugador);

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaSeleccionandoLaSegundaOpcionYObtienePuntaje(){
        falso = new OpcionCorrecta();
        verdadero = new OpcionIncorrecta();
        opcionesDisponibles.add(verdadero);
        opcionesDisponibles.add(falso);

        respuestaJugador.opcionSeleccionada(1);
        respuestaJugador.otorgarPuntos(opcionesDisponibles);

        Assertions.assertEquals(jugador.getPuntos(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaSeleccionandoLaPrimeraOpcionYNoObtienePuntaje(){
        falso = new OpcionCorrecta();
        verdadero = new OpcionIncorrecta();
        opcionesDisponibles.add(verdadero);
        opcionesDisponibles.add(falso);

        respuestaJugador.opcionSeleccionada(0);
        respuestaJugador.otorgarPuntos(opcionesDisponibles);

        Assertions.assertEquals(jugador.getPuntos(),0);
    }

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaSeleccionandoLaPrimeraOpcionYObtienePuntaje(){
        falso = new OpcionIncorrecta();
        verdadero = new OpcionCorrecta();
        opcionesDisponibles.add(verdadero);
        opcionesDisponibles.add(falso);

        respuestaJugador.opcionSeleccionada(0);
        respuestaJugador.otorgarPuntos(opcionesDisponibles);

        Assertions.assertEquals(jugador.getPuntos(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaSeleccionandoLaSegundaOpcionYNoObtienePuntaje(){
        falso = new OpcionIncorrecta();
        verdadero = new OpcionCorrecta();
        opcionesDisponibles.add(verdadero);
        opcionesDisponibles.add(falso);

        respuestaJugador.opcionSeleccionada(1);
        respuestaJugador.otorgarPuntos(opcionesDisponibles);

        Assertions.assertEquals(jugador.getPuntos(),0);
    }
}