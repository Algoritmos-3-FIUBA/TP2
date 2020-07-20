package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

public class TestPreguntaVoFClasico {
    @Test
    public void CreoPreguntaVoFClasicoIndicoRespuestaCorrecta(){
        Jugador lucas = new Jugador("Lucas");

        Pregunta pregunta = new Pregunta("¿1+1 no es 3?",true);

        Opcion opcion = new Opcion(false);
       // Opcion opcionCorrecta = pregunta.getOpcionCorrecta();

        Respuesta respuestaJugador1 = lucas.responderPregunta(pregunta,opcion);

        ArrayList listasRespuestas = new ArrayList();

        listasRespuestas.add( respuestaJugador1 );

        pregunta.recibirRespuestas(listasRespuestas);

        assertEquals(lucas.getPuntos,0);
    }

    @Test
    public void CreoPreguntaVoFClasicoIndicoRespuestaCorrecta(){
        Jugador jugador1 = new Jugador("Pepito");
        Jugador jugador2 = new Jugador("Fonso");

        PreguntaVoFClasico pregunta = new PreguntaVoFClasicoConVCorrecto("¿El radio de la tierra es 2m?");

        //Solo para probar (luego lo enviará el panel)
        Opcion opcion1 = pregunta.getOpcionVerdadera();
        Opcion opcion2 = pregunta.getOpcionFalsa();
        //

        Opcion opcionCorrecta = pregunta.getOpcionCorrecta();

        Respuesta respuestaJugador1 = jugador1.responderPregunta(pregunta,opcion1);
        Respuesta respuestaJugador2 = jugador2.responderPregunta(pregunta,opcion2);

        ArrayList listasRespuestas = new ArrayList();

        listasRespuestas.add( respuestaJugador1 );

        pregunta.recibirRespuestas(listasRespuestas);


        /*Respuesta respuestaJugador1 = jugador1.responder(pregunta, opcion1);
        Respuesta respuestaJugador2 = jugador2.responder(pregunta, opcion2);

        ArrayList<Respuesta> listaRespuestas =  new ArrayList<>();
        listaRespuestas.add(respuestaJugador1);
        listaRespuestas.add(respuestaJugador2);
        pregunta.enviarRespuesta(listaRespuestas);*/

        assertEquals(1, jugador1.getCantidadPuntos());
        assertEquals(0, jugador2.getCantidadPuntos());

    }
}
