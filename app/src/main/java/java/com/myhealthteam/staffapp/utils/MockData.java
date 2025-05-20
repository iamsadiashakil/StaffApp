package java.com.myhealthteam.staffapp.utils;

import java.com.myhealthteam.staffapp.models.Appointment;
import java.com.myhealthteam.staffapp.models.Patient;
import java.util.ArrayList;
import java.util.List;

public final class MockData {

    private MockData() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static List<Patient> getPatients() {
        List<Patient> patientList = new ArrayList<>();
        patientList.add(new Patient(1, "John Smith", 35, "Male", "A+", true));
        patientList.add(new Patient(2, "Emily Davis", 28, "Female", "O-", false));
        patientList.add(new Patient(3, "Michael Johnson", 42, "Male", "B+", true));
        patientList.add(new Patient(4, "Sarah Wilson", 31, "Female", "AB+", true));
        patientList.add(new Patient(5, "Robert Brown", 50, "Male", "O+", false));
        return patientList;
    }

    public static Patient getPatientById(int id) {
        List<Patient> patients = getPatients();
        return patients.stream()
                .filter(patient -> id == patient.getId())
                .findFirst()
                .orElseThrow(()->new RuntimeException("Data not found"));
    }

    public static List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, 1, "8:00 AM", "Pending", "Blood pressure checkup"));
        appointments.add(new Appointment(2, 2, "10:30 AM", "Completed", "Diabetes follow-up", "19-05-2025", "Medications:\n" +
                "\n" +
                "Metformin 500mg: Take one tablet twice daily with meals.\n" +
                "Gliclazide 80mg: Take one tablet in the morning before breakfast.\n" +
                "Vitamin D3 1000 IU: Take one tablet daily after lunch.\n" +
                "Lifestyle Modifications:\n" +
                "\n" +
                "Follow a balanced diet, including more vegetables, lean protein, and whole grains.\n" +
                "Limit sugar, processed foods, and saturated fats.\n" +
                "Exercise for at least 30 minutes daily (e.g., brisk walking, cycling, or swimming).\n" +
                "Monitoring:\n" +
                "\n" +
                "Check blood sugar levels twice daily (fasting and post-meal).\n" +
                "Maintain a log of blood sugar readings to share at the next visit.\n" +
                "Follow-Up Tests:\n" +
                "\n" +
                "HbA1c Test: To be done every 3 months.\n" +
                "Lipid Profile: To monitor cholesterol levels.\n" +
                "Kidney Function Test: To monitor for any complications.\n" +
                "Additional Notes:\n" +
                "\n" +
                "Stay hydrated and drink plenty of water throughout the day.\n" +
                "Immediately report any signs of hypoglycemia (dizziness, sweating, or confusion).\n" +
                "Ensure regular foot care and check for any wounds or infections.\n" +
                "Next Follow-Up:\n" +
                "\n" +
                "Schedule an appointment in 4-6 weeks for a review of progress and test results."));
        appointments.add(new Appointment(3, 3, "12:00 PM", "Pending", "Routine checkup"));
        appointments.add(new Appointment(4, 4, "1:00 PM", "Pending", "Cardiology consultation"));
        return appointments;
    }

    public static Appointment getAppointmentById(int id) {
        List<Appointment> appointments = getAppointments();
        return appointments.stream()
                .filter(appointment -> id == appointment.getId())
                .findFirst()
                .orElseThrow(()->new RuntimeException("Data not found"));
    }

}
