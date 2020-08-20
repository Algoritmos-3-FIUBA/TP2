package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.TurnoJugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import edu.fiuba.algo3.vista.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class ControladorOrderedChoice extends Controlador{
    private LinkedList<Button> opcionesMostradas = new LinkedList<>();
    private LinkedList<Opcion> opcionesElegidas = new LinkedList<>();
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
    public Button opcion1;
    @FXML
    public Button opcion2;
    @FXML
    public Button opcion3;
    @FXML
    public Button opcion4;
    @FXML
    public Button opcion5;

    Stage escenarioActual;
    private Jugador jugador;

    public void initialize() {
        this.escenarioActual = App.obtenerEscenarioActual();

        opcionesMostradas.add(opcion1);
        opcionesMostradas.add(opcion2);
        opcionesMostradas.add(opcion3);
        opcionesMostradas.add(opcion4);
        opcionesMostradas.add(opcion5);

    }

    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual, TurnoJugador turnoActual) {
        this.turnoActual = turnoActual;
        this.jugador = jugadorActual;

        nombrepregunta.setText(pregunta.getNombre());
        jugadoractual.setText(jugadorActual.getNombre());
        puntosactuales.setText(String.valueOf(jugadorActual.getPuntos().cantidad));

        for (int i = 0; i < pregunta.getOpciones().cantidadElementos(); i++) {
            opcionesMostradas.get(i).setText(pregunta.getOpciones().getOpciones().get(i).getNombre());
            opcionesMostradas.get(i).setOnAction(new SeleccionarCheckBoxOrderedChoiceHandler(pregunta.getOpciones().getOpciones().get(1), opcionesElegidas));
        }
    }

    public void siguienteTurno() throws IOException {
        this.turnoActual.siguienteJugador(new RespuestaMultiple(opcionesElegidas,jugador));
    }
}
