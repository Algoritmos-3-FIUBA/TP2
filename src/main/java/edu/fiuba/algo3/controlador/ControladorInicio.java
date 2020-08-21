package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.App;
import edu.fiuba.algo3.vista.FormularioInicial;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class ControladorInicio {
    @FXML
    public Button botoninicio;

    private static final int ANCHO = 790;
    private static final int ALTO = 549;

    public void comenzar(ActionEvent actionEvent) {
        FormularioInicial formularioInicial = new FormularioInicial() ;
        formularioInicial.agregarControlesInterfaz(App.escenario);
        Scene scene = new Scene(formularioInicial, ANCHO, ALTO);
        App.escenario.setScene(scene);
        App.escenario.setResizable(true);
        App.escenario.show();
    }
}
