package com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.myhealthteam.staffapp.R;

public class LoginActivity extends Activity {

    private TextView forgotPassword, createAccount;
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        forgotPassword = findViewById(R.id.forgot_password);
        createAccount = findViewById(R.id.create_account);

        // Set up login button click listener
        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            // Validate input
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Error: Username or Password cannot be empty.", Toast.LENGTH_SHORT).show();
            } else if (username.equals("admin") && password.equals("password")) { // Dummy credentials
                Toast.makeText(LoginActivity.this, "Welcome " + username, Toast.LENGTH_SHORT).show();

                // Navigate to DoctorDashboardActivity
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                // Clear the back stack and start ProfileActivity as a new task
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // Close LoginActivity
            } else {
                Toast.makeText(LoginActivity.this, "Error: Invalid Username or Password.", Toast.LENGTH_SHORT).show();
            }
        });

        forgotPassword.setOnClickListener(v -> {
            // Navigate to Forgot Password Activity
            Intent intent = new Intent(this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

        createAccount.setOnClickListener(v -> {
            // Navigate to Create Account Activity
            Intent intent = new Intent(this, CreateAccountActivity.class);
            startActivity(intent);
        });
    }
}