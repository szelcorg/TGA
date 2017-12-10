package org.szelc.fit.training;

import org.jxmapviewer.viewer.GeoPosition;

/**
 * @author by marcin.szelc on 2017-12-08.
 */
public class RecordTraining {
    private static final double GEO_CONVERT_VALUE = 180 / Math.pow(2, 31);

    private GeoPosition position;

    private long timestamp;
    private int positionLat;
    private int  positionLong;
    private double distance;
    private double  altitude;
    private double speed;
    private short heartRate;
    private double enhancedAltitude;
    private double enhancedSpeed;

    public RecordTraining(long timestamp, int positionLat, int positionLong, double distance, double altitude,
                          double speed, short heartRate, double enhancedAltitude, double enhancedSpeed) {
        
        this.timestamp = timestamp;
        this.positionLat = positionLat;
        this.positionLong = positionLong;
        this.distance = distance;
        this.altitude = altitude;
        this.speed = speed;
        this.heartRate = heartRate;
        this.enhancedAltitude = enhancedAltitude;
        this.enhancedSpeed = enhancedSpeed;

        position = new GeoPosition(positionLat * GEO_CONVERT_VALUE, positionLong * GEO_CONVERT_VALUE );
    }

    public GeoPosition getPosition() {
        return position;
    }

    public void setPosition(GeoPosition position) {
        this.position = position;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getPositionLat() {
        return positionLat;
    }

    public void setPositionLat(int positionLat) {
        this.positionLat = positionLat;
    }

    public long getPositionLong() {
        return positionLong;
    }

    public void setPositionLong(int positionLong) {
        this.positionLong = positionLong;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(short heartRate) {
        this.heartRate = heartRate;
    }

    public double getEnhancedAltitude() {
        return enhancedAltitude;
    }

    public void setEnhancedAltitude(double enhancedAltitude) {
        this.enhancedAltitude = enhancedAltitude;
    }

    public double getEnhancedSpeed() {
        return enhancedSpeed;
    }

    public void setEnhancedSpeed(double enhancedSpeed) {
        this.enhancedSpeed = enhancedSpeed;
    }


}
