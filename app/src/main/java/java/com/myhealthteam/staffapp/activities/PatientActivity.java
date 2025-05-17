package java.com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.com.myhealthteam.staffapp.R;
import java.com.myhealthteam.staffapp.adapters.PatientsAdapter;
import java.com.myhealthteam.staffapp.models.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientActivity extends Activity {
    List<Patient> patientList;
    PatientsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        // Set up back button
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN);
        backButton.setOnClickListener(v -> finish());

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.patient_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create mock data
        patientList = new ArrayList<>();
        patientList.add(new Patient("John Smith", 35, "Male", "A+", true));
        patientList.add(new Patient("Emily Davis", 28, "Female", "O-", false));
        patientList.add(new Patient("Michael Johnson", 42, "Male", "B+", true));
        patientList.add(new Patient("Sarah Wilson", 31, "Female", "AB+", true));
        patientList.add(new Patient("Robert Brown", 50, "Male", "O+", false));


        adapter = new PatientsAdapter(this, patientList, this::viewPatientDetail);
        recyclerView.setAdapter(adapter);

        // Set up search functionality
        EditText searchPatient = findViewById(R.id.search_view);
        searchPatient.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterPatient(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filterPatient(String query) {
        List<Patient> filteredPatients = new ArrayList<>();
        for (Patient patient : patientList) {
            if (patient.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredPatients.add(patient);
            }
        }
        adapter.updateList(filteredPatients);
    }

    private void viewPatientDetail(Patient patient) {
        // Handle to view selected Patient Details
        // Example: Navigate to PatientDetailsActivity
        Intent intent = new Intent(PatientActivity.this, PatientDetailActivity.class);
        intent.putExtra("patient_name", patient.getName());
        intent.putExtra("patient_age", patient.getAge());
        intent.putExtra("patient_sex", patient.getSex());
        intent.putExtra("patient_blood_group", patient.getBloodGroup());
        startActivity(intent);
    }
}
