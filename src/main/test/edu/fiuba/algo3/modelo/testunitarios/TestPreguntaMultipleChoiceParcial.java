package edu.fiuba.algo3.modelo.testunitarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.excepciones.MasDeCincoOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoiceParcial;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

public class TestPreguntaMultipleChoiceParcial {

   @Test
    public void testCreoPreguntaMultipleChoiceParcialYTieneRespuestasCorrectas01(){

        Jugador Juan = new Jugador("Juan");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("1969",5);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("1974",0);

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿En que año llego el hombre a la luna?",opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Juan);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),5);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceParcialYTieneRespuestasIncorrectas02(){

        Jugador Juan = new Jugador("Juan");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("1969",5);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("1974",0);

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿En que año llego el hombre a la luna?",opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(segundaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Juan);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),0);
    }

    @Test
    public void testPreguntaEvaluaUnaRespuestaParcialmenteCorrectaYOtorgaLosPuntosEsperados03(){

        Jugador Juan = new Jugador("Juan");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("Paris",1);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("Francia",1);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("Europa",1);
        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("Argentina",0);

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿Donde se encuentra la torre Eiffel?",opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Juan);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),2);
    }

    @Test
    public void testPreguntaEvaluaUnaRespuestaQueTieneOpcionesCorrectasYUnaIncorrectaYNoOtorgaPuntos04(){

        Jugador Juan = new Jugador("Juan");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("C",1);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("Java",0);
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("Smalltalk",0);

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿Cuales de los siguientes lenguajes no son orientados a objetos?",opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(terceraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Juan);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),0);
    }

    @Test
    public void testPreguntaEvaluaUnaRespuestaQueTieneTodasOpcionesCorrectasYDevuelveLosPuntosEsperados05(){

        Jugador Juan = new Jugador("Juan");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("Encapsulamiento",1);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("Polimorfismo",1);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("Ocultamiento de la informacio",1);
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("Herencia",1);

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿Cuales de los siguientes conceptos son importantes en POO?",opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Juan);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),4);
    }

