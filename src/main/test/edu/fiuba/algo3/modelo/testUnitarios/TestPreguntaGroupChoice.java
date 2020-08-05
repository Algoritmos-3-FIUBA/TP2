package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Grupo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGrupos;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaGroupChoice {
    OpcionCorrecta primeraOpcion = new OpcionCorrecta("Newton", 0);
    OpcionCorrecta segundaOpcion = new OpcionCorrecta("Faraday", 0);
    OpcionCorrecta terceraOpcion = new OpcionCorrecta("Gauss", 0);
    OpcionCorrecta cuartaOpcion = new OpcionCorrecta("Euler", 0);
    @Test
    public void CreoPreguntaGroupChoiceYJugadorRespondeCorrectamenteVerificoQueLaAsignacionDePuntosSeaCorrecta() {

        Jugador Guido = new Jugador("Guido");

        LinkedList<Grupo> gruposCorrectos = new LinkedList<Grupo>();

        Grupo grupo1Correcto = new Grupo("Grupo1CorrectoFísicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        Grupo grupo2Correcto = new Grupo("Grupo2CorrectoMatemáticos");
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);


        LinkedList<RespuestaGrupos> respuestas = new LinkedList<RespuestaGrupos>();

        LinkedList<Grupo> gruposElegidos = new LinkedList<Grupo>();

        Grupo grupo1Elegidos = new Grupo("Grupo1ElegidoFísicos");
        grupo1Elegidos.agregarOpcion(primeraOpcion);
        grupo1Elegidos.agregarOpcion(segundaOpcion);

        Grupo grupo2Elegidos = new Grupo("Grupo2ElegidoMatemáticos");
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
    public void CreoPreguntaGroupChoiceYJugadorRespondeParcialmenteVerificoQueLaAsignacionDePuntosSeaCorrecta() {

        Jugador Guido = new Jugador("Guido");

        LinkedList<Grupo> gruposCorrectos = new LinkedList<Grupo>();

        Grupo grupo1Correcto = new Grupo("Grupo1CorrectoFísicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        Grupo grupo2Correcto = new Grupo("Grupo2CorrectoMatemáticos");
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);


        LinkedList<RespuestaGrupos> respuestas = new LinkedList<RespuestaGrupos>();

        LinkedList<Grupo> gruposElegidos = new LinkedList<Grupo>();

        Grupo grupo1Elegidos = new Grupo("Grupo1ElegidoFísicos");
        grupo1Elegidos.agregarOpcion(segundaOpcion);

        Grupo grupo2Elegidos = new Grupo("Grupo2ElegidoMatemáticos");
        grupo2Elegidos.agregarOpcion(terceraOpcion);
        grupo2Elegidos.agregarOpcion(cuartaOpcion);

        gruposElegidos.add(grupo1Elegidos);
        gruposElegidos.add(grupo2Elegidos);

        RespuestaGrupos respuesta = new RespuestaGrupos(gruposElegidos, Guido);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 1);
    }

    @Test
    public void CreoPreguntaGroupChoiceYJugadorRespondeIncorrectamenteVerificoQueLaAsignacionDePuntosSeaCorrecta() {

        Jugador Guido = new Jugador("Guido");

        LinkedList<Grupo> gruposCorrectos = new LinkedList<Grupo>();

        Grupo grupo1Correcto = new Grupo("Grupo1CorrectoFísicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        Grupo grupo2Correcto = new Grupo("Grupo2CorrectoMatemáticos");
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);


        LinkedList<RespuestaGrupos> respuestas = new LinkedList<RespuestaGrupos>();

        LinkedList<Grupo> gruposElegidos = new LinkedList<Grupo>();

        Grupo grupo1Elegidos = new Grupo("Grupo1ElegidoFísicos");
        grupo1Elegidos.agregarOpcion(segundaOpcion);

        Grupo grupo2Elegidos = new Grupo("Grupo2ElegidoMatemáticos");
        grupo2Elegidos.agregarOpcion(terceraOpcion);

        gruposElegidos.add(grupo1Elegidos);
        gruposElegidos.add(grupo2Elegidos);

        RespuestaGrupos respuesta = new RespuestaGrupos(gruposElegidos, Guido);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 0);
    }

    @Test
    public void CreoPreguntaGroupChoiceYJugadorRespondeIncorrectamente() {

        Jugador Guido = new Jugador("Guido");

        LinkedList<Grupo> gruposCorrectos = new LinkedList<Grupo>();

        Grupo grupo1Correcto = new Grupo("Grupo1CorrectoFísicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        Grupo grupo2Correcto = new Grupo("Grupo2CorrectoMatemáticos");
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);


        LinkedList<Grupo> gruposElegidos = new LinkedList<Grupo>();

        Grupo grupo1Elegidos = new Grupo("Grupo1ElegidoFísicos");
        grupo1Elegidos.agregarOpcion(segundaOpcion);

        Grupo grupo2Elegidos = new Grupo("Grupo2ElegidoMatemáticos");
        grupo2Elegidos.agregarOpcion(terceraOpcion);

        gruposElegidos.add(grupo1Elegidos);
        gruposElegidos.add(grupo2Elegidos);

        RespuestaGrupos respuesta = new RespuestaGrupos(gruposElegidos, Guido);

        pregunta.verificarlosGruposDeLaRespuesta(respuesta);//Comprobamos este métedo

        assertEquals(Guido.getPuntos().getCantidad(), 0);
    }

    @Test
    public void CreoPreguntaGroupChoiceYJugadorRespondeParcialmente() {

        Jugador Guido = new Jugador("Guido");

        LinkedList<Grupo> gruposCorrectos = new LinkedList<Grupo>();

        Grupo grupo1Correcto = new Grupo("Grupo1CorrectoFísicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        Grupo grupo2Correcto = new Grupo("Grupo2CorrectoMatemáticos");
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);


        LinkedList<Grupo> gruposElegidos = new LinkedList<Grupo>();

        Grupo grupo1Elegidos = new Grupo("Grupo1ElegidoFísicos");
        grupo1Elegidos.agregarOpcion(primeraOpcion);
        grupo1Elegidos.agregarOpcion(segundaOpcion);

        Grupo grupo2Elegidos = new Grupo("Grupo2ElegidoMatemáticos");
        grupo2Elegidos.agregarOpcion(terceraOpcion);

        gruposElegidos.add(grupo1Elegidos);
        gruposElegidos.add(grupo2Elegidos);

        RespuestaGrupos respuesta = new RespuestaGrupos(gruposElegidos, Guido);

        pregunta.verificarlosGruposDeLaRespuesta(respuesta);//Comprobamos este métedo

        assertEquals(Guido.getPuntos().getCantidad(), 1);
    }

    @Test
    public void CreoPreguntaGroupChoiceYJugadorRespondeCorrectamente() {

        Jugador Guido = new Jugador("Guido");

        LinkedList<Grupo> gruposCorrectos = new LinkedList<Grupo>();

        Grupo grupo1Correcto = new Grupo("Grupo1CorrectoFísicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        Grupo grupo2Correcto = new Grupo("Grupo2CorrectoMatemáticos");
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);


        LinkedList<Grupo> gruposElegidos = new LinkedList<Grupo>();

        Grupo grupo1Elegidos = new Grupo("Grupo1ElegidoFísicos");
        grupo1Elegidos.agregarOpcion(primeraOpcion);
        grupo1Elegidos.agregarOpcion(segundaOpcion);

        Grupo grupo2Elegidos = new Grupo("Grupo2ElegidoMatemáticos");
        grupo2Elegidos.agregarOpcion(terceraOpcion);
        grupo2Elegidos.agregarOpcion(cuartaOpcion);

        gruposElegidos.add(grupo1Elegidos);
        gruposElegidos.add(grupo2Elegidos);

        RespuestaGrupos respuesta = new RespuestaGrupos(gruposElegidos, Guido);

        pregunta.verificarlosGruposDeLaRespuesta(respuesta);//Comprobamos este métedo

        assertEquals(Guido.getPuntos().getCantidad(), 2);
    }
}
