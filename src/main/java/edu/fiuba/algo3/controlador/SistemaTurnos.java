package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import java.io.IOException;
import java.util.*;


public class SistemaTurnos {
    private LinkedList<Jugador> jugadores;
    private Queue<Escena> turnos = new LinkedList();


    public SistemaTurnos(LinkedList<Jugador> jugadores, LinkedList<Pregunta> preguntas, HashMap<Pregunta, String> plantillasPreguntas) throws IOException {
        this.jugadores = jugadores;
        for(Pregunta pregunta : preguntas){
            turnos.add(new EscenaJugador(jugadores,pregunta,plantillasPreguntas.get(pregunta)));
            if (preguntas.indexOf(pregunta) != (preguntas.size() -1)){
                turnos.add(new EscenaPuntuaciones(jugadores,"src/main/java/edu/fiuba/algo3/vista/plantilla/Puntuacion.fxml"));
            }

        }
    }

    public void siguienteEscena() throws IOException {
        try{
            turnos.remove().mostrarEscena();
        }catch(Exception e) {
            turnos.add(new EscenaPuntuacionesFinales(jugadores,"src/main/java/edu/fiuba/algo3/vista/plantilla/PuntuacionFinal.fxml"));
            turnos.remove().mostrarEscena();
        }
    }
}
