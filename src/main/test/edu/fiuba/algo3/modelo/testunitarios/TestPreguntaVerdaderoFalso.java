package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaVerdaderoFalso {

    @Test
    public void testCreoPreguntaVerdaderoFalsoClasicoConNombrePregunta1YObtengoNombrePregunta101(){
        PreguntaVerdaderoFalsoClasico preguntaPrueba = new PreguntaVerdaderoFalsoClasico("Pregunta1");
        preguntaPrueba.setVerdaderoOpcionCorrecta();

        assertEquals(preguntaPrueba.getNombrePregunta(), "Pregunta1");
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoClasicoConVerdaderoCorrectaYVerdaderoSumaUnPunto02(){
        PreguntaVerdaderoFalsoClasico preguntaPrueba = new PreguntaVerdaderoFalsoClasico("Pregunta");
        preguntaPrueba.setVerdaderoOpcionCorrecta();

        Opcion opcionVerdaderoCorrecta = preguntaPrueba.getOpcionVerdadera();

        assertEquals(opcionVerdaderoCorrecta.puntosObtenidos().getCantidad(), 1);
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoClasicoConFalsoCorrectaYFalsoSumaUnPunto03(){
        PreguntaVerdaderoFalsoClasico preguntaPrueba = new PreguntaVerdaderoFalsoClasico("Pregunta");
        preguntaPrueba.setFalsoOpcionCorrecta();

        Opcion opcionFalsoCorrecta = preguntaPrueba.getOpcionFalsa();

        assertEquals(opcionFalsoCorrecta.puntosObtenidos().getCantidad(), 1);
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoClasicoConFalsoIncorrectoYFalsoSumaCeroPuntos04(){
        PreguntaVerdaderoFalsoClasico preguntaPrueba = new PreguntaVerdaderoFalsoClasico("Pregunta");
        preguntaPrueba.setVerdaderoOpcionCorrecta();

        Opcion opcionVerdaderoCorrecta = preguntaPrueba.getOpcionFalsa();

        assertEquals(opcionVerdaderoCorrecta.puntosObtenidos().getCantidad(), 0);
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoClasicoConVerdaderoIncorrectoYVerdaderoSumaCeroPuntos05(){
        PreguntaVerdaderoFalsoClasico preguntaPrueba = new PreguntaVerdaderoFalsoClasico("Pregunta");
        preguntaPrueba.setFalsoOpcionCorrecta();

        Opcion opcionFalsoCorrecta = preguntaPrueba.getOpcionVerdadera();

        assertEquals(opcionFalsoCorrecta.puntosObtenidos().getCantidad(), 0);
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoYJugadorRespondeMalAsignaPuntosCorrectamente06(){
        Jugador Lucas = new Jugador("Lucas");
        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Lucas));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        assertEquals(Lucas.getPuntos().getCantidad(),0);
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoYJugadorRespondeBienAsignaPuntosCorrectamente07(){
        Jugador Lucas = new Jugador("Lucas");
        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Lucas));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        assertEquals(Lucas.getPuntos().getCantidad(),1);
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoYJugadorRespondeBienConExclusividad08(){
        Jugador Lucas = new Jugador("Lucas");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Lucas, new Exclusividad()));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        assertEquals(Lucas.getPuntos().getCantidad(),2);
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoYDosJugadoresRespondenBienConUnaExclusividad09(){
        Jugador Lucas = new Jugador("Lucas");
        Jugador Juan = new Jugador("Juan");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Lucas, new Exclusividad()));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Juan));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        assertEquals(Lucas.getPuntos().getCantidad(),0);
        assertEquals(Juan.getPuntos().getCantidad(),0);
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoYDosJugadoresRespondenMalConUnaExclusividad10(){
        Jugador Lucas = new Jugador("Lucas");
        Jugador Juan = new Jugador("Juan");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Lucas, new Exclusividad()));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Juan));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        assertEquals(Lucas.getPuntos().getCantidad(),0);
        assertEquals(Juan.getPuntos().getCantidad(),0);
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoYRespondeBienJugadorSinExclusividad11(){
        Jugador Lucas = new Jugador("Lucas");
        Jugador Juan = new Jugador("Juan");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Lucas, new Exclusividad()));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Juan));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        assertEquals(Lucas.getPuntos().getCantidad(),0);
        assertEquals(Juan.getPuntos().getCantidad(),2);
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoYRespondeBienUnJugadorConDosExclusividades12(){
        Jugador Lucas = new Jugador("Lucas");
        Jugador Juan = new Jugador("Juan");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Lucas, new Exclusividad()));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Juan, new Exclusividad()));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        assertEquals(Lucas.getPuntos().getCantidad(),0);
        assertEquals(Juan.getPuntos().getCantidad(),4);
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoYRespondeBienUnSoloJugadorConUnaExclusividad13(){
        Jugador Lucas = new Jugador("Lucas");
        Jugador Juan = new Jugador("Juan");
        Jugador Pedro = new Jugador("Pedro");
        Jugador Ramiro = new Jugador("Ramiro");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Lucas));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Juan));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Pedro, new Exclusividad()));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Ramiro));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        assertEquals(Lucas.getPuntos().getCantidad(),0);
        assertEquals(Juan.getPuntos().getCantidad(),0);
        assertEquals(Pedro.getPuntos().getCantidad(),2);
        assertEquals(Ramiro.getPuntos().getCantidad(),0);
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoYRespondenBienTresJugadoresConDosExclusividades14(){
        Jugador Lucas = new Jugador("Lucas");
        Jugador Juan = new Jugador("Juan");
        Jugador Pedro = new Jugador("Pedro");
        Jugador Ramiro = new Jugador("Ramiro");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Lucas));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Juan, new Exclusividad()));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Pedro, new Exclusividad()));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Ramiro));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        assertEquals(Lucas.getPuntos().getCantidad(),0);
        assertEquals(Juan.getPuntos().getCantidad(),0);
        assertEquals(Pedro.getPuntos().getCantidad(),0);
        assertEquals(Ramiro.getPuntos().getCantidad(),0);
    }
}