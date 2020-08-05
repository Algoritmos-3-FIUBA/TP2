package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;

import java.util.HashSet;

public class Grupo {
    private String Nombre;
    HashSet<OpcionCorrecta> opcionesDelGrupo = new HashSet<OpcionCorrecta>();

    public Grupo(String nombre) {
        Nombre = nombre;
    }

    public void agregarOpcion(OpcionCorrecta opcionesDelGrupo) {
        this.opcionesDelGrupo.add(opcionesDelGrupo);
    }

    public Puntos evaluarGrupo(HashSet<OpcionCorrecta> opcionesElegidasDelGrupo, Puntos cantidadDePuntos) {
        Puntos puntosAsignar = new Puntos(0);
        if (opcionesElegidasDelGrupo.equals(opcionesDelGrupo)){
            puntosAsignar = cantidadDePuntos;
        }
        return(puntosAsignar);
    }

    public HashSet<OpcionCorrecta> getOpcionesDelGrupo(){
        return opcionesDelGrupo;
    }
}
