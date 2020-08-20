package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorDos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SeleccionarMultiplicadorX2ButtonHandler implements EventHandler<ActionEvent> {
    private Multiplicador multiplicador;

    public SeleccionarMultiplicadorX2ButtonHandler(Multiplicador multiplicadorActual) {
        this.multiplicador = multiplicadorActual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        multiplicador = new MultiplicadorPorDos();
    }
}
