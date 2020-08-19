package edu.fiuba.algo3.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.util.ArrayList;

public class ControladorMultipleChoiceClasico {



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

    public void establecerVista() {
        nombrepregunta.setText("Pregunta");

        opcion1.setText("Opc 1");
        opcion2.setText("Opc 2");
        opcion3.setText("Opc 3");
        opcion4.setText("Opc 4");
        opcion5.setText("Opc 5");
        opcion6.setDisable(true);
        opcion6.setOpacity(00);

    }

    public void initialize(/*JuegoControlador controlador*/) {
   /*
        listaRespuestas = new ArrayList<>();
        this.juegocontrolador = controlador;
        juegocontrolador.botonsiguiente.setDisable(true);
*/
        establecerVista();
    }


}


