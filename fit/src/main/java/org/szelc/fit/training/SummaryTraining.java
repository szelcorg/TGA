package org.szelc.fit.training;

//SESSION garmin
public class SummaryTraining
{
    private long timestamp;
    private long  startTime;
    private long startPositionLat;
    private long  startPositionLong;
    private double  totalElapsedTime;
    private double  totalTimerTime;
    private double  totalDistance;
    private long  necLat;
    private long  necLong;
    private long swcLat;
    private long swcLong;
    private int messageIndex;
    private int totalCalories;
    private int totalFatCalories;
    private double   avgSpeed;
    private double   maxSpeed;
    private int totalAscent;
    private int totalDescent;
    private int firstLapIndex;
    private int numLaps;
    private short event;
    private short eventType;
    private short sport;
    private short subSport;
    private short avgHeartRate;
    private short maxHeartRate;
    private float totalTrainingEffect;
    private float trigger;
    private float enhancedAvgSpeed;
    private float enhancedMaxSpeed;

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

    public long getStartPositionLat() {
        return startPositionLat;
    }

    public void setStartPositionLat(long startPositionLat) {
        this.startPositionLat = startPositionLat;
    }

    public long getStartPositionLong() {
        return startPositionLong;
    }

    public void setStartPositionLong(long startPositionLong) {
        this.startPositionLong = startPositionLong;
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

    public long getNecLat() {
        return necLat;
    }

    public void setNecLat(long necLat) {
        this.necLat = necLat;
    }

    public long getNecLong() {
        return necLong;
    }

    public void setNecLong(long necLong) {
        this.necLong = necLong;
    }

    public long getSwcLat() {
        return swcLat;
    }

    public void setSwcLat(long swcLat) {
        this.swcLat = swcLat;
    }

    public long getSwcLong() {
        return swcLong;
    }

    public void setSwcLong(long swcLong) {
        this.swcLong = swcLong;
    }

    public int getMessageIndex() {
        return messageIndex;
    }

    public void setMessageIndex(int messageIndex) {
        this.messageIndex = messageIndex;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public int getTotalFatCalories() {
        return totalFatCalories;
    }

    public void setTotalFatCalories(int totalFatCalories) {
        this.totalFatCalories = totalFatCalories;
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

    public int getFirstLapIndex() {
        return firstLapIndex;
    }

    public void setFirstLapIndex(int firstLapIndex) {
        this.firstLapIndex = firstLapIndex;
    }

    public int getNumLaps() {
        return numLaps;
    }

    public void setNumLaps(int numLaps) {
        this.numLaps = numLaps;
    }

    public short getEvent() {
        return event;
    }

    public void setEvent(short event) {
        this.event = event;
    }

    public short getEventType() {
        return eventType;
    }

    public void setEventType(short eventType) {
        this.eventType = eventType;
    }

    public short getSport() {
        return sport;
    }

    public void setSport(short sport) {
        this.sport = sport;
    }

    public short getSubSport() {
        return subSport;
    }

    public void setSubSport(short subSport) {
        this.subSport = subSport;
    }

    public short getAvgHeartRate() {
        return avgHeartRate;
    }

    public void setAvgHeartRate(short avgHeartRate) {
        this.avgHeartRate = avgHeartRate;
    }

    public short getMaxHeartRate() {
        return maxHeartRate;
    }

    public void setMaxHeartRate(short maxHeartRate) {
        this.maxHeartRate = maxHeartRate;
    }

    public float getTotalTrainingEffect() {
        return totalTrainingEffect;
    }

    public void setTotalTrainingEffect(float totalTrainingEffect) {
        this.totalTrainingEffect = totalTrainingEffect;
    }

    public float getTrigger() {
        return trigger;
    }

    public void setTrigger(float trigger) {
        this.trigger = trigger;
    }

    public float getEnhancedAvgSpeed() {
        return enhancedAvgSpeed;
    }

    public void setEnhancedAvgSpeed(float enhancedAvgSpeed) {
        this.enhancedAvgSpeed = enhancedAvgSpeed;
    }

    public float getEnhancedMaxSpeed() {
        return enhancedMaxSpeed;
    }

    public void setEnhancedMaxSpeed(float enhancedMaxSpeed) {
        this.enhancedMaxSpeed = enhancedMaxSpeed;
    }
}
