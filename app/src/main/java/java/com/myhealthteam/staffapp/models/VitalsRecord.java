package java.com.myhealthteam.staffapp.models;

public class VitalsRecord {
    private String reading;
    private String measuredAt;
    private String status;

    public VitalsRecord(String reading, String measuredAt, String status) {
        this.reading = reading;
        this.measuredAt = measuredAt;
        this.status = status;
    }

    public String getReading() {
        return reading;
    }

    public String getMeasuredAt() {
        return measuredAt;
    }

    public String getStatus() {
        return status;
    }
}
