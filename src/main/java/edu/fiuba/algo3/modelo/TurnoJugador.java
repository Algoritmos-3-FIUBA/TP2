package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.LinkedList;
import java.util.Queue;

public class TurnoJugador extends Turno{

    private Queue<Jugador> jugadores = new LinkedList();
    private Pregunta pregunta;

    public TurnoJugador(LinkedList<Jugador> jugadores, Pregunta pregunta, String plantilla) {
        this.plantilla = plantilla;
        this.pregunta = pregunta;

        for (Jugador jugador:jugadores)
                this.jugadores.add(jugador);
    }

    @Override
    protected void actualizarPlantilla() {

    }
}
