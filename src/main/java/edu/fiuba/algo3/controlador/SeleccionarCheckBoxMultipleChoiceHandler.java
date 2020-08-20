package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.LinkedList;

public class SeleccionarCheckBoxMultipleChoiceHandler implements EventHandler<ActionEvent> {

    Opcion opcionVinculada;
    LinkedList<Opcion> opcionesSeleccionadas;
    
    public SeleccionarCheckBoxMultipleChoiceHandler(Opcion opcion, LinkedList<Opcion> opcionesSeleccionadas) {
        this.opcionVinculada = opcion;
        this.opcionesSeleccionadas = opcionesSeleccionadas;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.print("Click");
        if(opcionesSeleccionadas.contains(opcionVinculada))
            opcionesSeleccionadas.remove(opcionVinculada);
        else
            opcionesSeleccionadas.add(opcionVinculada);
    }
}
