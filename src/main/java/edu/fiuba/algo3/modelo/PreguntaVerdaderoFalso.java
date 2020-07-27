package edu.fiuba.algo3.modelo;

import java.util.LinkedList;

public class PreguntaVerdaderoFalso {

    private String nombre;
    private Opcion opcionVerdadero;
    private Opcion opcionFalso;

    public PreguntaVerdaderoFalso(String nombrePregunta) { this.nombre = nombrePregunta; }

    public void setVerdaderoOpcionCorrecta() {

        opcionFalso = new OpcionIncorrecta("Falso",0);
        opcionVerdadero = new OpcionCorrecta("Verdadero",1);

    }

    public void falsoOpcionCorrecta() {

        opcionFalso = new OpcionCorrecta("Falso",1);
        opcionVerdadero = new OpcionIncorrecta("Verdadero",0);

    }

    public void evaluarRespuestas(LinkedList<Respuesta> respuestasDeJugadores) {

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

