package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private final String nombre;
    private int puntos = 0;
    private final Respuesta respuestaJugador = new Respuesta(this);

    //  private ArrayList opcionesPregunta;

    //  private OpcionVoF opcionSeleccionada;

    public Jugador(String name) {
        this.nombre = name;
    }

    public Respuesta responderPregunta(int opcionSeleccionada) {
        respuestaJugador.opcionSeleccionada(opcionSeleccionada-1);
        return respuestaJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void sumarPuntos(Opcion opcion) {
        puntos = puntos + opcion.puntosASumar();
    }
}