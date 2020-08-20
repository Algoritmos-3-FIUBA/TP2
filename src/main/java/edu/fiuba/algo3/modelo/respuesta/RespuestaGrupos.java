package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.excepciones.MasDeSeisOpcionesException;

import java.util.LinkedList;

public class RespuestaGrupos extends Respuesta{

    private LinkedList<ColeccionOpciones> gruposElegidos;

    public RespuestaGrupos (LinkedList<ColeccionOpciones> gruposElegidos, Jugador jugador) {
        super(jugador);
        this.gruposElegidos = gruposElegidos;
        verificarGrupo(gruposElegidos);
    }

    public RespuestaGrupos (LinkedList<ColeccionOpciones> gruposElegidos, Jugador jugador, Exclusividad exclusividad) {
        super(jugador, exclusividad);
        this.gruposElegidos = gruposElegidos;
        verificarGrupo(gruposElegidos);
    }

    public LinkedList<ColeccionOpciones> getGruposElegidos(){
        return gruposElegidos;
    }

    private void verificarGrupo(LinkedList<ColeccionOpciones> gruposElegidos){
        for (ColeccionOpciones opcionesGrupo: gruposElegidos){
            if(opcionesGrupo.cantidadElementos() > 6) {
                throw new MasDeSeisOpcionesException();
            }
        }
    }
}