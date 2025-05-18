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
        appointments.add(new Appointment(2, 2, "10:30 AM", "Completed", "Diabetes follow-up"));
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
