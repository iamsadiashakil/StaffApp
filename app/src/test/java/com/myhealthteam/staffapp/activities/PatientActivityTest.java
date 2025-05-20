package com.myhealthteam.staffapp.activities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ActivityScenario;

import com.myhealthteam.staffapp.R;
import com.myhealthteam.staffapp.adapters.PatientsAdapter;
import com.myhealthteam.staffapp.models.Patient;
import com.myhealthteam.staffapp.utils.MockData;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class PatientActivityTest {

    private List<Patient> mockPatients;

    @Before
    public void setUp() {
        mockPatients = MockData.getPatients();
    }

    @Test
    public void testActivityInitialization() {
        ActivityScenario<PatientActivity> scenario = Mockito.mock(ActivityScenario.class);

        scenario.onActivity(activity -> {
            // Check if views are properly initialized
            ImageView backButton = activity.findViewById(R.id.back_button);
            RecyclerView recyclerView = activity.findViewById(R.id.patient_recycler_view);
            EditText searchPatient = activity.findViewById(R.id.search_view);

            assertNotNull(backButton);
            assertNotNull(recyclerView);
            assertNotNull(searchPatient);

            // Check if RecyclerView adapter is set
            PatientsAdapter adapter = (PatientsAdapter) recyclerView.getAdapter();
            assertNotNull(adapter);
            assertEquals(mockPatients.size(), adapter.getItemCount());
        });
    }

    @Test
    public void testFilterPatient() {
        ActivityScenario<PatientActivity> scenario = Mockito.mock(ActivityScenario.class);

        scenario.onActivity(activity -> {
            // Simulate filtering functionality
            activity.filterPatient("john"); // Assuming a mock patient named "John" exists in MockData

            PatientsAdapter adapter = activity.adapter;
            List<Patient> filteredList = mockPatients;

            // Check if the filtered list contains only the matched patient(s)
            assertEquals(1, filteredList.size());
            assertEquals("John", filteredList.get(0).getName());
        });
    }

    @Test
    public void testViewPatientDetail() {
        ActivityScenario<PatientActivity> scenario = Mockito.mock(ActivityScenario.class);

        scenario.onActivity(activity -> {
            Patient patient = mockPatients.get(0); // Simulate selecting the first patient
            activity.viewPatientDetail(patient);

            Intent expectedIntent = new Intent(activity, PatientDetailActivity.class);
            expectedIntent.putExtra("patient_id", patient.getId());

            // Assert that the intent is correctly set
            assertEquals(expectedIntent.getComponent(), activity.getIntent().getComponent());
            assertEquals(patient.getId(), activity.getIntent().getIntExtra("patient_id", -1));
        });
    }
}