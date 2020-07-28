package edu.fiuba.algo3.modelo;

public abstract class Opcion {

    protected String Nombre;
    protected int PuntosOtorgados;

    public Opcion(String NombreOpcion, int Puntos){
        Nombre = NombreOpcion;
        PuntosOtorgados = Puntos;
    }

    public int puntosObtenidos(){
        return PuntosOtorgados;
    }

    public String getNombre(){
        return Nombre;
    }

/*
    //Reimplementación del equals.
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null) { return false; }
        if (obj instanceof Opcion) {
            Opcion otraOpcion = (Opcion)obj;
            return otraOpcion.getNombre().equals(getNombre());
        } else{ return false; }
    }

*/

}

