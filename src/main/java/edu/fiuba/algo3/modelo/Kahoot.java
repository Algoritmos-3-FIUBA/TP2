package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.LecturaDeArchivo;

import java.util.LinkedList;

public class Kahoot {

    private LinkedList<Jugador> jugadores = new LinkedList<>();
    private LinkedList<Pregunta> preguntas = new LinkedList<>();;

    public Kahoot(String jugador1, String jugador2){

        jugadores.add(new Jugador(jugador1));
        jugadores.add(new Jugador(jugador2));

        System.out.println(jugador1);

        LecturaDeArchivo leerArchivo = new LecturaDeArchivo(preguntas);
    }


}
