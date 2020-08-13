package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonResponderFalso implements EventHandler<ActionEvent> {

    private Stage stage;


    public BotonResponderFalso(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.close(); // return to main window
    }
}
