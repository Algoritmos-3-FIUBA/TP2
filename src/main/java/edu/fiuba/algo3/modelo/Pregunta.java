package edu.fiuba.algo3.modelo;

public class Pregunta {

    private String enunciadoPregunta;

    private Opcion verdadero;
    private Opcion falso;

    public Pregunta(String enunciado,boolean opcionCorrecta){
        if(opcionCorrecta = true)
            this.verdadero = new OpcionCorrecta;
            this.falso = new OpcionIncorrecta;
        else
            this.falso = new OpcionCorrecta;
            this.verdadero = new OpcionIncorrecta;
    }
}
