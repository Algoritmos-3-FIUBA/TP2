package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.amplificador.Amplificador;

public abstract class EstadoRespuesta {
    public abstract void actualizarEstadoAmplificador(Amplificador amplificadorFinal);

    public abstract void otorgarPuntos(Puntos puntosOtorgados, Jugador jugador);
}
