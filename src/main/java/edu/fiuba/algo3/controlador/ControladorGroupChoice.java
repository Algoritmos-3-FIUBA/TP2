package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.TurnoJugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGrupos;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import edu.fiuba.algo3.vista.App;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

import static java.lang.String.valueOf;

public class ControladorGroupChoice extends Controlador{
    private LinkedList<Button> opcionesMostradas = new LinkedList<>();
    private LinkedList<ComboBox> gruposMostrados = new LinkedList<>();
    private LinkedList<ColeccionOpciones> gruposElegidos = new LinkedList<>();
    private Pregunta pregunta;
    private TurnoJugador turnoActual;
    private Jugador jugador;

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
    private Stage escenarioActual;
    private ColeccionOpciones primerGrupo;
    private ColeccionOpciones segundoGrupo;

    public void initialize() {
        this.escenarioActual = App.obtenerEscenarioActual();

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

    }

    @Override
    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual, TurnoJugador turnoActual) {
        this.turnoActual = turnoActual;
        this.jugador = jugadorActual;
        this.pregunta = pregunta;

        nombrepregunta.setText(pregunta.getNombre());
        jugadoractual.setText(jugadorActual.getNombre());
        puntosactuales.setText(valueOf(jugadorActual.getPuntos().cantidad));

        gruposElegidos = new LinkedList<>();

        primerGrupo = new ColeccionOpciones();
        segundoGrupo = new ColeccionOpciones();

        gruposElegidos.add(primerGrupo);
        gruposElegidos.add(segundoGrupo);

        for(ComboBox caja : gruposMostrados){
            caja.setValue(null);
        }

        for(ComboBox caja : gruposMostrados){
            caja.getItems().add("Grupo1");
            caja.getItems().add("Grupo2");
        }

        for (int i = 0; i < pregunta.getOpciones().cantidadElementos(); i++)
            opcionesMostradas.get(i).setText(pregunta.getOpciones().getOpciones().get(i).getNombre());
    }

    public void siguienteTurno() throws IOException {
        for(int i = 0; i < gruposMostrados.size(); i++) {
            if(gruposMostrados.get(i).getValue() == "Grupo1")
                primerGrupo.agregarOpcion(pregunta.getOpciones().getOpciones().get(i));
            else
                segundoGrupo.agregarOpcion(pregunta.getOpciones().getOpciones().get(i));
        }
        this.turnoActual.siguienteJugador(new RespuestaGrupos(gruposElegidos,jugador));
    }
}