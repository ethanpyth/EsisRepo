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
    private Button allButton;
    private Menu menu;
    private Button profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Home");
        changeActivity(setSession());
        initComponents();
        profileButtonAction(savedInstanceState);
        allButtonAction(savedInstanceState);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container_view, ItemFragment.class, null)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        this.menu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    private void initComponents() {
        allButton = findViewById(R.id.allButton);
        profileButton = findViewById(R.id.profileButton);
    }

    private void profileButtonAction(Bundle savedInstanceState){
        profileButton.setOnClickListener(v -> {
            if(savedInstanceState == null){
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container_view, ProfileFragment.class, null)
                        .commit();
            }
            getMenuInflater().inflate(R.menu.menu_profile, menu);
        });
    }

    private void allButtonAction(Bundle savedInstanceState){
        allButton.setOnClickListener(v -> {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container_view, ItemFragment.class, null)
                        .commit();
            }
            getMenuInflater().inflate(R.menu.menu_home, menu);
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
