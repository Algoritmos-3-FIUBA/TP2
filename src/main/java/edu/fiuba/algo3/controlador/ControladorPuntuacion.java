package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.LinkedList;

public class ControladorPuntuacion {
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

    public ControladorPuntuacion() { }

    public ControladorPuntuacion(LinkedList<Jugador> jugadores) {
        primerJugador = jugadores.get(0);
        segundoJugador = jugadores.get(1);
    }

    public void initialize() {
        jugador1.setText(primerJugador.getNombre());
        jugador2.setText(segundoJugador.getNombre());

        puntosjugador1.setText(String.valueOf(primerJugador.getPuntos().getCantidad()));
        puntosjugador2.setText(String.valueOf(segundoJugador.getPuntos().getCantidad()));
    }

}
