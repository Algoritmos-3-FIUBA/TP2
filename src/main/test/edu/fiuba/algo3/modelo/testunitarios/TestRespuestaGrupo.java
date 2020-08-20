package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.excepciones.MasDeSeisOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGrupos;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestRespuestaGrupo {

    private final OpcionCorrecta primeraOpcion = new OpcionCorrecta("Opcion1");
    private final OpcionCorrecta segundaOpcion = new OpcionCorrecta("Opcion2");
    private final OpcionCorrecta terceraOpcion = new OpcionCorrecta("Opcion3");
    private final OpcionCorrecta cuartaOpcion = new OpcionCorrecta("Opcion4");
    private final OpcionCorrecta quintaOpcion = new OpcionCorrecta("Opcion5");
    private final OpcionCorrecta sextaOpcion = new OpcionCorrecta("Opcion6");
    private final OpcionCorrecta septimaOpcion = new OpcionCorrecta("Opcion7");

    @Test
    public void testCreoLaRespuestaGroupChoiceDelJugadorYVerificoSiSonLasElegidas01() {
        Jugador jugador = new Jugador("Guido");

        ColeccionOpciones grupo = new ColeccionOpciones();

        LinkedList<ColeccionOpciones> gruposElegidos = new LinkedList<ColeccionOpciones>();

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(segundaOpcion);
        grupo.agregarOpcion(terceraOpcion);
        grupo.agregarOpcion(cuartaOpcion);

        gruposElegidos.add(grupo);

        RespuestaGrupos respuesta = new RespuestaGrupos(gruposElegidos, jugador);

        assertEquals(respuesta.getGruposElegidos(), gruposElegidos);
    }

    @Test
    public void testCreoLaRespuestaGroupChoiceDelJugadorYVerificoSiSonLasElegidasElJugadorNoEligeTodasLasOpciones02() {
        Jugador jugador = new Jugador("Guido");

        ColeccionOpciones grupo = new ColeccionOpciones();

        LinkedList<ColeccionOpciones> gruposElegidos = new LinkedList<ColeccionOpciones>();

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(segundaOpcion);

        gruposElegidos.add(grupo);

        RespuestaGrupos respuesta = new RespuestaGrupos(gruposElegidos, jugador);

        assertEquals(respuesta.getGruposElegidos(), gruposElegidos);
    }

    @Test
    public void testAsignoPuntajeAlJugador03() {
        Jugador jugador = new Jugador("Guido");

        Puntos puntos = new Puntos(1);

        ColeccionOpciones grupo = new ColeccionOpciones();

        LinkedList<ColeccionOpciones> gruposElegidos = new LinkedList<ColeccionOpciones>();

        HashSet<Opcion> opciones = new HashSet<Opcion>();

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(segundaOpcion);
        grupo.agregarOpcion(terceraOpcion);
        grupo.agregarOpcion(cuartaOpcion);

        gruposElegidos.add(grupo);

        RespuestaGrupos respuesta = new RespuestaGrupos(gruposElegidos, jugador);

        respuesta.setCorrecta();
        respuesta.otorgarPuntos(puntos);

        assertEquals(jugador.getPuntos().getCantidad(), 1);
    }

    @Test
    public void testJugadorRealizaUnaRespuestaGrupoConMasDeSeisOpciones04() {
        Jugador jugador = new Jugador("Guido");
        ColeccionOpciones grupo = new ColeccionOpciones();
        LinkedList<ColeccionOpciones> gruposElegidos = new LinkedList<ColeccionOpciones>();

        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(segundaOpcion);
        grupo.agregarOpcion(terceraOpcion);
        grupo.agregarOpcion(cuartaOpcion);
        grupo.agregarOpcion(quintaOpcion);
        grupo.agregarOpcion(sextaOpcion);
        grupo.agregarOpcion(septimaOpcion);

        gruposElegidos.add(grupo);

        assertThrows(MasDeSeisOpcionesException.class,
                ()->{
                    new RespuestaGrupos(gruposElegidos,jugador);
                });
    }

}