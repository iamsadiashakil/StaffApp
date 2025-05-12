package java.com.myhealthteam.staffapp.models;

public class Doctor {
    private String doctorId;
    private String doctorName;

    public Doctor(String doctorId, String doctorName) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

}
