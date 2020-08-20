package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.LinkedList;

public class SeleccionarRadioButtonHandler implements EventHandler<ActionEvent> {

    String nombreOpcion;
    Opcion opcionVinculada;
    ColeccionOpciones opcionesPregunta;

    public SeleccionarRadioButtonHandler(PreguntaVerdaderoFalso pregunta, Opcion opcion, String nombreOpcionSeleccionada) {
        opcionVinculada = opcion;
        nombreOpcion = nombreOpcionSeleccionada;
        opcionesPregunta = pregunta.getOpciones();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(nombreOpcion == opcionesPregunta.getOpciones().getFirst().getNombre())
            opcionVinculada = opcionesPregunta.getOpciones().getFirst();
        else
            opcionVinculada = opcionesPregunta.getOpciones().getLast();
    }
}
