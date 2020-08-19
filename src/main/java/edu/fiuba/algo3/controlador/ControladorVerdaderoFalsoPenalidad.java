package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

public class ControladorVerdaderoFalsoPenalidad extends Controlador {
    @Override
    public void actualizarPlantilla(Pregunta pregunta, Jugador actual) {

    }
    /*
        DEJO COMENTADO
        PORQUE NO EXISTE
        LA PLANTILLA DE
        PREGUNTA VOF PENALIDAD
    */


  /*  private LinkedList<CheckBox> opcionesMostradas = new LinkedList<>();
    private Opcion opcionesElegidas;

    @FXML
    public Label nombrepregunta;
    @FXML
    public Button botonsiguiente;
    @FXML
    public CheckBox opcion1;
    @FXML
    public CheckBox opcion2;

    Stage escenarioActual;

    public void initialize() {
        this.escenarioActual = App.obtenerEscenarioActual();

        opcionesMostradas.add(opcion1);
        opcionesMostradas.add(opcion2);

        //opcion6.setDisable(true);
        //opcion6.setOpacity(0);
    }

    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual) {
        nombrepregunta.setText(pregunta.getNombre());

        for (int i = 0; i < pregunta.getOpciones().cantidadElementos(); i++)
            opcionesMostradas.get(i).setText(pregunta.getOpciones().getOpciones().get(i).getNombre());
    }*/
}
