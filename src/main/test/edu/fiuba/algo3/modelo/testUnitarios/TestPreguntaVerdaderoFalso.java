package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Exclusividad;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaVerdaderoFalso {

    @Test
    public void CreoPreguntaVerdaderoFalsoClasicoConNombrePregunta1YObtengoNombrePregunta1(){

        PreguntaVerdaderoFalsoClasico preguntaPrueba = new PreguntaVerdaderoFalsoClasico("Pregunta1");
        preguntaPrueba.setVerdaderoOpcionCorrecta();

        assertEquals(preguntaPrueba.getNombrePregunta(), "Pregunta1");

    }

    @Test
    public void CreoPreguntaVerdaderoFalsoClasicoConVerdaderoCorrectaYVerdaderoSumaUnPunto(){

        PreguntaVerdaderoFalsoClasico preguntaPrueba = new PreguntaVerdaderoFalsoClasico("Pregunta");
        preguntaPrueba.setVerdaderoOpcionCorrecta();

        Opcion opcionVerdaderoCorrecta = preguntaPrueba.getOpcionVerdadera();

        assertEquals(opcionVerdaderoCorrecta.puntosObtenidos().getCantidad(), 1);

    }

    @Test
    public void CreoPreguntaVerdaderoFalsoClasicoConFalsoCorrectaYFalsoSumaUnPunto(){

        PreguntaVerdaderoFalsoClasico preguntaPrueba = new PreguntaVerdaderoFalsoClasico("Pregunta");
        preguntaPrueba.setFalsoOpcionCorrecta();

        Opcion opcionFalsoCorrecta = preguntaPrueba.getOpcionFalsa();

        assertEquals(opcionFalsoCorrecta.puntosObtenidos().getCantidad(), 1);

    }

    @Test
    public void CreoPreguntaVerdaderoFalsoClasicoConFalsoIncorrectoYFalsoSumaCeroPuntos(){

        PreguntaVerdaderoFalsoClasico preguntaPrueba = new PreguntaVerdaderoFalsoClasico("Pregunta");
        preguntaPrueba.setVerdaderoOpcionCorrecta();

        Opcion opcionVerdaderoCorrecta = preguntaPrueba.getOpcionFalsa();

        assertEquals(opcionVerdaderoCorrecta.puntosObtenidos().getCantidad(), 0);

    }

    @Test
    public void CreoPreguntaVerdaderoFalsoClasicoConVerdaderoIncorrectoYVerdaderoSumaCeroPuntos(){

        PreguntaVerdaderoFalsoClasico preguntaPrueba = new PreguntaVerdaderoFalsoClasico("Pregunta");
        preguntaPrueba.setFalsoOpcionCorrecta();

        Opcion opcionFalsoCorrecta = preguntaPrueba.getOpcionVerdadera();

        assertEquals(opcionFalsoCorrecta.puntosObtenidos().getCantidad(), 0);

    }

    @Test
    public void CreoPreguntaVerdaderoFalsoYJugadorRespondeMalAsignaPuntosCorrectamente(){

        Jugador Lucas = new Jugador("Lucas");
        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Lucas));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        assertEquals(Lucas.getPuntos().getCantidad(),0);
    }

    @Test
    public void CreoPreguntaVerdaderoFalsoYJugadorRespondeBienAsignaPuntosCorrectamente(){

        Jugador Lucas = new Jugador("Lucas");
        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Lucas));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        Assertions.assertEquals(Lucas.getPuntos().getCantidad(),1);
    }

    @Test
    public void CreoPreguntaVerdaderoFalsoYJugadorRespondeBienConExclusividad(){

        Jugador Lucas = new Jugador("Lucas");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Lucas, new Exclusividad()));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        Assertions.assertEquals(Lucas.getPuntos().getCantidad(),2);
    }

    @Test
    public void CreoPreguntaVerdaderoFalsoYDosJugadoresRespondenBienConUnaExclusividad(){

        Jugador Lucas = new Jugador("Lucas");
        Jugador Juan = new Jugador("Juan");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Lucas, new Exclusividad()));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Juan));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        Assertions.assertEquals(Lucas.getPuntos().getCantidad(),0);
        Assertions.assertEquals(Juan.getPuntos().getCantidad(),0);
    }

    @Test
    public void CreoPreguntaVerdaderoFalsoYDosJugadoresRespondenMalConUnaExclusividad(){

        Jugador Lucas = new Jugador("Lucas");
        Jugador Juan = new Jugador("Juan");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Lucas, new Exclusividad()));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Juan));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        Assertions.assertEquals(Lucas.getPuntos().getCantidad(),0);
        Assertions.assertEquals(Juan.getPuntos().getCantidad(),0);
    }

    @Test
    public void CreoPreguntaVerdaderoFalsoYRespondeBienJugadorSinExclusividad(){

        Jugador Lucas = new Jugador("Lucas");
        Jugador Juan = new Jugador("Juan");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Lucas, new Exclusividad()));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Juan));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        Assertions.assertEquals(Lucas.getPuntos().getCantidad(),0);
        Assertions.assertEquals(Juan.getPuntos().getCantidad(),2);
    }

    @Test
    public void CreoPreguntaVerdaderoFalsoYRespondeBienUnJugadorConDosExclusividades(){

        Jugador Lucas = new Jugador("Lucas");
        Jugador Juan = new Jugador("Juan");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Lucas, new Exclusividad()));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Juan, new Exclusividad()));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        Assertions.assertEquals(Lucas.getPuntos().getCantidad(),0);
        Assertions.assertEquals(Juan.getPuntos().getCantidad(),4);
    }

    @Test
    public void CreoPreguntaVerdaderoFalsoYRespondeBienUnSoloJugadorConUnaExclusividad(){

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

        Assertions.assertEquals(Lucas.getPuntos().getCantidad(),0);
        Assertions.assertEquals(Juan.getPuntos().getCantidad(),0);
        Assertions.assertEquals(Pedro.getPuntos().getCantidad(),2);
        Assertions.assertEquals(Ramiro.getPuntos().getCantidad(),0);
    }

    @Test
    public void CreoPreguntaVerdaderoFalsoYRespondenBienTresJugadoresConDosExclusividades(){

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

        Assertions.assertEquals(Lucas.getPuntos().getCantidad(),0);
        Assertions.assertEquals(Juan.getPuntos().getCantidad(),0);
        Assertions.assertEquals(Pedro.getPuntos().getCantidad(),0);
        Assertions.assertEquals(Ramiro.getPuntos().getCantidad(),0);
    }
}