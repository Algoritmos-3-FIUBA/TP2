package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.Grupo;
import edu.fiuba.algo3.modelo.Jugador;

import java.util.LinkedList;

public class RespuestaGrupos extends Respuesta{
    private LinkedList<Grupo> gruposElegidos;
    //private Jugador jugador;

    public RespuestaGrupos (LinkedList<Grupo> gruposElegidos, Jugador jugador) {
        super(jugador);
        this.gruposElegidos = gruposElegidos;
        //this.jugador = jugador;
    }
/*
    public void otorgarPuntos(LinkedList<Grupo> gruposCorrectos, Puntos cantidadDePuntos) {
        for (int i=0; i<gruposCorrectos.size(); i++){
            puntosAsignar = gruposElegidos.get(i).evaluarGrupo(gruposCorrectos.get(i).getOpcionesDelGrupo(), cantidadDePuntos);
            jugador.sumarPuntos(puntosAsignar);
        }
    }

    public void otorgarPuntos(Puntos cantidadDePuntos) {
        jugador.sumarPuntos(cantidadDePuntos);
    }
*/
    public LinkedList<Grupo> getGruposElegidos(){
        return gruposElegidos;
    }
}