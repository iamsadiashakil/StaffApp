package java.com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.com.myhealthteam.staffapp.R;

public class ProfileActivity extends Activity {

    private TextView staffName, staffRole, staffEmail, staffPhone, staffJoinDate;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        staffName = findViewById(R.id.staff_name);
        staffRole = findViewById(R.id.staff_role);
        staffEmail = findViewById(R.id.staff_email);
        staffPhone = findViewById(R.id.staff_phone);
        staffJoinDate = findViewById(R.id.staff_join_date);
        btnLogout = findViewById(R.id.btn_logout);

        ImageView backButton = findViewById(R.id.back_button);
        ImageView btnEditProfile = findViewById(R.id.btn_edit_profile);
        ImageView profilePicture = findViewById(R.id.profile_picture);

        // Back button listener
        backButton.setOnClickListener(v -> finish());
        backButton.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN);
        btnEditProfile.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN);
        profilePicture.setColorFilter(ContextCompat.getColor(this, R.color.primary), PorterDuff.Mode.SRC_IN);

        // Set mock data (replace with actual API data)
        staffName.setText("Dr. Sadia Shakil");
        staffRole.setText("Staff Nurse");
        staffEmail.setText("sadia.shakil@example.com");
        staffPhone.setText("+1 234 567 890");
        staffJoinDate.setText("2023-04-15");

        // Button listeners
        btnEditProfile.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
            startActivity(intent);
        });

        btnLogout.setOnClickListener(v -> {
            // Handle logout logic (e.g., clear session, navigate to login)
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}
