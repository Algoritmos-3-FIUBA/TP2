package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.exclusividad.ExclusividadDefault;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class ControladorOrderedChoice extends Controlador{
    private final LinkedList<Button> opcionesMostradas = new LinkedList<>();
    private final LinkedList<Label> ordenMostrado = new LinkedList<>();

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
    public Button opcion1;
    @FXML
    public Button opcion2;
    @FXML
    public Button opcion3;
    @FXML
    public Button opcion4;
    @FXML
    public Button opcion5;
    @FXML
    public Label opcion1num;
    @FXML
    public Label opcion2num;
    @FXML
    public Label opcion3num;
    @FXML
    public Label opcion4num;
    @FXML
    public Label opcion5num;
    @FXML
    public Button botonexclusividad;
    @FXML
    public Button multiplicadorx2;
    @FXML
    public Button multiplicadorx3;

    Stage escenarioActual;

    public void initialize() {
        this.escenarioActual = App.obtenerEscenarioActual();

        opcionesMostradas.add(opcion1);
        opcionesMostradas.add(opcion2);
        opcionesMostradas.add(opcion3);
        opcionesMostradas.add(opcion4);
        opcionesMostradas.add(opcion5);

        ordenMostrado.add(opcion1num);
        ordenMostrado.add(opcion2num);
        ordenMostrado.add(opcion3num);
        ordenMostrado.add(opcion4num);
        ordenMostrado.add(opcion5num);

        multiplicadorx2.setDisable(true);
        multiplicadorx3.setDisable(true);

    }

    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual, EscenaJugador escenaActual) {
        this.actualizador = new ControladorActualizador(pregunta,jugadorActual,escenaActual);
        this.actualizador.actualizarTextosEtiquetas(nombrepregunta,tipopregunta,jugadoractual,puntosactuales);

        for(Label orden : ordenMostrado)
            orden.setText("");

        this.actualizador.actualizarPlantillaOrderedChoice(opcionesMostradas,botonexclusividad,this);
    }

    public void siguienteTurno() throws IOException {
        this.actualizador.siguenteTurnoOrderedChoice();
    }

    public void asignarExclusividad() throws IOException {
        this.actualizador.asignarExclusividad(botonexclusividad);
    }

    public void actualizarOrden() {
        for(Label orden : ordenMostrado)
            orden.setText("");
        this.actualizador.actualizarOrden(ordenMostrado);
    }
}
