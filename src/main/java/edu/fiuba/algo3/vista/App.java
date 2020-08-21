package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import java.nio.file.Paths;

public class App extends Application {

    public static Stage escenario;
    private static final String TITULO_JUEGO = "Kahoot!";
    private static final String ICONO_JUEGO = "src/main/java/edu/fiuba/algo3/vista/imagenes/icono.png";
    private static final String SONIDO_JUEGO = "src/main/java/edu/fiuba/algo3/vista/sonidos/kahoot-lobby-music.mp3";

    @Override
    public void start(Stage escenarioInicial) throws Exception {
        this.escenario = escenarioInicial;

        escenarioInicial.getIcons().add(new Image(Paths.get(ICONO_JUEGO).toUri().toString()));

        AudioClip audio = new AudioClip(Paths.get(SONIDO_JUEGO).toUri().toString());
        audio.play();
        audio.setVolume(0.75);
        escenarioInicial.setTitle(TITULO_JUEGO);
        escenario.setResizable(false);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Paths.get("src/main/java/edu/fiuba/algo3/vista/plantilla/Inicio.fxml").toUri().toURL());
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        escenarioInicial.setScene(scene);
        escenarioInicial.show();
    }

    public static Stage obtenerEscenarioActual(){
        return escenario;
    }

    public static void main(String[] args) {
        launch(args);
    }
}