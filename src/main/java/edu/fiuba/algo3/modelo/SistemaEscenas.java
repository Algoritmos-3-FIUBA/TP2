package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.App;
import edu.fiuba.algo3.vista.FormularioInicial;
import edu.fiuba.algo3.vista.PanelJugadorGeneral;
import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

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

        PanelJugadorGeneral panelJugadorGeneral = new PanelJugadorGeneral() ;
        Scene scene = new Scene(panelJugadorGeneral, 790, 549);
        panelJugadorGeneral.puntosJugadores(App.escenario, jugadores);
        App.escenario.setScene(scene);
        App.escenario.setResizable(false);
        App.escenario.show();
        App.escenario.setResizable(true);



        PauseTransition pause = new PauseTransition(Duration.seconds(4));
        pause.setOnFinished(event ->
        {
            try {
              //  escenarioPanel.close();
                turnos.remove().mostrarEscena();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        pause.play();

/*
        Turno turnoSiguiente = turnos.remove();
        System.out.println(turnoSiguiente.controlador.getClass());
        System.out.println("///////////////////////////////////");
        turnoSiguiente.mostrarEscena();
*/

    }
}
