package java.com.myhealthteam.staffapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;

import java.com.myhealthteam.staffapp.R;
import java.com.myhealthteam.staffapp.utils.ChartUtils;

public class PatientActivity extends AppCompatActivity {

    private PieChart appointmentStatusChart;
    private BarChart weeklyVisitsChart;
    private LineChart monthlyEarningsChart;
    private TextView tvTotalPatients, tvTodayAppointments, tvTotalEarnings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        // Initialize views
        initializeViews();

        // Set up charts
        setupAppointmentStatusChart();
        setupWeeklyVisitsChart();
        setupMonthlyEarningsChart();

        // Set click listeners for cards
        setupCardClickListeners();

        // Load data
        loadDashboardData();
    }

    private void initializeViews() {
        appointmentStatusChart = findViewById(R.id.appointmentStatusChart);
        weeklyVisitsChart = findViewById(R.id.weeklyVisitsChart);
        monthlyEarningsChart = findViewById(R.id.monthlyEarningsChart);

        tvTotalPatients = findViewById(R.id.tvTotalPatients);
        tvTodayAppointments = findViewById(R.id.tvTodayAppointments);
        tvTotalEarnings = findViewById(R.id.tvTotalEarnings);
    }

    private void setupAppointmentStatusChart() {
        // Implementation would use MPAndroidChart to show pie chart of appointment statuses
        // (Confirmed, Cancelled, Completed, etc.)
        ChartUtils.setupAppointmentStatusPieChart(appointmentStatusChart, getApplicationContext());
    }

    private void setupWeeklyVisitsChart() {
        // Bar chart showing patient visits by day of week
        ChartUtils.setupWeeklyVisitsBarChart(weeklyVisitsChart, getApplicationContext());
    }

    private void setupMonthlyEarningsChart() {
        // Line chart showing earnings trend over months
        ChartUtils.setupMonthlyEarningsLineChart(monthlyEarningsChart, getApplicationContext());
    }

    private void setupCardClickListeners() {
        CardView patientsCard = findViewById(R.id.cardPatients);
        CardView appointmentsCard = findViewById(R.id.cardAppointments);
        CardView earningsCard = findViewById(R.id.cardEarnings);
        CardView prescriptionsCard = findViewById(R.id.cardPrescriptions);

        /*patientsCard.setOnClickListener(v -> {
            startActivity(new Intent(this, PatientsActivity.class));
        });

        appointmentsCard.setOnClickListener(v -> {
            startActivity(new Intent(this, AppointmentsActivity.class));
        });

        earningsCard.setOnClickListener(v -> {
            startActivity(new Intent(this, EarningsActivity.class));
        });

        prescriptionsCard.setOnClickListener(v -> {
            startActivity(new Intent(this, PrescriptionsActivity.class));
        });*/
    }

    private void loadDashboardData() {
        // In a real app, this would fetch data from your backend/API
        // For demo purposes, we'll use mock data

        // Mock stats
        tvTotalPatients.setText("142");
        tvTodayAppointments.setText("8");
        tvTotalEarnings.setText("$12,850");

        // Load chart data
        ChartDataLoader.loadAppointmentStatusData(appointmentStatusChart);
        ChartDataLoader.loadWeeklyVisitsData(weeklyVisitsChart);
        ChartDataLoader.loadMonthlyEarningsData(monthlyEarningsChart);
    }
}