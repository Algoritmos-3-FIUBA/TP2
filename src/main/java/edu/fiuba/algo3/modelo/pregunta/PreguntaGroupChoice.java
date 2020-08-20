package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.excepciones.MasDeSeisOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGrupos;

import java.util.LinkedList;

public class PreguntaGroupChoice extends Pregunta{

    private final Puntos PuntosOtorgados;
    private final LinkedList<ColeccionOpciones> gruposCorrectos;

    public PreguntaGroupChoice(String nombre, int puntos, LinkedList<ColeccionOpciones> gruposCorrectos) {

        this.chequearQueHayaOpciones(gruposCorrectos);
        this.chequearQueNoHayaMasDeSeisOpciones(gruposCorrectos);

        this.nombre = nombre;

        PuntosOtorgados = new Puntos(puntos);

        this.gruposCorrectos = gruposCorrectos;
    }

    private void chequearQueHayaOpciones(LinkedList<ColeccionOpciones> gruposCorrectos) {
        if(gruposCorrectos.size() == 0)
            throw new NoHayOpcionesException();
    }

    private void chequearQueNoHayaMasDeSeisOpciones(LinkedList<ColeccionOpciones> gruposCorrectos) {
        int cantidadOpcionesTotales = 0;
        for(ColeccionOpciones grupo : gruposCorrectos)
            cantidadOpcionesTotales += grupo.cantidadElementos();
        if(cantidadOpcionesTotales > 6)
            throw new MasDeSeisOpcionesException();
        if(cantidadOpcionesTotales == 0)
            throw new NoHayOpcionesException();

    }

    /*public void evaluarRespuestas(LinkedList<Respuesta> respuestas) {
        corregirRespuestas(respuestas);

        for (Respuesta respuesta : respuestas) {
            respuesta.actualizarCondicionDeUsoExclusividad(respuestas);
            respuesta.calcularAmplificacionExclusividad(respuestas);
        }

        for (Respuesta respuesta : respuestas)
            respuesta.establecerAmplificadorAdecuado();

        for (Respuesta respuesta : respuestas) {
            respuesta.otorgarPuntos(puntosAOtorgar(respuesta));
        }
    }*/

    @Override
    public ColeccionOpciones getOpciones() {
        return null;
    }

    @Override
    public void sumarPuntosJugadores(LinkedList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.otorgarPuntos(puntosAOtorgar(respuesta));
        }
    }

    @Override
    public void corregirRespuestas(LinkedList<Respuesta> respuestas){
        for (Respuesta respuesta : respuestas)
            for (int i = 0; i < gruposCorrectos.size(); i++)
                if (((RespuestaGrupos) respuesta).getGruposElegidos().get(i).tieneMismosElementos(gruposCorrectos.get(i)))
                    respuesta.setCorrecta();
    }


    private Puntos puntosAOtorgar(Respuesta respuesta){
        Puntos puntosParciales = new Puntos(0);
        for (int i = 0; i < gruposCorrectos.size(); i++)
            if (((RespuestaGrupos) respuesta).getGruposElegidos().get(i).tieneMismosElementos(gruposCorrectos.get(i)))
                puntosParciales.sumarPuntos(PuntosOtorgados);
        return puntosParciales;
    }

}