package edu.fiuba.algo3.modelo;

public class EstadoCorrecto implements Estado{

    @Override
    public int sumarPuntos(int puntos){
        return (puntos +=1);
    }
}
