package org.esisalama.esisrepo;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class HomePageActivity extends AppCompatActivity {
    private Button addWorkButton;
    private Button workDetailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Home");
        changeActivity(setSession());
        initComponents();
        addWorkButtonAction();
        workDetailButtonAction();
    }

    private void initComponents() {
        workDetailButton = findViewById(R.id.workDetailButton);
        addWorkButton = findViewById(R.id.addWorkButton);
    }

    private void workDetailButtonAction() {
        workDetailButton.setOnClickListener(v -> {
            Intent workDetailIntent = new Intent(this, WorkDetailActivity.class);
            startActivity(workDetailIntent);
        });
    }

    private void addWorkButtonAction() {
        addWorkButton.setOnClickListener(
            v -> {
                Intent addWorkIntent = new Intent(this, AddDocActivity.class);
                startActivity(addWorkIntent);
            }
        );
    }

    private boolean setSession(){
        SharedPreferences preferences = getSharedPreferences("session", 0);

        return preferences.getBoolean("session_active", false);
    }

    private void changeActivity(boolean sessionActive){
        if (!sessionActive) {
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }
    }
}
