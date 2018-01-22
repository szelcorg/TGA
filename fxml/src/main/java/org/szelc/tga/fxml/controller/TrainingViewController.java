package org.szelc.tga.fxml.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.szelc.fit.controller.FitLoaderListener;
import org.szelc.fit.training.SummaryLapTraining;
import org.szelc.fit.training.Training;
import org.szelc.log.LOG;
import org.szelc.tga.fxml.component.TrainingGrid;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author by marcin.szelc on 2017-12-08.
 */
public class TrainingViewController implements Initializable, FitLoaderListener {

    private ObservableList<SummaryLapTraining> trainingListObs = null;
    @FXML
    TrainingGrid trainingGrid;

    @FXML
    Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       TrainingLoaderController.loadTraining(this);
    }

    public List<SummaryLapTraining> getSummaryLapTraining(Training training){
        return training.getSummaryLapTrainingList();
    }

    @Override
    public void loaded(Training training) {
        LOG.i("Loaded fit file");
        trainingListObs = FXCollections.observableArrayList(
                getSummaryLapTraining(training)
        );
        trainingGrid.setItems(trainingListObs);
    }
}
