package com.myhealthteam.staffapp.activities;

import static org.junit.Assert.assertTrue;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.myhealthteam.staffapp.R;

import org.junit.Rule;
import org.junit.Test;

public class PatientActivityUITest {

    @Rule
    public ActivityScenarioRule<PatientActivity> activityRule = new ActivityScenarioRule<>(PatientActivity.class);

    @Test
    public void testUIElementsDisplayed() {
        // Check if all key UI elements are displayed
        Espresso.onView(ViewMatchers.withId(R.id.back_button))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.patient_recycler_view))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.search_view))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testSearchFunctionality() {
        // Type a query into the search bar
        Espresso.onView(ViewMatchers.withId(R.id.search_view))
                .perform(ViewActions.typeText("John"), ViewActions.closeSoftKeyboard());

        // Verify that the filtered patient is displayed
        Espresso.onView(ViewMatchers.withText("John"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testBackButton() {
        // Launch the activity
        ActivityScenario<PatientActivity> scenario = ActivityScenario.launch(PatientActivity.class);

        // Click the back button
        Espresso.onView(ViewMatchers.withId(R.id.back_button))
                .perform(ViewActions.click());

        // Assert that the activity is closed
        scenario.onActivity(activity -> {
            assertTrue(activity.isFinishing());
        });
    }

    @Test
    public void testPatientItemClick() {
        // Launch the activity
        ActivityScenario<PatientActivity> scenario = ActivityScenario.launch(PatientActivity.class);

        // Wait for RecyclerView to load
        Espresso.onView(ViewMatchers.withId(R.id.patient_recycler_view))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        // Simulate clicking on a patient item with the name "John"
        Espresso.onView(ViewMatchers.withText("John Smith"))
                .perform(ViewActions.click());

        // Verify that PatientDetailActivity is launched
        Espresso.onView(ViewMatchers.withText("Patient Details"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}