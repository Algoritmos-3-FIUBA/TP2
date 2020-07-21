package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOpcion {

    @Test
    public void OpcionCorrectaDevuelve1Punto(){
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta();
        assertEquals(1,opcionCorrecta.puntosASumar());
    }

    @Test
    public void OpcionIncorrectaNoDevuelvePuntos(){
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta();
        assertEquals(0,opcionIncorrecta.puntosASumar());
    }
}
