package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.net.MalformedURLException;

import static edu.fiuba.algo3.modelo.Kahoot.actualizarEscena;

public abstract class Turno {
    protected String plantilla;
    
    public void mostrarEscena() throws IOException {
        actualizarEscena(plantilla);
        this.actualizarPlantilla();
    }

    protected abstract void actualizarPlantilla() throws MalformedURLException, IOException;
}
