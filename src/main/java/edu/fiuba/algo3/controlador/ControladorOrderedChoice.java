package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.TurnoJugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
import edu.fiuba.algo3.vista.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

import static java.lang.String.valueOf;

public class ControladorOrderedChoice extends Controlador{
    private LinkedList<Button> opcionesMostradas = new LinkedList<>();
    private LinkedList<Label> ordenMostrado = new LinkedList<>();
    private LinkedList<Opcion> opcionesElegidas = new LinkedList<>();
    private Pregunta pregunta; //= new PreguntaMultipleChoice();
    private TurnoJugador turnoActual;
    private int cantidadExclusividades = 2;
    private Respuesta respuesta;

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
    public Label botonexclusividad;

    Stage escenarioActual;
    private Jugador jugador;

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

    }

    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual, TurnoJugador turnoActual) {
        this.turnoActual = turnoActual;
        this.jugador = jugadorActual;
        this.pregunta = pregunta;

        nombrepregunta.setText(pregunta.getNombre());
        tipopregunta.setText(pregunta.getClass().getSimpleName().replaceAll("(.)([A-Z])", "$1 $2"));
        jugadoractual.setText(jugadorActual.getNombre());
        puntosactuales.setText(valueOf(jugadorActual.getPuntos().cantidad));

        opcionesElegidas = new LinkedList<>();

        for(Label orden : ordenMostrado)
            orden.setText("");

        if(cantidadExclusividades == 0)
            botonexclusividad.setDisable(true);
        else
            botonexclusividad.setDisable(false);

        for (int i = 0; i < pregunta.getOpciones().cantidadElementos(); i++) {
            opcionesMostradas.get(i).setText(pregunta.getOpciones().getOpciones().get(i).getNombre());
            opcionesMostradas.get(i).setOnAction(new SeleccionarCheckBoxOrderedChoiceHandler(pregunta.getOpciones().getOpciones().get(i), opcionesElegidas,this));
        }
    }

    public void siguienteTurno() throws IOException {

        if(jugador.getExclusividades().size() == cantidadExclusividades)
            this.turnoActual.siguienteJugador(new RespuestaMultiple(opcionesElegidas,jugador));
        else
            this.turnoActual.siguienteJugador(respuesta);
    }

    public void asignarExclusividad() throws IOException {

        cantidadExclusividades = jugador.getExclusividades().size();
        respuesta = new  RespuestaMultiple(opcionesElegidas,jugador, jugador.usarExclusividad());
        botonexclusividad.setDisable(true);
    }

    public void actualizarOrden() {
        for(Label orden : ordenMostrado)
            orden.setText("");

        for(int i = 0; i < opcionesElegidas.size(); i++){
            int j = pregunta.getOpciones().getOpciones().indexOf(opcionesElegidas.get(i));
            ordenMostrado.get(j).setText(Integer.toString(i+1));
        }
    }
}
