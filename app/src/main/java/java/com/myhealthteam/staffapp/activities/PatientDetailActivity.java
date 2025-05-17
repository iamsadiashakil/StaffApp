package java.com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.core.content.ContextCompat;

import java.com.myhealthteam.staffapp.R;

public class PatientDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_detail);

        // Set up back button
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN);
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

        // Set up card click listeners
        findViewById(R.id.card_blood_pressure).setOnClickListener(v -> {
            Intent bloodPressureIntent = new Intent(this, VitalsHistoryActivity.class);
            bloodPressureIntent.putExtra("vital_type", "Blood Pressure");
            startActivity(bloodPressureIntent);
        });

        findViewById(R.id.card_body_temperature).setOnClickListener(v -> {
            Intent bodyTemperatureIntent = new Intent(this, VitalsHistoryActivity.class);
            bodyTemperatureIntent.putExtra("vital_type", "Body Temperature");
            startActivity(bodyTemperatureIntent);
        });

        findViewById(R.id.card_blood_oxygen).setOnClickListener(v -> {
            Intent bodyOxygenIntent = new Intent(this, VitalsHistoryActivity.class);
            bodyOxygenIntent.putExtra("vital_type", "Blood Oxygen");
            startActivity(bodyOxygenIntent);
        });

        findViewById(R.id.card_pulse_rate).setOnClickListener(v -> {
            Intent pulseRateIntent = new Intent(this, VitalsHistoryActivity.class);
            pulseRateIntent.putExtra("vital_type", "Pulse Rate");
            startActivity(pulseRateIntent);
        });

        findViewById(R.id.card_sugar_level).setOnClickListener(v -> {
            Intent sugarLevelIntent = new Intent(this, VitalsHistoryActivity.class);
            sugarLevelIntent.putExtra("vital_type", "Sugar Level");
            startActivity(sugarLevelIntent);
        });

        findViewById(R.id.card_last_allergy).setOnClickListener(v -> {
            Intent allergyIntent = new Intent(this, AllergiesHistoryActivity.class);
            startActivity(allergyIntent);
        });
    }
}