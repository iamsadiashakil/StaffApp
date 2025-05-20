package com.myhealthteam.staffapp.activities;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.mockito.Mockito;

import com.myhealthteam.staffapp.R;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProfileActivityTest {

    @Test
    public void testProfileActivityInitialization() {
        ActivityScenario<ProfileActivity> scenario = Mockito.mock(ActivityScenario.class);

        scenario.onActivity(activity -> {
            // Assert that views are properly initialized
            TextView staffName = activity.findViewById(R.id.staff_name);
            TextView staffRole = activity.findViewById(R.id.staff_role);
            TextView staffEmail = activity.findViewById(R.id.staff_email);
            TextView staffPhone = activity.findViewById(R.id.staff_phone);
            TextView staffJoinDate = activity.findViewById(R.id.staff_join_date);
            Button btnLogout = activity.findViewById(R.id.btn_logout);
            ImageView backButton = activity.findViewById(R.id.back_button);
            ImageView btnEditProfile = activity.findViewById(R.id.btn_edit_profile);

            assertNotNull(staffName);
            assertNotNull(staffRole);
            assertNotNull(staffEmail);
            assertNotNull(staffPhone);
            assertNotNull(staffJoinDate);
            assertNotNull(btnLogout);
            assertNotNull(backButton);
            assertNotNull(btnEditProfile);

            // Check default text values
            assertEquals("Dr. Sadia Shakil", staffName.getText());
            assertEquals("Staff Nurse", staffRole.getText());
            assertEquals("sadia.shakil@example.com", staffEmail.getText());
            assertEquals("+1 234 567 890", staffPhone.getText());
            assertEquals("2023-04-15", staffJoinDate.getText());
        });
    }

    @Test
    public void testEditProfileButtonClick() {
        ActivityScenario<ProfileActivity> scenario = Mockito.mock(ActivityScenario.class);

        scenario.onActivity(activity -> {
            ImageView btnEditProfile = activity.findViewById(R.id.btn_edit_profile);
            btnEditProfile.performClick();

            // Check that the EditProfileActivity is launched
            Intent expectedIntent = new Intent(activity, EditProfileActivity.class);
            assertEquals(expectedIntent.getComponent(), activity.getIntent().getComponent());
        });
    }

    @Test
    public void testLogoutButtonClick() {
        ActivityScenario<ProfileActivity> scenario = Mockito.mock(ActivityScenario.class);

        scenario.onActivity(activity -> {
            Button btnLogout = activity.findViewById(R.id.btn_logout);
            btnLogout.performClick();

            // Check that the LoginActivity is launched
            Intent expectedIntent = new Intent(activity, LoginActivity.class);
            assertEquals(expectedIntent.getComponent(), activity.getIntent().getComponent());
        });
    }
}