package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOpcion {

    @Test
    public void testOpcionCorrectaDevuelveLaCantidadDePuntosEsperados01(){
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Cristobal Colón",1);
        assertEquals(1,opcionCorrecta.puntosObtenidos().getCantidad());
    }

    @Test
    public void testOtraOpcionCorrectaDevuelveLaCantidadDePuntosEsperados02(){
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("1969",5);
        assertEquals(5,opcionCorrecta.puntosObtenidos().getCantidad());
    }

    @Test
    public void testOpcionIncorrectaDevuelveLaCantidadDePuntosEsperados03(){
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Kent Beck",0);
        assertEquals(0,opcionIncorrecta.puntosObtenidos().getCantidad());
    }

    @Test
    public void testOpcionCorrectaSeAgregaALaListaCorrecta04(){
        ColeccionOpciones opcionesCorrectas = new ColeccionOpciones();
        ColeccionOpciones opcionesIncorrectas = new ColeccionOpciones();

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("28",5);

        opcionCorrecta.agregarseAlGrupoCorrespondiente(opcionesCorrectas,opcionesIncorrectas);

        assertTrue(opcionesCorrectas.contiene(opcionCorrecta));
        assertEquals(opcionesIncorrectas.cantidadElementos(),0);
        assertEquals(opcionesCorrectas.cantidadElementos(),1);
    }

    @Test
    public void testOpcionIncorrectaSeAgregaALaListaCorrecta05(){
        ColeccionOpciones opcionesCorrectas = new ColeccionOpciones();
        ColeccionOpciones opcionesIncorrectas = new ColeccionOpciones();

        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("La cordillera de los Andes",2);

        opcionIncorrecta.agregarseAlGrupoCorrespondiente(opcionesCorrectas,opcionesIncorrectas);

        assertTrue(opcionesIncorrectas.contiene(opcionIncorrecta));
        assertEquals(opcionesCorrectas.cantidadElementos(),0);
        assertEquals(opcionesIncorrectas.cantidadElementos(),1);
    }

    @Test
    public void testOpcionDevuelveNombreEsperado06(){
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Cristobal Colón",1);
        assertEquals(opcionCorrecta.getNombre(),"Cristobal Colón");
    }

    @Test
    public void testOtraOpcionDevuelveNombreEsperado07(){
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Cristobal Colón",1);
        assertEquals(opcionIncorrecta.getNombre(),"Cristobal Colón");
    }
}