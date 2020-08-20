package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.FormularioInicial;
import edu.fiuba.algo3.vista.PanelJugadorGeneral;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static edu.fiuba.algo3.modelo.Kahoot.actualizarEscena;

public class SistemaEscenas {
    private LinkedList<Jugador> jugadores;

    private Queue<Turno> turnos = new LinkedList();

    public SistemaEscenas(LinkedList<Jugador> jugadores, LinkedList<Pregunta> preguntas, HashMap<Pregunta, String> plantillasPreguntas) throws IOException {
        this.jugadores = jugadores;
        for(Pregunta pregunta : preguntas){
            turnos.add(new TurnoJugador(jugadores,pregunta,plantillasPreguntas.get(pregunta)));
            //turnos.add(new TurnoPuntuaciones(jugadores,"url"));
        }
    }

    public void siguienteEscena() throws IOException {

  /*      PanelJugadorGeneral panelJugadorGeneral = new PanelJugadorGeneral() ;
        Scene scene = new Scene(panelJugadorGeneral, 500, 500);
        Stage escenarioPanel = new Stage();
        panelJugadorGeneral.puntosJugadores(escenarioPanel, jugadores);
        escenarioPanel.setScene(scene);

*/


        Turno turnoSiguiente = turnos.remove();
        turnoSiguiente.mostrarEscena();
    }
}
