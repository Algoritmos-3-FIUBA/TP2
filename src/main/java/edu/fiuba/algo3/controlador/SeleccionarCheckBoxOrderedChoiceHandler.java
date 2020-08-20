package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.LinkedList;

public class SeleccionarCheckBoxOrderedChoiceHandler implements EventHandler<MouseEvent> {

    private LinkedList<Opcion> opcionesOrdenadas;
    private Opcion opcionVinculada;

    public SeleccionarCheckBoxOrderedChoiceHandler(Opcion opcionVinculada, LinkedList<Opcion> opcionesOrdenadas){
        this.opcionVinculada = opcionVinculada;
        this.opcionesOrdenadas = opcionesOrdenadas;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.print("Entro");
        if(opcionesOrdenadas.contains(opcionVinculada))
            opcionesOrdenadas.remove(opcionVinculada);
        else
            opcionesOrdenadas.addLast(opcionVinculada);
    }
}
