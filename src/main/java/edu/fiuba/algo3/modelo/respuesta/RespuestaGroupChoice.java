package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.Grupo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;

import java.util.HashSet;
import java.util.LinkedList;

public class RespuestaGroupChoice {
    private LinkedList<Grupo> gruposElegidos;
    private Jugador jugador;
    private Puntos puntosAsignar;

    public RespuestaGroupChoice (LinkedList<Grupo> gruposElegidos, Jugador jugador) {
        this.gruposElegidos = gruposElegidos;
        this.jugador = jugador;
    }

    public void otorgarPuntos(LinkedList<Grupo> gruposCorrectos, Puntos cantidadDePuntos) {
        for (int i=0; i<gruposCorrectos.size(); i++){
            puntosAsignar = gruposElegidos.get(i).evaluarGrupo(gruposCorrectos.get(i).getOpcionesDelGrupo(), cantidadDePuntos);
            jugador.sumarPuntos(puntosAsignar);
        }
    }
}
