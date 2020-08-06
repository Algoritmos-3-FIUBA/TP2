package edu.fiuba.algo3.modelo.testEntregas;

import edu.fiuba.algo3.modelo.Grupo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGrupos;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPreguntaGroupChoiceEntrega2 {
    OpcionCorrecta primeraOpcion = new OpcionCorrecta("1 + 1", 0);
    OpcionCorrecta segundaOpcion = new OpcionCorrecta("3 - 1", 0);
    OpcionCorrecta terceraOpcion = new OpcionCorrecta("2 + 2", 0);
    OpcionCorrecta cuartaOpcion = new OpcionCorrecta("2 * 2", 0);
    @Test
    public void CreoPreguntaGroupChoiceYJugadorRespondeCorrectamente() {
    //Pregunta sabe los grupos correctos
        Jugador Guido = new Jugador("Guido");

        LinkedList<Grupo> gruposCorrectos = new LinkedList<>();

        Grupo grupo1Correcto = new Grupo("Grupo1Correcto");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        Grupo grupo2Correcto = new Grupo("Grupo2Correcto");
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, gruposCorrectos);

        //Jugador selecciona coloca las opciones en los grupos
        LinkedList<RespuestaGrupos> respuestas = new LinkedList<>();

        LinkedList<Grupo> gruposElegidos = new LinkedList<>();

        Grupo grupo1Elegidos = new Grupo("Grupo1Elegido");
        grupo1Elegidos.agregarOpcion(primeraOpcion);
        grupo1Elegidos.agregarOpcion(segundaOpcion);

        Grupo grupo2Elegidos = new Grupo("Grupo2Elegido");
        grupo2Elegidos.agregarOpcion(terceraOpcion);
        grupo2Elegidos.agregarOpcion(cuartaOpcion);

        gruposElegidos.add(grupo1Elegidos);
        gruposElegidos.add(grupo2Elegidos);

        RespuestaGrupos respuesta = new RespuestaGrupos(gruposElegidos, Guido);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        //Por cada grupo correcto se otorga un punto. Dos grupos correctos son dos puntos. Un grupo correcto es un punto.
        assertEquals(Guido.getPuntos().getCantidad(), 2);
    }

    @Test
    public void CreoPreguntaGroupChoiceConDosJugadoresSoloUnoRespondeCorrectamente() {
        //Pregunta sabe los grupos correctos
        Jugador Guido = new Jugador("Guido");
        Jugador Lucas = new Jugador("Lucas");

        LinkedList<Grupo> gruposCorrectos = new LinkedList<>();

        Grupo grupo1Correcto = new Grupo("Grupo1Correcto");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        Grupo grupo2Correcto = new Grupo("Grupo2Correcto");
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, gruposCorrectos);

        //Jugador Guido selecciona coloca las opciones en los grupos
        LinkedList<RespuestaGrupos> respuestas = new LinkedList<>();

        LinkedList<Grupo> gruposElegidosGuido = new LinkedList<>();

        Grupo grupo1ElegidosGuido = new Grupo("Grupo1Elegido");
        grupo1ElegidosGuido.agregarOpcion(primeraOpcion);
        grupo1ElegidosGuido.agregarOpcion(segundaOpcion);

        Grupo grupo2ElegidosGuido = new Grupo("Grupo2Elegido");
        grupo2ElegidosGuido.agregarOpcion(terceraOpcion);
        grupo2ElegidosGuido.agregarOpcion(cuartaOpcion);

        gruposElegidosGuido.add(grupo1ElegidosGuido);
        gruposElegidosGuido.add(grupo2ElegidosGuido);

        RespuestaGrupos respuestaGuido = new RespuestaGrupos(gruposElegidosGuido, Guido);

        //Jugador Lucas selecciona coloca las opciones en los grupos
        LinkedList<Grupo> gruposElegidosLucas = new LinkedList<>();

        Grupo grupo1ElegidosLucas = new Grupo("Grupo1Elegido");
        grupo1ElegidosLucas.agregarOpcion(terceraOpcion);
        grupo1ElegidosLucas.agregarOpcion(segundaOpcion);

        Grupo grupo2ElegidosLucas = new Grupo("Grupo2Elegido");
        grupo2ElegidosLucas.agregarOpcion(primeraOpcion);
        grupo2ElegidosLucas.agregarOpcion(cuartaOpcion);

        gruposElegidosLucas.add(grupo1ElegidosLucas);
        gruposElegidosLucas.add(grupo2ElegidosLucas);

        RespuestaGrupos respuestaLucas = new RespuestaGrupos(gruposElegidosLucas, Lucas);


        respuestas.add(respuestaGuido);
        respuestas.add(respuestaLucas);

        pregunta.evaluarRespuestas(respuestas);
        //Por cada grupo correcto se otorga un punto. Dos grupos correctos son dos puntos. Un grupo correcto es un punto.
        assertEquals(Guido.getPuntos().getCantidad(), 2);
        assertEquals(Lucas.getPuntos().getCantidad(), 0);
    }
    @Test
    public void CreoPreguntaGroupChoiceConDosJugadoresUnoRespondeCorrectamenteYElOtroParcialmente() {
        //Pregunta sabe los grupos correctos
        Jugador Guido = new Jugador("Guido");
        Jugador Lucas = new Jugador("Lucas");

        LinkedList<Grupo> gruposCorrectos = new LinkedList<>();

        Grupo grupo1Correcto = new Grupo("Grupo1Correcto");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        Grupo grupo2Correcto = new Grupo("Grupo2Correcto");
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("¿Cuales de las siguientes cuentas tiene resultado 4?", 1, gruposCorrectos);

        //Jugador Guido selecciona coloca las opciones en los grupos
        LinkedList<RespuestaGrupos> respuestas = new LinkedList<>();

        LinkedList<Grupo> gruposElegidosGuido = new LinkedList<>();

        Grupo grupo1ElegidosGuido = new Grupo("Grupo1Elegido");
        grupo1ElegidosGuido.agregarOpcion(primeraOpcion);
        grupo1ElegidosGuido.agregarOpcion(segundaOpcion);

        Grupo grupo2ElegidosGuido = new Grupo("Grupo2Elegido");
        grupo2ElegidosGuido.agregarOpcion(terceraOpcion);
        grupo2ElegidosGuido.agregarOpcion(cuartaOpcion);

        gruposElegidosGuido.add(grupo1ElegidosGuido);
        gruposElegidosGuido.add(grupo2ElegidosGuido);

        RespuestaGrupos respuestaGuido = new RespuestaGrupos(gruposElegidosGuido, Guido);

        //Jugador Lucas selecciona coloca las opciones en los grupos
        LinkedList<Grupo> gruposElegidosLucas = new LinkedList<>();

        Grupo grupo1ElegidosLucas = new Grupo("Grupo1Elegido");
        grupo1ElegidosLucas.agregarOpcion(primeraOpcion);
        grupo1ElegidosLucas.agregarOpcion(segundaOpcion);

        Grupo grupo2ElegidosLucas = new Grupo("Grupo2Elegido");
        grupo2ElegidosLucas.agregarOpcion(cuartaOpcion);

        gruposElegidosLucas.add(grupo1ElegidosLucas);
        gruposElegidosLucas.add(grupo2ElegidosLucas);

        RespuestaGrupos respuestaLucas = new RespuestaGrupos(gruposElegidosLucas, Lucas);


        respuestas.add(respuestaGuido);
        respuestas.add(respuestaLucas);

        pregunta.evaluarRespuestas(respuestas);
        //Por cada grupo correcto se otorga un punto. Dos grupos correctos son dos puntos. Un grupo correcto es un punto.
        assertEquals(Guido.getPuntos().getCantidad(), 2);
        assertEquals(Lucas.getPuntos().getCantidad(), 1);
    }
}
