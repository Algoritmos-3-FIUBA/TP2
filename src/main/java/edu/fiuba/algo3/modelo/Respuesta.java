package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {

    private Jugador jugador;
    private int idOpcion;
    private Opcion opcion;

    public Respuesta(Jugador jugador) {
        this.jugador = jugador;
    }

    public void opcionSeleccionada(int i) {
        this.idOpcion = i;
    }

    public void otorgarPuntos(ArrayList opcionesDisponibles) {
        opcion = (Opcion) opcionesDisponibles.get(idOpcion);
        jugador.sumarPuntos((Opcion) opcion);
    }

}

