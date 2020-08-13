package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonResponderFalso;
import edu.fiuba.algo3.controlador.BotonResponderVerdadero;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PreguntaVoF {

    private static final int ANCHO = 800;
    private static final int ALTO = 500;

    public PreguntaVoF(){
        Stage stage = new Stage();

        VBox box = new VBox();
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER);

        Label jugadorlabel = new Label("Jugador: 1");
        jugadorlabel.setTextFill(Color.web("#FFF"));


        Label label = new Label("¿1 + 1 = 2?"); //Leerá de un JSON.
        label.setTextFill(Color.web("#FFF"));

        Button verdadero = new Button();
        verdadero.setText("Verdadero");

        BotonResponderVerdadero botonResponderVerdadero = new BotonResponderVerdadero(stage);
        verdadero.setOnAction(botonResponderVerdadero);


        verdadero.setPrefHeight(40);
        verdadero.setPrefWidth(100);
        verdadero.setDefaultButton(true);


        Button falso = new Button();
        falso.setText("Falso");


        falso.setPrefHeight(40);
        falso.setPrefWidth(100);
        falso.setDefaultButton(true);


        BotonResponderFalso botonResponderFalso = new BotonResponderFalso(stage);
        verdadero.setOnAction(botonResponderFalso);

        box.getChildren().add(jugadorlabel);
        box.getChildren().add(label);
        box.getChildren().add(verdadero);
        box.getChildren().add(falso);


        BackgroundFill fondo = new BackgroundFill(Color.BLUEVIOLET, new CornerRadii(1),  null);


        box.setBackground(new Background(fondo));



        Scene scene = new Scene(box, ANCHO, ALTO);

        stage.setScene(scene);
        stage.show();
    }


}
