package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.excepciones.MasDeSeisOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
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

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones("Físicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones("Matemáticos");
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

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones("Físicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones("Matemáticos");
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

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones("Físicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones("Matemáticos");
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

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones("Físicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);
        grupo1Correcto.agregarOpcion(sextaOpcion);
        grupo1Correcto.agregarOpcion(septimaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones("Matemáticos");
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
    public void testCreoPreguntaGroupChoiceConGruposVaciosYDevuelveExcepcion06() {

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

    @Test
    public void testCreoPreguntaGroupChoiceYJugadorRespondeBienConExclusividad07() {

        Jugador Guido = new Jugador("Guido");

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones("Físicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones("Matemáticos");
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

        RespuestaGrupos respuesta = new RespuestaGrupos(gruposElegidos, Guido,new Exclusividad());

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 4);
    }

    @Test
    public void testCreoPreguntaGroupChoiceYDosJugadoresRespondenBienConUnaExclusividad08() {

        Jugador Guido = new Jugador("Guido");
        Jugador Juan = new Jugador("Juan");

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones("Físicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones("Matemáticos");
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

        RespuestaGrupos respuestaGuido = new RespuestaGrupos(gruposElegidos, Guido,new Exclusividad());
        RespuestaGrupos respuestaJuan = new RespuestaGrupos(gruposElegidos, Juan);

        respuestas.add(respuestaGuido);
        respuestas.add(respuestaJuan);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 0);
        assertEquals(Juan.getPuntos().getCantidad(), 0);
    }

    @Test
    public void testCreoPreguntaGroupChoiceYDosJugadoresRespondenBienConDosExclusividad09() {

        Jugador Guido = new Jugador("Guido");
        Jugador Juan = new Jugador("Juan");

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones("Físicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones("Matemáticos");
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

        RespuestaGrupos respuestaGuido = new RespuestaGrupos(gruposElegidos, Guido,new Exclusividad());
        RespuestaGrupos respuestaJuan = new RespuestaGrupos(gruposElegidos, Juan,new Exclusividad());

        respuestas.add(respuestaGuido);
        respuestas.add(respuestaJuan);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 0);
        assertEquals(Juan.getPuntos().getCantidad(), 0);
    }

    @Test
    public void testCreoPreguntaGroupChoiceYUnJugadorContestaBienConDosExclusividad10() {

        Jugador Guido = new Jugador("Guido");
        Jugador Juan = new Jugador("Juan");

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones("Físicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones("Matemáticos");
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<ColeccionOpciones> gruposElegidosGuido = new LinkedList<ColeccionOpciones>();
        LinkedList<ColeccionOpciones> gruposElegidosJuan = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1ElegidosGuido = new ColeccionOpciones();
        grupo1ElegidosGuido.agregarOpcion(primeraOpcion);
        grupo1ElegidosGuido.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2ElegidosGuido = new ColeccionOpciones();
        grupo2ElegidosGuido.agregarOpcion(terceraOpcion);
        grupo2ElegidosGuido.agregarOpcion(cuartaOpcion);


        ColeccionOpciones grupo1ElegidosJuan = new ColeccionOpciones();
        grupo1ElegidosJuan.agregarOpcion(primeraOpcion);

        ColeccionOpciones grupo2ElegidosJuan = new ColeccionOpciones();
        grupo2ElegidosJuan.agregarOpcion(cuartaOpcion);

        gruposElegidosGuido.add(grupo1ElegidosGuido);
        gruposElegidosGuido.add(grupo2ElegidosGuido);

        gruposElegidosJuan.add(grupo1ElegidosJuan);
        gruposElegidosJuan.add(grupo2ElegidosJuan);

        RespuestaGrupos respuestaGuido = new RespuestaGrupos(gruposElegidosGuido, Guido,new Exclusividad());
        RespuestaGrupos respuestaJuan = new RespuestaGrupos(gruposElegidosJuan, Juan,new Exclusividad());

        respuestas.add(respuestaGuido);
        respuestas.add(respuestaJuan);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 8);
        assertEquals(Juan.getPuntos().getCantidad(), 0);
    }


    @Test
    public void testCreoPreguntaGroupChoiceYUnJugadorContestaBienPeroConLaExclusividadDeOtro11() {

        Jugador Guido = new Jugador("Guido");
        Jugador Juan = new Jugador("Juan");

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones("Físicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones("Matemáticos");
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<ColeccionOpciones> gruposElegidosGuido = new LinkedList<ColeccionOpciones>();
        LinkedList<ColeccionOpciones> gruposElegidosJuan = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1ElegidosGuido = new ColeccionOpciones();
        grupo1ElegidosGuido.agregarOpcion(primeraOpcion);
        grupo1ElegidosGuido.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2ElegidosGuido = new ColeccionOpciones();
        grupo2ElegidosGuido.agregarOpcion(terceraOpcion);
        grupo2ElegidosGuido.agregarOpcion(cuartaOpcion);


        ColeccionOpciones grupo1ElegidosJuan = new ColeccionOpciones();
        grupo1ElegidosJuan.agregarOpcion(primeraOpcion);

        ColeccionOpciones grupo2ElegidosJuan = new ColeccionOpciones();
        grupo2ElegidosJuan.agregarOpcion(cuartaOpcion);

        gruposElegidosGuido.add(grupo1ElegidosGuido);
        gruposElegidosGuido.add(grupo2ElegidosGuido);

        gruposElegidosJuan.add(grupo1ElegidosJuan);
        gruposElegidosJuan.add(grupo2ElegidosJuan);

        RespuestaGrupos respuestaGuido = new RespuestaGrupos(gruposElegidosGuido, Guido);
        RespuestaGrupos respuestaJuan = new RespuestaGrupos(gruposElegidosJuan, Juan,new Exclusividad());

        respuestas.add(respuestaGuido);
        respuestas.add(respuestaJuan);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 4);
        assertEquals(Juan.getPuntos().getCantidad(), 0);
    }

    @Test
    public void testCreoPreguntaGroupChoiceYDosJugadoresRespondenMalConUnaExclusividad12() {

        Jugador Guido = new Jugador("Guido");
        Jugador Juan = new Jugador("Juan");

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones("Físicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones("Matemáticos");
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<ColeccionOpciones> gruposElegidos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Elegidos = new ColeccionOpciones();
        grupo1Elegidos.agregarOpcion(primeraOpcion);

        ColeccionOpciones grupo2Elegidos = new ColeccionOpciones();
        grupo2Elegidos.agregarOpcion(terceraOpcion);

        gruposElegidos.add(grupo1Elegidos);
        gruposElegidos.add(grupo2Elegidos);

        RespuestaGrupos respuestaGuido = new RespuestaGrupos(gruposElegidos, Guido,new Exclusividad());
        RespuestaGrupos respuestaJuan = new RespuestaGrupos(gruposElegidos, Juan);

        respuestas.add(respuestaGuido);
        respuestas.add(respuestaJuan);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 0);
        assertEquals(Juan.getPuntos().getCantidad(), 0);
    }

    @Test
    public void testCreoPreguntaGroupChoiceYUnJugadorContestaBienYOtroParcialmentePeroConExclusividad13() {

        Jugador Guido = new Jugador("Guido");
        Jugador Juan = new Jugador("Juan");

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones("Físicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones("Matemáticos");
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);

        LinkedList<Respuesta> respuestas = new LinkedList<Respuesta>();

        LinkedList<ColeccionOpciones> gruposElegidosGuido = new LinkedList<ColeccionOpciones>();
        LinkedList<ColeccionOpciones> gruposElegidosJuan = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1ElegidosGuido = new ColeccionOpciones();
        grupo1ElegidosGuido.agregarOpcion(primeraOpcion);
        grupo1ElegidosGuido.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2ElegidosGuido = new ColeccionOpciones();
        grupo2ElegidosGuido.agregarOpcion(terceraOpcion);
        grupo2ElegidosGuido.agregarOpcion(cuartaOpcion);


        ColeccionOpciones grupo1ElegidosJuan = new ColeccionOpciones();
        grupo1ElegidosJuan.agregarOpcion(primeraOpcion);

        ColeccionOpciones grupo2ElegidosJuan = new ColeccionOpciones();
        grupo2ElegidosJuan.agregarOpcion(terceraOpcion);
        grupo2ElegidosJuan.agregarOpcion(cuartaOpcion);

        gruposElegidosGuido.add(grupo1ElegidosGuido);
        gruposElegidosGuido.add(grupo2ElegidosGuido);

        gruposElegidosJuan.add(grupo1ElegidosJuan);
        gruposElegidosJuan.add(grupo2ElegidosJuan);

        RespuestaGrupos respuestaGuido = new RespuestaGrupos(gruposElegidosGuido, Guido);
        RespuestaGrupos respuestaJuan = new RespuestaGrupos(gruposElegidosJuan, Juan,new Exclusividad());

        respuestas.add(respuestaGuido);
        respuestas.add(respuestaJuan);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 0);
        assertEquals(Juan.getPuntos().getCantidad(), 0);
    }

    @Test
    public void testCreoPreguntaGroupChoiceYJugadorRespondeBienPeroAgregarOpcionesIncorrectasEnUnGrupo14() {

        Jugador Guido = new Jugador("Guido");

        OpcionIncorrecta quintaOpcion = new OpcionIncorrecta("Messi");

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones("Físicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones("Matemáticos");
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
        grupo1Elegidos.agregarOpcion(quintaOpcion);

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
    public void testCreoPreguntaGroupChoiceYJugadorRespondeBienPeroAgregarOpcionesIncorrectasEnTodosLosGrupos15() {

        Jugador Guido = new Jugador("Guido");

        OpcionIncorrecta quintaOpcion = new OpcionIncorrecta("Messi");
        OpcionIncorrecta sextaOpcion = new OpcionIncorrecta("Aguero");

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones("Físicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones("Matemáticos");
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
        grupo1Elegidos.agregarOpcion(quintaOpcion);

        ColeccionOpciones grupo2Elegidos = new ColeccionOpciones();
        grupo2Elegidos.agregarOpcion(terceraOpcion);
        grupo2Elegidos.agregarOpcion(cuartaOpcion);
        grupo2Elegidos.agregarOpcion(sextaOpcion);

        gruposElegidos.add(grupo1Elegidos);
        gruposElegidos.add(grupo2Elegidos);

        RespuestaGrupos respuesta = new RespuestaGrupos(gruposElegidos, Guido);

        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(Guido.getPuntos().getCantidad(), 0);
    }

    //Agrego este test (aunque sea un getter) para aumentar cobertura
    @Test
    public void testCreoPreguntaGroupChoiceYTieneNombreEsperado16(){

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones("Físicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones("Matemáticos");
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);

        assertEquals(pregunta.getNombre(),"Colocar en cada grupo según corresponda");
    }

    //Agrego este test (aunque sea un getter) para aumentar cobertura
    @Test
    public void testCreoPreguntaOrderedChoiceLePidoLasOpcionesYSonDevueltas17() {

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones("Físicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones("Matemáticos");
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);

        ColeccionOpciones coleccionEsperada = new ColeccionOpciones();
        coleccionEsperada.agregarOpcion(primeraOpcion);
        coleccionEsperada.agregarOpcion(segundaOpcion);
        coleccionEsperada.agregarOpcion(terceraOpcion);
        coleccionEsperada.agregarOpcion(cuartaOpcion);

        assert(pregunta.getColeccionDeOpciones().tieneMismosElementos(coleccionEsperada));
    }

    //Agrego este test (aunque sea un getter) para aumentar cobertura
    @Test
    public void testCreoPreguntaOrderedChoiceLePidoLosNombreDelasOpcionesOpcionesYSonDevueltas18() {

        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();

        ColeccionOpciones grupo1Correcto = new ColeccionOpciones("Físicos");
        grupo1Correcto.agregarOpcion(primeraOpcion);
        grupo1Correcto.agregarOpcion(segundaOpcion);

        ColeccionOpciones grupo2Correcto = new ColeccionOpciones("Matemáticos");
        grupo2Correcto.agregarOpcion(terceraOpcion);
        grupo2Correcto.agregarOpcion(cuartaOpcion);

        gruposCorrectos.add(grupo1Correcto);
        gruposCorrectos.add(grupo2Correcto);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("Colocar en cada grupo según corresponda", 1, gruposCorrectos);

        LinkedList<String> nombresEsperados = new LinkedList<>();
        nombresEsperados.add("Físicos");
        nombresEsperados.add("Matemáticos");

        assertEquals(pregunta.getNombresGrupos(),nombresEsperados);
    }
}