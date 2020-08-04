package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.Puntos;

import java.util.HashSet;
import java.util.LinkedList;

public abstract class Opcion {

    protected String Nombre;
    protected Puntos PuntosOtorgados;

    public Opcion(String NombreOpcion, int puntos){
        Nombre = NombreOpcion;
        PuntosOtorgados = new Puntos(puntos);
    }

    public Puntos puntosObtenidos(){
        return PuntosOtorgados;
    }

    public abstract void agregarseALaListaCorrespondiente(HashSet<OpcionCorrecta> opcionesCorrectas, HashSet<OpcionIncorrecta> opcionesIncorrectas);

    public abstract void agregarseALaListaCorrespondienteOrdenada(LinkedList<OpcionCorrecta> opcionesCorrectas, LinkedList<OpcionIncorrecta> opcionesIncorrectas);

    public String getNombre(){
        return Nombre;
    }

}

