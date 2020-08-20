package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.controlador.Controlador;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.nio.file.Paths;

import static edu.fiuba.algo3.modelo.Kahoot.actualizarEscena;

public abstract class Turno {
    protected Scene escena;
    protected Controlador controlador;
    //protected ControladorMultipleChoiceClasico controlador;

    public Turno(String plantilla) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Paths.get(plantilla).toUri().toURL());
        Parent root = fxmlLoader.load();
        this.escena = new Scene(root);
        this.controlador = fxmlLoader.getController();
    }

    public void mostrarEscena() throws IOException {
        System.out.println("MOSTRAR ESCENA FALLA ANTES DE ACTUALIZAR ");
        this.actualizarPlantilla();
        System.out.println("MOSTRAR ESCENA FALLA DURANTE DE ACTUALIZAR ");
        actualizarEscena(escena);
        System.out.println("MOSTRAR ESCENA FALLA DESPUES DE ACTUALIZAR ");
    }

    protected abstract void actualizarPlantilla() throws IOException;
}
