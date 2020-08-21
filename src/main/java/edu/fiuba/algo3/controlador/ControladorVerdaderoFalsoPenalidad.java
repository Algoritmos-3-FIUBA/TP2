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

    private LinkedList<RadioButton> cajasOpcionesMostradas = new LinkedList<RadioButton>();
    private LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
    private LinkedList<Button> cajasMultiplicadores = new LinkedList<>();
    private EscenaJugador turnoActual;
    private Jugador jugador;
    private Multiplicador multiplicador = new MultiplicadorDefault();

    @FXML
    public Label nombrepregunta;
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

    }
    @Override
    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual, EscenaJugador turnoActual) {
        this.turnoActual = turnoActual;
        this.jugador = jugadorActual;

        nombrepregunta.setText(pregunta.getNombre());
        jugadoractual.setText(jugadorActual.getNombre());
        puntosactuales.setText(String.valueOf(jugadorActual.getPuntos().cantidad));

        for(RadioButton opcion : cajasOpcionesMostradas)
            opcion.setSelected(false);

        for(Button multiplicador : cajasMultiplicadores)
           multiplicador.setDisable(false);

        botonexclusivdad.setDisable(true);

        if(jugador.cantidadMultiplicadoresPor2() == 0) multiplicadorx2.setDisable(true);
        if(jugador.cantidadMultiplicadoresPor3() == 0) multiplicadorx3.setDisable(true);

        opcionesSeleccionadas = new LinkedList<>();

        for (int i = 0; i < pregunta.getColeccionDeOpciones().cantidadElementos(); i++) {
            cajasOpcionesMostradas.get(i).setOnAction(new SeleccionarRadioButtonHandler(pregunta.getColeccionDeOpciones().getOpciones().get(i), opcionesSeleccionadas));
        }
    }

    public void siguienteTurno() throws IOException {

        try{
            this.turnoActual.siguienteJugador(new RespuestaUnica(opcionesSeleccionadas.removeFirst(),jugador,multiplicador));
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!");
            alert.setHeaderText("No has elegido ninguna respuesta");
            alert.setContentText("Por favor, elegí una y volvé a intentar.");
            alert.showAndWait();
        }

    }

    public void asignarMultiplicadorx2() {

        if(jugador.cantidadMultiplicadoresPor2() != 0) multiplicador = jugador.usarMultiplicadorPorDos();
        multiplicadorx2.setDisable(true);
        multiplicadorx3.setDisable(true);
    }
    public void asignarMultiplicadorx3() {
        if(jugador.cantidadMultiplicadoresPor3() != 0) multiplicador = jugador.usarMultiplicadorPorTres();
        multiplicadorx3.setDisable(true);
        multiplicadorx2.setDisable(true);
    }
}
