package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.excepciones.MasDeSeisOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
import edu.fiuba.algo3.modelo.opcion.Opcion;

import java.util.LinkedList;

public class RespuestaGrupos extends Respuesta{

    private LinkedList<ColeccionOpciones> gruposElegidos;

    public RespuestaGrupos (LinkedList<ColeccionOpciones> gruposElegidos, Jugador jugador) {
        super(jugador);
        this.gruposElegidos = gruposElegidos;
        verificarGrupo(gruposElegidos);
    }

    public LinkedList<ColeccionOpciones> getGruposElegidos(){
        return gruposElegidos;
    }

    private void verificarGrupo(LinkedList<ColeccionOpciones> gruposElegidos){
        if(gruposElegidos == null || gruposElegidos.size() == 0) {
            throw new NoHayOpcionesException();
        }

        for (ColeccionOpciones opcionesGrupo: gruposElegidos){
            if(opcionesGrupo.cantidadElementos() == 0) {
                throw new NoHayOpcionesException();
            }

            if(opcionesGrupo.cantidadElementos() > 6) {
                throw new MasDeSeisOpcionesException();
            }
        }
    }
}