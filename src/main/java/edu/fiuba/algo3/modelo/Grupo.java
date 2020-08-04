package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultipleChoice;

import java.util.HashSet;
import java.util.LinkedList;

public class Grupo {
    private String Nombre;
    HashSet<OpcionCorrecta> opcionesDelGrupo = new HashSet<OpcionCorrecta>();
    private Puntos puntosAsignar = new Puntos(0);

    public Grupo(String nombre) {

        Nombre = nombre;

    }

    public void agregarOpcion(OpcionCorrecta opcionesDelGrupo) {
        this.opcionesDelGrupo.add(opcionesDelGrupo);
    }

    public Puntos evaluarGrupo(HashSet<OpcionCorrecta> opcionesCorrctasDelGrupo, Puntos cantidadDePuntos) {
        if (opcionesDelGrupo.equals(opcionesCorrctasDelGrupo)){
            puntosAsignar = cantidadDePuntos;
        }
        return(puntosAsignar);
    }

    public HashSet<OpcionCorrecta> getOpcionesDelGrupo(){
        return opcionesDelGrupo;
    }
}
