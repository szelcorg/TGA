package org.szelc.tga.app;


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
import org.jxmapviewer.viewer.GeoPosition;
import org.szelc.fit.garmin.FitReadListener;
import org.szelc.fit.training.Training;
import org.szelc.log.LOG;
import org.szelc.map.Map;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author by marcin.szelc on 2017-12-08.
 */
public class Main extends Application implements FitLoaderListener{
    Pane rootPane;
    private Stage stage;
    private final double MINIMUM_WINDOW_WIDTH = 390.0;
    private final double MINIMUM_WINDOW_HEIGHT = 500.0;
    JPanel mapPanel = new JPanel();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(Main.class, (String[]) null);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {



        StackPane swingPane = new StackPane();
        swingPane.setMinSize(1900,950);


        LOG.i("Start");
        try {
            stage = primaryStage;
            stage.setTitle("Training GPS Analyzer");
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            gotoAntStockMainView();
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        addMapTab();

    }


    private void gotoAntStockMainView() {
        try {
            replaceSceneContent("TGA.fxml");

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();

        System.out.println("Load main resource [" + fxml + "]");

        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));

        try {
            rootPane = (Pane) loader.load(in);
        } finally {
            //in.close();
        }

        Scene scene = new Scene(rootPane, 1000, 800);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }

    private void createSwingContent(final SwingNode swingNode, JPanel panel) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                swingNode.setContent(panel);
            }
        });
    }


    public void addMapTab(){

        final SwingNode swingNode = new SwingNode();
        StackPane swingStackPane = new StackPane();
        JPanel testPane = new JPanel();
        testPane.setSize(new Dimension(1000, 800));
        testPane.add(new JButton("adjajsdk"));
        createSwingContent(swingNode, mapPanel);
        // createSwingContent(swingNode, testPane);
        swingStackPane.getChildren().add(swingNode);

        Tab tabMap = new Tab();
        tabMap.setText("Map");
        tabMap.setContent(swingStackPane);

        TabPane tabPane = (TabPane)rootPane.getChildren().get(0);
        tabPane.getTabs().add(tabMap);

        tabPane.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                LOG.i("NEW VALUE ["+newValue+"]");
                if(newValue.toString().equals("2")){
                    loadPoint();
                    LOG.i("Selected");
                }
            }
        });
    }

    public void loadPoint(){
        FitReadListener fitReadListener = new FitReadListener();
        fitReadListener.addListener(this);
        FitParser fit = new FitParser(fitReadListener);
    }


    @Override
    public void loaded(Training training) {
        Map map = new Map();
        JPanel p = map.finishLoadPoint(training.getRoutePoint(), training.getWayPoint());

        mapPanel.setBackground(Color.RED);
        mapPanel.setLayout(new BorderLayout());
        p.setMinimumSize(new Dimension(800, 600));
        mapPanel.add(p, BorderLayout.CENTER);

        //training.displayWayPoint();

        training.displayRoutePoint();
    }
}
