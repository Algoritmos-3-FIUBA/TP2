package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.TurnoJugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import edu.fiuba.algo3.vista.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class ControladorMultipleChoiceClasico extends Controlador{
    private LinkedList<CheckBox> cajasOpcionesMostradas = new LinkedList<>();
    private LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
    private Pregunta pregunta; //= new PreguntaMultipleChoice();
    private TurnoJugador turnoActual;
    private Jugador jugador;

    @FXML
    public Label nombrepregunta;
    @FXML
    public Label tipopregunta;
    @FXML
    public Label jugadoractual;
    @FXML
    public Label puntosactuales;
    @FXML
    public Button botonsiguiente;
    @FXML
    public CheckBox opcion1;
    @FXML
    public CheckBox opcion2;
    @FXML
    public CheckBox opcion3;
    @FXML
    public CheckBox opcion4;
    @FXML
    public CheckBox opcion5;
    @FXML
    public Button multiplicadorx2;
    @FXML
    public Button multiplicadorx3;
    Stage escenarioActual;

    public void initialize() {
        this.escenarioActual = App.obtenerEscenarioActual();

        cajasOpcionesMostradas.add(opcion1);
        cajasOpcionesMostradas.add(opcion2);
        cajasOpcionesMostradas.add(opcion3);
        cajasOpcionesMostradas.add(opcion4);
        cajasOpcionesMostradas.add(opcion5);
        multiplicadorx2.setDisable(true);
        multiplicadorx3.setDisable(true);

    }

    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual, TurnoJugador turnoActual) {
        this.turnoActual = turnoActual;
        this.jugador = jugadorActual;

        nombrepregunta.setText(pregunta.getNombre());
        tipopregunta.setText(pregunta.getClass().getSimpleName().replaceAll("(.)([A-Z])", "$1 $2"));
        jugadoractual.setText(jugadorActual.getNombre());
        puntosactuales.setText(String.valueOf(jugadorActual.getPuntos().cantidad));

        for(CheckBox opcion : cajasOpcionesMostradas)
            opcion.setSelected(false);

        opcionesSeleccionadas = new LinkedList<>();

        for (int i = 0; i < pregunta.getOpciones().cantidadElementos(); i++) {
            cajasOpcionesMostradas.get(i).setOnAction(new SeleccionarCheckBoxMultipleChoiceHandler(pregunta.getOpciones().getOpciones().get(i), opcionesSeleccionadas));
            cajasOpcionesMostradas.get(i).setText(pregunta.getOpciones().getOpciones().get(i).getNombre());
        }
    }

    public void siguienteTurno() throws IOException {
        this.turnoActual.siguienteJugador(new RespuestaMultiple(opcionesSeleccionadas,jugador));
    }

}


