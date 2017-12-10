package org.szelc.fit.garmin;

import com.garmin.fit.Field;
import com.garmin.fit.Mesg;
import com.garmin.fit.MesgListener;
import org.szelc.fit.controller.FitLoaderListener;
import org.szelc.fit.listener.MainListener;
import org.jxmapviewer.viewer.GeoPosition;
import org.szelc.fit.training.RecordTraining;
import org.szelc.fit.training.SummaryLapTraining;
import org.szelc.fit.training.Training;
import org.szelc.log.LOG;

import java.util.*;

public class FitReadListener implements MesgListener {

    private Training training;

    private List<FitLoaderListener> listeners;

    public void addListener(FitLoaderListener listener) {
        listeners.add(listener);
    }


    public FitReadListener() {
        training = new Training();
        listeners = new ArrayList<>();
    }

    private void finishedLoading(Training training) {
        training.addSession();
        for (FitLoaderListener listener : listeners) {
            listener.loaded(training);
        }
    }

    private void addRecord(Mesg mesg) {

        Iterator<Field> it = mesg.getFields().iterator();
        Map fm = new HashMap<>();
        while (it.hasNext()) {
            FitField f = new FitField(it.next());
            LOG.d(f.getName());
            fm.put(f.getName(), f.getValue());
        }
        RecordTraining rec = new RecordTraining((long) fm.get("timestamp"),
                fm.get("position_lat")==null ? -1 : (int) fm.get("position_lat"),
                fm.get("position_long")==null ? -1 : (int) fm.get("position_long"),
                fm.get("distance")==null ? -1 : (double)fm.get("distance"),
                (double) fm.get("altitude"),
                fm.get("speed")==null ? -1 : (double) fm.get("speed"),
                (short) fm.get("heart_rate"),
                (double) fm.get("enhanced_altitude"),
                fm.get("enhanced_speed") == null ? -1 : (double) fm.get("enhanced_speed"));
        training.addRecord(rec);
    }

    private void addLap(Mesg mesg) {
        Iterator<Field> it = mesg.getFields().iterator();
        Map fm = new HashMap<>();
        while (it.hasNext()) {
            FitField f = new FitField(it.next());
            LOG.d(""+f.getName());
            fm.put(f.getName(), f.getValue());
        }

        SummaryLapTraining lap = new SummaryLapTraining((long) fm.get("timestamp"),
                (int)fm.get("start_position_lat"),(int)fm.get("start_position_long"),
                (int)fm.get("end_position_lat"),(int)fm.get("end_position_long"),
                (long) fm.get("start_time"),
                (double) fm.get("total_elapsed_time"),
                (double) fm.get("total_timer_time"), (double) fm.get("total_distance"), (int) fm.get("total_calories"),
                (double) fm.get("avg_speed"), (double) fm.get("max_speed"), (int) fm.get("total_ascent"), (int) fm.get("total_descent"),
                (short) fm.get("event"),
                (short) fm.get("event_type"), (short) fm.get("avg_heart_rate"), (short) fm.get("max_heart_rate"),
                (short) fm.get("lap_trigger")
                , (short) fm.get("sport"), (double) fm.get("enhanced_avg_speed"), (double) fm.get("enhanced_max_speed"));

        training.addSummaryLap(lap);
    }


    @Override
    public void onMesg(Mesg mesg) {

        LOG.d("-----------------NAME " + mesg.getName() + " ----------------------");
        if ("record".equals(mesg.getName())) {
            addRecord(mesg);
        } else if ("lap".equals(mesg.getName())) {
            addLap(mesg);
        } else if ("activity".equals(mesg.getName())) {
            finishedLoading(training);
        }

    }

}
