package org.esisalama.esisrepo;

import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

import esisRepo.entity.User;
import esisRepo.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomePageActivity extends AppCompatActivity {
    private FloatingActionButton addWorkButton;
    private Button allButton;
    private Button profileButton;
    private TextView nameText;
    private TextView matriculeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar());
        setContentView(R.layout.activity_home_page);
        changeActivity(setSession());
        initComponents();
        profileButtonAction(savedInstanceState);
        allButtonAction(savedInstanceState);
        addWorkButtonAction();
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container_view, ItemFragment.class, null)
                    .commit();
        }
    }

    private void getRequest(String id){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build();
        UserService userService = retrofit.create(UserService.class);

        Call<User> callback = userService.getUser(id);
        callback.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if (response.isSuccessful()){
                    User user = response.body();
                    if (user == null){
                        Toast.makeText(
                                HomePageActivity.this,
                                "Cet utilisateur n'éxiste pas",
                                Toast.LENGTH_SHORT
                        ).show();
                    } else {
                        nameText.setText(user.getName());
                        matriculeText.setText(user.getId());
                    }
                } else {
                    Toast.makeText(
                            HomePageActivity.this,
                            "",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void initComponents() {
        addWorkButton = findViewById(R.id.addWork);
        allButton = findViewById(R.id.allButton);
        profileButton = findViewById(R.id.profileButton);
        matriculeText = findViewById(R.id.matriculeText);
        nameText = findViewById(R.id.nameText);
    }

    private void profileButtonAction(Bundle savedInstanceState){
        profileButton.setOnClickListener(v -> {
            if(savedInstanceState == null){
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container_view, ProfileFragment.class, null)
                        .commit();
            }
        });
    }

    private void addWorkButtonAction(){
        addWorkButton.setOnClickListener(v -> {
            Intent addWorkIntent = new Intent(this, AddDocActivity.class);
            startActivity(addWorkIntent);
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
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(R.id.modifyProfile == item.getItemId()){
            Intent modifyProfileIntent = new Intent(this, ModifyProfileActivity.class);
            startActivity(modifyProfileIntent);
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
