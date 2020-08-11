package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;

import java.util.LinkedList;

public class RespuestaGrupos extends Respuesta{

    private LinkedList<ColeccionOpciones> gruposElegidos;

    public RespuestaGrupos (LinkedList<ColeccionOpciones> gruposElegidos, Jugador jugador) {
        super(jugador);
        this.gruposElegidos = gruposElegidos;
    }

    public LinkedList<ColeccionOpciones> getGruposElegidos(){
        return gruposElegidos;
    }

    //Version Anterior
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
}