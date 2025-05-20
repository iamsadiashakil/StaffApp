package com.myhealthteam.staffapp.models;

public class Vital {
    private String reading;     // The reading of the vital (e.g., "120/80 mmHg", "98.6°F")
    private String measuredAt;  // The date and time the vital was measured (e.g., "2025-05-16 08:00 AM")
    private String status;      // The status of the vital (e.g., "Normal", "Elevated", "Fever")

    public Vital(String reading, String measuredAt, String status) {
        this.reading = reading;
        this.measuredAt = measuredAt;
        this.status = status;
    }

    // Getters
    public String getReading() {
        return reading;
    }

    public String getMeasuredAt() {
        return measuredAt;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setReading(String reading) {
        this.reading = reading;
    }

    public void setMeasuredAt(String measuredAt) {
        this.measuredAt = measuredAt;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}