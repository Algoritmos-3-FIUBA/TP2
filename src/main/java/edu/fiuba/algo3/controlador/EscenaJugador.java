package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import static edu.fiuba.algo3.controlador.Kahoot.siguienteTurno;

public class EscenaJugador extends Escena {
    private Jugador jugadorActual;
    private Respuesta respuestaActual;
    private Queue<Jugador> jugadoresRestantes = new LinkedList();
    private Pregunta pregunta;
    private LinkedList<Respuesta> respuestas = new LinkedList<>();

    public EscenaJugador(LinkedList<Jugador> jugadores, Pregunta pregunta, String plantilla) throws IOException {
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

    public void siguienteJugador(Respuesta respuesta) throws IOException {
        respuestas.add(respuesta);
        if(jugadoresRestantes.isEmpty()){
            pregunta.evaluarRespuestas(respuestas);
            siguienteTurno();
        }
        else{
            this.jugadorActual = jugadoresRestantes.remove();
            this.controlador.actualizarPlantilla(pregunta, jugadorActual,this);
        }
    }
}
