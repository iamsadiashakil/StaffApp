package com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myhealthteam.staffapp.R;
import com.myhealthteam.staffapp.adapters.AppointmentAdapter;
import com.myhealthteam.staffapp.models.Appointment;
import com.myhealthteam.staffapp.utils.MockData;
import java.util.List;

public class AppointmentActivity extends Activity {

    private List<Appointment> allAppointments;
    private AppointmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        // Back button setup
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN);
        backButton.setOnClickListener(v -> finish());

        // Initialize all today's appointments (mock data)
        allAppointments = MockData.getAppointments();

        // RecyclerView setup
        RecyclerView recyclerView = findViewById(R.id.recycler_appointments);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AppointmentAdapter(this, allAppointments);
        recyclerView.setAdapter(adapter);

    }

}