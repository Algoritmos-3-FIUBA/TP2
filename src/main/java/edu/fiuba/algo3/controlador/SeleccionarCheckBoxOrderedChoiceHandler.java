package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.LinkedList;

public class SeleccionarCheckBoxOrderedChoiceHandler implements EventHandler<ActionEvent>{

    private LinkedList<Opcion> opcionesOrdenadas;
    private Opcion opcionVinculada;
    private ControladorOrderedChoice controlador;

    public SeleccionarCheckBoxOrderedChoiceHandler(Opcion opcionVinculada, LinkedList<Opcion> opcionesOrdenadas, ControladorOrderedChoice controlador){
        this.opcionVinculada = opcionVinculada;
        this.opcionesOrdenadas = opcionesOrdenadas;
        this.controlador = controlador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(opcionesOrdenadas.contains(opcionVinculada))
            opcionesOrdenadas.remove(opcionVinculada);
        else
            opcionesOrdenadas.addLast(opcionVinculada);
        controlador.actualizarOrden();
    }
}
