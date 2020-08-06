package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorDefault;
import edu.fiuba.algo3.modelo.opcion.Opcion;

import java.util.Collection;

public abstract class Respuesta {

    protected Jugador jugador;
    protected Multiplicador multiplicador;

    public Respuesta(Jugador jugador) {
        this.jugador = jugador;
        multiplicador = new MultiplicadorDefault();
    }

    public Respuesta(Jugador jugador, Multiplicador multiplicador){
        this.jugador = jugador;
        this.multiplicador = multiplicador;
    }

    public void otorgarPuntos(Puntos puntos){
        multiplicador.utilizarBeneficio(puntos, jugador);
    };


}
