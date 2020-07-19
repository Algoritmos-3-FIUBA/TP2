package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPregunta {

    @Test
    public void CreoUnaPreguntaConRespuestaVerdadero(){
        Pregunta preguntaUno = new Pregunta("1+1 no es 3");
        assertEquals(preguntaUno.getPregunta(),"1+1 no es 3");
    }

}
