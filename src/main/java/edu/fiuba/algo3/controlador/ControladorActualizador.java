package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.exclusividad.ExclusividadDefault;
import edu.fiuba.algo3.modelo.multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicador.MultiplicadorDefault;
import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.respuesta.RespuestaGrupos;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultiple;
import edu.fiuba.algo3.modelo.respuesta.RespuestaUnica;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.LinkedList;

public class ControladorActualizador {
    private final Pregunta pregunta;
    private final Jugador jugador;
    private final EscenaJugador escenaActual;
    private LinkedList<Opcion> opcionesSeleccionadas = new LinkedList<>();
    private Exclusividad exclusividad = new ExclusividadDefault();
    private Multiplicador multiplicador = new MultiplicadorDefault();
    private LinkedList<ColeccionOpciones> gruposElegidos;

    public ControladorActualizador(Pregunta pregunta, Jugador jugadorActual, EscenaJugador escenaActual) {
        this.pregunta = pregunta;
        this.jugador = jugadorActual;
        this.escenaActual = escenaActual;
    }

    public void actualizarTextosEtiquetas(Label nombrepregunta, Label tipopregunta, Label jugadoractual, Label puntosactuales) {
        nombrepregunta.setText(this.pregunta.getNombre());
        tipopregunta.setText(this.pregunta.getClass().getSimpleName().replaceAll("(.)([A-Z])", "$1 $2"));
        jugadoractual.setText(this.jugador.getNombre());
        puntosactuales.setText(String.valueOf(this.jugador.getPuntos().cantidad));
    }

    public void actualizarPlantillaVerdaderoFalsoClasico(LinkedList<RadioButton> cajasOpcionesMostradas, Button botonexclusivdad) {

        //actualizarTextosEtiquetas(nombrepregunta,tipopregunta,jugadoractual,puntosactuales)
        for(RadioButton opcion : cajasOpcionesMostradas)
            opcion.setSelected(false);

        if(jugador.getExclusividades().size() == 0) botonexclusivdad.setDisable(true);
        else botonexclusivdad.setDisable(false);

        opcionesSeleccionadas = new LinkedList<>();

        for (int i = 0; i < pregunta.getColeccionDeOpciones().cantidadElementos(); i++) {
            cajasOpcionesMostradas.get(i).setOnAction(new SeleccionarRadioButtonHandler(pregunta.getColeccionDeOpciones().getOpciones().get(i), opcionesSeleccionadas));
        }
    }
    public void actualizarPlantillaVerdaderoFalsoPenalidad(LinkedList<RadioButton> cajasOpcionesMostradas, LinkedList<Button> cajasMultiplicadores){
        for(RadioButton opcion : cajasOpcionesMostradas)
            opcion.setSelected(false);

        for(Button multiplicador : cajasMultiplicadores)
            multiplicador.setDisable(false);

        if(jugador.cantidadMultiplicadoresPor2() == 0) cajasMultiplicadores.getFirst().setDisable(true);
        if(jugador.cantidadMultiplicadoresPor3() == 0) cajasMultiplicadores.getLast().setDisable(true);

        opcionesSeleccionadas = new LinkedList<>();

        for (int i = 0; i < pregunta.getColeccionDeOpciones().cantidadElementos(); i++) {
            cajasOpcionesMostradas.get(i).setOnAction(new SeleccionarRadioButtonHandler(pregunta.getColeccionDeOpciones().getOpciones().get(i), opcionesSeleccionadas));
        }
    }
    public void actualizarPlantillaMultipleChoiceClasico(Button botonexclusivdad,LinkedList<CheckBox> cajasOpcionesMostradas) {
        for(CheckBox opcion : cajasOpcionesMostradas)
            opcion.setSelected(false);

        if(jugador.getExclusividades().size() == 0) botonexclusivdad.setDisable(true);
        else botonexclusivdad.setDisable(false);

        opcionesSeleccionadas = new LinkedList<>();

        for (int i = 0; i < pregunta.getColeccionDeOpciones().cantidadElementos(); i++) {
            cajasOpcionesMostradas.get(i).setOnAction(new SeleccionarCheckBoxMultipleChoiceHandler(pregunta.getColeccionDeOpciones().getOpciones().get(i), opcionesSeleccionadas));
            cajasOpcionesMostradas.get(i).setText(pregunta.getColeccionDeOpciones().getOpciones().get(i).getNombre());
        }
    }

    public void actualizarPlantillaOrderedChoice(LinkedList<Button> opcionesMostradas, Button botonexclusividad, LinkedList<Label> ordenMostrado) {
        System.out.println("Hola jeje");

        opcionesSeleccionadas = new LinkedList<>();

        botonexclusividad.setDisable(jugador.getExclusividades().size() == 0);


        for (int i = 0; i < pregunta.getColeccionDeOpciones().cantidadElementos(); i++) {
            opcionesMostradas.get(i).setText(pregunta.getColeccionDeOpciones().getOpciones().get(i).getNombre());
            opcionesMostradas.get(i).setOnAction(new SeleccionarCheckBoxOrderedChoiceHandler(pregunta.getColeccionDeOpciones().getOpciones().get(i), opcionesSeleccionadas,this,ordenMostrado));
        }
    }

