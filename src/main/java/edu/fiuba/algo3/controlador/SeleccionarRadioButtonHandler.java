package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.LinkedList;

public class SeleccionarRadioButtonHandler implements EventHandler<ActionEvent> {
    Opcion opcionVinculada;
    LinkedList<Opcion> opcionesSeleccionadas;

    public SeleccionarRadioButtonHandler(Opcion opcion, LinkedList<Opcion> opcionesSeleccionadas) {
        this.opcionVinculada = opcion;
        this.opcionesSeleccionadas = opcionesSeleccionadas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(opcionesSeleccionadas.contains(opcionVinculada))
            opcionesSeleccionadas.remove(opcionVinculada);
        else
            opcionesSeleccionadas.add(opcionVinculada);
    }
    /*
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
        opcionVinculada = opcionesPregunta.getOpciones().getFirst();

        /* if(nombreOpcion == opcionesPregunta.getOpciones().getFirst().getNombre()){
            System.out.println("OPCION VERDADERO FALSO 1");
            opcionVinculada = opcionesPregunta.getOpciones().getFirst();
            System.out.println(opcionVinculada.getNombre() );
        }
        else{
            System.out.println("OPCION VERDADERO FALSO 2");
            opcionVinculada = opcionesPregunta.getOpciones().getLast();
            System.out.println(opcionVinculada.getNombre() );
    }*/
}
