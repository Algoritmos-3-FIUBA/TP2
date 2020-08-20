package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoTieneBeneficioException;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoClasico;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestJugador {


    @Test
    public void testCreoJugadorLlamadoJuanObtengoNombreJuan01(){
        Jugador Juan = new Jugador("Juan");
        assertEquals(Juan.getNombre(), "Juan");
    }

    @Test
    public void testCreoJugadorLlamadoJuanObtengoNombreLucas02(){
        Jugador Juan = new Jugador("Lucas");
        assertEquals(Juan.getNombre(), "Lucas");
    }

    @Test
    public void testCreoJugadorLlamadoPedroNoTienePuntosInicialesObtengo0Puntos03(){
        Jugador Pedro = new Jugador("Pedro");
        Puntos puntos = Pedro.getPuntos();
        assertEquals(puntos.getCantidad(), 0);
    }

    @Test
    public void testCreoJugadorLlamadoPedroNoTienePuntosInicialesLeSumo1PuntoTiene1Punto04() {
        Jugador Pedro = new Jugador("Pedro");
        Pedro.sumarPuntos(new Puntos(1));
        assertEquals(Pedro.getPuntos().getCantidad(), 1);
    }

    @Test
    public void testCreoJugadorLlamadoLucasSumaPuntos05() {
        Jugador Lucas = new Jugador("Lucas");
        Lucas.sumarPuntos(new Puntos(1));
        Lucas.sumarPuntos(new Puntos(3));
        assertEquals(Lucas.getPuntos().getCantidad(), 4);
        Lucas.sumarPuntos(new Puntos(-1));
        assertEquals(Lucas.getPuntos().getCantidad(), 3);
    }

    @Test
    public void testCreoJugadorYTieneMultiplicadorPorDos() {

        Jugador Lucas = new Jugador("Lucas");

        Multiplicador multiplicadorPorDos = Lucas.usarMultiplicadorPorDos();

        assertEquals(multiplicadorPorDos.getFactor(), 2);
    }

    @Test
    public void testCreoJugadorYTieneMultiplicadorPorTres() {

        Jugador Lucas = new Jugador("Lucas");

        Multiplicador multiplicadorPorTres = Lucas.usarMultiplicadorPorTres();

        assertEquals(multiplicadorPorTres.getFactor(), 3);
    }

    @Test
    public void testCreoJugadorYPuedeUsarMultiplicadorPorTres() {

        Jugador Lucas = new Jugador("Lucas");
        Puntos puntos = new Puntos(2);

        Multiplicador multiplicadorPorTres = Lucas.usarMultiplicadorPorTres();

        multiplicadorPorTres.utilizarBeneficio( puntos, Lucas);

        assertEquals(Lucas.getPuntos().getCantidad(), 6);
    }

    @Test
    public void testCreoJugadorYPuedeUsarMultiplicadorPorDos() {

        Jugador Lucas = new Jugador("Lucas");
        Puntos puntos = new Puntos(1);

        Multiplicador multiplicadorPorDos = Lucas.usarMultiplicadorPorDos();

        multiplicadorPorDos.utilizarBeneficio( puntos, Lucas);

        assertEquals(Lucas.getPuntos().getCantidad(), 2);
    }

    @Test
    public void testCreoJugadorYNoPuedeUsarMultiplicadorPorDosDosVeces() {

        Jugador Lucas = new Jugador("Lucas");
        Puntos puntos = new Puntos(1);

        Lucas.usarMultiplicadorPorDos().utilizarBeneficio(puntos, Lucas);


        assertThrows(NoTieneBeneficioException.class,
                ()->{
                    Lucas.usarMultiplicadorPorDos().utilizarBeneficio(puntos, Lucas);
                });

    }

    @Test
    public void testCreoJugadorYNoPuedeUsarMultiplicadorPorTresDosVeces() {

        Jugador Lucas = new Jugador("Lucas");
        Puntos puntos = new Puntos(1);

        Lucas.usarMultiplicadorPorTres().utilizarBeneficio(puntos, Lucas);


        assertThrows(NoTieneBeneficioException.class,
                ()->{
                    Lucas.usarMultiplicadorPorTres().utilizarBeneficio(puntos, Lucas);
                });

    }

    @Test
    public void testCreoJugadorYUsaExclusividadDePuntaje() {

        Jugador Lucas = new Jugador("Lucas");
        Puntos puntos = new Puntos(5);

        Lucas.sumarPuntos(puntos);

        Lucas.usarExclusividad().getAmplificador().amplificarPuntos(Lucas.getPuntos());
        Lucas.usarExclusividad().getAmplificador().amplificarPuntos(Lucas.getPuntos());

        assertThrows(NoTieneBeneficioException.class,
                ()->{
                    Lucas.usarExclusividad().getAmplificador().amplificarPuntos(Lucas.getPuntos());
                });

    }

}
