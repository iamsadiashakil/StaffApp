package com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.myhealthteam.staffapp.R;

public class ForgotPasswordActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        EditText emailInput = findViewById(R.id.email_input);
        Button submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();

            if (!email.isEmpty()) {
                // Add logic to handle password reset here (e.g., send a reset link to email)
                Toast.makeText(this, "Password reset link sent to " + email, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please enter your email address", Toast.LENGTH_SHORT).show();
                return;
            }
            // Navigate to LoginActivity
            Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
            // Clear the back stack and start ProfileActivity as a new task
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Close ForgotPasswordActivity
        });
    }
}
