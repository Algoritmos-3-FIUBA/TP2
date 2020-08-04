package edu.fiuba.algo3.modelo;

public class Jugador {
    private final String nombre;
    private int puntos = 0;

    public Jugador(String name) {
        this.nombre = name;
        Multiplicador multiplicador()
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void sumarPuntos(int cantidadDePuntos) {
        puntos = puntos + cantidadDePuntos;
    }
}