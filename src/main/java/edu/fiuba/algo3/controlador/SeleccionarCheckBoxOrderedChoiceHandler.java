package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

import java.util.LinkedList;

public class SeleccionarCheckBoxOrderedChoiceHandler implements EventHandler<ActionEvent>{

    private final LinkedList<Label> ordenMostrado;
    private LinkedList<Opcion> opcionesOrdenadas;
    private Opcion opcionVinculada;
    private ControladorActualizador controlador;

    public SeleccionarCheckBoxOrderedChoiceHandler(Opcion opcionVinculada, LinkedList<Opcion> opcionesOrdenadas, ControladorActualizador controlador, LinkedList<Label> ordenMostrado){
        this.opcionVinculada = opcionVinculada;
        this.opcionesOrdenadas = opcionesOrdenadas;
        this.controlador = controlador;
        this.ordenMostrado = ordenMostrado;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        if(opcionesOrdenadas.contains(opcionVinculada))
            opcionesOrdenadas.remove(opcionVinculada);
        else
            opcionesOrdenadas.addLast(opcionVinculada);
        controlador.actualizarOrden(ordenMostrado);
    }
}
