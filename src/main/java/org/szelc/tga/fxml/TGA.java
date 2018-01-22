package org.szelc.tga.fxml;


import org.szelc.fit.controller.FitLoaderListener;
import org.szelc.fit.garmin.FitParser;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.szelc.fit.garmin.FitReadListener;
import org.szelc.fit.training.Training;
import org.szelc.log.LOG;
import org.szelc.map.Map;
import org.szelc.tga.fxml.app.TgaFxml;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author by marcin.szelc on 2017-12-08.
 */
public class TGA{

    public static void main(String[] args) {
        Application.launch(TgaFxml.class, (String[]) null);
    }


}
