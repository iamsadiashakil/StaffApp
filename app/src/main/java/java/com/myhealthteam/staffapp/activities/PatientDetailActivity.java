package java.com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.com.myhealthteam.staffapp.R;
import java.com.myhealthteam.staffapp.adapters.AllergiesHistoryAdapter;
import java.com.myhealthteam.staffapp.adapters.VitalsHistoryAdapter;
import java.com.myhealthteam.staffapp.models.Allergy;
import java.com.myhealthteam.staffapp.models.Vital;
import java.util.ArrayList;
import java.util.List;

public class PatientDetailActivity extends Activity {

    private RecyclerView recyclerBloodPressure, recyclerBodyTemperature, recyclerPulseRate, recyclerBloodOxygen, recyclerSugarLevel, recyclerAllergies;
    private VitalsHistoryAdapter bloodPressureAdapter, bodyTemperatureAdapter, pulseRateAdapter, bloodOxygenAdapter, sugarLevelAdapter;
    private AllergiesHistoryAdapter allergiesAdapter;
    private List<Vital> bloodPressureHistory, bodyTemperatureHistory, pulseRateHistory, bloodOxygenHistory, sugarLevelHistory;
    private List<Allergy> allergiesHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_detail);

        // Set up back button
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish());

        // Initialize patient info
        TextView patientName = findViewById(R.id.patient_name);
        TextView patientDetails = findViewById(R.id.patient_details);

        // Retrieve patient data passed from intent
        Intent intent = getIntent();
        patientName.setText(intent.getStringExtra("patient_name"));
        String patientDetailsText = intent.getIntExtra("patient_age", 0) + " years | " +
                intent.getStringExtra("patient_sex") + " | " +
                intent.getStringExtra("patient_blood_group");
        patientDetails.setText(patientDetailsText);

        // Initialize RecyclerViews
        recyclerBloodPressure = findViewById(R.id.recycler_blood_pressure);
        recyclerBodyTemperature = findViewById(R.id.recycler_body_temperature);
        recyclerPulseRate = findViewById(R.id.recycler_pulse_rate);
        recyclerBloodOxygen = findViewById(R.id.recycler_blood_oxygen);
        recyclerSugarLevel = findViewById(R.id.recycler_sugar_level);
        recyclerAllergies = findViewById(R.id.recycler_allergies);

        setupRecyclerViews();

        // Populate mock data
        populateBloodPressureHistory();
        populateBodyTemperatureHistory();
        populatePulseRateHistory();
        populateBloodOxygenHistory();
        populateSugarLevelHistory();
        populateAllergiesHistory();
    }

    private void setupRecyclerViews() {
        // Blood Pressure RecyclerView
        bloodPressureHistory = new ArrayList<>();
        bloodPressureAdapter = new VitalsHistoryAdapter(this, bloodPressureHistory);
        recyclerBloodPressure.setLayoutManager(new LinearLayoutManager(this));
        recyclerBloodPressure.setAdapter(bloodPressureAdapter);

        // Body Temperature RecyclerView
        bodyTemperatureHistory = new ArrayList<>();
        bodyTemperatureAdapter = new VitalsHistoryAdapter(this, bodyTemperatureHistory);
        recyclerBodyTemperature.setLayoutManager(new LinearLayoutManager(this));
        recyclerBodyTemperature.setAdapter(bodyTemperatureAdapter);

        // Pulse Rate RecyclerView
        pulseRateHistory = new ArrayList<>();
        pulseRateAdapter = new VitalsHistoryAdapter(this, pulseRateHistory);
        recyclerPulseRate.setLayoutManager(new LinearLayoutManager(this));
        recyclerPulseRate.setAdapter(pulseRateAdapter);

        // Blood Oxygen RecyclerView
        bloodOxygenHistory = new ArrayList<>();
        bloodOxygenAdapter = new VitalsHistoryAdapter(this, bloodOxygenHistory);
        recyclerBloodOxygen.setLayoutManager(new LinearLayoutManager(this));
        recyclerBloodOxygen.setAdapter(bloodOxygenAdapter);

        // Sugar Level RecyclerView
        sugarLevelHistory = new ArrayList<>();
        sugarLevelAdapter = new VitalsHistoryAdapter(this, sugarLevelHistory);
        recyclerSugarLevel.setLayoutManager(new LinearLayoutManager(this));
        recyclerSugarLevel.setAdapter(sugarLevelAdapter);

        // Allergies RecyclerView
        allergiesHistory = new ArrayList<>();
        allergiesAdapter = new AllergiesHistoryAdapter(this, allergiesHistory);
        recyclerAllergies.setLayoutManager(new LinearLayoutManager(this));
        recyclerAllergies.setAdapter(allergiesAdapter);
    }

    private void populateBloodPressureHistory() {
        bloodPressureHistory.add(new Vital("120/80 mmHg", "2025-05-16 08:00 AM", "Normal"));
        bloodPressureHistory.add(new Vital("130/90 mmHg", "2025-05-15 08:00 AM", "Elevated"));
        bloodPressureAdapter.notifyDataSetChanged();
    }

    private void populateBodyTemperatureHistory() {
        bodyTemperatureHistory.add(new Vital("98.6°F", "2025-05-16 08:00 AM", "Normal"));
        bodyTemperatureHistory.add(new Vital("99.5°F", "2025-05-15 08:00 AM", "Fever"));
        bodyTemperatureAdapter.notifyDataSetChanged();
    }

    private void populatePulseRateHistory() {
        pulseRateHistory.add(new Vital("72 bpm", "2025-05-16 08:00 AM", "Normal"));
        pulseRateHistory.add(new Vital("80 bpm", "2025-05-15 08:00 AM", "Normal"));
        pulseRateAdapter.notifyDataSetChanged();
    }

    private void populateBloodOxygenHistory() {
        bloodOxygenHistory.add(new Vital("97%", "2025-05-16 08:00 AM", "Normal"));
        bloodOxygenHistory.add(new Vital("95%", "2025-05-15 08:00 AM", "Low"));
        bloodOxygenAdapter.notifyDataSetChanged();
    }

    private void populateSugarLevelHistory() {
        sugarLevelHistory.add(new Vital("110 mg/dL", "2025-05-16 08:00 AM", "Normal"));
        sugarLevelHistory.add(new Vital("140 mg/dL", "2025-05-15 08:00 AM", "Elevated"));
        sugarLevelAdapter.notifyDataSetChanged();
    }

    private void populateAllergiesHistory() {
        allergiesHistory.add(new Allergy("Peanuts", "Food", "Severe", "Anaphylaxis", "2025-01-15"));
        allergiesHistory.add(new Allergy("Dust", "Environmental", "Moderate", "Sneezing", "2023-11-05"));
        allergiesAdapter.notifyDataSetChanged();
    }
}