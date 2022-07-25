package org.esisalama.esisrepo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyProfileActivity extends AppCompatActivity {
    private Button modifyButton;
    private EditText oldPWD;
    private EditText newPWD;
    private EditText confirmNewPWD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_profile);
        initComponents();
        modifyButtonAction();
    }

    private void initComponents(){
        modifyButton = findViewById(R.id.modifyButton);
        oldPWD = findViewById(R.id.oldPWDField);
        newPWD = findViewById(R.id.newPWDField);
        confirmNewPWD = findViewById(R.id.confirmNewPWDField);
    }

    private boolean validatorNewPWD(EditText oldPWDField, EditText newPWDField, EditText confirmNewPWDField){
        String newPWD = newPWDField.getText().toString().toUpperCase();
        String oldPWD = oldPWDField.getText().toString().toUpperCase();
        String confirmPWD = confirmNewPWDField.getText().toString().toUpperCase();
        if (oldPWD.equals("19KA201")){
            if (newPWD.equals(confirmPWD)){
                if (newPWD.length() >= 6){
                    Toast.makeText(
                                    this,
                                    "Nouveau mot de passe valider",
                                    Toast.LENGTH_SHORT)
                            .show();
                    return true;
                } else {
                    Toast.makeText(
                            this,
                            "Votre nouveau mot de passe doit avoir plus de 6 caractères",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            } else {
                Toast.makeText(
                                this,
                                "Le mot de passe du dernier champ ne correspond pas au mot de passe du " +
                                        "deuxième champ",
                                Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        } else {
            Toast.makeText(
                            this,
                            "Votre ancien mot de passe n'est pas valide",
                            Toast.LENGTH_SHORT)
                    .show();
        }
        return false;
    }

    private void modifyButtonAction(){
        modifyButton.setOnClickListener(v -> {
            boolean bool = validatorNewPWD(oldPWD, newPWD, confirmNewPWD);
            if (bool){
                Intent homePageIntent = new Intent(this, HomePageActivity.class);
                startActivity(homePageIntent);
                finish();
            }
        });
    }
}