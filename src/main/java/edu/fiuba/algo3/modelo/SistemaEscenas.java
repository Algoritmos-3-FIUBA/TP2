package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import static edu.fiuba.algo3.modelo.Kahoot.actualizarEscena;

public class SistemaEscenas {

    private Queue<Turno> turnos = new LinkedList();

    public SistemaEscenas(LinkedList<Jugador> jugadores, LinkedList<Pregunta> preguntas, HashMap<Pregunta, String> plantillasPreguntas) throws IOException {
        for(Pregunta pregunta : preguntas){
            turnos.add(new TurnoJugador(jugadores,pregunta,plantillasPreguntas.get(pregunta)));
            //turnos.add(new TurnoPuntuaciones(jugadores,"url"));
        }
    }

    public void siguienteEscena() throws IOException {
        Turno turnoSiguiente = turnos.remove();
        System.out.println(turnoSiguiente.controlador.getClass());
        System.out.println("///////////////////////////////////");

        turnoSiguiente.mostrarEscena();
    }
}
