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
    private static final String ICONO_JUEGO = "src/main/java/edu/fiuba/algo3/vista/imagenes/favicon.png";
    private static final String SONIDO_JUEGO = "src/main/java/edu/fiuba/algo3/vista/sonidos/kahoot-lobby-music.mp3"; //PROXIMAMENTE
    private static final int ANCHO = 800;
    private static final int ALTO = 500;

    @Override
    public void start(Stage escenarioInicial) throws Exception {
        this.escenario = escenarioInicial;

        escenarioInicial.getIcons().add(new Image(Paths.get(ICONO_JUEGO).toUri().toString()));


        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Paths.get("src/main/java/edu/fiuba/algo3/vista/MultipleChoiceClasico.fxml").toUri().toURL());
        Parent root = fxmlLoader.load();


/*
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Paths.get("src/main/java/edu/fiuba/algo3/vista/vofinicial.fxml").toUri().toURL());
        Parent root = fxmlLoader.load();
*/

/*Con este código la música funciona por pocos segundos, se corta de la nada. Probar en otra PC
        Media media = new Media(Paths.get(SONIDO_JUEGO).toUri().toString());
        MediaPlayer musicaDeFondo = new MediaPlayer(media);
        musicaDeFondo.play();
        musicaDeFondo.setVolume(0.3);
*/
//Funciona con este
        AudioClip audio = new AudioClip(Paths.get(SONIDO_JUEGO).toUri().toString());
        audio.play();
        audio.setVolume(0.85);
//---

        escenarioInicial.setTitle(TITULO_JUEGO);

       //FormularioInicial formularioInicial = new FormularioInicial() ;
        //formularioInicial.agregarControlesInterfaz(escenarioInicial);
        //Scene scene = new Scene(formularioInicial);

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