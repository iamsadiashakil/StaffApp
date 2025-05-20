package com.myhealthteam.staffapp.activities;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import com.myhealthteam.staffapp.R;

public class ProfileActivityUITest {

    @Rule
    public ActivityScenarioRule<ProfileActivity> activityRule = new ActivityScenarioRule<>(ProfileActivity.class);

    @Test
    public void testProfileUIElementsDisplayed() {
        // Check that all views are displayed
        Espresso.onView(ViewMatchers.withId(R.id.staff_name))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.staff_role))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.staff_email))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.staff_phone))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.staff_join_date))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.btn_logout))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testEditProfileButtonClick() {
        // Perform click on Edit Profile button
        Espresso.onView(ViewMatchers.withId(R.id.btn_edit_profile))
                .perform(ViewActions.click());

        // Check that the EditProfileActivity is launched
        Espresso.onView(ViewMatchers.withText("Edit Profile"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testLogoutButtonClick() {
        // Perform click on Logout button
        Espresso.onView(ViewMatchers.withId(R.id.btn_logout))
                .perform(ViewActions.click());

        // Check that the LoginActivity is launched
        Espresso.onView(ViewMatchers.withText("Login"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}