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

}

