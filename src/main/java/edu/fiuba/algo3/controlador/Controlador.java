package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

public abstract class Controlador {
    protected ControladorActualizador actualizador;
    public abstract void actualizarPlantilla(Pregunta pregunta, Jugador actual, EscenaJugador turnoActual);
}
