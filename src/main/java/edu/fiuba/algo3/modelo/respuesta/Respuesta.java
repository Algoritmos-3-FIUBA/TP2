package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.Exclusividad;
import edu.fiuba.algo3.modelo.ExclusividadDefault;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.amplificador.Amplificador;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorDefault;

import java.util.LinkedList;

public abstract class Respuesta {

    protected Jugador jugador;
    protected Multiplicador multiplicador;
    protected Exclusividad exclusividad;
    protected Amplificador amplificador;
    protected EstadoRespuesta estado;

    public Respuesta(Jugador jugador) {
        this.jugador = jugador;
        this.estado = new EstadoIncorrecto();
        this.multiplicador = new MultiplicadorDefault();
        this.exclusividad = new ExclusividadDefault();
        this.amplificador = new Amplificador(1);
    }

    public Respuesta(Jugador jugador, Multiplicador multiplicador){
        this.jugador = jugador;
        this.estado = new EstadoIncorrecto();
        this.multiplicador = multiplicador;
        this.exclusividad = new ExclusividadDefault();
        this.amplificador = multiplicador.getAmplificador();
    }

    public Respuesta(Jugador jugador, Exclusividad exclusividad){
        this.jugador = jugador;
        this.estado = new EstadoIncorrecto();
        this.exclusividad = exclusividad;
        this.multiplicador = new MultiplicadorDefault();
        this.amplificador = new Amplificador(1);
    }
    //Test
    public void setAmplificador(Amplificador amplificador) {
        this.amplificador = amplificador;
    }

    //Test
    public void setCorrecta(){
        this.estado = new EstadoCorrecto();
    }
    //Test
    public void calcularAmplificacionExclusividad(Amplificador amplificador, LinkedList<Respuesta> respuestas){
        exclusividad.actualizarAmplificador(amplificador,respuestas);
    }

    public void actualizarEstadoAmplificador(Amplificador amplificadorFinal){
        estado.actualizarEstadoAmplificador(amplificadorFinal);
    }

    public void otorgarPuntos(Puntos puntos){
        amplificador.amplificarPuntos(puntos);
        multiplicador.inutilizarMultiplicador();
        estado.otorgarPuntos(puntos,jugador);
    }
}
