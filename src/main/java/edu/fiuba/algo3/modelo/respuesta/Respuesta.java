package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.amplificador.FactorDefault;
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

    public Respuesta(Jugador jugador) {
        this.jugador = jugador;
        this.estado = new EstadoIncorrecto();
        this.multiplicador = new MultiplicadorDefault();
        this.exclusividad = new ExclusividadDefault();
        this.amplificador = new Amplificador(new FactorDefault(1));
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
        this.amplificador = new Amplificador(new FactorDefault(1));
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
    public void calcularAmplificacionExclusividad(LinkedList<Respuesta> respuestas){
        exclusividad.actualizarAmplificador(respuestas,this);
    }

    public void actualizarCondicionDeUsoExclusividad(LinkedList<Respuesta> respuestas){
        estado.actualizarCondicionDeUsoExclusividad(respuestas);
    }

    public void otorgarPuntos(Puntos puntos){
        amplificador.amplificarPuntos(puntos);
        multiplicador.inutilizarMultiplicador();
        estado.otorgarPuntos(puntos,jugador);
    }

    public void notificarExclusividadQueHayRespuestaCorrecta() {
        exclusividad.hayRespuestaCorrecta();
    }

    public Amplificador getAmplificadorExclusividad() {
        return exclusividad.getAmplificador();
    }

    public void establecerAmplificadorAdecuado() {
        this.exclusividad.establecerAmplificadorRequerido();
    }

    public void setAmplificadorExclusividad() {
        this.amplificador = this.exclusividad.getAmplificador();
    }
}
