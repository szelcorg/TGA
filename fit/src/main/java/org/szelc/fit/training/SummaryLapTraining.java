package org.szelc.fit.training;

import org.jxmapviewer.viewer.GeoPosition;

import java.util.Collection;

public class SummaryLapTraining {
    private static final double GEO_CONVERT_VALUE = 180 / Math.pow(2, 31);

    private long timestamp;
    private long startTime;
    private int startPositionLat;
    private int  startPositionLong;
    private int endPositionLat;
    private int endPositionLong;

    private double totalElapsedTime;
    private double totalTimerTime;
    private double totalDistance;
    private int totalCalories;
    private double avgSpeed;
    private double maxSpeed;
    private int totalAscent;
    private int totalDescent;
    private short event;
    private short eventType;
    private short avgHeartRate;
    private short maxHeartRate;
    private short lapTrigger;
    private short sport;
    private double enhancedAvgSpeed;
    private double getEnhancedMaxSpeed;

    public SummaryLapTraining() {
    }

    public SummaryLapTraining(long timestamp, int startPositionLat, int startPositionLong, int endPositionLat, int endPositionLong,
                              long startTime, double totalElapsedTime, double totalTimesTime, double totalDistance,
                              int totalCalories, double avgSpeed, double maxSpeed, int totalAscent, int totalDescent,
                              short event, short eventType, short avgHeartRate, short maxHeartRate, short lapTrigger, short sport,
                              double enhancedAvgSpeed, double getEnhancedMaxSpeed) {
        this.timestamp = timestamp;
        this.startPositionLat = startPositionLat;
        this.startPositionLong = startPositionLong;
        this.endPositionLat = endPositionLat;
        this.endPositionLong = endPositionLong;
        this.startTime = startTime;
        this.totalElapsedTime = totalElapsedTime;
        this.totalTimerTime = totalTimesTime;
        this.totalDistance = totalDistance;
        this.totalCalories = totalCalories;
        this.avgSpeed = avgSpeed;
        this.maxSpeed = maxSpeed;
        this.totalAscent = totalAscent;
        this.totalDescent = totalDescent;
        this.event = event;
        this.eventType = eventType;
        this.avgHeartRate = avgHeartRate;
        this.maxHeartRate = maxHeartRate;
        this.lapTrigger = lapTrigger;
        this.sport = sport;
        this.enhancedAvgSpeed = enhancedAvgSpeed;
        this.getEnhancedMaxSpeed = getEnhancedMaxSpeed;

    }

    private LapGeoPosition lapGeoPositions;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public double getTotalElapsedTime() {
        return totalElapsedTime;
    }

    public void setTotalElapsedTime(double totalElapsedTime) {
        this.totalElapsedTime = totalElapsedTime;
    }

    public double getTotalTimerTime() {
        return totalTimerTime;
    }

    public void setTotalTimerTime(double totalTimerTime) {
        this.totalTimerTime = totalTimerTime;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getTotalAscent() {
        return totalAscent;
    }

    public void setTotalAscent(int totalAscent) {
        this.totalAscent = totalAscent;
    }

    public int getTotalDescent() {
        return totalDescent;
    }

    public void setTotalDescent(int totalDescent) {
        this.totalDescent = totalDescent;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(short event) {
        this.event = event;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(short eventType) {
        this.eventType = eventType;
    }

    public int getAvgHeartRate() {
        return avgHeartRate;
    }

    public void setAvgHeartRate(short avgHeartRate) {
        this.avgHeartRate = avgHeartRate;
    }

    public int getMaxHeartRate() {
        return maxHeartRate;
    }

    public void setMaxHeartRate(short maxHeartRate) {
        this.maxHeartRate = maxHeartRate;
    }

    public int getLapTrigger() {
        return lapTrigger;
    }

    public void setLapTrigger(short lapTrigger) {
        this.lapTrigger = lapTrigger;
    }

    public int getSport() {
        return sport;
    }

    public void setSport(short sport) {
        this.sport = sport;
    }

    public double getEnhancedAvgSpeed() {
        return enhancedAvgSpeed;
    }

    public void setEnhancedAvgSpeed(double enhancedAvgSpeed) {
        this.enhancedAvgSpeed = enhancedAvgSpeed;
    }

    public double getGetEnhancedMaxSpeed() {
        return getEnhancedMaxSpeed;
    }

    public void setGetEnhancedMaxSpeed(double getEnhancedMaxSpeed) {
        this.getEnhancedMaxSpeed = getEnhancedMaxSpeed;
    }

    public LapGeoPosition getLapGeoPositions() {
        return lapGeoPositions;
    }

    public void setLapGeoPositions(LapGeoPosition lapGeoPositions) {
        this.lapGeoPositions = lapGeoPositions;
    }


    public GeoPosition getLapPosition() {
        return new GeoPosition(endPositionLat * GEO_CONVERT_VALUE, endPositionLong * GEO_CONVERT_VALUE);
    }
}
