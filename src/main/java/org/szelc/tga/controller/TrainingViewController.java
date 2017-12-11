package org.szelc.tga.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.szelc.fit.controller.FitLoaderListener;
import org.szelc.fit.garmin.FitParser;
import org.szelc.fit.garmin.FitReadListener;
import org.szelc.fit.training.SummaryLapTraining;
import org.szelc.fit.training.Training;
import org.szelc.log.LOG;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author by marcin.szelc on 2017-12-08.
 */
public class TrainingViewController implements Initializable, FitLoaderListener {

    private ObservableList<SummaryLapTraining> trainingListObs = null;
    @FXML
    TrainingGridView trainingGridView;

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
        trainingGridView.setItems(trainingListObs);
    }
}
