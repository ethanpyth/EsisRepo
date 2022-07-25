package org.esisalama.esisrepo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {
    private MenuItem shareItem;
    private MenuItem modifyItem;
    private MenuItem deleteItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //verifyUser();
    }

    private void verifyUser() {
        if (!Objects.equals("Betty", "Archie")){
            deleteItem.setVisible(false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(R.id.modifyProfile == item.getItemId()){
            Intent modifyProfileIntent = new Intent(this, ModifyProfileActivity.class);
            startActivity(modifyProfileIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
