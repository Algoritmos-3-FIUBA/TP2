package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
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
    public void testCreoPreguntaVerdaderoFalsoYLaPrimerOpcionEsLaVerdadera(){

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        ColeccionOpciones coleccionDeOpciones = pregunta.getColeccionDeOpciones();

        assertEquals(coleccionDeOpciones.getOpciones().getFirst(), pregunta.getOpcionVerdadera());
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoYLaPrimeraOpcionEsLaFalsa(){

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 es 3?");
        pregunta.setFalsoOpcionCorrecta();

        ColeccionOpciones coleccionDeOpciones = pregunta.getColeccionDeOpciones();

        assertEquals(coleccionDeOpciones.getOpciones().getLast(), pregunta.getOpcionFalsa());
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
    public void testCreoPreguntaVerdaderoFalsoYVariosJugadoresRespondeEntoncesAsignaPuntos08(){
        Jugador Lucas = new Jugador("Lucas");
        Jugador Juan = new Jugador("Juan");
        Jugador Mati = new Jugador("Mati");
        Jugador Pablo = new Jugador("Pablo");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("Todas las semanas tienen siete dias");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Lucas));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Mati));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Pablo));
        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionFalsa(),Juan));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        assertEquals(Lucas.getPuntos().getCantidad(),1);
        assertEquals(Juan.getPuntos().getCantidad(),0);
        assertEquals(Mati.getPuntos().getCantidad(),0);
        assertEquals(Pablo.getPuntos().getCantidad(),1);
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoYJugadorRespondeBienConExclusividad09(){
        Jugador Lucas = new Jugador("Lucas");

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿1+1 no es 3?");
        pregunta.setVerdaderoOpcionCorrecta();

        LinkedList<Respuesta> respuestasDeJugadores = new LinkedList<Respuesta>();

        respuestasDeJugadores.add(new RespuestaUnica(pregunta.getOpcionVerdadera(),Lucas, new Exclusividad()));

        pregunta.evaluarRespuestas(respuestasDeJugadores);

        assertEquals(Lucas.getPuntos().getCantidad(),2);
    }

    @Test
    public void testCreoPreguntaVerdaderoFalsoYDosJugadoresRespondenBienConUnaExclusividad10(){
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
    public void testCreoPreguntaVerdaderoFalsoYDosJugadoresRespondenMalConUnaExclusividad11(){
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
    public void testCreoPreguntaVerdaderoFalsoYRespondeBienElJugadorQueNoRespondioConExclusividad12(){
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
    public void testCreoPreguntaVerdaderoFalsoYRespondeBienUnJugadorConDosExclusividades13(){
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
    public void testCreoPreguntaVerdaderoFalsoYRespondeBienUnSoloJugadorConUnaExclusividad14(){
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
    public void testCreoPreguntaVerdaderoFalsoYRespondenBienTresJugadoresConDosExclusividades15(){
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