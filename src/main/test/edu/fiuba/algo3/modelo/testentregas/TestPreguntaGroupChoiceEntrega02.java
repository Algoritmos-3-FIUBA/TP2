package edu.fiuba.algo3.modelo.testentregas;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGrupos;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaGroupChoiceEntrega02 {
    private final OpcionCorrecta primeraOpcion = new OpcionCorrecta("1 + 1");
    private final OpcionCorrecta segundaOpcion = new OpcionCorrecta("3 - 1");
    private final OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2");
    private final OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2");

    @Test
    public void testCreoPreguntaGroupChoiceYJugadorRespondeCorrectamente01() {

        Jugador Guido = new Jugador("Guido");

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones();
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones();
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, gruposCorrectos);

        //Jugador selecciona coloca las opciones en los grupos
        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<ColeccionOpciones> gruposElegidos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Elegidos = new ColeccionOpciones();
        grupo1Elegidos.agregarOpcion(primeraOpcion);
        grupo1Elegidos.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Elegidos = new ColeccionOpciones();
        grupo2Elegidos.agregarOpcion(terceraOpcion);
        grupo2Elegidos.agregarOpcion(cuartaOpcion);

        gruposElegidos.add(grupo1Elegidos);
        gruposElegidos.add(grupo2Elegidos);

        RespuestaGrupos respuesta = new RespuestaGrupos(gruposElegidos, Guido);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 2);
    }

    @Test
    public void testCreoPreguntaGroupChoiceConDosJugadoresSoloUnoRespondeCorrectamente02() {

        Jugador Guido = new Jugador("Guido");
        Jugador Lucas = new Jugador("Lucas");

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones();
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones();
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, gruposCorrectos);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<ColeccionOpciones> gruposElegidosGuido = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1ElegidosGuido = new ColeccionOpciones();
        grupo1ElegidosGuido.agregarOpcion(primeraOpcion);
        grupo1ElegidosGuido.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2ElegidosGuido = new ColeccionOpciones();
        grupo2ElegidosGuido.agregarOpcion(terceraOpcion);
        grupo2ElegidosGuido.agregarOpcion(cuartaOpcion);

        gruposElegidosGuido.add(grupo1ElegidosGuido);
        gruposElegidosGuido.add(grupo2ElegidosGuido);

        RespuestaGrupos respuestaGuido = new RespuestaGrupos(gruposElegidosGuido, Guido);

        LinkedList<ColeccionOpciones> gruposElegidosLucas = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1ElegidosLucas = new ColeccionOpciones();
        grupo1ElegidosLucas.agregarOpcion(terceraOpcion);
        grupo1ElegidosLucas.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2ElegidosLucas = new ColeccionOpciones();
        grupo2ElegidosLucas.agregarOpcion(primeraOpcion);
        grupo2ElegidosLucas.agregarOpcion(cuartaOpcion);

        gruposElegidosLucas.add(grupo1ElegidosLucas);
        gruposElegidosLucas.add(grupo2ElegidosLucas);

        RespuestaGrupos respuestaLucas = new RespuestaGrupos(gruposElegidosLucas, Lucas);

        respuestas.add(respuestaGuido);
        respuestas.add(respuestaLucas);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 2);
        assertEquals(Lucas.getPuntos().getCantidad(), 0);
    }
    @Test
    public void testCreoPreguntaGroupChoiceConDosJugadoresUnoRespondeCorrectamenteYElOtroParcialmente03() {

        Jugador Guido = new Jugador("Guido");
        Jugador Lucas = new Jugador("Lucas");

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones();
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones();
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, gruposCorrectos);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<ColeccionOpciones> gruposElegidosGuido = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1ElegidosGuido = new ColeccionOpciones();
        grupo1ElegidosGuido.agregarOpcion(primeraOpcion);
        grupo1ElegidosGuido.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2ElegidosGuido = new ColeccionOpciones();
        grupo2ElegidosGuido.agregarOpcion(terceraOpcion);
        grupo2ElegidosGuido.agregarOpcion(cuartaOpcion);

        gruposElegidosGuido.add(grupo1ElegidosGuido);
        gruposElegidosGuido.add(grupo2ElegidosGuido);

        RespuestaGrupos respuestaGuido = new RespuestaGrupos(gruposElegidosGuido, Guido);

        LinkedList<ColeccionOpciones> gruposElegidosLucas = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1ElegidosLucas = new ColeccionOpciones();
        grupo1ElegidosLucas.agregarOpcion(primeraOpcion);
        grupo1ElegidosLucas.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2ElegidosLucas = new ColeccionOpciones();
        grupo2ElegidosLucas.agregarOpcion(cuartaOpcion);

        gruposElegidosLucas.add(grupo1ElegidosLucas);
        gruposElegidosLucas.add(grupo2ElegidosLucas);

        RespuestaGrupos respuestaLucas = new RespuestaGrupos(gruposElegidosLucas, Lucas);

        respuestas.add(respuestaGuido);
        respuestas.add(respuestaLucas);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 2);
        assertEquals(Lucas.getPuntos().getCantidad(), 1);
    }
}