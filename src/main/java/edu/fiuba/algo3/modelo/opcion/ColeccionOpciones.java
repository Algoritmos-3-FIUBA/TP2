package edu.fiuba.algo3.modelo.opcion;

import java.util.HashSet;
import java.util.LinkedList;

public class ColeccionOpciones {

    private final LinkedList<Opcion> opciones;

    public ColeccionOpciones() {
        this.opciones = new LinkedList<>();
    }

    public ColeccionOpciones(LinkedList<Opcion> opciones) {
        this.opciones = opciones;
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

    //VersionAnterior
    /*
    private String Nombre;
    HashSet<OpcionCorrecta> opcionesDelGrupo = new HashSet<OpcionCorrecta>();

    public Grupo(String nombre) {
        Nombre = nombre;
    }

    public void agregarOpcion(OpcionCorrecta opcionesDelGrupo) {
        this.opcionesDelGrupo.add(opcionesDelGrupo);
    }

    public Puntos evaluarGrupo(HashSet<OpcionCorrecta> opcionesElegidasDelGrupo, Puntos cantidadDePuntos) {
        Puntos puntosAsignar = new Puntos(0);
        if (opcionesElegidasDelGrupo.equals(opcionesDelGrupo)){
            puntosAsignar = cantidadDePuntos;
        }
        return(puntosAsignar);
    }

    public HashSet<OpcionCorrecta> getOpcionesDelGrupo(){
        return opcionesDelGrupo;
    } */
}
