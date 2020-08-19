package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.util.LinkedList;

public class ControladorVerdaderoFalsoClasico extends Controladores {
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

    public void initialize() {
        this.escenarioActual = App.obtenerEscenarioActual();

        opcionesMostradas.add(botonverdadero);
        opcionesMostradas.add(botonfalso);

        //opcion6.setDisable(true);
        //opcion6.setOpacity(0);
    }

    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual) {
        nombrepregunta.setText(pregunta.getNombre());
        jugadoractual.setText(jugadorActual.getNombre());
        puntosactuales.setText(String.valueOf(jugadorActual.getPuntos().cantidad));

        for (int i = 0; i < pregunta.getOpciones().cantidadElementos(); i++)
            opcionesMostradas.get(i).setText(pregunta.getOpciones().getOpciones().get(i).getNombre());
    }
}
