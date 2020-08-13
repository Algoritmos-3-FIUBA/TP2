package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;

public class BotonInicioJuego implements EventHandler<ActionEvent>  {
    private TextField jugador1;
    private TextField jugador2;
    private GridPane gridPane;
    private App aplicacion;

    public BotonInicioJuego(TextField jugador1, TextField jugador2, GridPane gridPane, App aplicacion) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.gridPane = gridPane;
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(ActionEvent event) {
        if(jugador1.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Por favor ingrese el nombre del primer jugador");
            return;
        }
        if(jugador2.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Por favor ingrese el nombre del segundo jugador");
            return;
        }

        aplicacion.showLoginScreen();
        //     showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Bienvenidos!", "Bienvenidos " + jugador1.getText() + " y " + jugador2.getText() );
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
