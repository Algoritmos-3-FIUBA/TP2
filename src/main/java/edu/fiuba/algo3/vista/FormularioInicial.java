package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonInicioJuego;
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

public class FormularioInicial extends GridPane {
    public FormularioInicial(){
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

    public void agregarControlesInterfaz(Stage escenarioInicial) {
        Label headerLabel = new Label("Jugadores:");
        headerLabel.setTextFill(Color.web("#FFF"));
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        this.add(headerLabel, 0,0,2,1);
        this.setHalignment(headerLabel, HPos.CENTER);
        this.setMargin(headerLabel, new Insets(20, 0,20,0));


        Label jugador1label = new Label("1°Jugador: ");
        jugador1label.setTextFill(Color.web("#FFF"));
        this.add(jugador1label, 0,1);

        TextField jugador1 = new TextField();
        jugador1.setPrefHeight(40);
        this.add(jugador1, 1,1);


        Label jugador2label = new Label("2°Jugador: ");
        jugador2label.setTextFill(Color.web("#FFF"));
        this.add(jugador2label, 0, 2);

        TextField jugador2 = new TextField();
        jugador2.setPrefHeight(40);

        this.add(jugador2, 1, 2);

        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        this.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        BotonInicioJuego botonInicioJuego = new BotonInicioJuego(jugador1,jugador2,this); 

        submitButton.setOnAction(botonInicioJuego);//Nuevo
    }
    
}