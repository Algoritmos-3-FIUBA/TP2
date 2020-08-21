package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;

import java.io.IOException;
import java.util.LinkedList;

public class EscenaPuntuaciones extends Escena {
    private final LinkedList<Jugador> jugadores;

    public EscenaPuntuaciones(LinkedList<Jugador> jugadores, String url) throws IOException {
        super(url);
        this.jugadores = jugadores;
    }

    @Override
    protected void actualizarPlantilla() {
        ((ControladorPuntuacion)controlador).actualizarPlantilla(jugadores);
    }
}
