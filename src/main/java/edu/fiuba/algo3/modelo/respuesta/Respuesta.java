package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.exclusividad.ExclusividadDefault;
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

    private void inicializacionComun(Jugador jugador){
        this.jugador = jugador;
        this.estado = new EstadoIncorrecto();
    }

    public Respuesta(Jugador jugador) {
        inicializacionComun(jugador);
        this.multiplicador = new MultiplicadorDefault();
        this.exclusividad = new ExclusividadDefault();
        this.amplificador = new Amplificador(1);
    }

    public Respuesta(Jugador jugador, Multiplicador multiplicador){
        inicializacionComun(jugador);
        this.multiplicador = multiplicador;
        this.exclusividad = new ExclusividadDefault();
        this.amplificador = multiplicador.getAmplificador();
    }

    public Respuesta(Jugador jugador, Exclusividad exclusividad){
        inicializacionComun(jugador);
        this.exclusividad = exclusividad;
        this.multiplicador = new MultiplicadorDefault();
        this.amplificador = new Amplificador(1); //Porque no sabemos si se va a usar el de exclusividad
    }

    public void otorgarPuntos(Puntos puntos){
        amplificador.amplificarPuntos(puntos);
        multiplicador.inutilizarMultiplicador();
        estado.otorgarPuntos(puntos,jugador);
    }

    public void setAmplificador(Amplificador amplificador) {
        this.amplificador = amplificador;
    }

    public void actualizarAmplificacionExclusividad(LinkedList<Respuesta> respuestas){
        exclusividad.actualizarAmplificador(respuestas,this);
    }

    public void actualizarCondicionDeUsoExclusividad(LinkedList<Respuesta> respuestas){
        estado.actualizarCondicionDeUsoExclusividad(respuestas);
    }

    public void notificarExclusividadQueHayRespuestaCorrecta() {
        exclusividad.hayRespuestaCorrecta();
    }

    public void establecerUsoDeExclusividadSiEsNecesario() {
        this.exclusividad.establecerAmplificadorRequerido();
    }

    public void setAmplificadorExclusividad() {
        this.amplificador = this.exclusividad.getAmplificador();
    }

    public void actualizarFactorAmplificacion(int factor) {
        exclusividad.aumentarAmplificador(factor);
    }

    public void esCorrecta(){
        estado = new EstadoCorrecto();
    }

    public void esIncorrecta(){
        estado = new EstadoIncorrecto();
    }
}
