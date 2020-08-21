package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.TurnoJugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.LinkedList;

public class ControladorPuntuacionFinal extends Controlador {
    @FXML
    public Label jugador1;
    @FXML
    public Label puntosjugador1;
    @FXML
    public Label jugador2;
    @FXML
    public Label puntosjugador2;

    public static Jugador jugadorGanador;
    public static Jugador segundoJugador;

    public ControladorPuntuacionFinal()  { }

    public void initialize(){
        App.escenario.setResizable(false);
    }

    public void actualizarPlantilla(LinkedList<Jugador> jugadores) {

        if (jugadores.get(0).getPuntos().cantidad>jugadores.get(1).getPuntos().cantidad){
            jugadorGanador = jugadores.get(0);
            segundoJugador = jugadores.get(1);
        }else{
            jugadorGanador = jugadores.get(1);
            segundoJugador = jugadores.get(0);
        }

        jugador1.setText(jugadorGanador.getNombre());
        jugador2.setText(segundoJugador.getNombre());

        puntosjugador1.setText(String.valueOf(jugadorGanador.getPuntos().getCantidad()));
        puntosjugador2.setText(String.valueOf(segundoJugador.getPuntos().getCantidad()));
    }

    @Override
    public void actualizarPlantilla(Pregunta pregunta, Jugador actual, TurnoJugador turnoActual) {

    }

    public void finalizar(ActionEvent actionEvent) {
        App.escenario.close();
    }
}

