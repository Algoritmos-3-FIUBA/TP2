package edu.fiuba.algo3.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

public class VerdaderoFalso {
    @FXML
    public RadioButton idverdadero;
    @FXML
    public RadioButton idfalso;

    public void setUpView() {
        idverdadero.setText("Lucas Puto verdadero");
        idfalso.setText("Lucas puto falso");
    }

}
