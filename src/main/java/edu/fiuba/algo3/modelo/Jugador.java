package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;

public class Jugador {

    private final String nombre;
    private Puntos puntos;

    public Jugador(String name) {
        this.nombre = name;
        puntos = new Puntos(0);
    }

    public String getNombre() {
        return nombre;
    }

    public Puntos getPuntos() {
        return puntos;
    }

    public void sumarPuntos(Puntos puntosASumar) {
        puntos.sumarPuntos(puntosASumar);
    }
}