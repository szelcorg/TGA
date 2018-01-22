package org.szelc.tga.fxml.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.szelc.fit.controller.FitLoaderListener;
import org.szelc.tga.fxml.component.TrainingSummaryComponent;

import java.net.URL;
import java.util.ResourceBundle;

public class TrainingSummaryViewController implements Initializable {
    @FXML
    TrainingSummaryComponent trainingSummaryComponent;
    @FXML
    Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //trainingSummaryComponent.getDateTrainingLbl().setText("Zmieniony");
    }


}
