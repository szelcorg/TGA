package org.szelc.fit.training;

import org.jxmapviewer.viewer.GeoPosition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by marcin.szelc on 2017-12-08.
 */
public class LapsTraining {

    private List<LapTraining> lapTrainingList;
    //private List<GeoPosition> lapPositions;

    public LapsTraining() {
        lapTrainingList = new ArrayList<>();
        lapTrainingList.add(new LapTraining());
    }

    public void addSummaryLap(SummaryLapTraining summaryLapTraining){
        lapTrainingList.get(lapTrainingList.size()-1).setSummaryLapTraining(summaryLapTraining);
        lapTrainingList.add(new LapTraining());
    }

    public void addRecord(RecordTraining rec) {
        lapTrainingList.get(lapTrainingList.size()-1).addRecord(rec);
    }

    public void addSession(){
        lapTrainingList.remove(lapTrainingList.size()-1);
    }

    public List<GeoPosition> getPositions(){
        List<GeoPosition> result = new ArrayList<>();
        for(LapTraining l : lapTrainingList){
            result.addAll(l.getPositions());
        }
        return result;
    }

    public List<GeoPosition> getLapPositions() {
        List<GeoPosition> result = new ArrayList<>();
        for(LapTraining l : lapTrainingList){
            result.add(l.getLapPosition());
        }
        return result;
    }

    public double getTotalDistance() {
        double result = 0d;
        for(LapTraining lap : lapTrainingList){
            result+=lap.getTotalDistance();
        }
        return result;
    }
}
