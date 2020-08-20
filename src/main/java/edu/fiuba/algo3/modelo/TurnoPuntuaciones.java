package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.controlador.ControladorPuntuacion;

import java.io.IOException;
import java.util.LinkedList;

public class TurnoPuntuaciones extends Turno{
    private final LinkedList<Jugador> jugadores;

    public TurnoPuntuaciones(LinkedList<Jugador> jugadores, String url) throws IOException {
        super(url);
        this.jugadores = jugadores;
    }

    @Override
    protected void actualizarPlantilla() {
        ((ControladorPuntuacion)controlador).actualizarPlantilla(jugadores);
    }
}
