package org.szelc.fit.training;

import org.jxmapviewer.viewer.GeoPosition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author by marcin.szelc on 2017-12-08.
 */
public class RecordsTraining {

    private List<RecordTraining> recordTrainingList;

    public RecordsTraining() {
        recordTrainingList = new ArrayList<>();
    }

    public void addRecordTraining(RecordTraining rec){
        recordTrainingList.add(rec);
    }

    public List<RecordTraining> getRecordTrainingList() {
        return recordTrainingList;
    }

    public List<GeoPosition> getPositions(){
        List<GeoPosition> result = new ArrayList<>();
        for(RecordTraining r : recordTrainingList){
            result.add(r.getPosition());
        }
        return result;
    }


    public short getMinHeartRate() {
        short min = 220;
        for(RecordTraining rt : recordTrainingList){
            if(rt.getHeartRate()<min){
                min = (short)rt.getHeartRate();
            }
        }
        return min;
    }
}
