package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.respuesta.RespuestaVerdaderoFalso;

import java.util.LinkedList;

public abstract class PreguntaVerdaderoFalso {

    private String nombre;
    //private Opcion opcionVerdadero;
   // private Opcion opcionFalso;

    public PreguntaVerdaderoFalso(String nombrePregunta) { this.nombre = nombrePregunta; }

    //@Override
    public abstract void setVerdaderoOpcionCorrecta();
  //  @Override
    public abstract void setFalsoOpcionCorrecta();

  //  @Override
    public void evaluarRespuestas(LinkedList<RespuestaVerdaderoFalso> respuestasDeJugadores) {

        RespuestaVerdaderoFalso respuesta;
        for (Object respuestaDeJugador : respuestasDeJugadores) {
            respuesta = (RespuestaVerdaderoFalso) respuestaDeJugador;
            respuesta.otorgarPuntos();
        }

    }

    public String getNombrePregunta() { return nombre; }

  //  public Opcion getOpcionVerdadera() { return opcionVerdadero; }

  //  public Opcion getOpcionFalsa() { return opcionFalso; }

}

