package java.com.myhealthteam.staffapp.activities;

import android.graphics.Color;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ChartDataLoader {

    public static void loadAppointmentStatusData(PieChart chart) {
        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(62f, "Completed"));
        entries.add(new PieEntry(18f, "Cancelled"));
        entries.add(new PieEntry(12f, "No Show"));
        entries.add(new PieEntry(8f, "Rescheduled"));

        PieDataSet dataSet = new PieDataSet(entries, "Appointment Status");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextSize(12f);
        dataSet.setValueTextColor(Color.WHITE);

        PieData data = new PieData(dataSet);
        chart.setData(data);
        chart.invalidate(); // refresh
    }

    public static void loadWeeklyVisitsData(BarChart chart) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 12f));
        entries.add(new BarEntry(1f, 18f));
        entries.add(new BarEntry(2f, 15f));
        entries.add(new BarEntry(3f, 22f));
        entries.add(new BarEntry(4f, 19f));
        entries.add(new BarEntry(5f, 8f));
        entries.add(new BarEntry(6f, 5f));

        BarDataSet dataSet = new BarDataSet(entries, "Weekly Visits");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextSize(10f);

        BarData data = new BarData(dataSet);
        data.setBarWidth(0.9f);
        chart.setData(data);

        // Set day labels
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(days));

        chart.invalidate();
    }

    public static void loadMonthlyEarningsData(LineChart chart) {
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 1850));
        entries.add(new Entry(1, 2200));
        entries.add(new Entry(2, 1950));
        entries.add(new Entry(3, 2400));
        entries.add(new Entry(4, 2800));
        entries.add(new Entry(5, 3200));

        LineDataSet dataSet = new LineDataSet(entries, "Monthly Earnings ($)");
        dataSet.setColor(Color.parseColor("#FFA726"));
        dataSet.setValueTextColor(Color.parseColor("#212121"));
        dataSet.setLineWidth(2f);
        dataSet.setCircleColor(Color.parseColor("#FFA726"));
        dataSet.setCircleRadius(4f);
        dataSet.setValueTextSize(10f);

        LineData data = new LineData(dataSet);
        chart.setData(data);

        // Set month labels
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun"};
        chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(months));

        chart.invalidate();
    }
}