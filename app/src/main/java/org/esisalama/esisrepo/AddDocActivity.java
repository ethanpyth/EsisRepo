package org.esisalama.esisrepo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import esisRepo.DAO.UserDAO;
import esisRepo.Database.AppDatabase;
import esisRepo.User;

public class AddDocActivity extends AppCompatActivity {
    private EditText descriptionField;
    private EditText promotionField;
    private EditText categoryField;
    private EditText workDateField;
    private Button addWorkButton;
    private TextView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doc);
        initComponents();
        addWorkButtonAction();
    }

    private void initComponents(){
//        descriptionField = findViewById(R.id.id);
        categoryField = findViewById(R.id.mat);
        promotionField = findViewById(R.id.promotion);
        workDateField = findViewById(R.id.nom);
        addWorkButton = findViewById(R.id.addWork);
//        addImageButton = findViewById(R.id.addImage);
        userList = findViewById(R.id.listUsers);
    }

    private void addWorkButtonAction(){
        addWorkButton.setOnClickListener(v -> {

//            String description = descriptionField.getText().toString();
            String category = categoryField.getText().toString();
            String promotion = promotionField.getText().toString();
            String workDate = workDateField.getText().toString();

//            Toast.makeText(this, "Categorie :" + category, Toast.LENGTH_SHORT).show();
            /*if (description.isEmpty()){
                Toast.makeText(this, "La description ne doit pas etre vide", Toast.LENGTH_SHORT).show();
            } else*/ if (category.isEmpty()) {
                Toast.makeText(this, "La categorie ne doit pas etre vide", Toast.LENGTH_SHORT).show();
            } else if (promotion.isEmpty()) {
                Toast.makeText(this, "La promotion ne doit pas etre vide", Toast.LENGTH_SHORT).show();
            } else if (workDate.isEmpty()) {
                Toast.makeText(this, "La date ne doit pas etre vide", Toast.LENGTH_SHORT).show();
            } else{
                savedUser(workDate, category, promotion);
//                Intent homePageIntent = new Intent(this, HomePageActivity.class);
//                startActivity(homePageIntent);
//                finish();
            }
        });
    }

    private void savedUser(String nom, String matricule, String promotion){
        User user = new User(nom, matricule, promotion);
        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "db").allowMainThreadQueries().build();
        UserDAO userDAO = db.userDAO();
        userDAO.insert(user);
        show(userDAO);
    }

    private void show(UserDAO userDAO){
        List<User> users = userDAO.readAll();
        StringBuilder str = new StringBuilder();
        for (User e: users) {
            userList.setText(str.append(e.getMatricule()).append("\n"));
        }
    }
}