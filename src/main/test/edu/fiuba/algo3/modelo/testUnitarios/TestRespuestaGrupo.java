package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGrupos;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuestaGrupo {

    OpcionCorrecta primeraOpcion = new OpcionCorrecta("Opcion1");
    OpcionCorrecta segundaOpcion = new OpcionCorrecta("Opcion2");
    OpcionCorrecta terceraOpcion = new OpcionCorrecta("Opcion3");
    OpcionCorrecta cuartaOpcion = new OpcionCorrecta("Opcion4");
    @Test
    public void CreoLaRespuestaGroupChoiceDelJugadorYVerificoSiSonLasElegidas() {
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
    public void CreoLaRespuestaGroupChoiceDelJugadorYVerificoSiSonLasElegidasElJugadorNoEligeTodasLasOpciones() {
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
    public void AsignoPuntajeAlJugador() {
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
}