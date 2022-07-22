package org.esisalama.esisrepo;

import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.Menu;

import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class HomePageActivity extends AppCompatActivity {
    private Button addWorkButton;
    private MenuItem searchItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
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


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.searchItem) {
            Toast.makeText(
                    this,
                    "You want to search something.",
                    Toast.LENGTH_SHORT
            ).show();
        } else if(item.getItemId() == R.id.filterItem) {
            Toast.makeText(
                    this,
                    "You want to filter your home.",
                    Toast.LENGTH_SHORT
            ).show();
        }
        return super.onOptionsItemSelected(item);
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
