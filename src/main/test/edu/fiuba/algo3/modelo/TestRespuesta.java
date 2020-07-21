package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuesta {
    private Opcion verdadero;
    private Opcion falso;
    private ArrayList opcionesDisponibles = new ArrayList();
    @Test
    public void JugadorRealizaUnaRespuestaCorrectaYObtienePuntaje(){
        falso = new OpcionCorrecta();
        verdadero = new OpcionIncorrecta();
        opcionesDisponibles.add(verdadero);
        opcionesDisponibles.add(falso);

        Jugador jugador = new Jugador("Guido");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.opcionSeleccionada(1);
        respuestaJugador.otorgarPuntos(opcionesDisponibles);

        Assertions.assertEquals(jugador.getPuntos(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaYObtienePuntaje(){
        falso = new OpcionCorrecta();
        verdadero = new OpcionIncorrecta();
        opcionesDisponibles.add(verdadero);
        opcionesDisponibles.add(falso);

        Jugador jugador = new Jugador("Guido");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.opcionSeleccionada(0);
        respuestaJugador.otorgarPuntos(opcionesDisponibles);

        Assertions.assertEquals(jugador.getPuntos(),0);
    }
}