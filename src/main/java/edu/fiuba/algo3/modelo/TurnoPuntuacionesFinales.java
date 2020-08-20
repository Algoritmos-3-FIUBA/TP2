package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.controlador.ControladorPuntuacionFinal;

import java.io.IOException;
import java.util.LinkedList;

public class TurnoPuntuacionesFinales extends Turno{
    private final LinkedList<Jugador> jugadores;

    public TurnoPuntuacionesFinales(LinkedList<Jugador> jugadores, String url) throws IOException {
        super(url);
        this.jugadores = jugadores;
    }

    @Override
    protected void actualizarPlantilla() {
        ((ControladorPuntuacionFinal)controlador).actualizarPlantilla(jugadores);
    }
}
