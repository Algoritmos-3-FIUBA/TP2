package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonInicioJuego;
import edu.fiuba.algo3.controlador.BotonResponderVerdadero;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.FileInputStream;
import java.nio.file.Paths;

import static jdk.xml.internal.SecuritySupport.getResourceAsStream;

public class App extends Application {

    private Stage escenario;
    private static final String TITULO_JUEGO = "Kahoot!";
    private static final String ICONO_JUEGO = "imagenes/favicon.png"; //PROXIMAMENTE
    private static final String SONIDO_JUEGO = "sonidos/sonido_inicio.mp3"; //PROXIMAMENTE
    private static final int ANCHO = 800;
    private static final int ALTO = 500;

    @Override
    public void start(Stage escenarioInicial) throws Exception {
        this.escenario=escenarioInicial;

        //escenarioInicial.getIcons().add(new Image(getClass().getResourceAsStream(ICONO_JUEGO)));
        //escenarioInicial.getIcons().add(icono);

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