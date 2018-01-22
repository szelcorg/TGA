package org.szelc.fit.garmin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.szelc.fit.controller.FitLoaderListener;
import org.szelc.fit.training.Training;
import org.szelc.log.LOG;

import static org.junit.Assert.*;

public class FitReadListenerTest implements FitLoaderListener{

    long start;
    long end;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onMesg() throws Exception {
        start = System.currentTimeMillis();
        FitReadListener fit = new FitReadListener();
        fit.addListener(this);

        FitParser parser = new FitParser(fit);
    }

    @Override
    public void loaded(Training training) {
        //org.szelc.tga.fxml.training.displayDistance();
        LOG.i(""+(System.currentTimeMillis() - start));
    }
}