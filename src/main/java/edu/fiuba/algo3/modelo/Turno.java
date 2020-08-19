package edu.fiuba.algo3.modelo;

import java.io.IOException;

import static edu.fiuba.algo3.modelo.Kahoot.actualizarEscena;

public abstract class Turno {
    protected String plantilla;
    
    public void mostrarEscena() throws IOException {
        this.actualizarPlantilla();
        actualizarEscena(plantilla);
    }

    protected abstract void actualizarPlantilla();
}
