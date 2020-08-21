package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.exclusividad.ExclusividadDefault;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
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
    private LinkedList<CheckBox> cajasOpcionesMostradas = new LinkedList<>();
    private LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
    private EscenaJugador turnoActual;
    private Jugador jugador;
   /* private Respuesta respuesta;
    private int cantidadExclusividades = 2;*/

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
        this.turnoActual = turnoActual;
        this.jugador = jugadorActual;

        nombrepregunta.setText(pregunta.getNombre());
        tipopregunta.setText(pregunta.getClass().getSimpleName().replaceAll("(.)([A-Z])", "$1 $2"));
        jugadoractual.setText(jugadorActual.getNombre());
        puntosactuales.setText(String.valueOf(jugadorActual.getPuntos().cantidad));

        for(CheckBox opcion : cajasOpcionesMostradas)
            opcion.setSelected(false);

        multiplicadorx2.setDisable(true);
        multiplicadorx3.setDisable(true);

        if(jugador.getExclusividades().size() == 0)
            botonexclusivdad.setDisable(true);
        else
            botonexclusivdad.setDisable(false);

        opcionesSeleccionadas = new LinkedList<>();

        for (int i = 0; i < pregunta.getColeccionDeOpciones().cantidadElementos(); i++) {
            cajasOpcionesMostradas.get(i).setOnAction(new SeleccionarCheckBoxMultipleChoiceHandler(pregunta.getColeccionDeOpciones().getOpciones().get(i), opcionesSeleccionadas));
            cajasOpcionesMostradas.get(i).setText(pregunta.getColeccionDeOpciones().getOpciones().get(i).getNombre());
        }
    }

    public void siguienteTurno() throws IOException {

        this.turnoActual.siguienteJugador(new RespuestaMultiple(opcionesSeleccionadas,jugador, exclusividad));
        /*
        if(jugador.getExclusividades().size() == cantidadExclusividades || jugador.getExclusividades().size() == 0)
            this.turnoActual.siguienteJugador(new RespuestaMultiple(opcionesSeleccionadas,jugador));
        else
            this.turnoActual.siguienteJugador(respuesta);*/
    }

    public void asignarExclusividad() throws IOException {

        this.exclusividad = jugador.usarExclusividad();
        botonexclusivdad.setDisable(true);

        /*   VIEJO
        respuesta = new RespuestaUnica(opcionesSeleccionadas.getFirst(), jugador, jugador.usarExclusividad());
        */

        /*cantidadExclusividades = jugador.getExclusividades().size();
        respuesta = new RespuestaMultiple(opcionesSeleccionadas,jugador, jugador.usarExclusividad());
        botonexclusivdad.setDisable(true);*/
    }

}


