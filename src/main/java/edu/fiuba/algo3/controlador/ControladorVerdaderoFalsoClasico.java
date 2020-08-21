package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.exclusividad.ExclusividadDefault;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
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
    private LinkedList<RadioButton> cajasOpcionesMostradas = new LinkedList<RadioButton>();
    private LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
    private LinkedList<Button> cajasMultiplicadores = new LinkedList<>();
    private EscenaJugador turnoActual;
    private Jugador jugador;
    private Exclusividad exclusividad = new ExclusividadDefault();
    /*private Respuesta respuesta;
    private int cantidadExclusividades = 2;*/

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
        multiplicadorx2.setDisable(true);
        multiplicadorx3.setDisable(true);

    }
    @Override
    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual, EscenaJugador turnoActual) {
        this.turnoActual = turnoActual;
        this.jugador = jugadorActual;

        nombrepregunta.setText(pregunta.getNombre());
        tipopregunta.setText(pregunta.getClass().getSimpleName().replaceAll("(.)([A-Z])", "$1 $2"));
        jugadoractual.setText(jugadorActual.getNombre());
        puntosactuales.setText(String.valueOf(jugadorActual.getPuntos().cantidad));

        for(RadioButton opcion : cajasOpcionesMostradas)
            opcion.setSelected(false);

        multiplicadorx2.setDisable(true);
        multiplicadorx3.setDisable(true);

        if(jugador.getExclusividades().size() == 0)
            botonexclusivdad.setDisable(true);
        else
            botonexclusivdad.setDisable(false);

        opcionesSeleccionadas = new LinkedList<>();

        for (int i = 0; i < pregunta.getOpciones().cantidadElementos(); i++) {
            cajasOpcionesMostradas.get(i).setOnAction(new SeleccionarRadioButtonHandler(pregunta.getOpciones().getOpciones().get(i), opcionesSeleccionadas));
        }

    }

    public void siguienteTurno() throws IOException {

        this.turnoActual.siguienteJugador(new RespuestaUnica(opcionesSeleccionadas.removeFirst(), jugador, exclusividad));

        /*if(jugador.getExclusividades().size() == cantidadExclusividades || jugador.getExclusividades().size() == 0)
            this.turnoActual.siguienteJugador(new RespuestaUnica(opcionesSeleccionadas.removeFirst(), jugador));
        else
            this.turnoActual.siguienteJugador(new RespuestaUnica(opcionesSeleccionadas.getFirst(), jugador, exclusividadPrueba));*/
    }

    public void asignarExclusividad() throws IOException {

       //cantidadExclusividades = jugador.getExclusividades().size();
        // NUEVO
       this.exclusividad = jugador.usarExclusividad();
        botonexclusivdad.setDisable(true);
       /*   VIEJO
        respuesta = new RespuestaUnica(opcionesSeleccionadas.getFirst(), jugador, jugador.usarExclusividad());
        */

    }
}
