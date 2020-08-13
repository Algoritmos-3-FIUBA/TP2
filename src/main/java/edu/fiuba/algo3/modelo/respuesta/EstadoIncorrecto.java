package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.amplificador.Amplificador;

public class EstadoIncorrecto extends EstadoRespuesta{
    @Override
    public void actualizarEstadoAmplificador(Amplificador amplificadorFinal){   }

    @Override
    public void otorgarPuntos(Puntos puntosOtorgados, Jugador jugador) {
        jugador.sumarPuntos(new Puntos(0));
    }
}
