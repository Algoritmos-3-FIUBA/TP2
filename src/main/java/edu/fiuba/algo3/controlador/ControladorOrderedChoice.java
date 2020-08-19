package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.TurnoJugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class ControladorOrderedChoice extends Controlador{
    private LinkedList<Label> opcionesMostradas = new LinkedList<>();
    private ColeccionOpciones opcionesElegidas = new ColeccionOpciones();
    private Pregunta pregunta; //= new PreguntaMultipleChoice();
    private TurnoJugador turnoActual;

    @FXML
    public Label nombrepregunta;
    @FXML
    public Label jugadoractual;
    @FXML
    public Label puntosactuales;
    @FXML
    public Button botonsiguiente;
    @FXML
    public Label ordenopcion1;
    @FXML
    public Label ordenopcion2;
    @FXML
    public Label ordenopcion3;
    @FXML
    public Label ordenopcion4;
    @FXML
    public Label ordenopcion5;
    //@FXML
    //public CheckBox ordenopcion6;

    Stage escenarioActual;

    public void initialize() {
        this.escenarioActual = App.obtenerEscenarioActual();

        opcionesMostradas.add(ordenopcion1);
        opcionesMostradas.add(ordenopcion2);
        opcionesMostradas.add(ordenopcion3);
        opcionesMostradas.add(ordenopcion4);
        opcionesMostradas.add(ordenopcion5);

        //opcion6.setDisable(true);
        //opcion6.setOpacity(0);
    }

    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual, TurnoJugador turnoActual) {
        this.turnoActual = turnoActual;

        nombrepregunta.setText(pregunta.getNombre());
        jugadoractual.setText(jugadorActual.getNombre());
        puntosactuales.setText(String.valueOf(jugadorActual.getPuntos().cantidad));

        for (int i = 0; i < pregunta.getOpciones().cantidadElementos(); i++) {
            //opcionesMostradas.get(i).setSelected(false);
            opcionesMostradas.get(i).setText(pregunta.getOpciones().getOpciones().get(i).getNombre());
        }
    }

    /*public void siguienteTurno() throws IOException {
        this.turnoActual.siguienteJugador();
    }*/

}
