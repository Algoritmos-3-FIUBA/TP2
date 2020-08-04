package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorDefault;
import edu.fiuba.algo3.modelo.opcion.Opcion;

public class RespuestaVerdaderoFalsoPenalidad{

    private Opcion opcion;
    private Jugador jugador;
    private Multiplicador multiplicador;

    public RespuestaVerdaderoFalsoPenalidad (Opcion opcion, Multiplicador multiplicador) {
        this.opcion = opcion;
        this.multiplicador = multiplicador;
    }

    public RespuestaVerdaderoFalsoPenalidad (Opcion opcion, Jugador jugador) {
        this.opcion = opcion;
        this.jugador = jugador;
        this.multiplicador = new MultiplicadorDefault(jugador);
    }

    public void otorgarPuntos() {
        multiplicador.utilizarBeneficio(opcion.puntosObtenidos());
    }

}
