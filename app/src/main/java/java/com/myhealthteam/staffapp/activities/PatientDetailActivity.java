package java.com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.ImageView;


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

        // Set up card click listeners
        findViewById(R.id.card_blood_pressure).setOnClickListener(v -> {
            Intent intent = new Intent(this, VitalsHistoryActivity.class);
            intent.putExtra("vital_type", "Blood Pressure");
            startActivity(intent);
        });

        findViewById(R.id.card_body_temperature).setOnClickListener(v -> {
            Intent intent = new Intent(this, VitalsHistoryActivity.class);
            intent.putExtra("vital_type", "Body Temperature");
            startActivity(intent);
        });

        findViewById(R.id.card_blood_oxygen).setOnClickListener(v -> {
            Intent intent = new Intent(this, VitalsHistoryActivity.class);
            intent.putExtra("vital_type", "Blood Oxygen");
            startActivity(intent);
        });

        findViewById(R.id.card_pulse_rate).setOnClickListener(v -> {
            Intent intent = new Intent(this, VitalsHistoryActivity.class);
            intent.putExtra("vital_type", "Pulse Rate");
            startActivity(intent);
        });

        findViewById(R.id.card_sugar_level).setOnClickListener(v -> {
            Intent intent = new Intent(this, VitalsHistoryActivity.class);
            intent.putExtra("vital_type", "Sugar Level");
            startActivity(intent);
        });

        findViewById(R.id.card_last_allergy).setOnClickListener(v -> {
            Intent intent = new Intent(this, AllergiesHistoryActivity.class);
            startActivity(intent);
        });
    }
}