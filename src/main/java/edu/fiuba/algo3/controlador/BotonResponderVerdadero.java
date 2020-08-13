package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonResponderVerdadero implements EventHandler<ActionEvent> {

    private Stage stage;


    public BotonResponderVerdadero(Stage stage) {
        // Assume success always!
        this.stage = stage;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.close(); // return to main window
    }
}
