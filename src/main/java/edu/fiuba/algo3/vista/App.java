package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.nio.file.Paths;

public class App extends Application {

    private Stage escenario;
    private static final String TITULO_JUEGO = "Kahoot!";
    private static final String ICONO_JUEGO = "src/main/java/edu/fiuba/algo3/vista/imagenes/favicon.png";
    private static final String SONIDO_JUEGO = "src/main/java/edu/fiuba/algo3/vista/sonidos/kahoot-lobby-music.mp33"; //PROXIMAMENTE
    private static final int ANCHO = 800;
    private static final int ALTO = 500;

    @Override
    public void start(Stage escenarioInicial) throws Exception {
        this.escenario=escenarioInicial;

        escenarioInicial.getIcons().add(new Image(Paths.get(ICONO_JUEGO).toUri().toString()));

/* Falta media
        Media media = new Media(Paths.get(SONIDO_JUEGO).toUri().toString());
        MediaPlayer musicaDeFondo = new MediaPlayer(media);
        musicaDeFondo.setVolume(0.3);
        musicaDeFondo.play();
*/
        escenarioInicial.setTitle(TITULO_JUEGO);

        FormularioInicial formularioInicial = new FormularioInicial() ;
        formularioInicial.agregarControlesInterfaz(escenarioInicial);

        Scene scene = new Scene(formularioInicial, ANCHO, ALTO);

        escenarioInicial.setScene(scene);

        escenarioInicial.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}