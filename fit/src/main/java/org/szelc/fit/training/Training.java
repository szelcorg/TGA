package org.szelc.fit.training;

import org.jxmapviewer.viewer.GeoPosition;
import org.szelc.log.LOG;

import java.util.List;

/**
 * @author by marcin.szelc on 2017-12-08.
 */
public class Training {

    private TimeTraining timeTraining;

    private LapsTraining lapsTraining;
    private SummaryTraining summaryTraining;

    public Training() {
        timeTraining = new TimeTraining();
        lapsTraining = new LapsTraining();
        summaryTraining = new SummaryTraining();
    }

    public void addRecord(RecordTraining rec) {
        if(rec.getPositionLat()<0){
            return;
        }
        lapsTraining.addRecord(rec);
    }

    public void addSummaryLap(SummaryLapTraining summaryLapTraining){
        lapsTraining.addSummaryLap(summaryLapTraining);
    }

    public void addSession(){
        lapsTraining.addSession();
    }

    public List<GeoPosition> getWayPoint(){
        return lapsTraining.getLapPositions();
    }

    public List<GeoPosition> getRoutePoint(){
        return lapsTraining.getPositions();
    }

    public void displayWayPoint(){
        for(GeoPosition g : getWayPoint()){
            LOG.i(g.getLatitude()+" : "+g.getLongitude());
        }
    }

    public void displayRoutePoint(){
        for(GeoPosition g : getRoutePoint()){
            LOG.i(g.getLatitude()+" : "+g.getLongitude());
        }
    }

    public void displayDistance() {
        LOG.i("DISTANCE ["+getDistance()+"]");
    }

    public double getDistance(){
        return lapsTraining.getTotalDistance();
    }
}
