package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.excepciones.NoTieneBeneficioException;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

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

        assertEquals(Lucas.cantidadMultiplicadoresPor2(),1);

        Multiplicador multiplicadorPorDos = Lucas.usarMultiplicadorPorDos();

        assertEquals(multiplicadorPorDos.getFactor(), 2);
    }

    @Test
    public void testCreoJugadorYTieneMultiplicadorPorTres() {

        Jugador Lucas = new Jugador("Lucas");

        assertEquals(Lucas.cantidadMultiplicadoresPor3(),1);

        Multiplicador multiplicadorPorTres = Lucas.usarMultiplicadorPorTres();

        assertEquals(multiplicadorPorTres.getFactor(), 3);
    }

    @Test
    public void testCreoJugadorYTieneDosExclusividades() {

        Jugador Lucas = new Jugador("Lucas");

        Multiplicador multiplicadorPorTres = Lucas.usarMultiplicadorPorTres();

        assertEquals(multiplicadorPorTres.getFactor(), 3);
    }

    @Test
    public void testpidoDosVecesElMultiplicadorPorDosYDevuelveExcepcion() {

        Jugador Lucas = new Jugador("Lucas");
        Lucas.usarMultiplicadorPorDos();

        assertThrows(NoTieneBeneficioException.class,
                ()->{
                    Lucas.usarMultiplicadorPorDos();
                });
    }

    @Test
    public void testpidoDosVecesElMultiplicadorPorTresYDevuelveExcepcion() {

        Jugador Lucas = new Jugador("Lucas");
        Lucas.usarMultiplicadorPorTres();

        assertThrows(NoTieneBeneficioException.class,
                ()->{
                    Lucas.usarMultiplicadorPorTres();
                });
    }

    @Test
    public void testpidoUnaExclusividadYSeDevuelveCorrectamente() {

        Jugador Lucas = new Jugador("Lucas");
        Exclusividad exclusividad = Lucas.usarExclusividad();

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("En el trabajo se uso mas el patron state que el strategy");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Lucas, exclusividad));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        assertEquals(Lucas.getPuntos().getCantidad(), 2);
    }

    @Test
    public void testpidoDosExclusividadesYSeDevuelveCorrectamente() {

        Jugador Lucas = new Jugador("Lucas");
        Exclusividad primeraExclusividad = Lucas.usarExclusividad();
        Exclusividad segundaExclusividad = Lucas.usarExclusividad();

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("En el trabajo se uso mas el patron state que el strategy");
        pregunta.setVerdaderoOpcionCorrecta();
        PreguntaVerdaderoFalsoClasico preguntaSegunda = new PreguntaVerdaderoFalsoClasico("Todos los años tienen 365 dias");
        preguntaSegunda.setFalsoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadoresPrimeraPregunta = new LinkedList<Respuesta>();

        respuestasDeJugadoresPrimeraPregunta.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Lucas, primeraExclusividad));

        pregunta.evaluarRespuestas(respuestasDeJugadoresPrimeraPregunta);

        LinkedList<Respuesta> respuestasDeJugadoresSegundaPregunta = new LinkedList<Respuesta>();

        respuestasDeJugadoresSegundaPregunta.add(new RespuestaUnica(preguntaSegunda.getOpcionFalsa(),Lucas, segundaExclusividad));

        preguntaSegunda.evaluarRespuestas(respuestasDeJugadoresSegundaPregunta);

        assertEquals(Lucas.getPuntos().getCantidad(), 4);
    }

    @Test
    public void testpidoTresVecesExclusividadAlJugadorYDevuelveExcepcion() {

        Jugador Lucas = new Jugador("Lucas");
        Lucas.usarExclusividad();
        Lucas.usarExclusividad();

        assertThrows(NoTieneBeneficioException.class,
                ()->{
                    Lucas.usarExclusividad();
                });
    }


    @Test
    public void testpidoListaDeExcepcionesYLaDevueltaEsCorrecta() {

        Jugador Lucas = new Jugador("Lucas");
        Exclusividad primeraExclusividad = Lucas.getExclusividades().get(0);
        Exclusividad segundaExclusividad = Lucas.getExclusividades().get(1);

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("En el trabajo se uso mas el patron state que el strategy");
        pregunta.setVerdaderoOpcionCorrecta();
        PreguntaVerdaderoFalsoClasico preguntaSegunda = new PreguntaVerdaderoFalsoClasico("Todos los años tienen 365 dias");
        preguntaSegunda.setFalsoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadoresPrimeraPregunta = new LinkedList<Respuesta>();

        respuestasDeJugadoresPrimeraPregunta.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Lucas, primeraExclusividad));

        pregunta.evaluarRespuestas(respuestasDeJugadoresPrimeraPregunta);

        LinkedList<Respuesta> respuestasDeJugadoresSegundaPregunta = new LinkedList<Respuesta>();

        respuestasDeJugadoresSegundaPregunta.add(new RespuestaUnica(preguntaSegunda.getOpcionFalsa(),Lucas, segundaExclusividad));

        preguntaSegunda.evaluarRespuestas(respuestasDeJugadoresSegundaPregunta);

        assertEquals(Lucas.getPuntos().getCantidad(), 4);
    }

}
