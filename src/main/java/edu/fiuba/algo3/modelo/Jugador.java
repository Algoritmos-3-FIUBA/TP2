package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorDos;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorTres;

import java.util.LinkedList;

public class Jugador {

    private final String nombre;
    private Puntos puntos;
    private LinkedList<Multiplicador> multiplicadoresPorDos;
    private LinkedList<Multiplicador> multiplicadoresPorTres;

    public Jugador(String name) {
        this.nombre = name;
        puntos = new Puntos(0);

        multiplicadoresPorDos = new LinkedList<Multiplicador>();
        multiplicadoresPorTres = new LinkedList<Multiplicador>();

        multiplicadoresPorDos.add(new MultiplicadorPorDos());
        multiplicadoresPorTres.add(new MultiplicadorPorTres());
    }

    public String getNombre() {
        return nombre;
    }

    public Puntos getPuntos() {
        return puntos;
    }

    public void sumarPuntos(Puntos puntosASumar) {
        puntos.sumarPuntos(puntosASumar);
    }

    public Multiplicador usarMultiplicadorPorDos(){
        //if(multiplicadoresPorDos.isEmpty())
        return multiplicadoresPorDos.removeLast();
    }

    public Multiplicador usarMultiplicadorPorTres(){
        //if(multiplicadoresPorTres.isEmpty())
        return multiplicadoresPorTres.removeLast();
    }
}