    @Test
    public void testPreguntaEvaluaLasRespuestasDeVariosJugadoresYOtorgaLosPuntosAdecuados06(){

        Jugador Juan = new Jugador("Juan");
        Jugador Mati = new Jugador("Mati");
        Jugador Lucas = new Jugador("Lucas");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("Sarmiento",5);
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("Belgrano",5);
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("Saavedra",0);
        OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("Liniers",0);

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿Quien de los siguientes proceres aparece en un billete?",opciones);

        LinkedList <Respuesta> respuestas = new LinkedList <Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJuan = new LinkedList<>();
        opcionesSeleccionadasJuan.add(primeraOpcion);
        opcionesSeleccionadasJuan.add(segundaOpcion);
        opcionesSeleccionadasJuan.add(terceraOpcion);

        LinkedList<Opcion> opcionesSeleccionadasMati = new LinkedList<>();
        opcionesSeleccionadasMati.add(primeraOpcion);

        LinkedList<Opcion> opcionesSeleccionadasLucas = new LinkedList<>();
        opcionesSeleccionadasLucas.add(primeraOpcion);
        opcionesSeleccionadasLucas.add(segundaOpcion);

        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan);
        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati);
        RespuestaMultiple respuestaLucas = new RespuestaMultiple(opcionesSeleccionadasLucas, Lucas);

        respuestas.add(respuestaJuan);
        respuestas.add(respuestaMati);
        respuestas.add(respuestaLucas);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),0);
        assertEquals(Mati.getPuntos().getCantidad(),5);
        assertEquals(Lucas.getPuntos().getCantidad(),10);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceParcialYRespondeSoloUnJugadorCorrectamenteConExclusividad07() {

        Jugador Juan = new Jugador("Juan");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1874", 0);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("2020", 0);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("1912", 1);
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1989", 1);

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿Cual de los siguientes años pertenece al siglo XX?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJuan = new LinkedList<Opcion>();
        opcionesSeleccionadasJuan.add(terceraOpcion);
        opcionesSeleccionadasJuan.add(cuartaOpcion);

        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan, new Exclusividad());

        respuestas.add(respuestaJuan);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(), 4);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceParcialYRespondenDosJugadoresCorrectamenteConUnaExclusividad08() {

        Jugador Juan = new Jugador("Juan");
        Jugador Mati = new Jugador("Mati");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1874", 0);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("2020", 0);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("1912", 1);
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1989", 1);

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿Cual de los siguientes años pertenece al siglo XX?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJuan = new LinkedList<Opcion>();
        opcionesSeleccionadasJuan.add(terceraOpcion);
        opcionesSeleccionadasJuan.add(cuartaOpcion);

        LinkedList<Opcion> opcionesSeleccionadasMati = new LinkedList<Opcion>();
        opcionesSeleccionadasJuan.add(cuartaOpcion);

        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan, new Exclusividad());
        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati);

        respuestas.add(respuestaJuan);
        respuestas.add(respuestaMati);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(), 0);
        assertEquals(Mati.getPuntos().getCantidad(), 0);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceParcialYRespondenCorrectamenteElJugadorQueNoSeleccionoExclusividad09() {

        Jugador Juan = new Jugador("Juan");
        Jugador Mati = new Jugador("Mati");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1874", 0);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("2020", 0);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("1912", 1);
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1989", 1);

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿Cual de los siguientes años pertenece al siglo XX?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJuan = new LinkedList<Opcion>();
        opcionesSeleccionadasJuan.add(primeraOpcion);

        LinkedList<Opcion> opcionesSeleccionadasMati = new LinkedList<Opcion>();
        opcionesSeleccionadasMati.add(cuartaOpcion);

        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan, new Exclusividad());
        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati);

        respuestas.add(respuestaJuan);
        respuestas.add(respuestaMati);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(), 0);
        assertEquals(Mati.getPuntos().getCantidad(), 2);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceParcialYRespondenDosJugadoresBienConDosExclusividades10() {

        Jugador Juan = new Jugador("Juan");
        Jugador Mati = new Jugador("Mati");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1874", 0);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("2020", 0);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("1912", 1);
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1989", 1);

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿Cual de los siguientes años pertenece al siglo XX?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJuan = new LinkedList<Opcion>();
        opcionesSeleccionadasJuan.add(terceraOpcion);

        LinkedList<Opcion> opcionesSeleccionadasMati = new LinkedList<Opcion>();
        opcionesSeleccionadasMati.add(cuartaOpcion);

        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan, new Exclusividad());
        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati, new Exclusividad());

        respuestas.add(respuestaJuan);
        respuestas.add(respuestaMati);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(), 0);
        assertEquals(Mati.getPuntos().getCantidad(), 0);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceParcialYRespondenDosJugadoresMalConDosExclusividades12() {

        Jugador Juan = new Jugador("Juan");
        Jugador Mati = new Jugador("Mati");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1874", 0);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("2020", 0);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("1912", 1);
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1989", 1);

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿Cual de los siguientes años pertenece al siglo XX?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJuan = new LinkedList<Opcion>();
        opcionesSeleccionadasJuan.add(primeraOpcion);
        opcionesSeleccionadasJuan.add(segundaOpcion);

        LinkedList<Opcion> opcionesSeleccionadasMati = new LinkedList<Opcion>();
        opcionesSeleccionadasMati.add(primeraOpcion);

        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan, new Exclusividad());
        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati, new Exclusividad());

        respuestas.add(respuestaJuan);
        respuestas.add(respuestaMati);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(), 0);
        assertEquals(Mati.getPuntos().getCantidad(), 0);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceParcialYUnJugadorRespondeBienConDosExclusividades13() {

        Jugador Juan = new Jugador("Juan");
        Jugador Mati = new Jugador("Mati");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1874", 0);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("2020", 0);
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("1912", 1);
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1989", 1);

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("¿Cual de los siguientes años pertenece al siglo XX?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJuan = new LinkedList<Opcion>();
        opcionesSeleccionadasJuan.add(primeraOpcion);
        opcionesSeleccionadasJuan.add(segundaOpcion);

        LinkedList<Opcion> opcionesSeleccionadasMati = new LinkedList<Opcion>();
        opcionesSeleccionadasMati.add(terceraOpcion);
        opcionesSeleccionadasMati.add(cuartaOpcion);

        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan, new Exclusividad());
        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati, new Exclusividad());

        respuestas.add(respuestaJuan);
        respuestas.add(respuestaMati);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(), 0);
        assertEquals(Mati.getPuntos().getCantidad(), 8);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceParcialConSieteOpcionesYDevuelveExcepcion14() {

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(new OpcionCorrecta("España",5));
        opciones.agregarOpcion(new OpcionIncorrecta("Brasil",0));
        opciones.agregarOpcion(new OpcionIncorrecta("Angola",0));
        opciones.agregarOpcion(new OpcionCorrecta("Reino Unido",4));
        opciones.agregarOpcion(new OpcionCorrecta("Croacia",4));
        opciones.agregarOpcion(new OpcionIncorrecta("China",0));
        opciones.agregarOpcion(new OpcionCorrecta("Grecia",1));

        assertThrows(MasDeCincoOpcionesException.class,
                ()->{
                    new PreguntaMultipleChoiceParcial("¿Cuales de los siguientes paises son europeos?", opciones);
                });
    }

    @Test
    public void testCreoPreguntaMultipleChoiceParcialConNingunaOpcionYDevuelveExcepcion15() {

        assertThrows(NoHayOpcionesException.class,
                ()->{
                    new PreguntaMultipleChoiceParcial("¿Como se llama la calle donde se ubica la facultad de ingenieria?",  new ColeccionOpciones());
                });
    }
}