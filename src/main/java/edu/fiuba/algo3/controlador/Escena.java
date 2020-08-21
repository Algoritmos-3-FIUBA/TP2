package edu.fiuba.algo3.controlador;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.nio.file.Paths;

import static edu.fiuba.algo3.controlador.Kahoot.actualizarEscena;

public abstract class Escena {
    protected Scene escena;
    protected Controlador controlador;

    public Escena(String plantilla) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Paths.get(plantilla).toUri().toURL());
        Parent root = fxmlLoader.load();
        this.escena = new Scene(root);
        this.controlador = fxmlLoader.getController();
    }

    public void mostrarEscena() throws IOException {
        this.actualizarPlantilla();
        actualizarEscena(escena);
    }

    protected abstract void actualizarPlantilla() throws IOException;
}
