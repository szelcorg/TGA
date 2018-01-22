package org.szelc.tga.fxml.component;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import org.szelc.fit.training.SummaryLapTraining;
import org.szelc.log.LOG;

import java.io.IOException;

public class TrainingSummaryComponent extends AnchorPane {
    private static final String FXML_FILE_COMPONENT = "/org/szelc/tga/fxml/summary/TrainingSummaryComponent.fxml";
    public TrainingSummaryComponent() {
        loadComponent();
    }

    @FXML
    private Label dateTrainingLbl;

    public void setItems(ObservableList<SummaryLapTraining> items) {

    }

    private void loadComponent() {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource(FXML_FILE_COMPONENT));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);

        }

        dateTrainingLbl.setText("ZMieniony");
    }


}
