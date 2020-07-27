package edu.fiuba.algo3.modelo;

import java.util.LinkedList;

public abstract class PreguntaVerdaderoFalso {

    private String nombre;
    //private Opcion opcionVerdadero;
   // private Opcion opcionFalso;

    public PreguntaVerdaderoFalso(String nombrePregunta) { this.nombre = nombrePregunta; }

    //@Override
    public abstract void setVerdaderoOpcionCorrecta();
  //  @Override
    public abstract void setfalsoOpcionCorrecta();

  //  @Override
    public void evaluarRespuestas(LinkedList<Respuesta> respuestasDeJugadores) {

        Respuesta respuesta;
        for (Object respuestaDeJugador : respuestasDeJugadores) {
            respuesta = (Respuesta) respuestaDeJugador;
            respuesta.otorgarPuntos();
        }

    }

    public String getNombrePregunta() { return nombre; }

  //  public Opcion getOpcionVerdadera() { return opcionVerdadero; }

  //  public Opcion getOpcionFalsa() { return opcionFalso; }

}

