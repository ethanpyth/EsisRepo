package org.esisalama.esisrepo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDocActivity extends AppCompatActivity {
    private EditText descriptionField;
    private EditText promotionField;
    private EditText categoryField;
    private EditText workDateField;
    private Button addWorkButton;
    private Button addImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doc);
        initComponents();
        addWorkButtonAction();
    }

    private void initComponents(){
        descriptionField = findViewById(R.id.descriptionTravail);
        categoryField = findViewById(R.id.category);
        promotionField = findViewById(R.id.promotion);
        workDateField = findViewById(R.id.workDateField);
        addWorkButton = findViewById(R.id.addWork);
        addImageButton = findViewById(R.id.addImage);
    }

    private void addWorkButtonAction(){
        addWorkButton.setOnClickListener(v -> {

            String description = descriptionField.getText().toString();
            String category = categoryField.getText().toString();
            String promotion = promotionField.getText().toString();
            String workDate = workDateField.getText().toString();

            Toast.makeText(this, "Categorie :" + category, Toast.LENGTH_SHORT).show();
            if (description.isEmpty()){
                Toast.makeText(this, "La description ne doit pas etre vide", Toast.LENGTH_SHORT).show();
            } else if (category.isEmpty()) {
                Toast.makeText(this, "La categorie ne doit pas etre vide", Toast.LENGTH_SHORT).show();
            } else if (promotion.isEmpty()) {
                Toast.makeText(this, "La promotion ne doit pas etre vide", Toast.LENGTH_SHORT).show();
            } else if (workDate.isEmpty()) {
                Toast.makeText(this, "La date ne doit pas etre vide", Toast.LENGTH_SHORT).show();
            } else{
                Intent homePageIntent = new Intent(this, HomePageActivity.class);
                startActivity(homePageIntent);
                finish();
            }
        });

    }
}