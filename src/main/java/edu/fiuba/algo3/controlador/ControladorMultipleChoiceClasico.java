package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.TurnoJugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoice;
import edu.fiuba.algo3.vista.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import static edu.fiuba.algo3.modelo.Kahoot.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import static edu.fiuba.algo3.modelo.Kahoot.actualizarEscena;

public class ControladorMultipleChoiceClasico extends Controladores{
    private LinkedList<CheckBox> opcionesMostradas = new LinkedList<>();
    private ColeccionOpciones opcionesElegidas = new ColeccionOpciones();
    private Pregunta pregunta; //= new PreguntaMultipleChoice();
    private TurnoJugador turnoActual;

    @FXML
    public Label nombrepregunta;
    @FXML
    public Label jugadoractual;
    @FXML
    public Label puntosactuales;
    @FXML
    public Button botonsiguiente;
    @FXML
    public CheckBox opcion1;
    @FXML
    public CheckBox opcion2;
    @FXML
    public CheckBox opcion3;
    @FXML
    public CheckBox opcion4;
    @FXML
    public CheckBox opcion5;
    @FXML
    public CheckBox opcion6;

    Stage escenarioActual;

    public void initialize() {
        this.escenarioActual = App.obtenerEscenarioActual();

        opcionesMostradas.add(opcion1);
        opcionesMostradas.add(opcion2);
        opcionesMostradas.add(opcion3);
        opcionesMostradas.add(opcion4);
        opcionesMostradas.add(opcion5);

        opcion6.setDisable(true);
        opcion6.setOpacity(0);
    }

    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual, TurnoJugador turnoActual) {
        this.turnoActual = turnoActual;

        nombrepregunta.setText(pregunta.getNombre());
        jugadoractual.setText(jugadorActual.getNombre());
        puntosactuales.setText(String.valueOf(jugadorActual.getPuntos().cantidad));

        for (int i = 0; i < pregunta.getOpciones().cantidadElementos(); i++) {
            opcionesMostradas.get(i).setSelected(false);
            opcionesMostradas.get(i).setText(pregunta.getOpciones().getOpciones().get(i).getNombre());
        }
    }

    public void siguienteTurno(){
        this.turnoActual.siguienteJugador();
    }

}


