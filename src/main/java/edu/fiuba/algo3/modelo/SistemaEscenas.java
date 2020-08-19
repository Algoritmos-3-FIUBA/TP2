package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SistemaEscenas {

    private Queue<Turno> turnos = new LinkedList();

    public SistemaEscenas(LinkedList<Jugador> jugadores, LinkedList<Pregunta> preguntas, HashMap<Pregunta, String> plantillasPreguntas) {
        for(Pregunta pregunta : preguntas){
            turnos.add(new TurnoJugador(jugadores,pregunta,plantillasPreguntas.get(pregunta)));
            turnos.add(new TurnoPuntuaciones(jugadores,"url"));
        }
    }
}
