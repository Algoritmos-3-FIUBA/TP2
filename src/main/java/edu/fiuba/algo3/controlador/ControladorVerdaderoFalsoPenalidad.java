package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorDefault;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
import edu.fiuba.algo3.vista.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class ControladorVerdaderoFalsoPenalidad  extends Controlador{

    private final LinkedList<RadioButton> cajasOpcionesMostradas = new LinkedList<RadioButton>();
    private final LinkedList<Button> cajasMultiplicadores = new LinkedList<>();

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
    @FXML
    public Button multiplicadorx2;
    @FXML
    public Button multiplicadorx3;
    @FXML
    public Button botonexclusivdad;

    Stage escenarioActual;


    public void initialize() {
        this.escenarioActual = App.obtenerEscenarioActual();

        cajasOpcionesMostradas.add(opcionfalso);
        cajasOpcionesMostradas.add(opcionverdadero);
        cajasMultiplicadores.add(multiplicadorx2);
        cajasMultiplicadores.add(multiplicadorx3);

        botonexclusivdad.setDisable(true);

    }
    @Override
    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual, EscenaJugador escenaActual) {

        this.actualizador = new ControladorActualizador(pregunta,jugadorActual,escenaActual);
        this.actualizador.actualizarTextosEtiquetas(nombrepregunta,tipopregunta,jugadoractual,puntosactuales);
        this.actualizador.actualizarPlantillaVerdaderoFalsoPenalidad(cajasOpcionesMostradas,cajasMultiplicadores);
    }

    public void siguienteTurno() throws IOException {

        this.actualizador.siguenteTurnoVoFPenalidad();
    }

    public void asignarMultiplicadorx2() {
        this.actualizador.asignarMultiplicadoex2(multiplicadorx2,multiplicadorx3);
    }
    public void asignarMultiplicadorx3() {
        this.actualizador.asignarMultiplicadoex3(multiplicadorx2,multiplicadorx3);
    }
}
