package java.com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.com.myhealthteam.staffapp.R;
import java.util.ArrayList;

public class EarningActivity extends Activity {

    private BarChart earningsChart;
    private TextView tvTotalEarnings, tvEarningsChange, tvCompletedAppointments, tvCompletedChange, tvAvgEarnings, tvAvgChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earning);

        // Initialize views
        earningsChart = findViewById(R.id.earningsChart);
        tvTotalEarnings = findViewById(R.id.tvTotalEarnings);
        tvEarningsChange = findViewById(R.id.tvEarningsChange);
        tvCompletedAppointments = findViewById(R.id.tvCompletedAppointments);
        tvCompletedChange = findViewById(R.id.tvCompletedChange);
        tvAvgEarnings = findViewById(R.id.tvAvgEarnings);
        tvAvgChange = findViewById(R.id.tvAvgChange);
        ImageView backButton = findViewById(R.id.back_button);
        ImageView filterButton = findViewById(R.id.filter_button);

        // Setup toolbar
        backButton.setOnClickListener(v -> finish());
        backButton.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN);
        filterButton.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN);
        filterButton.setOnClickListener(v -> showFilterDialog());

        // Load data
        loadEarningsData();
        setupEarningsChart();
    }

    private void loadEarningsData() {
        // In a real app, you would fetch this data from a database or API
        tvTotalEarnings.setText("$12,850");
        tvEarningsChange.setText("+12% from last month");
        tvCompletedAppointments.setText("142");
        tvCompletedChange.setText("+8% from last month");
        tvAvgEarnings.setText("$90.50");
        tvAvgChange.setText("+5% from last month");
    }

    private void setupEarningsChart() {
        // Configure chart appearance
        earningsChart.getDescription().setEnabled(false);
        earningsChart.setDrawGridBackground(false);
        earningsChart.setDrawBarShadow(false);
        earningsChart.setHighlightFullBarEnabled(false);
        earningsChart.setPinchZoom(false);
        earningsChart.setDrawValueAboveBar(true);
        earningsChart.getLegend().setEnabled(false);

        // X-axis configuration
        XAxis xAxis = earningsChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);
        xAxis.setTextSize(10f);
        xAxis.setTextColor(ContextCompat.getColor(this, R.color.gray));

        // Y-axis configuration
        YAxis leftAxis = earningsChart.getAxisLeft();
        leftAxis.setDrawGridLines(true);
        leftAxis.setGranularity(100f);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setTextColor(ContextCompat.getColor(this, R.color.gray));
        leftAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return "$" + (int) value;
            }
        });

        earningsChart.getAxisRight().setEnabled(false);

        // Add data to chart
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, 1200));
        entries.add(new BarEntry(1, 1800));
        entries.add(new BarEntry(2, 1500));
        entries.add(new BarEntry(3, 2100));
        entries.add(new BarEntry(4, 2400));
        entries.add(new BarEntry(5, 1950));

        BarDataSet dataSet = new BarDataSet(entries, "Monthly Earnings");
        dataSet.setColor(ContextCompat.getColor(this, R.color.primary));
        dataSet.setValueTextColor(ContextCompat.getColor(this, R.color.black));
        dataSet.setValueTextSize(10f);
        dataSet.setValueFormatter(new ValueFormatter() {
            @Override
            public String getBarLabel(BarEntry barEntry) {
                return "$" + (int) barEntry.getY();
            }
        });

        BarData barData = new BarData(dataSet);
        barData.setBarWidth(0.7f);
        earningsChart.setData(barData);

        // Custom X-axis labels
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun"};
        xAxis.setValueFormatter(new IndexAxisValueFormatter(months));

        // Refresh chart
        earningsChart.invalidate();
        earningsChart.animateY(1000);
    }

    private void showFilterDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Filter Earnings");

        String[] filters = {"All Time", "This Month", "Last Month", "This Year", "Custom Range"};
        builder.setItems(filters, (dialog, which) -> {
            // Filter earnings based on selection
            // In a real app, you would implement this filtering logic
            Toast.makeText(this, "Filtering by: " + filters[which], Toast.LENGTH_SHORT).show();
        });

        builder.show();
    }
}
