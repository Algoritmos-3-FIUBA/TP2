package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class ControladorMultipleChoicePenalidad  extends Controlador{
    private final LinkedList<CheckBox> cajasOpcionesMostradas = new LinkedList<>();
    private final LinkedList<Button> cajasMultiplicadores = new LinkedList<>();


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
    @FXML
    public Button botonexclusivdad;

    public void initialize() {

        cajasOpcionesMostradas.add(opcion1);
        cajasOpcionesMostradas.add(opcion2);
        cajasOpcionesMostradas.add(opcion3);
        cajasOpcionesMostradas.add(opcion4);
        cajasOpcionesMostradas.add(opcion5);
        cajasMultiplicadores.add(multiplicadorx2);
        cajasMultiplicadores.add(multiplicadorx3);

        botonexclusivdad.setDisable(true);

    }

    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual, EscenaJugador turnoActual) {
        this.actualizador = new ControladorActualizador(pregunta,jugadorActual,turnoActual);
        this.actualizador.actualizarTextosEtiquetas(nombrepregunta,tipopregunta,jugadoractual,puntosactuales);
        this.actualizador.actualizarPlantillaMultipleChoicePenalidad(cajasMultiplicadores,cajasOpcionesMostradas);
      }

    public void siguienteTurno() throws IOException {
        this.actualizador.siguenteTurnoMultipleChoicePenalidad();
    }
    public void asignarMultiplicadorx2() {
        this.actualizador.asignarMultiplicadoex2(multiplicadorx2,multiplicadorx3);
    }
    public void asignarMultiplicadorx3() {

        this.actualizador.asignarMultiplicadoex3(multiplicadorx2,multiplicadorx3); }

}
