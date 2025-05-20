package java.com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.com.myhealthteam.staffapp.R;

public class EditProfileActivity extends Activity {
    private EditText editName, editEmail, editPhone;
    private Button btnSaveProfile;
    private ImageView backButton, profilePicture;
    private TextView editProfilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        // Initialize views
        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editPhone = findViewById(R.id.edit_phone);
        btnSaveProfile = findViewById(R.id.btn_save_profile);
        backButton = findViewById(R.id.back_button);
        profilePicture = findViewById(R.id.profile_picture);
        editProfilePicture = findViewById(R.id.change_picture);

        // Mock data (Replace with actual data from the backend)
        editName.setText("Dr. Sadia Shakil");
        editEmail.setText("sadia.shakil@example.com");
        editPhone.setText("+1 234 567 890");

        // Back button listener
        backButton.setOnClickListener(v -> finish());
        backButton.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN);

        // Change profile picture listener
        profilePicture.setColorFilter(ContextCompat.getColor(this, R.color.primary), PorterDuff.Mode.SRC_IN);
        editProfilePicture.setOnClickListener(v -> {
            // Implement functionality to change profile picture
            Toast.makeText(this, "Change Profile Picture clicked", Toast.LENGTH_SHORT).show();
        });

        // Save button listener
        btnSaveProfile.setOnClickListener(v -> {
            // Save the updated data
            String name = editName.getText().toString().trim();
            String email = editEmail.getText().toString().trim();
            String phone = editPhone.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Save updated profile logic (e.g., API call to update profile)
            Toast.makeText(this, "Profile updated successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(EditProfileActivity.this, ProfileActivity.class);
            startActivity(intent);
            finish(); // Close EditProfileActivity
        });
    }
}
