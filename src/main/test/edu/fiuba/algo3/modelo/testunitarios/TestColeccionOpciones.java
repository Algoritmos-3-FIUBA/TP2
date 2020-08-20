package edu.fiuba.algo3.modelo.testunitarios;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestColeccionOpciones {

    private final OpcionCorrecta primeraOpcion = new OpcionCorrecta("Juan", 0);
    private final OpcionCorrecta segundaOpcion = new OpcionCorrecta("Mati", 0);
    private final OpcionCorrecta terceraOpcion = new OpcionCorrecta("Fer", 0);
    private final OpcionIncorrecta cuartaOpcion = new OpcionIncorrecta("Guido", 0);
    private final OpcionIncorrecta quintaOpcion = new OpcionIncorrecta("Lucas", 0);

    @Test
    public void testCreoGrupoConUnaListaDeOpcionesYAlPedirlasLasDevuelveCorrectamente01() {
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
    public void testCreoGrupoConOtraListaDeOpcionesYAlPedirlasLasDevuelveCorrectamente02() {
        LinkedList<Opcion> opciones = new LinkedList<>();

        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);
        opciones.add(primeraOpcion);
        opciones.add(segundaOpcion);

        ColeccionOpciones grupo = new ColeccionOpciones(opciones);

        assertEquals(grupo.getOpciones(),opciones);
    }

    @Test
    public void testCreoGrupoAgregarndoUnaOpcionPorUnaYAlPedirlasLasDevuelveCorrectamente03() {
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
    public void testCreoDosGruposConLasMismasOpcionesEnElMismoOrdenYTienenLosMismosElementos04() {
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

        assertTrue(grupo.tieneMismosElementos(otroGrupo));
    }

    @Test
    public void testCreoDosGruposConLasMismasOpcionesEnDistintoOrdenYTienenLosMismosElementos05() {
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

        assertTrue(grupo.tieneMismosElementos(otroGrupo));
    }

    @Test
    public void testCreoDosGruposDiferentesYNoTienenLosMismosElementos06() {
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
    public void testCreoDosGruposConLasMismasOpcionesEnElMismoOrdenYSonIguales07() {
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

        assertTrue(grupo.esIgual(otroGrupo));
    }

    @Test
    public void testCreoDosGruposConLasMismasOpcionesEnDistintoOrdenYNoSonIguales08() {
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
    public void testCreoDosGruposDiferentesYNoSonIguales09() {
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
    public void testGrupoSeparaCorrectamenteEnLosDosGruposCorrectos10() {
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

        assertTrue(grupoCorrecto.esIgual(grupoEsperadoCorrecto));
        assertTrue(grupoIncorrecto.esIgual(grupoEsperadoIncorrecto));
    }

    @Test
    public void testDosGruposQueCompartenOpcionesTienenOpcionesEnComun11() {
        ColeccionOpciones grupo = new ColeccionOpciones();

        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(segundaOpcion);
        grupo.agregarOpcion(quintaOpcion);

        ColeccionOpciones otroGrupo = new ColeccionOpciones();

        otroGrupo.agregarOpcion(terceraOpcion);
        otroGrupo.agregarOpcion(quintaOpcion);
        otroGrupo.agregarOpcion(primeraOpcion);

        assertTrue(grupo.tieneElementos(otroGrupo));
    }

    @Test
    public void testDosGruposDiferentesNoTienenOpcionesEnComun12() {
        ColeccionOpciones grupo = new ColeccionOpciones();

        grupo.agregarOpcion(primeraOpcion);
        grupo.agregarOpcion(segundaOpcion);
        grupo.agregarOpcion(quintaOpcion);

        ColeccionOpciones otroGrupo = new ColeccionOpciones();

        otroGrupo.agregarOpcion(terceraOpcion);
        otroGrupo.agregarOpcion(cuartaOpcion);

        assertFalse(grupo.tieneElementos(otroGrupo));
    }
}