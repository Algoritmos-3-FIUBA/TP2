package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalso;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.vista.PreguntaVoF;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Window;

import java.nio.file.Paths;
import java.util.LinkedList;

public class BotonInicioJuego implements EventHandler<ActionEvent>  {
    private TextField jugador1;
    private TextField jugador2;
    private GridPane gridPane;
    private static final String SONIDO_JUEGO = "src/main/java/edu/fiuba/algo3/vista/sonidos/kahoot-lobby-music.mp3";
    private static final String SONIDO_JUEGO_PREGUNTAS = "src/main/java/edu/fiuba/algo3/vista/sonidos/musica-preguntas.mp3";

    public BotonInicioJuego(TextField jugador1, TextField jugador2, GridPane gridPane) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.gridPane = gridPane;
    }

    @Override
    public void handle(ActionEvent event) {
        if(jugador1.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Por favor ingrese el nombre del primer jugador");
            return;
        }
        if(jugador2.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Por favor ingrese el nombre del segundo jugador");
            return;
        }

        AudioClip audio = new AudioClip(Paths.get(SONIDO_JUEGO).toUri().toString());
        audio.stop();

        AudioClip audioPreguntas = new AudioClip(Paths.get(SONIDO_JUEGO_PREGUNTAS).toUri().toString());
        audioPreguntas.play();
        audioPreguntas.setVolume(0.85);

        LinkedList<PreguntaVerdaderoFalso> listaPreguntas = new LinkedList<>();
        this.ingresarPreguntas(listaPreguntas);
        for(int i = 2 ; i > 0 ; i--)
            new PreguntaVoF(listaPreguntas,i);
    }

    private void ingresarPreguntas(LinkedList<PreguntaVerdaderoFalso> listaPreguntas) {

        Kahoot kahoot = new Kahoot(jugador1.getText(),jugador2.getText());

        PreguntaVerdaderoFalsoClasico preg1 = new PreguntaVerdaderoFalsoClasico("1 + 1 = 2");
        preg1.setVerdaderoOpcionCorrecta();
        listaPreguntas.add(preg1);
        PreguntaVerdaderoFalsoClasico preg2 =  new PreguntaVerdaderoFalsoClasico("Existe el Sol");
        preg2.setVerdaderoOpcionCorrecta();
        listaPreguntas.add(preg2);
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
