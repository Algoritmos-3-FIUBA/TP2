package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.LecturaDeArchivo;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;

public class Kahoot {


    private static LinkedList<Jugador> jugadores = new LinkedList<>();

    private static LinkedList<Pregunta> preguntas = new LinkedList<>();

    private static HashMap<Pregunta,String> plantillasPreguntas = new HashMap<>();

    private static SistemaEscenas sistemaTurnos;

    private static Kahoot juego = new Kahoot();

    private Kahoot(){}

    public static void juegoKahoot(String jugador1, String jugador2){
        jugadores.add(new Jugador(jugador1));
        jugadores.add(new Jugador(jugador2));

        System.out.println(jugador1);

        LecturaDeArchivo leerArchivo = new LecturaDeArchivo(preguntas,plantillasPreguntas);

        sistemaTurnos = new SistemaEscenas(jugadores,preguntas,plantillasPreguntas);
    }

    public static void actualizarEscena(Stage escenarioActual) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Paths.get("src/main/java/edu/fiuba/algo3/vista/vofinicial.fxml").toUri().toURL());
        Parent root = fxmlLoader.load();


        Scene scene = new Scene(root);

        escenarioActual.setScene(scene);


    }
    public static void obtenerOpcionDeMultipleChoise(){

    }
    /*
    public Kahoot(String jugador1, String jugador2){

        jugadores.add(new Jugador(jugador1));
        jugadores.add(new Jugador(jugador2));

        System.out.println(jugador1);

        LecturaDeArchivo leerArchivo = new LecturaDeArchivo(preguntas);
    }*/


}
