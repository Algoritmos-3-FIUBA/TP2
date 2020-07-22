package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuesta {
    private Opcion opcionVerdadero;
    private Opcion opcionFalso;
    private ArrayList opcionesDisponibles = new ArrayList();

    private Jugador jugador = new Jugador("Guido");
    private Respuesta respuestaJugador = new Respuesta(jugador);

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaSeleccionandoLaSegundaOpcionYObtienePuntaje(){
        opcionFalso = new OpcionCorrecta();
        opcionVerdadero = new OpcionIncorrecta();
        opcionesDisponibles.add(opcionVerdadero);
        opcionesDisponibles.add(opcionFalso);

        respuestaJugador.opcionSeleccionada(1);
        respuestaJugador.otorgarPuntos(opcionesDisponibles);

        Assertions.assertEquals(jugador.getPuntos(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaSeleccionandoLaPrimeraOpcionYNoObtienePuntaje(){
        opcionFalso = new OpcionCorrecta();
        opcionVerdadero = new OpcionIncorrecta();
        opcionesDisponibles.add(opcionVerdadero);
        opcionesDisponibles.add(opcionFalso);

        respuestaJugador.opcionSeleccionada(0);
        respuestaJugador.otorgarPuntos(opcionesDisponibles);

        Assertions.assertEquals(jugador.getPuntos(),0);
    }

    @Test
    public void JugadorRealizaUnaRespuestaCorrectaSeleccionandoLaPrimeraOpcionYObtienePuntaje(){
        opcionFalso = new OpcionIncorrecta();
        opcionVerdadero = new OpcionCorrecta();
        opcionesDisponibles.add(opcionVerdadero);
        opcionesDisponibles.add(opcionFalso);

        respuestaJugador.opcionSeleccionada(0);
        respuestaJugador.otorgarPuntos(opcionesDisponibles);

        Assertions.assertEquals(jugador.getPuntos(),1);
    }

    @Test
    public void JugadorRealizaUnaRespuestaIncorrectaSeleccionandoLaSegundaOpcionYNoObtienePuntaje(){
        opcionFalso = new OpcionIncorrecta();
        opcionVerdadero = new OpcionCorrecta();
        opcionesDisponibles.add(opcionVerdadero);
        opcionesDisponibles.add(opcionFalso);

        respuestaJugador.opcionSeleccionada(1);
        respuestaJugador.otorgarPuntos(opcionesDisponibles);

        Assertions.assertEquals(jugador.getPuntos(),0);
    }
}