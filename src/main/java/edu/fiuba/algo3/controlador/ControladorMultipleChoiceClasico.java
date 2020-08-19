package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoice;
import edu.fiuba.algo3.vista.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import static edu.fiuba.algo3.modelo.Kahoot.*;

import java.io.IOException;
import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.Kahoot.actualizarEscena;

public class ControladorMultipleChoiceClasico {
    private ColeccionOpciones opcionesElegidas = new ColeccionOpciones();
    private Pregunta pregunta; //= new PreguntaMultipleChoice();

    @FXML
    public Label nombrepregunta;
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
        nombrepregunta.setText("Hola");
        opcion1.setText("Opc 1");
        opcion2.setText("Opc 2");
        opcion3.setText("Opc 3");
        opcion4.setText("Opc 4");
        opcion5.setText("Opc 5");
        opcion6.setDisable(true);
        opcion6.setOpacity(0);
    }

    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual) {
        nombrepregunta.setText(pregunta.getNombre());
    }


}


