package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVoF {
    private String nombre;
    private Opcion verdadero;
    private Opcion falso;

    private ArrayList opcionesDisponibles = new ArrayList();


    public PreguntaVoF(String s) {
        this.nombre = s;
    }

    public void verdaderoOpcionCorrecta() {
        falso = new OpcionIncorrecta();
        verdadero = new OpcionCorrecta();
        this.aniadirOpciones();
    }

    private void aniadirOpciones() {
        opcionesDisponibles.add(verdadero);
        opcionesDisponibles.add(falso);
    }

    public void falsoOpcionCorrecta() {
        falso = new OpcionCorrecta();
        verdadero = new OpcionIncorrecta();
        this.aniadirOpciones();
    }

    public void evaluarRespuestasFinales(ArrayList respuestasDeJugadores) {
        Respuesta respuesta;
        for(int i=0;i< respuestasDeJugadores.size();i++){
            respuesta = (Respuesta) respuestasDeJugadores.get(i);
            respuesta.otorgarPuntos(opcionesDisponibles);
        }
    }

    public String getNombrePregunta() { return nombre; }

    public Opcion getOpcionVerdadero() { return verdadero; }

    public Opcion getOpcionFalso() { return falso; }

    public ArrayList getOpcionesDisponibles() { return opcionesDisponibles; }

}

