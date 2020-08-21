package edu.fiuba.algo3.modelo;

public class Puntos {

    public int cantidad;

    public Puntos(int cantidadPuntos){
        cantidad = cantidadPuntos;
    }

    public Puntos(Puntos puntos) {
        this.cantidad = puntos.getCantidad();
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

    public void multiplicar(int multiplicando){
        cantidad *= multiplicando;
    }

    public boolean sonNegativos() {
        return (this.getCantidad() < 0);
    }
}
