package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.App;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.io.IOException;
import java.util.LinkedList;

import static edu.fiuba.algo3.controlador.Kahoot.siguienteTurno;

public class ControladorPuntuacion extends Controlador{
    @FXML
    public Label jugador1;
    @FXML
    public Label puntosjugador1;
    @FXML
    public Label jugador2;
    @FXML
    public Label puntosjugador2;

    public static Jugador primerJugador;
    public static Jugador segundoJugador;
    private PauseTransition pause;

    public void initialize(){
        App.escenario.setResizable(false);
        pause = new PauseTransition(Duration.seconds(4));
        pause.setOnFinished(event ->
        {
            try {
                App.escenario.setResizable(true);
                siguienteTurno();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void actualizarPlantilla(LinkedList<Jugador> jugadores) {
        primerJugador = jugadores.get(0);
        segundoJugador = jugadores.get(1);

        jugador1.setText(primerJugador.getNombre());
        jugador2.setText(segundoJugador.getNombre());

        puntosjugador1.setText(String.valueOf(primerJugador.getPuntos().getCantidad()));
        puntosjugador2.setText(String.valueOf(segundoJugador.getPuntos().getCantidad()));

        pause.play();
    }

    @Override
    public void actualizarPlantilla(Pregunta pregunta, Jugador actual, EscenaJugador escenaActual) {

    }
}
