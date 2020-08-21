package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.exclusividad.ExclusividadDefault;
import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGrupos;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.LinkedList;

import static java.lang.String.valueOf;

public class ControladorGroupChoice extends Controlador{
    private final LinkedList<Button> opcionesMostradas = new LinkedList<>();
    private final LinkedList<ComboBox> gruposMostrados = new LinkedList<>();
    private final LinkedList<ColeccionOpciones> gruposElegidos = new LinkedList<>();

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
    public ComboBox comboopcion1;
    @FXML
    public ComboBox comboopcion2;
    @FXML
    public ComboBox comboopcion3;
    @FXML
    public ComboBox comboopcion4;
    @FXML
    public ComboBox comboopcion5;
    @FXML
    public Button botonexclusivdad;
    @FXML
    public Button multiplicadorx2;
    @FXML
    public Button multiplicadorx3;
    private Exclusividad exclusividad = new ExclusividadDefault();

    public void initialize() {

        opcionesMostradas.add(opcion1);
        opcionesMostradas.add(opcion2);
        opcionesMostradas.add(opcion3);
        opcionesMostradas.add(opcion4);
        opcionesMostradas.add(opcion5);

        gruposMostrados.add(comboopcion1);
        gruposMostrados.add(comboopcion2);
        gruposMostrados.add(comboopcion3);
        gruposMostrados.add(comboopcion4);
        gruposMostrados.add(comboopcion5);

        multiplicadorx2.setDisable(true);
        multiplicadorx3.setDisable(true);

    }

    @Override
    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual, EscenaJugador escenaActual) {
        this.actualizador = new ControladorActualizador(pregunta,jugadorActual,escenaActual);
        this.actualizador.actualizarTextosEtiquetas(nombrepregunta,tipopregunta,jugadoractual,puntosactuales);
        this.actualizador.actualizarPlantillaGroupChoice(opcionesMostradas,gruposMostrados,botonexclusivdad);
        }


    public void siguienteTurno() throws IOException {

        this.armarGrupos();
        this.actualizador.siguenteTurnoGroupChoice();
    }

    public void asignarExclusividad() throws IOException {

        this.actualizador.asignarExclusividad(botonexclusivdad);
    }

    private void armarGrupos() {
        this.actualizador.armarGrupos(gruposMostrados,gruposElegidos);
        }
}
