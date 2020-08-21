package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.TurnoJugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGrupos;
import edu.fiuba.algo3.vista.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

import static java.lang.String.valueOf;

public class ControladorGroupChoice extends Controlador{
    private final LinkedList<Button> opcionesMostradas = new LinkedList<>();
    private final LinkedList<ComboBox> gruposMostrados = new LinkedList<>();
    private LinkedList<ColeccionOpciones> gruposElegidos = new LinkedList<>();
    private Pregunta pregunta;
    private TurnoJugador turnoActual;
    private Jugador jugador;
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

    }

    @Override
    public void actualizarPlantilla(Pregunta pregunta, Jugador jugadorActual, TurnoJugador turnoActual) {
        this.turnoActual = turnoActual;
        this.jugador = jugadorActual;
        this.pregunta = pregunta;

        multiplicadorx2.setDisable(true);
        multiplicadorx3.setDisable(true);

        nombrepregunta.setText(pregunta.getNombre());
        tipopregunta.setText(pregunta.getClass().getSimpleName().replaceAll("(.)([A-Z])", "$1 $2"));
        jugadoractual.setText(jugadorActual.getNombre());
        puntosactuales.setText(valueOf(jugadorActual.getPuntos().cantidad));

        gruposElegidos = new LinkedList<>();

        ColeccionOpciones primerGrupo = new ColeccionOpciones(((PreguntaGroupChoice) pregunta).getNombresGrupos().get(0));
        ColeccionOpciones segundoGrupo = new ColeccionOpciones(((PreguntaGroupChoice) pregunta).getNombresGrupos().get(1));

        gruposElegidos.add(primerGrupo);
        gruposElegidos.add(segundoGrupo);

        for(ComboBox caja : gruposMostrados){
            caja.setValue(null);
            caja.getItems().clear();
        }

        for(ComboBox caja : gruposMostrados){
            caja.getItems().add(primerGrupo.getNombre());
            caja.getItems().add(segundoGrupo.getNombre());
        }

        if(jugador.getExclusividades().size() == 0)
            botonexclusivdad.setDisable(true);
        else
            botonexclusivdad.setDisable(false);

        for (int i = 0; i < pregunta.getOpciones().cantidadElementos(); i++)
            opcionesMostradas.get(i).setText(pregunta.getOpciones().getOpciones().get(i).getNombre());
    }


    public void siguienteTurno() throws IOException {

        this.armarGrupos();
        if(jugador.getExclusividades().size() == cantidadExclusividades || jugador.getExclusividades().size() == 0)
            this.turnoActual.siguienteJugador(new RespuestaGrupos(gruposElegidos,jugador));
        else
            this.turnoActual.siguienteJugador(respuesta);
    }

    public void asignarExclusividad() throws IOException {

        cantidadExclusividades = jugador.getExclusividades().size();
        respuesta = new RespuestaGrupos(gruposElegidos,jugador, jugador.usarExclusividad());
        botonexclusivdad.setDisable(true);
    }

    private void armarGrupos() {
        for(ComboBox caja : gruposMostrados)
            for(ColeccionOpciones grupos: gruposElegidos)
                if(caja.getValue() == grupos.getNombre())
                    grupos.agregarOpcion(pregunta.getOpciones().getOpciones().get(gruposMostrados.indexOf(caja)));
    }
}
