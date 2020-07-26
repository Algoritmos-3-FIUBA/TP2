package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVerdaderoFalso {

    private String nombre;
    private Opcion opcionVerdadero;
    private Opcion opcionFalso;

    public PreguntaVerdaderoFalso(String nombrePregunta) { this.nombre = nombrePregunta; }

    public void setVerdaderoOpcionCorrecta() {

        opcionFalso = new OpcionIncorrecta();
        opcionVerdadero = new OpcionCorrecta();

    }

    public void falsoOpcionCorrecta() {

        opcionFalso = new OpcionCorrecta();
        opcionVerdadero = new OpcionIncorrecta();

    }

    public void evaluarRespuestas(ArrayList respuestasDeJugadores) {

        Respuesta respuesta;
        for (Object respuestaDeJugador : respuestasDeJugadores) {
            respuesta = (Respuesta) respuestaDeJugador;
            respuesta.otorgarPuntos();
        }

    }

    public String getNombrePregunta() { return nombre; }

    public Opcion getOpcionVerdadera() { return opcionVerdadero; }

    public Opcion getOpcionFalsa() { return opcionFalso; }

}

