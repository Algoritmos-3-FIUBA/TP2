package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOpcion {

    @Test
    public void OpcionCorrectaDevuelveLaCantidadDePuntosEsperados(){
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Cristobal Colón",1);
        assertEquals(1,opcionCorrecta.puntosObtenidos());
    }

    @Test
    public void OtraOpcionCorrectaDevuelveLaCantidadDePuntosEsperados(){
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("1969",5);
        assertEquals(5,opcionCorrecta.puntosObtenidos());
    }

    @Test
    public void OpcionIncorrectaDevuelveLaCantidadDePuntosEsperados(){
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Kent Beck",0);
        assertEquals(0,opcionIncorrecta.puntosObtenidos());
    }
}
