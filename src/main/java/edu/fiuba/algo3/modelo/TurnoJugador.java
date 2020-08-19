package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.controlador.ControladorMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;

public class TurnoJugador extends Turno{

    private final Jugador actual;
    private Queue<Jugador> jugadoresRestantes = new LinkedList();
    private Pregunta pregunta;

    public TurnoJugador(LinkedList<Jugador> jugadores, Pregunta pregunta, String plantilla) {
        this.plantilla = plantilla;
        this.pregunta = pregunta;

        for (Jugador jugador:jugadores) {
            this.jugadoresRestantes.add(jugador);
        }

        this.actual = jugadoresRestantes.remove();
    }

    @Override
    public void actualizarPlantilla() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Paths.get(plantilla).toUri().toURL());

        Parent root = fxmlLoader.load();

        ((ControladorMultipleChoiceClasico)fxmlLoader.getController()).actualizarPlantilla(pregunta,actual);
        System.out.println(fxmlLoader.getController().getClass());

    }
    
}
