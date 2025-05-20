package java.com.myhealthteam.staffapp.models;

public class Appointment {
    private int id;
    private int patientId;
    private String time;
    private String status;
    private String notes;
    private String date;
    private String prescription;

    public Appointment(int id, int patientId, String time, String status, String notes) {
        this.id = id;
        this.patientId = patientId;
        this.time = time;
        this.status = status;
        this.notes = notes;
    }

    public Appointment(int id, int patientId, String time, String status, String notes, String date, String prescription) {
        this.id = id;
        this.patientId = patientId;
        this.time = time;
        this.status = status;
        this.notes = notes;
        this.date = date;
        this.prescription = prescription;
    }

    public int getId() {
        return id;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public String getDate() {
        return date;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
}