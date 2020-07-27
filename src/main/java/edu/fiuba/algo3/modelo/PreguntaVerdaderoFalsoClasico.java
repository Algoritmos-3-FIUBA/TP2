package edu.fiuba.algo3.modelo;

public class PreguntaVerdaderoFalsoClasico extends PreguntaVerdaderoFalso {

    private Opcion opcionVerdadero;
    private Opcion opcionFalso;

    public PreguntaVerdaderoFalsoClasico(String nombrePregunta) {
        super(nombrePregunta);
    }

    @Override
    public void setVerdaderoOpcionCorrecta() {

        opcionFalso = new OpcionIncorrecta("Falso", 0);
        opcionVerdadero = new OpcionCorrecta("Verdadero", 1);

    }

    @Override
    public void setfalsoOpcionCorrecta() {

        opcionFalso = new OpcionCorrecta("Falso",1);
        opcionVerdadero = new OpcionIncorrecta("Verdadero",0);

    }

    public Opcion getOpcionVerdadera() { return opcionVerdadero; }

    public Opcion getOpcionFalsa() { return opcionFalso; }


}
