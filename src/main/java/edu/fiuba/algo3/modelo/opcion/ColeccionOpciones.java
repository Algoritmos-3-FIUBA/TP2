package edu.fiuba.algo3.modelo.opcion;

import java.util.HashSet;
import java.util.LinkedList;

public class ColeccionOpciones {

    private final LinkedList<Opcion> opciones;
    private String nombre;

    public ColeccionOpciones() {
        this.opciones = new LinkedList<>();
    }

    public ColeccionOpciones(LinkedList<Opcion> opciones) {
        this.opciones = opciones;
    }

    public ColeccionOpciones(String nombre) {
        this.opciones = new LinkedList<>();
        this.nombre = nombre;
    }

    public ColeccionOpciones(LinkedList<Opcion> opciones,String nombre) {
        this.opciones = opciones;
        this.nombre = nombre;
    }

    public void agregarOpcion(Opcion opcion) {
        this.opciones.add(opcion);
    }

    public boolean esIgual(ColeccionOpciones otraColeccionOpciones) {
        return(otraColeccionOpciones.esIgual(opciones));
    }

    private boolean esIgual(LinkedList<Opcion> opciones){
        return this.opciones.equals(opciones);
    }

    public boolean tieneMismosElementos(ColeccionOpciones otraColeccionOpciones) {
        return(otraColeccionOpciones.esIgual(new HashSet<Opcion>(opciones)));
    }

    private boolean esIgual(HashSet<Opcion> opciones){
        return new HashSet<Opcion>(this.opciones).equals(opciones);
    }

    public boolean tieneElementos(ColeccionOpciones otraColeccionOpciones){
        return otraColeccionOpciones.tieneElementos(this.opciones);
    }

    private boolean tieneElementos(LinkedList<Opcion> opciones){
        LinkedList<Opcion> interseccion = new LinkedList<>(this.opciones);
        interseccion.retainAll(opciones);
        return(!interseccion.isEmpty());
    }

    public void separarEnGruposCorrespondientes(ColeccionOpciones opcionesCorrectas, ColeccionOpciones opcionesIncorrectas) {
        for(Opcion opcion : opciones)
            opcion.agregarseAlGrupoCorrespondiente(opcionesCorrectas,opcionesIncorrectas);
    }

    public LinkedList<Opcion> getOpciones(){
        return opciones;
    }

    public boolean contiene(Opcion opcion){
        return opciones.contains(opcion);
    }

    public int cantidadElementos(){
        return opciones.size();
    }

    public String getNombre() {
        if(nombre == null)
            return null;
        return nombre;
    }
}
