package org.szelc.tga.fxml.controller;



import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import org.szelc.fit.controller.FitLoaderListener;
import org.szelc.fit.training.SummaryLapTraining;
import org.szelc.fit.training.Training;
import org.szelc.tga.fxml.controller.TrainingLoaderController;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ChartViewController implements Initializable, FitLoaderListener {

    @FXML
    LineChart heartRateLineChart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TrainingLoaderController.loadTraining(this);
    }

    @Override
    public void loaded(Training training) {
        XYChart.Series series = new XYChart.Series();
        List<XYChart.Data> inner = new ArrayList<>();

        List<SummaryLapTraining> sltList = training.getSummaryLapTrainingList();
        for(SummaryLapTraining slt : sltList){
            inner.add(new XYChart.Data(slt.getStartTimeFormat(), slt.getAvgHeartRate()));
        }
        series.setData(FXCollections.observableArrayList(inner));

        heartRateLineChart.setData(FXCollections.observableArrayList(series));
    }


}
