package org.esisalama.esisrepo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private Button submitButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        EditText usernameField = findViewById(R.id.username_field);
        EditText pwdField = findViewById(R.id.pwd_field);
        cancelButton = findViewById(R.id.cancel_button);
        submitButton = findViewById(R.id.submit_button);
        progressBar = findViewById(R.id.progress_circular);

        cancelButtonAction();

        submitButtonAction(usernameField, pwdField);
    }

    private void login(String matricule, String pwd) {
        if (Objects.equals(matricule, "Archie") && Objects.equals(pwd, "Archie")) {
            SharedPreferences preferences = getSharedPreferences("session", 0);
            preferences.edit().putBoolean("session_active", true)
                    .putInt("userId", 123)
                    .apply();
            Intent homePageIntent = new Intent(this, HomePageActivity.class);
            startActivity(homePageIntent);
        }

        progressBar.setVisibility(View.VISIBLE);
        submitButton.setEnabled(false);
    }

    private void cancelButtonAction() {
        cancelButton.setOnClickListener(v -> {
            progressBar.setEnabled(false);
            finish();
        });
    }

    private void submitButtonAction(EditText usernameField, EditText pwdField) {
        submitButton.setOnClickListener(v -> {
            String matricule = usernameField.getText().toString();
            String pwd = pwdField.getText().toString();

            if(matricule.isEmpty()){
                Toast.makeText(
                        LoginActivity.this,
                        "le champ du matricule ne doit pas etre vide.",
                        Toast.LENGTH_SHORT).show();
            } else if (pwd.isEmpty()) {
                Toast.makeText(
                        LoginActivity.this,
                        "le champ du mot de passe ne doit pas etre vide.",
                        Toast.LENGTH_SHORT).show();
            } else {
                login(matricule, pwd);
            }
        });
    }
}