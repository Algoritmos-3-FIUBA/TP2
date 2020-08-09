package edu.fiuba.algo3.modelo.testUnitarios;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class TestColeccionOpciones {

    OpcionCorrecta primeraOpcion = new OpcionCorrecta("Juan", 0);
    OpcionCorrecta segundaOpcion = new OpcionCorrecta("Mati", 0);
    OpcionCorrecta terceraOpcion = new OpcionCorrecta("Fer", 0);
    OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("Guido", 0);
    OpcionIncorrecta quintaOpcion = new OpcionIncorrecta("Lucas", 0);

    @Test
    public void CreoGrupoConUnaListaDeOpcionesYAlPedirlasLasDevuelveCorrectamente() {
        LinkedList<Opcion> opciones = new LinkedList<>();

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);
        opciones.add(quintaOpcion);

        ColeccionOpciones grupo = new ColeccionOpciones(opciones);

        assertEquals(grupo.getOpciones(),opciones);
    }

    @Test
    public void CreoGrupoConOtraListaDeOpcionesYAlPedirlasLasDevuelveCorrectamente() {
        LinkedList<Opcion> opciones = new LinkedList<>();

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);

        ColeccionOpciones grupo = new ColeccionOpciones(opciones);

        assertEquals(grupo.getOpciones(),opciones);
    }

    @Test
    public void CreoGrupoAgregarndoUnaOpcionPorUnaYAlPedirlasLasDevuelveCorrectamente() {
        LinkedList<Opcion> opciones = new LinkedList<>();

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(terceraOpcion);
        opciones.add(cuartaOpcion);
        opciones.add(quintaOpcion);

        ColeccionOpciones grupo = new ColeccionOpciones();

        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(segundaOpcion);
        grupo.agregarOpcion(terceraOpcion);
        grupo.agregarOpcion(cuartaOpcion);
        grupo.agregarOpcion(quintaOpcion);

        assertEquals(grupo.getOpciones(),opciones);
    }

    @Test
    public void CreoDosGruposConLasMismasOpcionesEnElMismoOrdenYTienenLosMismosElementos() {
        ColeccionOpciones grupo = new ColeccionOpciones();

        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(segundaOpcion);
        grupo.agregarOpcion(terceraOpcion);
        grupo.agregarOpcion(cuartaOpcion);
        grupo.agregarOpcion(quintaOpcion);

        ColeccionOpciones otroGrupo = new ColeccionOpciones();

        otroGrupo.agregarOpcion(primeraOpcion);
        otroGrupo.agregarOpcion(segundaOpcion);
        otroGrupo.agregarOpcion(terceraOpcion);
        otroGrupo.agregarOpcion(cuartaOpcion);
        otroGrupo.agregarOpcion(quintaOpcion);

        assert(grupo.tieneMismosElementos(otroGrupo));
    }

    @Test
    public void CreoDosGruposConLasMismasOpcionesEnDistintoOrdenYTienenLosMismosElementos() {
        ColeccionOpciones grupo = new ColeccionOpciones();

        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(segundaOpcion);
        grupo.agregarOpcion(terceraOpcion);
        grupo.agregarOpcion(cuartaOpcion);
        grupo.agregarOpcion(quintaOpcion);

        ColeccionOpciones otroGrupo = new ColeccionOpciones();

        otroGrupo.agregarOpcion(quintaOpcion);
        otroGrupo.agregarOpcion(cuartaOpcion);
        otroGrupo.agregarOpcion(terceraOpcion);
        otroGrupo.agregarOpcion(segundaOpcion);
        otroGrupo.agregarOpcion(primeraOpcion);

        assert(grupo.tieneMismosElementos(otroGrupo));
    }

    @Test
    public void CreoDosGruposDiferentesYNoTienenLosMismosElementos() {
        ColeccionOpciones grupo = new ColeccionOpciones();

        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(terceraOpcion);

        ColeccionOpciones otroGrupo = new ColeccionOpciones();

        otroGrupo.agregarOpcion(quintaOpcion);
        otroGrupo.agregarOpcion(cuartaOpcion);
        otroGrupo.agregarOpcion(primeraOpcion);

        assertFalse(grupo.tieneMismosElementos(otroGrupo));
    }

    @Test
    public void CreoDosGruposConLasMismasOpcionesEnElMismoOrdenYSonIguales() {
        ColeccionOpciones grupo = new ColeccionOpciones();

        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(segundaOpcion);
        grupo.agregarOpcion(cuartaOpcion);
        grupo.agregarOpcion(quintaOpcion);

        ColeccionOpciones otroGrupo = new ColeccionOpciones();

        otroGrupo.agregarOpcion(primeraOpcion);
        otroGrupo.agregarOpcion(segundaOpcion);
        otroGrupo.agregarOpcion(cuartaOpcion);
        otroGrupo.agregarOpcion(quintaOpcion);

        assert(grupo.esIgual(otroGrupo));
    }

    @Test
    public void CreoDosGruposConLasMismasOpcionesEnDistintoOrdenYNoSonIguales() {
        ColeccionOpciones grupo = new ColeccionOpciones();

        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(segundaOpcion);
        grupo.agregarOpcion(cuartaOpcion);
        grupo.agregarOpcion(quintaOpcion);

        ColeccionOpciones otroGrupo = new ColeccionOpciones();

        otroGrupo.agregarOpcion(quintaOpcion);
        otroGrupo.agregarOpcion(cuartaOpcion);
        otroGrupo.agregarOpcion(segundaOpcion);
        otroGrupo.agregarOpcion(primeraOpcion);

        assertFalse(grupo.esIgual(otroGrupo));
    }

    @Test
    public void CreoDosGruposDiferentesYNoSonIguales() {
        ColeccionOpciones grupo = new ColeccionOpciones();

        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(cuartaOpcion);
        grupo.agregarOpcion(quintaOpcion);

        ColeccionOpciones otroGrupo = new ColeccionOpciones();

        otroGrupo.agregarOpcion(quintaOpcion);
        otroGrupo.agregarOpcion(cuartaOpcion);
        otroGrupo.agregarOpcion(terceraOpcion);
        otroGrupo.agregarOpcion(primeraOpcion);

        assertFalse(grupo.esIgual(otroGrupo));
    }

    @Test
    public void GrupoSeparaCorrectamenteEnLosDosGruposCorrectos() {
        ColeccionOpciones grupo = new ColeccionOpciones();

        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(segundaOpcion);
        grupo.agregarOpcion(terceraOpcion);
        grupo.agregarOpcion(cuartaOpcion);
        grupo.agregarOpcion(quintaOpcion);

        ColeccionOpciones grupoCorrecto = new ColeccionOpciones();
        ColeccionOpciones grupoIncorrecto = new ColeccionOpciones();

        grupo.separarEnGruposCorrespondientes(grupoCorrecto,grupoIncorrecto);

        ColeccionOpciones grupoEsperadoCorrecto = new ColeccionOpciones();
        ColeccionOpciones grupoEsperadoIncorrecto = new ColeccionOpciones();

        grupoEsperadoCorrecto.agregarOpcion(primeraOpcion);
        grupoEsperadoCorrecto.agregarOpcion(segundaOpcion);
        grupoEsperadoCorrecto.agregarOpcion(terceraOpcion);
        grupoEsperadoIncorrecto.agregarOpcion(cuartaOpcion);
        grupoEsperadoIncorrecto.agregarOpcion(quintaOpcion);

        assert(grupoCorrecto.esIgual(grupoEsperadoCorrecto));
        assert(grupoIncorrecto.esIgual(grupoEsperadoIncorrecto));
    }

    @Test
    public void DosGruposQueCompartenOpcionesTienenOpcionesEnComun() {
        ColeccionOpciones grupo = new ColeccionOpciones();

        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(segundaOpcion);
        grupo.agregarOpcion(quintaOpcion);

        ColeccionOpciones otroGrupo = new ColeccionOpciones();

        otroGrupo.agregarOpcion(terceraOpcion);
        otroGrupo.agregarOpcion(quintaOpcion);
        otroGrupo.agregarOpcion(primeraOpcion);

        assert(grupo.tieneElementos(otroGrupo));
    }

    @Test
    public void DosGruposDiferentesNoTienenOpcionesEnComun() {
        ColeccionOpciones grupo = new ColeccionOpciones();

        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(segundaOpcion);
        grupo.agregarOpcion(quintaOpcion);

        ColeccionOpciones otroGrupo = new ColeccionOpciones();

        otroGrupo.agregarOpcion(terceraOpcion);
        otroGrupo.agregarOpcion(cuartaOpcion);

        assertFalse(grupo.tieneElementos(otroGrupo));
    }

    //Version Anterior
    /*
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
    }*/
}