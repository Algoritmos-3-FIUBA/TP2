package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.Grupo;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestGrupo {

    OpcionCorrecta primeraOpcion = new OpcionCorrecta("Opcion1", 0);
    OpcionCorrecta segundaOpcion = new OpcionCorrecta("Opcion2", 0);
    OpcionCorrecta terceraOpcion = new OpcionCorrecta("Opcion3", 0);
    OpcionCorrecta cuartaOpcion = new OpcionCorrecta("Opcion4", 0);

    @Test
    public void CreoGrupoYPidoSusOpciones() {
        Grupo grupo = new Grupo("Grupo");

        HashSet<Opcion> opciones = new HashSet<Opcion>();
        //LinkedList< Opcion > list1 = new LinkedList < Opcion > ();

       // list1.add(primeraOpcion);
        //list1.add(segundaOpcion);
        //list1.add(terceraOpcion);
        //list1.add(cuartaOpcion);

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);
        System.out.println(opciones);

        //LinkedList< Opcion > list = new LinkedList < Opcion > ( opciones );

        //System.out.println(list);
        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(segundaOpcion);
        grupo.agregarOpcion(terceraOpcion);
        grupo.agregarOpcion(cuartaOpcion);

        //assertEquals(list1, list);
        assertEquals((grupo.getOpcionesDelGrupo()), opciones);
    }

    @Test
    public void CreoGrupoYVerificoSusOpcionesDeberianSerCorrectasYOtorgarPunto() {
        Grupo grupo = new Grupo("Grupo");

        Puntos puntosAsignar = new Puntos(1);

        Puntos puntosDevueltos;

        HashSet<OpcionCorrecta> opciones = new HashSet<OpcionCorrecta>();

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        grupo.agregarOpcion(cuartaOpcion);
        grupo.agregarOpcion(terceraOpcion);
        grupo.agregarOpcion(segundaOpcion);
        grupo.agregarOpcion(primeraOpcion);

        puntosDevueltos = grupo.evaluarGrupo(opciones,puntosAsignar);

        assertEquals(puntosAsignar, puntosDevueltos);
    }

    @Test
    public void CreoGrupoYVerificoSusOpcionesDeberianSerIncorrectasYNoOtorgarPunto() {
        Grupo grupo = new Grupo("Grupo");

        Puntos puntosAsignar = new Puntos(1);

        Puntos puntosDevueltos;

        HashSet<OpcionCorrecta> opciones = new HashSet<OpcionCorrecta>();

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);

        grupo.agregarOpcion(cuartaOpcion);
        grupo.agregarOpcion(terceraOpcion);
        grupo.agregarOpcion(segundaOpcion);

        puntosDevueltos = grupo.evaluarGrupo(opciones,puntosAsignar);

        assertNotEquals(puntosAsignar,puntosDevueltos);
    }
}