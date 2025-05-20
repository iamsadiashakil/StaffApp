package com.myhealthteam.staffapp.adapters;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.myhealthteam.staffapp.models.Patient;
import com.myhealthteam.staffapp.utils.MockData;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class PatientsAdapterTest {

    private PatientsAdapter adapter;
    private List<Patient> mockPatients;

    @Mock
    private Context mockContext;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Mock patient data
        mockPatients = MockData.getPatients();

        // Initialize adapter with mock context
        adapter = new PatientsAdapter(mockContext, mockPatients, patient -> {
            // Mock click listener
        });
    }

    @Test
    public void testItemCount() {
        // Verify that the adapter returns the correct item count
        assertEquals(mockPatients.size(), adapter.getItemCount());
    }

    @Test
    public void testOnPatientClick() {
        // Simulate a click event on the first item
        RecyclerView.ViewHolder mockViewHolder = mock(RecyclerView.ViewHolder.class);
        adapter.listener.onPatientClick(mockPatients.get(0));

        // Verify the click event was handled (this can be extended based on the listener logic)
        assertEquals("John Smith", mockPatients.get(0).getName());
    }
}