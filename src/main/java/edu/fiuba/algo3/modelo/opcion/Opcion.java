package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.respuesta.EstadoRespuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;

public abstract class Opcion {

    protected String Nombre;
    protected Puntos PuntosOtorgados;

    public Opcion(String NombreOpcion){
        Nombre = NombreOpcion;
    }

    public Opcion(String NombreOpcion, int puntos){
        Nombre = NombreOpcion;
        PuntosOtorgados = new Puntos(puntos);
    }

    public Puntos puntosObtenidos(){
        return PuntosOtorgados;
    }

    public abstract void agregarseAlGrupoCorrespondiente(ColeccionOpciones opcionesCorrectas, ColeccionOpciones opcionesIncorrectas);

    public String getNombre(){
        return Nombre;
    }

    public Puntos getPuntos() {
        return PuntosOtorgados;
    }

    public abstract void corregirRespuesta(RespuestaUnica respuestaUnica);
}