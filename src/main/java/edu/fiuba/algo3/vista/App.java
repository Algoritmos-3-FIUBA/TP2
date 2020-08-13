package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonInicioJuego;
import javafx.application.Application;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Kahoot!");

        GridPane gridPane = crearFormularioInicial();
        agregarControlesInterfaz(gridPane);

        Scene scene = new Scene(gridPane, 800, 500);

        primaryStage.setScene(scene);

        primaryStage.show();
    }


    private GridPane crearFormularioInicial() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }


    private void agregarControlesInterfaz(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("Jugadores:");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label jugador1label = new Label("1°Jugador: ");
        gridPane.add(jugador1label, 0,1);

        // Add Jugador 1 Text Field
        TextField jugador1 = new TextField();
        jugador1.setPrefHeight(40);
        gridPane.add(jugador1, 1,1);


        // Add Jugador 2 Label
        Label jugador2label = new Label("2°Jugador: ");
        gridPane.add(jugador2label, 0, 2);

        // Add Jugador 2 Text Field
        TextField jugador2 = new TextField();
        jugador2.setPrefHeight(40);
        gridPane.add(jugador2, 1, 2);

        // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        BotonInicioJuego botonInicioJuego = new BotonInicioJuego(jugador1,jugador2,gridPane); // no deberia ir App es solo para probar. Nuevo

        submitButton.setOnAction(botonInicioJuego);//Nuevo

        /*submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(jugador1.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Por favor ingrese el nombre del primer jugador");
                    return;
                }
                if(jugador2.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Por favor ingrese el nombre del segundo jugador");
                    return;
                }

                showLoginScreen();
           //     showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Bienvenidos!", "Bienvenidos " + jugador1.getText() + " y " + jugador2.getText() );
            }
        });*/
    }
/*
    public void showLoginScreen() {
        Stage stage = new Stage();

        VBox box = new VBox();
        box.setPadding(new Insets(10));

        // How to center align content in a layout manager in JavaFX
        box.setAlignment(Pos.CENTER);

        Label label = new Label("¿1 + 1=2?");

        /*
        TextField textUser = new TextField();
        textUser.setPromptText("enter user name");
        TextField textPass = new TextField();
        textPass.setPromptText("enter password");

        Button verdadero = new Button();
        verdadero.setText("Verdadero");

        verdadero.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // Assume success always!
                stage.close(); // return to main window
            }
        });

        Button falso = new Button();
        falso.setText("Falso");

        falso.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // Assume success always!
                stage.close(); // return to main window
            }
        });
        box.getChildren().add(label);
        box.getChildren().add(verdadero);
        box.getChildren().add(falso);

        Scene scene = new Scene(box, 250, 150);
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }*/

    public static void main(String[] args) {
        launch(args);
    }
}