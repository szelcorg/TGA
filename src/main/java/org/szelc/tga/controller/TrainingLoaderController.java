package org.szelc.tga.controller;

import org.szelc.fit.controller.FitLoaderListener;
import org.szelc.fit.garmin.FitParser;
import org.szelc.fit.garmin.FitReadListener;
import org.szelc.fit.training.Training;
import org.szelc.log.LOG;

public class TrainingLoaderController{

    private void loadFromFile(String path){
    }


    public void loaded(Training training) {

    }

    public static void loadTraining(FitLoaderListener listener){
        LOG.i("Start loading training");
        FitReadListener fitReadListener = new FitReadListener();
        fitReadListener.addListener(listener);
        FitParser fit = new FitParser(fitReadListener);
    }
}
