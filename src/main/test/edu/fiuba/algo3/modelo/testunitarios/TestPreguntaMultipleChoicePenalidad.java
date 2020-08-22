package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.excepciones.MasDeCincoOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorTres;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorDos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoicePenalidad;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPreguntaMultipleChoicePenalidad {

    private final OpcionCorrecta primeraOpcion = new OpcionCorrecta("2014",1);
    private final OpcionCorrecta segundaOpcion = new OpcionCorrecta("2010",1);
    private final OpcionIncorrecta terceraOpcion = new OpcionIncorrecta("1902",-1);
    private final OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("El año pasado",-1);

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadSinMultiplicadorYRespondoUnaOpcionesCorrecta01(){

        Jugador jugador = new Jugador("Pedro");

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadSinMultiplicadorYRespondoDosOpcionesCorrectas02(){

        Jugador jugador = new Jugador("Pedro");

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),2);
    }

    @Test
    public void testCreoPreguntaMultipleChoiceYLasOpcionesCargadasSonLasEsperadas() {

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionIncorrecta primeraOpcion = new OpcionIncorrecta("1 + 1");
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("3 - 1");
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2");
        OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2");

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿Cuales de las siguientes cuentas tiene resultado 4?", opciones);

        ColeccionOpciones coleccionDeOpciones = pregunta.getColeccionDeOpciones();

        assertEquals(coleccionDeOpciones, opciones);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadSinMultiplicadorYRespondoDosOpcionesCorrectasYUnaIncorrecta03(){

        Jugador jugador = new Jugador("Pedro");

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);
        opcionesSeleccionadas.add(terceraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),1);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadSinMultiplicadorYRespondoDosOpcionesIncorrectas04(){

        Jugador jugador = new Jugador("Pedro");

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),-2);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadConMultiplicadorPorDosYRespondoDosOpcionesCorrectas05(){

        Jugador jugador = new Jugador("Pedro");

        Multiplicador multiplicador = new MultiplicadorPorDos();

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador, multiplicador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),4);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadConMultiplicadorPorDosYRespondoDosOpcionesCorrectasYUnaIncorrecta06(){

        Jugador jugador = new Jugador("Pedro");

        Multiplicador multiplicador = new MultiplicadorPorDos();

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(segundaOpcion);
        opcionesSeleccionadas.add(terceraOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador, multiplicador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),2);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadConMultiplicadorPorDosYRespondoDosOpcionesIncorrectas07(){

        Jugador jugador = new Jugador("Pedro");

        Multiplicador multiplicador = new MultiplicadorPorDos();

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador, multiplicador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),-4);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadConMultiplicadorPorTresYRespondoDosOpcionesIncorrectas08(){

        Jugador jugador = new Jugador("Pedro");

        Multiplicador multiplicador = new MultiplicadorPorTres();

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador, multiplicador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),-6);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadConMultiplicadorPorTresYRespondoDosOpcionesIncorrectasYUnaCorrecta09(){

        Jugador jugador = new Jugador("Pedro");

        Multiplicador multiplicador = new MultiplicadorPorTres();

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(cuartaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que años se jugó mundial de futbol?", opciones);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
        opcionesSeleccionadas.add(primeraOpcion);
        opcionesSeleccionadas.add(terceraOpcion);
        opcionesSeleccionadas.add(cuartaOpcion);

        RespuestaMultiple respuesta = new RespuestaMultiple(opcionesSeleccionadas, jugador, multiplicador);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador.getPuntos().getCantidad(),-3);
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadConSieteOpcionesYDevuelveExcepcion10() {

        ColeccionOpciones opciones = new ColeccionOpciones();

        opciones.agregarOpcion(new OpcionCorrecta("España",5));
        opciones.agregarOpcion(new OpcionIncorrecta("Brasil",-2));
        opciones.agregarOpcion(new OpcionIncorrecta("Angola",-1));
        opciones.agregarOpcion(new OpcionCorrecta("Reino Unido",4));
        opciones.agregarOpcion(new OpcionCorrecta("Croacia",4));
        opciones.agregarOpcion(new OpcionIncorrecta("China",-7));
        opciones.agregarOpcion(new OpcionCorrecta("Grecia",1));

        assertThrows(MasDeCincoOpcionesException.class,
                ()->{
                    new PreguntaMultipleChoicePenalidad("¿Cuales de los siguientes paises son europeos?", opciones);
                });
    }

    @Test
    public void testCreoPreguntaMultipleChoicePenalidadConNingunaOpcionYDevuelveExcepcion11() {

        assertThrows(NoHayOpcionesException.class,
                ()->{
                    new PreguntaMultipleChoicePenalidad("¿Como se llama la calle donde se ubica la facultad de ingenieria?",  new ColeccionOpciones());
                });
    }

    //Agrego este test (aunque sea un getter) para aumentar cobertura
    @Test
    public void testCreoPreguntaMultipleChoicePenalidadYTieneNombreCorrecto12(){

        ColeccionOpciones opciones = new ColeccionOpciones();

        OpcionCorrecta primeraOpcion = new OpcionCorrecta("1969",5);
        OpcionIncorrecta segundaOpcion = new OpcionIncorrecta("1974",-5);

        opciones.agregarOpcion(primeraOpcion);
        opciones.agregarOpcion(segundaOpcion);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad("¿En que año llego el hombre a la luna?",opciones);

        assertEquals(pregunta.getNombre(),"¿En que año llego el hombre a la luna?");
    }
}