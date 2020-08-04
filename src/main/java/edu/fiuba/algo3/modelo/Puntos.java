package edu.fiuba.algo3.modelo;

public class Puntos {

    public int cantidad;

    public Puntos(int cantidadPuntos){
        cantidad = cantidadPuntos;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void sumarPuntos(Puntos puntosASumar){
        cantidad = puntosASumar.sumarCantidad(this.cantidad);
    }

    private int sumarCantidad(int cantidadASumar){
        return (this.cantidad + cantidadASumar);
    }
}
