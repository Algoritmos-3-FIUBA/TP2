package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.controlador.ControladorPuntuacion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.App;
import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;


public class SistemaEscenas {
    private LinkedList<Jugador> jugadores;
    private Queue<Turno> turnos = new LinkedList();


    public SistemaEscenas(LinkedList<Jugador> jugadores, LinkedList<Pregunta> preguntas, HashMap<Pregunta, String> plantillasPreguntas) throws IOException {
        this.jugadores = jugadores;
        for(Pregunta pregunta : preguntas){
            turnos.add(new TurnoJugador(jugadores,pregunta,plantillasPreguntas.get(pregunta)));
            if (preguntas.indexOf(pregunta) != (preguntas.size() -1)){
                turnos.add(new TurnoPuntuaciones(jugadores,"src/main/java/edu/fiuba/algo3/vista/plantilla/Puntuacion.fxml"));
            }

        }
    }

    public void siguienteEscena() throws IOException {
        try{
            turnos.remove().mostrarEscena();
        }catch(Exception e) {
            turnos.add(new TurnoPuntuacionesFinales(jugadores,"src/main/java/edu/fiuba/algo3/vista/plantilla/PuntuacionFinal.fxml"));
            turnos.remove().mostrarEscena();
        }
    }
}
