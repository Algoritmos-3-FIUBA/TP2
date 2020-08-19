package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import static edu.fiuba.algo3.modelo.Kahoot.siguienteTurno;

public class TurnoJugador extends Turno{
    private Jugador jugadorActual;
    private Queue<Jugador> jugadoresRestantes = new LinkedList();
    private Pregunta pregunta;

    public TurnoJugador(LinkedList<Jugador> jugadores, Pregunta pregunta, String plantilla) throws IOException {
        super(plantilla);

        this.pregunta = pregunta;

        for (Jugador jugador:jugadores) {
            this.jugadoresRestantes.add(jugador);
        }

        this.jugadorActual = jugadoresRestantes.remove();
    }

    @Override
    public void actualizarPlantilla() throws IOException {
        this.controlador.actualizarPlantilla(pregunta, jugadorActual,this);
    }

    public void siguienteJugador() {
        if(jugadoresRestantes.isEmpty())
            siguienteTurno();
        else{
            this.jugadorActual = jugadoresRestantes.remove();
            this.controlador.actualizarPlantilla(pregunta, jugadorActual,this);
        }
    }
}
