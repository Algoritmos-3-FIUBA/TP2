package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.LecturaDeArchivo;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class Kahoot{
    private static LinkedList<Jugador> jugadores = new LinkedList<>();

    private static LinkedList<Pregunta> preguntas = new LinkedList<>();

    private static HashMap<Pregunta,String> plantillasPreguntas = new HashMap<>();

    private static SistemaTurnos sistemaTurnos;
    private static Stage escenario;

    private Kahoot(){}

    public static void juegoKahoot(Stage escenario,String jugador1, String jugador2) throws IOException {
        Kahoot.escenario = escenario;

        jugadores.add(new Jugador(jugador1));
        jugadores.add(new Jugador(jugador2));

        new LecturaDeArchivo(preguntas,plantillasPreguntas);

        sistemaTurnos = new SistemaTurnos(jugadores,preguntas,plantillasPreguntas);
        sistemaTurnos.siguienteEscena();
    }

    public static void actualizarEscena(Scene escena) throws IOException{
        escenario.setScene(escena);
    }

    public static void siguienteTurno() throws IOException {
        sistemaTurnos.siguienteEscena();
    }
}
