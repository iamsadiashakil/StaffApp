package java.com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.os.Bundle;
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
    }
}