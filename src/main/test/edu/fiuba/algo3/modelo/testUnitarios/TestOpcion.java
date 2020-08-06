package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOpcion {

    @Test
    public void OpcionCorrectaLePreguntoElNombre(){
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Cristobal Colon",1);
        assertEquals(opcionCorrecta.getNombre(),"Cristobal Colon");
    }
    @Test
    public void OpcionIncorrectaLePreguntoElNombre(){
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("America",1);
        assertEquals(opcionIncorrecta.getNombre(),"America");
    }

    @Test
    public void OpcionCorrectaDevuelveLaCantidadDePuntosEsperados(){
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Cristobal Colón",1);
        assertEquals(1,opcionCorrecta.puntosObtenidos().getCantidad());
    }

    @Test
    public void OtraOpcionCorrectaDevuelveLaCantidadDePuntosEsperados(){
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("1969",5);
        assertEquals(5,opcionCorrecta.puntosObtenidos().getCantidad());
    }

    @Test
    public void OpcionIncorrectaDevuelveLaCantidadDePuntosEsperados(){
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Kent Beck",0);
        assertEquals(0,opcionIncorrecta.puntosObtenidos().getCantidad());
    }

    @Test
    public void OpcionCorrectaSeAgregaALaListaCorrecta(){
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<>();
        HashSet<OpcionIncorrecta> opcionesIncorrectas = new HashSet<>();

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("28",5);

        opcionCorrecta.agregarseALaListaCorrespondiente(opcionesCorrectas,opcionesIncorrectas);

        assert(opcionesCorrectas.contains(opcionCorrecta));
        assertEquals(opcionesIncorrectas.size(),0);
        assertEquals(opcionesCorrectas.size(),1);
    }

    @Test
    public void OpcionIncorrectaSeAgregaALaListaCorrecta(){
        HashSet<OpcionCorrecta> opcionesCorrectas = new HashSet<>();
        HashSet<OpcionIncorrecta> opcionesIncorrectas = new HashSet<>();

        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("La cordillera de los Andes",2);

        opcionIncorrecta.agregarseALaListaCorrespondiente(opcionesCorrectas,opcionesIncorrectas);

        assert(opcionesIncorrectas.contains(opcionIncorrecta));
        assertEquals(opcionesCorrectas.size(),0);
        assertEquals(opcionesIncorrectas.size(),1);
    }
}
