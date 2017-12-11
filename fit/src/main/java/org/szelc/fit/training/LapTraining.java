package org.szelc.fit.training;

import org.jxmapviewer.viewer.GeoPosition;

import java.util.Collection;
import java.util.List;

/**
 * @author by marcin.szelc on 2017-12-08.
 */
public class LapTraining {
    private RecordsTraining recordsTraining;
    private SummaryLapTraining summaryLapTraining;

    public LapTraining() {
        recordsTraining = new RecordsTraining();
        summaryLapTraining = new SummaryLapTraining(this);
    }

    public void addRecord(RecordTraining rec){
        recordsTraining.addRecordTraining(rec);
    }

    public SummaryLapTraining getSummaryLapTraining() {
        return summaryLapTraining;
    }

    public void setSummaryLapTraining(SummaryLapTraining summaryLapTraining) {
        this.summaryLapTraining = summaryLapTraining;
        this.summaryLapTraining.setLapTraining(this);
    }

    public List<GeoPosition> getPositions(){
        return recordsTraining.getPositions();
    }

    public GeoPosition getLapPosition() {
        return summaryLapTraining.getLapPosition();
    }

    public double getTotalDistance() {
        return summaryLapTraining.getTotalDistance();
    }

    public short getMinHeartRate() {
        return recordsTraining.getMinHeartRate();
    }
}