    public void actualizarPlantillaMultipleChoicePenalidad(LinkedList<Button> cajasMultiplicadores, LinkedList<CheckBox> cajasOpcionesMostradas) {
        for(CheckBox opcion : cajasOpcionesMostradas)
            opcion.setSelected(false);

        for(Button multiplicador : cajasMultiplicadores)
            multiplicador.setDisable(false);

        if(jugador.cantidadMultiplicadoresPor2() == 0) cajasMultiplicadores.getFirst().setDisable(true);
        if(jugador.cantidadMultiplicadoresPor3() == 0) cajasMultiplicadores.getLast().setDisable(true);

        opcionesSeleccionadas = new LinkedList<>();

        for (int i = 0; i < pregunta.getColeccionDeOpciones().cantidadElementos(); i++) {
            cajasOpcionesMostradas.get(i).setOnAction(new SeleccionarCheckBoxMultipleChoiceHandler(pregunta.getColeccionDeOpciones().getOpciones().get(i), opcionesSeleccionadas));
            cajasOpcionesMostradas.get(i).setText(pregunta.getColeccionDeOpciones().getOpciones().get(i).getNombre());
        }
    }

    public void siguenteTurnoVoFPenalidad() {
        try{
            this.escenaActual.siguienteJugador(new RespuestaUnica(opcionesSeleccionadas.removeFirst(),jugador,multiplicador));
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!");
            alert.setHeaderText("No has elegido ninguna respuesta");
            alert.setContentText("Por favor, elegí una y volvé a intentar.");
            alert.showAndWait();
        }
    }

    public void asignarExclusividad(Button botonexclusivdad) {
        if(jugador.getExclusividades().size() != 0) this.exclusividad = jugador.usarExclusividad();
        botonexclusivdad.setDisable(true);
    }

    public void siguenteTurnoVoF() {
        try{
            this.escenaActual.siguienteJugador(new RespuestaUnica(opcionesSeleccionadas.removeFirst(), jugador, exclusividad));
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!");
            alert.setHeaderText("No has elegido ninguna respuesta");
            alert.setContentText("Por favor, elegí una y volvé a intentar.");
            alert.showAndWait();
        }
    }

    public void asignarMultiplicadoex2(Button multiplicadorx2, Button multiplicadorx3) {
        if(jugador.cantidadMultiplicadoresPor2() != 0) multiplicador = jugador.usarMultiplicadorPorDos();
        multiplicadorx2.setDisable(true);
        multiplicadorx3.setDisable(true);
    }

    public void asignarMultiplicadoex3(Button multiplicadorx2, Button multiplicadorx3) {
        if(jugador.cantidadMultiplicadoresPor3() != 0) multiplicador = jugador.usarMultiplicadorPorTres();
        multiplicadorx2.setDisable(true);
        multiplicadorx3.setDisable(true);
    }

    public void siguenteTurnoMultipleChoice() throws IOException {
        this.escenaActual.siguienteJugador(new RespuestaMultiple(opcionesSeleccionadas,jugador, exclusividad));

    }
    public void siguenteTurnoMultipleChoicePenalidad() throws IOException {
        this.escenaActual.siguienteJugador(new RespuestaMultiple(opcionesSeleccionadas,jugador, multiplicador));

    }

    public void siguenteTurnoOrderedChoice() throws IOException {
        this.escenaActual.siguienteJugador(new RespuestaMultiple(opcionesSeleccionadas,jugador, exclusividad));
    }

    public void actualizarOrden(LinkedList<Label> ordenMostrado) {
        for(Label orden : ordenMostrado)
            orden.setText("");
        for(int i = 0; i < opcionesSeleccionadas.size(); i++){
            int j = pregunta.getColeccionDeOpciones().getOpciones().indexOf(opcionesSeleccionadas.get(i));
            ordenMostrado.get(j).setText(Integer.toString(i+1));
        }
    }

    public void actualizarPlantillaGroupChoice(LinkedList<Button> opcionesMostradas, LinkedList<ComboBox> gruposMostrados, Button botonexclusivdad) {
        gruposElegidos = new LinkedList<>();

        ColeccionOpciones primerGrupo = new ColeccionOpciones(((PreguntaGroupChoice) pregunta).getNombresGrupos().get(0));
        ColeccionOpciones segundoGrupo = new ColeccionOpciones(((PreguntaGroupChoice) pregunta).getNombresGrupos().get(1));

        gruposElegidos.add(primerGrupo);
        gruposElegidos.add(segundoGrupo);

        gruposMostrados.forEach(caja -> {
            caja.setValue(null);
            caja.getItems().clear();
        });

        gruposMostrados.forEach(caja -> {
            caja.getItems().add(primerGrupo.getNombre());
            caja.getItems().add(segundoGrupo.getNombre());
        });

        if(jugador.getExclusividades().size() == 0) botonexclusivdad.setDisable(true);
        else botonexclusivdad.setDisable(false);

        for (int i = 0; i < pregunta.getColeccionDeOpciones().cantidadElementos(); i++)
            opcionesMostradas.get(i).setText(pregunta.getColeccionDeOpciones().getOpciones().get(i).getNombre());
    }

    public void armarGrupos(LinkedList<ComboBox> gruposMostrados, LinkedList<ColeccionOpciones> gruposElegidos) {
        for(ComboBox caja : gruposMostrados)
            for(ColeccionOpciones grupos: gruposElegidos)
                if(caja.getValue() == grupos.getNombre())
                    grupos.agregarOpcion(pregunta.getColeccionDeOpciones().getOpciones().get(gruposMostrados.indexOf(caja)));

    }

    public void siguenteTurnoGroupChoice() throws IOException {
        escenaActual.siguienteJugador(new RespuestaGrupos(gruposElegidos,jugador,exclusividad));

    }
}
