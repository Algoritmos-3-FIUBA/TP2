package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.LecturaDeArchivo;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    @Test
    public void messageGreeting() {
        LinkedList<Pregunta> preguntas = new LinkedList<>();
        LecturaDeArchivo lectura = new LecturaDeArchivo(preguntas);

        //Message message = new Message("Hello world!");

        //assertEquals("Hello world!", message.greet());
    }
}