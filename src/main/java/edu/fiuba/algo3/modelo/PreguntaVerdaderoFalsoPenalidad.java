package edu.fiuba.algo3.modelo;

public class PreguntaVerdaderoFalsoPenalidad extends PreguntaVerdaderoFalso{

    private Opcion opcionVerdadero;
    private Opcion opcionFalso;

    public PreguntaVerdaderoFalsoPenalidad(String nombrePregunta){ super(nombrePregunta); }

    @Override
    public void setVerdaderoOpcionCorrecta() {

        opcionFalso = new OpcionIncorrecta("Falso", -1);
        opcionVerdadero = new OpcionCorrecta("Verdadero", 1);

    }

    @Override
    public void setFalsoOpcionCorrecta() {

        opcionFalso = new OpcionCorrecta("Falso",1);
        opcionVerdadero = new OpcionIncorrecta("Verdadero",-1);

    }

    public Opcion getOpcionVerdadera() { return opcionVerdadero; }

    public Opcion getOpcionFalsa() { return opcionFalso; }


}
