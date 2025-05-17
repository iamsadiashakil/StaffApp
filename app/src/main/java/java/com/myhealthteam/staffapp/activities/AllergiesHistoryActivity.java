package java.com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.com.myhealthteam.staffapp.R;
import java.com.myhealthteam.staffapp.adapters.AllergiesHistoryAdapter;
import java.com.myhealthteam.staffapp.models.Allergy;

import java.util.ArrayList;
import java.util.List;

public class AllergiesHistoryActivity extends Activity {

    private RecyclerView recyclerView;
    private AllergiesHistoryAdapter adapter;
    private List<Allergy> allergiesHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergies_history);

        // Set up back button
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN);
        backButton.setOnClickListener(v -> finish());

        // RecyclerView setup
        recyclerView = findViewById(R.id.recycler_allergies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Mock data for allergies
        allergiesHistory = new ArrayList<>();
        allergiesHistory.add(new Allergy("Peanuts", "Food", "Severe", "Anaphylaxis", "2025-01-15"));
        allergiesHistory.add(new Allergy("Dust", "Environmental", "Moderate", "Sneezing", "2023-11-05"));

        // Set adapter
        adapter = new AllergiesHistoryAdapter(this, allergiesHistory);
        recyclerView.setAdapter(adapter);

        // FAB for adding/modifying allergies
        findViewById(R.id.fab_add_allergy).setOnClickListener(v -> showAddModifyDialog());

    }

    private void showAddModifyDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_add_allergy, null));
        AlertDialog dialog = builder.create();

        dialog.show();

        dialog.findViewById(R.id.btn_save_allergy).setOnClickListener(v -> {
            // Collect data from inputs
            EditText nameInput = dialog.findViewById(R.id.input_allergy_name);
            EditText typeInput = dialog.findViewById(R.id.input_allergy_type);
            EditText severityInput = dialog.findViewById(R.id.input_allergy_severity);
            EditText reactionInput = dialog.findViewById(R.id.input_allergy_reaction);
            EditText dateInput = dialog.findViewById(R.id.input_allergy_date);

            String name = nameInput.getText().toString();
            String type = typeInput.getText().toString();
            String severity = severityInput.getText().toString();
            String reaction = reactionInput.getText().toString();
            String date = dateInput.getText().toString();

            // Update mock data
            allergiesHistory.add(new Allergy(name, type, severity, reaction, date));
            adapter.notifyDataSetChanged();

            dialog.dismiss();
        });
    }
}