package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVoF {

    private String nombre;
    private Opcion opcionVerdadero;
    private Opcion opcionFalso;
    private ArrayList opcionesDisponibles = new ArrayList();

    public PreguntaVoF(String nombrePregunta) {
        this.nombre = nombrePregunta;
    }

    public void verdaderoOpcionCorrecta() {
        opcionFalso = new OpcionIncorrecta();
        opcionVerdadero = new OpcionCorrecta();
        this.aniadirOpciones();
    }

    public void falsoOpcionCorrecta() {
        opcionFalso = new OpcionCorrecta();
        opcionVerdadero = new OpcionIncorrecta();
        this.aniadirOpciones();
    }

    private void aniadirOpciones() {
        opcionesDisponibles.add(opcionVerdadero);
        opcionesDisponibles.add(opcionFalso);
    }

    public void evaluarRespuestasFinales(ArrayList respuestasDeJugadores) {
        Respuesta respuesta;
        for (Object respuestaDeJugador : respuestasDeJugadores) {
            respuesta = (Respuesta) respuestaDeJugador;
            respuesta.otorgarPuntos(opcionesDisponibles);
        }
    }

    public String getNombrePregunta() { return nombre; }

    public Opcion getOpcionVerdadero() { return opcionVerdadero; }

    public Opcion getOpcionFalso() { return opcionFalso; }

    public ArrayList getOpcionesDisponibles() { return opcionesDisponibles; }

}

