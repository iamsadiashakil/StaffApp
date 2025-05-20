package com.myhealthteam.staffapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.myhealthteam.staffapp.R;

public class DashboardActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize card views
        CardView cardPatients = findViewById(R.id.cardPatients);
        CardView cardAppointments = findViewById(R.id.cardAppointments);
        CardView cardEarnings = findViewById(R.id.cardEarnings);

        // Set click listeners
        cardPatients.setOnClickListener(v -> {
            startActivity(new Intent(this, PatientActivity.class));
        });

        cardAppointments.setOnClickListener(v -> {
            startActivity(new Intent(this, AppointmentActivity.class));
        });

        cardEarnings.setOnClickListener(v -> {
            startActivity(new Intent(this, EarningActivity.class));
        });


        // Profile icon click
        findViewById(R.id.profile_icon).setOnClickListener(v -> {
            startActivity(new Intent(this, ProfileActivity.class));
        });


        // Set mock data
        TextView tvPatientCount = findViewById(R.id.tvPatientCount);
        TextView tvAppointmentCount = findViewById(R.id.tvAppointmentCount);
        TextView tvEarnings = findViewById(R.id.tvEarnings);

        tvPatientCount.setText("142 Patients");
        tvAppointmentCount.setText("8 Today");
        tvEarnings.setText("$12,850");
    }
}