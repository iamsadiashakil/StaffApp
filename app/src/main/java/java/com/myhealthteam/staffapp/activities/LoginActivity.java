package java.com.myhealthteam.staffapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.com.myhealthteam.staffapp.R;

public class LoginActivity extends Activity {

    private TextView logTextView, forgotPassword, createAccount;
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        logTextView = findViewById(R.id.logTextView);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        forgotPassword = findViewById(R.id.forgot_password);
        createAccount = findViewById(R.id.create_account);

        // Set up login button click listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validate input
                if (username.isEmpty() || password.isEmpty()) {
                    logTextView.setText("Error: Username or Password cannot be empty.");
                    logTextView.setTextColor(ContextCompat.getColor(logTextView.getContext(), R.color.red));
                } else if (username.equals("admin") && password.equals("password")) { // Dummy credentials
                    logTextView.setText("Login Successful!");
                    logTextView.setTextColor(ContextCompat.getColor(logTextView.getContext(), R.color.green));
                    Toast.makeText(LoginActivity.this, "Welcome " + username, Toast.LENGTH_SHORT).show();

                    // Navigate to PatientActivity
                    Intent intent = new Intent(LoginActivity.this, PatientActivity.class);
                    startActivity(intent);
                    finish(); // Close LoginActivity
                } else {
                    logTextView.setText("Error: Invalid Username or Password.");
                }
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