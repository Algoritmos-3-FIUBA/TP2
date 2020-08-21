package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.excepciones.MasDeCincoOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaOrderedChoice;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPreguntaOrderedChoice {

    @Test
    public void testCreoPreguntaOrderedChoiceYJugadorOrdenaIncorrectamente01(){

        Jugador Juan = new Jugador("Juan");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("7");
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("4");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("23");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1");

        opciones.agregarOpcion(cuartaOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(terceraOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordene los numeros de menor a mayor", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Juan);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),0);
    }

    @Test
    public void testCreoPreguntaOrderedChoiceYJugadorOrdenaCorrectamente02(){

        Jugador Juan = new Jugador("Juan");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("7");
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("4");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("23");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1");

        opciones.agregarOpcion(cuartaOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(terceraOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordene los numeros de menor a mayor", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(cuartaOpcion);
        opcionesSeleccionadas.add(segundaOpcion);
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(terceraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Juan);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),1);
    }

    @Test
    public void testCreoPreguntaOrderedChoiceYJugadorOrdenaCorrectamentePeroSinInsertarTodasLasOpciones03(){

        Jugador Juan = new Jugador("Juan");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("7");
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("4");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("23");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1");

        opciones.agregarOpcion(cuartaOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(terceraOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordene los numeros de menor a mayor", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(cuartaOpcion);
        opcionesSeleccionadas.add(segundaOpcion);
        opcionesSeleccionadas.add(primeraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Juan);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),0);
    }

    @Test
    public void testCreoPreguntaOrderedChoiceYJugadorOrdenaCorrectamenteConExclusividad04(){

        Jugador Juan = new Jugador("Juan");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("7");
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("4");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("23");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1");

        opciones.agregarOpcion(cuartaOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(terceraOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordene los numeros de menor a mayor", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(cuartaOpcion);
        opcionesSeleccionadas.add(segundaOpcion);
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(terceraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Juan, new Exclusividad());

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),2);
    }

    @Test
    public void testCreoPreguntaOrderedChoiceYDosJugadorOrdenanCorrectamenteConUnaExclusividad05(){

        Jugador Juan = new Jugador("Juan");
        Jugador Mati = new Jugador("Mati");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("7");
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("4");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("23");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1");

        opciones.agregarOpcion(cuartaOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(terceraOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordene los numeros de menor a mayor", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJuan = new LinkedList<>();
        opcionesSeleccionadasJuan.add(cuartaOpcion);
        opcionesSeleccionadasJuan.add(segundaOpcion);
        opcionesSeleccionadasJuan.add(primeraOpcion);
        opcionesSeleccionadasJuan.add(terceraOpcion);

        LinkedList<Opcion> opcionesSeleccionadasMati = new LinkedList<>();
        opcionesSeleccionadasMati.add(cuartaOpcion);
        opcionesSeleccionadasMati.add(segundaOpcion);
        opcionesSeleccionadasMati.add(primeraOpcion);
        opcionesSeleccionadasMati.add(terceraOpcion);

        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan, new Exclusividad());
        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati);

        respuestas.add(respuestaJuan);
        respuestas.add(respuestaMati);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),0);
        assertEquals(Mati.getPuntos().getCantidad(),0);
    }

    @Test
    public void testCreoPreguntaOrderedChoiceYDosJugadorOrdenanCorrectamenteConDosExclusividades06(){

        Jugador Juan = new Jugador("Juan");
        Jugador Mati = new Jugador("Mati");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("7");
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("4");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("23");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1");

        opciones.agregarOpcion(cuartaOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(terceraOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordene los numeros de menor a mayor", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJuan = new LinkedList<>();
        opcionesSeleccionadasJuan.add(cuartaOpcion);
        opcionesSeleccionadasJuan.add(segundaOpcion);
        opcionesSeleccionadasJuan.add(primeraOpcion);
        opcionesSeleccionadasJuan.add(terceraOpcion);

        LinkedList<Opcion> opcionesSeleccionadasMati = new LinkedList<>();
        opcionesSeleccionadasMati.add(cuartaOpcion);
        opcionesSeleccionadasMati.add(segundaOpcion);
        opcionesSeleccionadasMati.add(primeraOpcion);
        opcionesSeleccionadasMati.add(terceraOpcion);

        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan, new Exclusividad());
        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati, new Exclusividad());

        respuestas.add(respuestaJuan);
        respuestas.add(respuestaMati);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),0);
        assertEquals(Mati.getPuntos().getCantidad(),0);
    }

    @Test
    public void testCreoPreguntaOrderedChoiceYUnJugadorOrdenanCorrectamenteConDosExclusividades07(){

        Jugador Juan = new Jugador("Juan");
        Jugador Mati = new Jugador("Mati");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("7");
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("4");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("23");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1");

        opciones.agregarOpcion(cuartaOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(terceraOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordene los numeros de menor a mayor", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJuan = new LinkedList<>();
        opcionesSeleccionadasJuan.add(cuartaOpcion);
        opcionesSeleccionadasJuan.add(terceraOpcion);

        LinkedList<Opcion> opcionesSeleccionadasMati = new LinkedList<>();
        opcionesSeleccionadasMati.add(cuartaOpcion);
        opcionesSeleccionadasMati.add(segundaOpcion);
        opcionesSeleccionadasMati.add(primeraOpcion);
        opcionesSeleccionadasMati.add(terceraOpcion);

        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan, new Exclusividad());
        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati, new Exclusividad());

        respuestas.add(respuestaJuan);
        respuestas.add(respuestaMati);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),0);
        assertEquals(Mati.getPuntos().getCantidad(),4);
    }

    @Test
    public void testCreoPreguntaOrderedChoiceYDosJugadoresOrdenanIncorrectamenteConDosExclusividades08() {

        Jugador Juan = new Jugador("Juan");
        Jugador Mati = new Jugador("Mati");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("7");
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("4");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("23");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1");

        opciones.agregarOpcion(cuartaOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(terceraOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordene los numeros de menor a mayor", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJuan = new LinkedList<>();
        opcionesSeleccionadasJuan.add(cuartaOpcion);
        opcionesSeleccionadasJuan.add(terceraOpcion);
        opcionesSeleccionadasJuan.add(primeraOpcion);

        LinkedList<Opcion> opcionesSeleccionadasMati = new LinkedList<>();
        opcionesSeleccionadasMati.add(cuartaOpcion);
        opcionesSeleccionadasMati.add(primeraOpcion);
        opcionesSeleccionadasMati.add(terceraOpcion);
        opcionesSeleccionadasMati.add(segundaOpcion);

        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan, new Exclusividad());
        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati, new Exclusividad());

        respuestas.add(respuestaJuan);
        respuestas.add(respuestaMati);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(), 0);
        assertEquals(Mati.getPuntos().getCantidad(), 0);
    }

    @Test
    public void testCreoPreguntaOrderedChoiceYDosJugadoresOrdenanCorrectamente09() {

        Jugador Juan = new Jugador("Juan");
        Jugador Mati = new Jugador("Mati");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("7");
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("4");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("23");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1");

        opciones.agregarOpcion(cuartaOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(terceraOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordene los numeros de menor a mayor", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadasJuan = new LinkedList<>();
        opcionesSeleccionadasJuan.add(cuartaOpcion);
        opcionesSeleccionadasJuan.add(segundaOpcion);
        opcionesSeleccionadasJuan.add(primeraOpcion);
        opcionesSeleccionadasJuan.add(terceraOpcion);

        LinkedList<Opcion> opcionesSeleccionadasMati = new LinkedList<>();
        opcionesSeleccionadasMati.add(cuartaOpcion);
        opcionesSeleccionadasMati.add(segundaOpcion);
        opcionesSeleccionadasMati.add(primeraOpcion);
        opcionesSeleccionadasMati.add(terceraOpcion);

        RespuestaMultiple respuestaJuan = new RespuestaMultiple(opcionesSeleccionadasJuan, Juan);
        RespuestaMultiple respuestaMati = new RespuestaMultiple(opcionesSeleccionadasMati, Mati);

        respuestas.add(respuestaJuan);
        respuestas.add(respuestaMati);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(), 1);
        assertEquals(Mati.getPuntos().getCantidad(), 1);
    }

    @Test
    public void testCreoPreguntaOrderedChoiceConOpcionesCorrectasEIncorrectasYJugadorOrdenaCorrectamente10(){

        Jugador Juan = new Jugador("Juan");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("7");
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("4");
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("A");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1");

        opciones.agregarOpcion(cuartaOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(terceraOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordene los numeros de menor a mayor", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(cuartaOpcion);
        opcionesSeleccionadas.add(segundaOpcion);
        opcionesSeleccionadas.add(primeraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Juan);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),1);
    }

    @Test
    public void testCreoPreguntaOrderedChoiceConOpcionesCorrectasEIncorrectasYJugadorOrdenaCorrectamentePeroSeleccionaLaIncorrectaYNoTienePuntaje11(){

        Jugador Juan = new Jugador("Juan");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("7");
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("4");
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("A");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1");

        opciones.agregarOpcion(cuartaOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(terceraOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordene los numeros de menor a mayor", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(cuartaOpcion);
        opcionesSeleccionadas.add(segundaOpcion);
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(terceraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Juan);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),0);
    }

    @Test
    public void testCreoPreguntaOrderedChoiceConOpcionesCorrectasEIncorrectasYJugadorNoOrdenaCorrectamenteYSeleccionaLaIncorrectaYNoTienePuntaje12(){

        Jugador Juan = new Jugador("Juan");

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("7");
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("4");
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("A");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("1");

        opciones.agregarOpcion(cuartaOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(terceraOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordene los numeros de menor a mayor", 1, opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(segundaOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(primeraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, Juan);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Juan.getPuntos().getCantidad(),0);
    }

    @Test
    public void testCreoPreguntaOrderedChoiceConOchoOpcionesYDevuelveExcepcion13() {

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(new OpcionCorrecta("Llegada de Colon a America"));
        opciones.agregarOpcion(new OpcionCorrecta("Revolución francesa"));
        opciones.agregarOpcion(new OpcionCorrecta("Napoleon llega al poder"));
        opciones.agregarOpcion(new OpcionCorrecta("Independencia argentina"));
        opciones.agregarOpcion(new OpcionCorrecta("Primera guerra mundial"));
        opciones.agregarOpcion(new OpcionIncorrecta("Visita extraterrestre"));
        opciones.agregarOpcion(new OpcionIncorrecta("Llegada a Marte"));

        assertThrows(MasDeCincoOpcionesException.class,
                ()->{
                    new PreguntaOrderedChoice("Ordenar los siguientes eventos de más antiguo a mas nuevo",6, opciones);
                });
    }

    @Test
    public void testCreoPreguntaOrderedChoiceConNingunaOpcionYDevuelveExcepcion14() {

        assertThrows(NoHayOpcionesException.class,
                ()->{
                    new PreguntaOrderedChoice("Ordenar los siguientes eventos de más antiguo a mas nuevo", 5,  new ColeccionOpciones());
                });
    }

    //Agrego este test (aunque sea un getter) para aumentar cobertura
    @Test
    public void testCreoPreguntaOrderedChoiceYTieneNombreEsperado15(){

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("A");
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("C");
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("G");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("Z");

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordene las letras de primera a última segun el abecedario", 1, opciones);

        assertEquals(pregunta.getNombre(),"Ordene las letras de primera a última segun el abecedario");
    }

    //Agrego este test (aunque sea un getter) para aumentar cobertura
    @Test
    public void testCreoPreguntaOrderedChoiceLePidoLasOpcionesYSonDevueltas16(){

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("A");
        OpcionCorrecta segundaOpcion = new OpcionCorrecta("C");
        OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("G");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("Z");

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordene las letras de primera a última segun el abecedario", 1, opciones);

        ColeccionOpciones opcionesEsperadas = new ColeccionOpciones();

        opcionesEsperadas.agregarOpcion(primeraOpcion);
        opcionesEsperadas.agregarOpcion(segundaOpcion);
        opcionesEsperadas.agregarOpcion(terceraOpcion);
        opcionesEsperadas.agregarOpcion(cuartaOpcion);

        assert(pregunta.getColeccionDeOpciones().tieneMismosElementos(opcionesEsperadas));
    }
}