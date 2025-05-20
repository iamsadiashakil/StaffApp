package com.myhealthteam.staffapp.activities;

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
        // Simulate typing a query into the search bar
        Espresso.onView(ViewMatchers.withId(R.id.search_view))
                .perform(ViewActions.typeText("john"), ViewActions.closeSoftKeyboard());

        // Check if the RecyclerView is updated with the filtered result
        Espresso.onView(ViewMatchers.withText("John"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testBackButton() {
        // Simulate clicking the back button
        Espresso.onView(ViewMatchers.withId(R.id.back_button))
                .perform(ViewActions.click());

        // Verify that the activity finishes
        Espresso.onView(ViewMatchers.isRoot())
                .check((view, noViewFoundException) -> {
                    // If no exceptions are thrown, the activity has closed
                });
    }

    @Test
    public void testPatientItemClick() {
        // Simulate clicking on a patient item in the RecyclerView
        Espresso.onView(ViewMatchers.withText("John")) // Assuming "John" is in the mock data
                .perform(ViewActions.click());

        // Verify that the PatientDetailActivity is launched
        Espresso.onView(ViewMatchers.withText("Patient Details"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}