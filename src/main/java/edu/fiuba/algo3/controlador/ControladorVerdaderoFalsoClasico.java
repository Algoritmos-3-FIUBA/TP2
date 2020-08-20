package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.TurnoJugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
import edu.fiuba.algo3.vista.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class ControladorVerdaderoFalsoClasico extends Controlador {
    //private LinkedList<RadioButton> opcionesMostradas = new LinkedList<RadioButton>();
    private LinkedList<RadioButton> cajasOpcionesMostradas = new LinkedList<RadioButton>();
    private LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
    private Opcion opcionSeleccionada;// = new Opcion();
    //private Pregunta pregunta; //= new PreguntaMultipleChoice();
    private TurnoJugador turnoActual;
    private Jugador jugador;

    @FXML
    public Label nombrepregunta;
    @FXML
    public Label tipopregunta;
    @FXML
    public Button botonsiguiente;
    @FXML
    public Label jugadoractual;
    @FXML
    public Label puntosactuales;
    @FXML
    public RadioButton opcionverdadero;
    @FXML
    public RadioButton opcionfalso;

    Stage escenarioActual;

    public void initialize() {
        this.escenarioActual = App.obtenerEscenarioActual();

        cajasOpcionesMostradas.add(opcionfalso);
        cajasOpcionesMostradas.add(opcionverdadero);

    }
    @Override
    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual,TurnoJugador turnoActual) {
        this.turnoActual = turnoActual;
        this.jugador = jugadorActual;

        nombrepregunta.setText(pregunta.getNombre());
        tipopregunta.setText(pregunta.getClass().getSimpleName().replaceAll("(.)([A-Z])", "$1 $2"));
        jugadoractual.setText(jugadorActual.getNombre());
        puntosactuales.setText(String.valueOf(jugadorActual.getPuntos().cantidad));

        for(RadioButton opcion : cajasOpcionesMostradas)
            opcion.setSelected(false);

        opcionesSeleccionadas = new LinkedList<>();

        for (int i = 0; i < pregunta.getOpciones().cantidadElementos(); i++) {
            //cajasOpcionesMostradas.get(i).setOnAction(new SeleccionarRadioButtonHandler((PreguntaVerdaderoFalsoClasico) pregunta,opcionSeleccionada,cajasOpcionesMostradas.get(i).getText()));
            cajasOpcionesMostradas.get(i).setOnAction(new SeleccionarRadioButtonHandler(pregunta.getOpciones().getOpciones().get(i), opcionesSeleccionadas));
        }
    }
    public void siguienteTurno() throws IOException {
        this.turnoActual.siguienteJugador(new RespuestaUnica(opcionesSeleccionadas.removeFirst(),jugador));
    }
}
