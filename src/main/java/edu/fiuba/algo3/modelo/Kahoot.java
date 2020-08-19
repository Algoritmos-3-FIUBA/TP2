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
    private static Stage escenario;

    private static Kahoot juego = new Kahoot();

    private Kahoot(){}

    public static void juegoKahoot(Stage escenario,String jugador1, String jugador2) throws IOException {
        Kahoot.escenario = escenario;

        jugadores.add(new Jugador(jugador1));
        jugadores.add(new Jugador(jugador2));

        System.out.println(jugador1);

        LecturaDeArchivo leerArchivo = new LecturaDeArchivo(preguntas,plantillasPreguntas);

        sistemaTurnos = new SistemaEscenas(jugadores,preguntas,plantillasPreguntas);
        /// CREAR RESPUESTAS ANTES DE ESTA INSTANCIA Y QUE LA PREGUNTA LAS EVALUE ///
        sistemaTurnos.siguienteEscena();
    }

    public static void actualizarEscena(Scene escena) throws IOException{
        escenario.setScene(escena);
    }

    public static void siguienteTurno(){
        //sistemaTurnos.siguienteEscena();
    }
}
