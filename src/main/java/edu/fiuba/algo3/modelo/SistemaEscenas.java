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
            //turnos.add(new TurnoPuntuaciones(jugadores,"url"));
        }
    }

    public void siguienteEscena() throws IOException {

        new ControladorPuntuacion(jugadores);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Paths.get("src/main/java/edu/fiuba/algo3/vista/plantilla/Puntuacion.fxml").toUri().toURL());
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        App.escenario.setScene(scene);
        App.escenario.setResizable(false);
        App.escenario.show();
        App.escenario.setResizable(true);


        PauseTransition pause = new PauseTransition(Duration.seconds(4));
        pause.setOnFinished(event ->
        {
            try {
                turnos.remove().mostrarEscena();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        pause.play();


    }
}
