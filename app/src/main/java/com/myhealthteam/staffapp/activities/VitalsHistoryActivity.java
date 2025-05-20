package com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myhealthteam.staffapp.R;
import com.myhealthteam.staffapp.adapters.VitalsHistoryAdapter;
import com.myhealthteam.staffapp.models.Vital;
import java.util.ArrayList;
import java.util.List;

public class VitalsHistoryActivity extends Activity {

    private RecyclerView recyclerView;
    private VitalsHistoryAdapter adapter;
    private List<Vital> vitalsHistory;
    private String vitalType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitals_history);

        // Set up back button
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN);
        backButton.setOnClickListener(v -> finish());

        // Set title dynamically based on vital type
        vitalType = getIntent().getStringExtra("vital_type");
        TextView title = findViewById(R.id.top_bar_title);
        title.setText(vitalType + " History");

        // RecyclerView setup
        recyclerView = findViewById(R.id.recycler_vitals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Mock data for vitals
        initializeMockData();

        adapter = new VitalsHistoryAdapter(this, vitalsHistory);
        recyclerView.setAdapter(adapter);

        // FAB for adding/modifying vitals
        findViewById(R.id.fab_add_vital).setOnClickListener(v -> showAddModifyDialog());
    }

    private void showAddModifyDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_add_vital, null));
        AlertDialog dialog = builder.create();

        dialog.show();

        dialog.findViewById(R.id.btn_save_vital).setOnClickListener(v -> {
            // Collect data from inputs
            EditText readingInput = dialog.findViewById(R.id.input_vital_reading);
            EditText dateInput = dialog.findViewById(R.id.input_vital_date);
            EditText statusInput = dialog.findViewById(R.id.input_vital_status);

            String reading = readingInput.getText().toString();
            String date = dateInput.getText().toString();
            String status = statusInput.getText().toString();

            // Update mock data
            vitalsHistory.add(new Vital(reading, date, status));
            adapter.notifyDataSetChanged();

            dialog.dismiss();
        });
    }

    private void initializeMockData() {
        vitalsHistory = new ArrayList<>();

        switch (vitalType) {
            case "Blood Pressure":
                vitalsHistory.add(new Vital("120/80 mmHg", "2025-05-16 08:00 AM", "Normal"));
                vitalsHistory.add(new Vital("130/90 mmHg", "2025-05-15 08:00 AM", "Elevated"));
                vitalsHistory.add(new Vital("140/95 mmHg", "2025-05-14 08:00 AM", "High"));
                vitalsHistory.add(new Vital("125/85 mmHg", "2025-05-13 08:00 AM", "Normal"));
                break;

            case "Body Temperature":
                vitalsHistory.add(new Vital("98.6°F", "2025-05-16 08:00 AM", "Normal"));
                vitalsHistory.add(new Vital("99.5°F", "2025-05-15 08:00 AM", "Fever"));
                vitalsHistory.add(new Vital("97.8°F", "2025-05-14 08:00 AM", "Normal"));
                vitalsHistory.add(new Vital("100.2°F", "2025-05-13 08:00 AM", "Mild Fever"));
                break;

            case "Blood Oxygen":
                vitalsHistory.add(new Vital("97%", "2025-05-16 08:00 AM", "Normal"));
                vitalsHistory.add(new Vital("95%", "2025-05-15 08:00 AM", "Low"));
                vitalsHistory.add(new Vital("96%", "2025-05-14 08:00 AM", "Normal"));
                vitalsHistory.add(new Vital("94%", "2025-05-13 08:00 AM", "Low"));
                break;

            case "Pulse Rate":
                vitalsHistory.add(new Vital("72 bpm", "2025-05-16 08:00 AM", "Normal"));
                vitalsHistory.add(new Vital("80 bpm", "2025-05-15 08:00 AM", "Normal"));
                vitalsHistory.add(new Vital("85 bpm", "2025-05-14 08:00 AM", "Slightly Elevated"));
                vitalsHistory.add(new Vital("90 bpm", "2025-05-13 08:00 AM", "Elevated"));
                break;

            case "Sugar Level":
                vitalsHistory.add(new Vital("110 mg/dL", "2025-05-16 08:00 AM", "Normal"));
                vitalsHistory.add(new Vital("140 mg/dL", "2025-05-15 08:00 AM", "Elevated"));
                vitalsHistory.add(new Vital("125 mg/dL", "2025-05-14 08:00 AM", "Pre-Diabetic"));
                vitalsHistory.add(new Vital("160 mg/dL", "2025-05-13 08:00 AM", "High"));
                break;

            default:
                vitalsHistory.add(new Vital("No data available", "", ""));
                break;
        }
    }
}