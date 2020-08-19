package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorDos;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorPorTres;

import java.util.LinkedList;

public class Jugador {

    private final String nombre;
    private Puntos puntos;
    private LinkedList<Multiplicador> multiplicadoresPorDos;
    private LinkedList<Multiplicador> multiplicadoresPorTres;
    private LinkedList<Exclusividad> exclusividades;

    public Jugador(String name) {
        this.nombre = name;
        puntos = new Puntos(0);

        multiplicadoresPorDos = new LinkedList<Multiplicador>();
        multiplicadoresPorTres = new LinkedList<Multiplicador>();
        exclusividades = new LinkedList<Exclusividad>();

        multiplicadoresPorDos.add(new MultiplicadorPorDos());
        multiplicadoresPorTres.add(new MultiplicadorPorTres());
        exclusividades.add(new Exclusividad());
        exclusividades.add(new Exclusividad());
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

    public Exclusividad usarExclusividad(){
        //if(exclusividades.isEmpty())
        return exclusividades.removeLast();
    }
}