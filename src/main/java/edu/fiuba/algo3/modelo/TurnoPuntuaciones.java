package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.LinkedList;

public class TurnoPuntuaciones extends Turno{
    public TurnoPuntuaciones(LinkedList<Jugador> jugadores, String url) throws IOException {
        super(url);
    }

    @Override
    protected void actualizarPlantilla() {

    }
}
