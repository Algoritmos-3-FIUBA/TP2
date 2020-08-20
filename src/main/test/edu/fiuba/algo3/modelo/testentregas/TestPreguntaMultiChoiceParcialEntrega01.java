package edu.fiuba.algo3.modelo.testentregas;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoiceParcial;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaMultiChoiceParcialEntrega01 {

    @Test
    public void testPreguntaMultipleChoiceParcialSeCreaIndicandoleCualesSonSusOpcionesCorrectas01(){

        Jugador Juan = new Jugador("Juan");
        Jugador Fer = new Jugador("Fer");
        Jugador Guido = new Jugador("Guido");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("Europa",5);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("Asia",5);
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("America",0);
        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("Marte",0);

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿En qué lugar ocurrió la segunda guerra mundial?",opciones);

        LinkedList<Opcion> opcionesJuan = new LinkedList<>();

        opcionesJuan.add(primeraOpcion);
        opcionesJuan.add(segundaOpcion);

        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesJuan,Juan);

        LinkedList<Opcion> opcionesFer = new LinkedList<>();

        opcionesFer.add(primeraOpcion);

        RespuestaMultiple respuestaFer = new RespuestaMultiple(opcionesFer,Fer);

        LinkedList<Opcion> opcionesGuido = new LinkedList<>();

        opcionesGuido.add(segundaOpcion);

        RespuestaMultiple respuestaGuido = new RespuestaMultiple(opcionesGuido,Guido);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        respuestas.add(respuestaJuan);
        respuestas.add(respuestaGuido);
        respuestas.add(respuestaFer);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),10);
        assertEquals(Guido.getPuntos().getCantidad(),5);
        assertEquals(Fer.getPuntos().getCantidad(),5);

    }


    @Test
    public void testPreguntaMultipleChoiceParcialRecibeListaDeRespuestasYAsignaPuntosCorrectamenteALosJugadores02(){


        Jugador Mati = new Jugador("Mati");
        Jugador Lucas = new Jugador("Lucas");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("Enero",1);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("Octubre",1);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("Mayo",1);

        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("Febrero",0);
        OpcionIncorrecta quintaOpcion = new OpcionIncorrecta("Noviembre",0);

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);
        opciones.agregarOpcion(quintaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿Cuales de los siguientes meses tienen 31 dias?",opciones);

        LinkedList<Respuesta> respuestas = new LinkedList <Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasMati = new LinkedList<Opcion>();
        opcionesSeleccionadasMati.add(primeraOpcion);
        opcionesSeleccionadasMati.add(segundaOpcion);
        opcionesSeleccionadasMati.add(terceraOpcion);
        opcionesSeleccionadasMati.add(cuartaOpcion);

        LinkedList<Opcion> opcionesSeleccionadasLucas = new LinkedList<Opcion>();
        opcionesSeleccionadasLucas.add(primeraOpcion);
        opcionesSeleccionadasLucas.add(segundaOpcion);

        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati);
        RespuestaMultiple respuestaLucas = new RespuestaMultiple(opcionesSeleccionadasLucas, Lucas);

        respuestas.add(respuestaMati);
        respuestas.add(respuestaLucas);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Mati.getPuntos().getCantidad(),0);
        assertEquals(Lucas.getPuntos().getCantidad(),2);

    }
}
