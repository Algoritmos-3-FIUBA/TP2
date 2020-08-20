package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.excepciones.MasDeSeisOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGrupos;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPreguntaGroupChoice {

    private final OpcionCorrecta primeraOpcion = new OpcionCorrecta("Newton");
    private final OpcionCorrecta segundaOpcion = new OpcionCorrecta("Faraday");
    private final OpcionCorrecta terceraOpcion = new OpcionCorrecta("Gauss");
    private final OpcionCorrecta cuartaOpcion = new OpcionCorrecta("Euler");

    @Test
    public void testCreoPreguntaGroupChoiceYJugadorRespondeCorrectamenteVerificoQueLaAsignacionDePuntosSeaCorrecta01() {

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

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);

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
    public void testCreoPreguntaGroupChoiceYJugadorRespondeParcialmenteVerificoQueLaAsignacionDePuntosSeaCorrecta02() {

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

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);


        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<ColeccionOpciones> gruposElegidos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Elegidos = new ColeccionOpciones();
        grupo1Elegidos.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Elegidos = new ColeccionOpciones();
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
    public void testCreoPreguntaGroupChoiceYJugadorRespondeIncorrectamenteVerificoQueLaAsignacionDePuntosSeaCorrecta03() {

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

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<ColeccionOpciones> gruposElegidos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Elegidos = new ColeccionOpciones();
        grupo1Elegidos.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Elegidos = new ColeccionOpciones();
        grupo2Elegidos.agregarOpcion(terceraOpcion);

        gruposElegidos.add(grupo1Elegidos);
        gruposElegidos.add(grupo2Elegidos);

        RespuestaGrupos respuesta = new RespuestaGrupos(gruposElegidos, Guido);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 0);
    }

    @Test
    public void testCreoPreguntaGroupChoiceConSieteOpcionesYDevuelveExcepcion04() {

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        OpcionCorrecta quintaOpcion = new OpcionCorrecta("Einstein");
        OpcionCorrecta sextaOpcion = new OpcionCorrecta("Schrodinger");
        OpcionCorrecta septimaOpcion = new OpcionCorrecta("Bernoulli");

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones();
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);
        grupo1Correcto.agregarOpcion(sextaOpcion);
        grupo1Correcto.agregarOpcion(septimaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones();
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);
        grupo2Correcto.agregarOpcion(quintaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        assertThrows(MasDeSeisOpcionesException.class,
                ()->{
                    new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);
                });
    }

    @Test
    public void testCreoPreguntaGroupChoiceSinGruposYDevuelveExcepcion05() {

        assertThrows(NoHayOpcionesException.class,
                ()->{
                    new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 2,  new LinkedList<ColeccionOpciones>());
                });
    }

    @Test
    public void testCreoPreguntaGroupChoiceConGruposVaciosYDevuelveExcepcion04() {

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones();
        ColeccionOpciones grupo2Correcto = new ColeccionOpciones();
        ColeccionOpciones grupo3Correcto = new ColeccionOpciones();

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);
        gruposCorrectos.add(grupo3Correcto);

        assertThrows(NoHayOpcionesException.class,
                ()->{
                    new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 3, gruposCorrectos);
                });
    }
}