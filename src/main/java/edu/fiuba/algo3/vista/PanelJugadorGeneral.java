package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonInicioJuego;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.LinkedList;

public class PanelJugadorGeneral extends GridPane {
    public PanelJugadorGeneral(){
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(40, 40, 40, 40));
        this.setHgap(10);
        this.setVgap(10);

        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        this.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        BackgroundFill fondo = new BackgroundFill(Color.BLUEVIOLET, new CornerRadii(1),  null);
        this.setBackground(new Background(fondo));
    }

    public void puntosJugadores(Stage escenarioInicial, LinkedList<Jugador> jugadores) {
        Label headerLabel = new Label("Puntación:");
        headerLabel.setTextFill(Color.web("#FFF"));
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        this.add(headerLabel, 0,0,2,1);
        this.setHalignment(headerLabel, HPos.CENTER);
        this.setMargin(headerLabel, new Insets(20, 0,20,0));


        Label jugador1label = new Label();
        jugador1label.setText(jugadores.get(0).getNombre()+":");
        jugador1label.setTextFill(Color.web("#FFF"));
        this.add(jugador1label, 0,1);

        Label jugador1Puntos = new Label();
        jugador1Puntos.setText(String.valueOf(jugadores.get(0).getPuntos().getCantidad()));
        jugador1Puntos.setTextFill(Color.web("#FFF"));
        jugador1Puntos.setPrefHeight(40);
        this.add(jugador1Puntos, 1,1);

        Label jugador2label = new Label();
        jugador2label.setText(jugadores.get(1).getNombre()+":");
        jugador2label.setTextFill(Color.web("#FFF"));
        this.add(jugador2label, 0,2);

        Label jugador2Puntos = new Label();
        jugador2Puntos.setText(String.valueOf(jugadores.get(1).getPuntos().getCantidad()));
        jugador2Puntos.setTextFill(Color.web("#FFF"));
        jugador2Puntos.setPrefHeight(40);
        this.add(jugador2Puntos, 1,2);
    }
}