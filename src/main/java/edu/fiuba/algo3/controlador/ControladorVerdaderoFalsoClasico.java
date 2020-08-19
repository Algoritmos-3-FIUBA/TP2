package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.TurnoJugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class ControladorVerdaderoFalsoClasico extends Controlador {
    private LinkedList<RadioButton> opcionesMostradas = new LinkedList<RadioButton>();
    private Opcion opcionesElegidas;

    @FXML
    public Label nombrepregunta;
    @FXML
    public Button botonsiguiente;
    @FXML
    public Label jugadoractual;
    @FXML
    public Label puntosactuales;
    @FXML
    public RadioButton botonverdadero;
    @FXML
    public RadioButton botonfalso;

    Stage escenarioActual;
    private TurnoJugador turnoActual;

    public void initialize() {
        this.escenarioActual = App.obtenerEscenarioActual();

        opcionesMostradas.add(botonverdadero);
        opcionesMostradas.add(botonfalso);

        //opcion6.setDisable(true);
        //opcion6.setOpacity(0);
    }
    @Override
    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual,TurnoJugador turnoActual) {
        this.turnoActual = turnoActual;

        nombrepregunta.setText(pregunta.getNombre());
        jugadoractual.setText(jugadorActual.getNombre());
        puntosactuales.setText(String.valueOf(jugadorActual.getPuntos().cantidad));

        for (int i = 0; i < pregunta.getOpciones().cantidadElementos(); i++) {
            opcionesMostradas.get(i).setSelected(false);
            opcionesMostradas.get(i).setText(pregunta.getOpciones().getOpciones().get(i).getNombre());
        }
    }
    public void siguienteTurno() throws IOException {
        //this.turnoActual.siguienteJugador();
    }
}
