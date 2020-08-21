package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.Puntos;
import edu.fiuba.algo3.modelo.excepciones.MasDeSeisOpcionesException;
import edu.fiuba.algo3.modelo.excepciones.NoHayOpcionesException;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGrupos;
import java.util.LinkedList;

public class PreguntaGroupChoice extends Pregunta{

    private final Puntos PuntosOtorgados;
    private final LinkedList<ColeccionOpciones> gruposCorrectos;
    private final ColeccionOpciones opciones;

    public PreguntaGroupChoice(String nombre, int puntos, LinkedList<ColeccionOpciones> gruposCorrectos) {

        this.chequearQueHayaGrupos(gruposCorrectos);
        this.chequearQueHayaCantidadDeOpcionesAdecuadas(gruposCorrectos);

        this.nombre = nombre;

        PuntosOtorgados = new Puntos(puntos);

        this.gruposCorrectos = gruposCorrectos;

        this.opciones = new ColeccionOpciones();
        for(ColeccionOpciones coleccion : gruposCorrectos)
            for(Opcion opcion : coleccion.getOpciones())
                this.opciones.agregarOpcion(opcion);
        this.opciones.mezclar();
    }

    private void chequearQueHayaGrupos(LinkedList<ColeccionOpciones> gruposCorrectos) {
        if(gruposCorrectos.size() == 0)
            throw new NoHayOpcionesException();
    }

    private void chequearQueHayaCantidadDeOpcionesAdecuadas(LinkedList<ColeccionOpciones> gruposCorrectos) {
        int cantidadOpcionesTotales = 0;
        for(ColeccionOpciones grupo : gruposCorrectos)
            cantidadOpcionesTotales += grupo.cantidadElementos();
        if(cantidadOpcionesTotales > 6)
            throw new MasDeSeisOpcionesException();
        if(cantidadOpcionesTotales == 0)
            throw new NoHayOpcionesException();
    }

    @Override
    public ColeccionOpciones getColeccionDeOpciones() {
        return opciones;
    }

    public LinkedList<String> getNombresGrupos() {
        LinkedList<String> nombres = new LinkedList<>();
        for(ColeccionOpciones grupo : gruposCorrectos)
            if(grupo.getNombre() != null)
                nombres.add(grupo.getNombre());
        return nombres;
    }

    @Override
    public void sumarPuntosJugadores(LinkedList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas)
            respuesta.otorgarPuntos(puntosAOtorgar(respuesta));
    }

    @Override
    public void corregirRespuestas(LinkedList<Respuesta> respuestas){
        for (Respuesta respuesta : respuestas)
            for (int i = 0; i < gruposCorrectos.size(); i++)
                if (((RespuestaGrupos) respuesta).getGruposElegidos().get(i).tieneMismosElementos(gruposCorrectos.get(i)))
                    respuesta.esCorrecta();
    }

    private Puntos puntosAOtorgar(Respuesta respuesta){
        Puntos puntosParciales = new Puntos(0);
        for (int i = 0; i < gruposCorrectos.size(); i++)
            if (((RespuestaGrupos) respuesta).getGruposElegidos().get(i).tieneMismosElementos(gruposCorrectos.get(i)))
                puntosParciales.sumarPuntos(PuntosOtorgados);
        return puntosParciales;
    }

}