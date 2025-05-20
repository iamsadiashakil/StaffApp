package java.com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.com.myhealthteam.staffapp.R;
import java.com.myhealthteam.staffapp.models.Appointment;
import java.com.myhealthteam.staffapp.models.Patient;
import java.com.myhealthteam.staffapp.utils.MockData;

public class AppointmentDetailsActivity extends Activity {

    private TextView patientName, appointmentNotes;
    private EditText editPrescription;
    private Button btnMarkAsComplete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details);

        // Initialize views
        patientName = findViewById(R.id.patient_name);
        appointmentNotes = findViewById(R.id.appointment_notes);
        editPrescription = findViewById(R.id.edit_prescription);
        ImageView btnViewPatientDetails = findViewById(R.id.btn_view_patient_details);
        btnMarkAsComplete = findViewById(R.id.btn_mark_as_complete);
        ImageView backButton = findViewById(R.id.back_button);

        // Get data from intent
        int patientId = getIntent().getIntExtra("patient_id", 0);
        int appointmentId = getIntent().getIntExtra("appointment_id", 0);

        // get mock data
        Patient patient = MockData.getPatientById(patientId);
        Appointment appointment = MockData.getAppointmentById(appointmentId);

        // Set data in views
        patientName.setText(patient.getName());
        appointmentNotes.setText(appointment.getNotes());

        // Back button click listener
        backButton.setOnClickListener(v -> finish());
        backButton.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN);

        // View patient details button click listener
        btnViewPatientDetails.setOnClickListener(v -> {
            Toast.makeText(this, "Viewing patient details", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AppointmentDetailsActivity.this, PatientDetailActivity.class);
            intent.putExtra("patient_id", patientId);
            startActivity(intent);
        });
        btnViewPatientDetails.setColorFilter(ContextCompat.getColor(this, R.color.primary), PorterDuff.Mode.SRC_IN);

        if(!appointment.getStatus().equals("Completed")) {// Mark appointment as complete button click listener
            btnMarkAsComplete.setOnClickListener(v -> {
                String prescription = editPrescription.getText().toString().trim();
                if (prescription.isEmpty()) {
                    Toast.makeText(this, "Please enter a prescription", Toast.LENGTH_SHORT).show();
                } else {
                    appointment.setPrescription(prescription);
                    editPrescription.setText(""); // Clear the input field
                    appointment.setStatus("Completed");
                    Toast.makeText(this, "Appointment marked as Completed", Toast.LENGTH_SHORT).show();
                    // Update the appointment in the database or backend if applicable
                    Intent intent = new Intent(AppointmentDetailsActivity.this, AppointmentActivity.class);
                    startActivity(intent);
                    finish(); // Close AppointmentDetailsActivity
                }
            });
        } else {
            // Set button to non-clickable
            btnMarkAsComplete.setClickable(false);
            btnMarkAsComplete.setEnabled(false); // Disable the button visually as well

            // Set EditText to non-editable
            editPrescription.setFocusable(false);
            editPrescription.setFocusableInTouchMode(false);
            editPrescription.setClickable(false);

            // Set prescription text
            editPrescription.setText(appointment.getPrescription());
        }
    }
}