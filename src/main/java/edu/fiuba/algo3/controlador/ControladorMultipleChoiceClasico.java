package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.exclusividad.ExclusividadDefault;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
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
    private final LinkedList<CheckBox> cajasOpcionesMostradas = new LinkedList<>();

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

    Stage escenarioActual;
    private Exclusividad exclusividad = new ExclusividadDefault();

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

    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual, EscenaJugador turnoActual) {

        this.actualizador = new ControladorActualizador(pregunta,jugadorActual,turnoActual);
        this.actualizador.actualizarTextosEtiquetas(nombrepregunta,tipopregunta,jugadoractual,puntosactuales);
        this.actualizador.actualizarPlantillaMultipleChoiceClasico(botonexclusivdad,cajasOpcionesMostradas);
      }

    public void siguienteTurno() throws IOException {

        this.actualizador.siguenteTurnoMultipleChoice();
      }

    public void asignarExclusividad() throws IOException {

        this.actualizador.asignarExclusividad(botonexclusivdad);
      }

}


