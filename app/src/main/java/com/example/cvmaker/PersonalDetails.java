package com.example.cvmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PersonalDetails extends AppCompatActivity {

    EditText etNameInput, etPhoneNumber, etEmail;
    Button btnSavePersonalDetails, btnCancelPersonalDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personal_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        btnSavePersonalDetails.setOnClickListener((v)->{
            Intent intent = new Intent();
            if(etNameInput.getText().length() != 0 && etPhoneNumber.getText().length() != 0 && etEmail.getText().length() != 0){
                String[] str = {etNameInput.getText().toString(), etPhoneNumber.getText().toString(), etEmail.getText().toString()};
                intent.putExtra("PersonalDetails", str);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
            else {
                Toast.makeText(PersonalDetails.this, "Personal Details are empty.", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancelPersonalDetails.setOnClickListener((v)->{
            Intent intent = new Intent();
            setResult(Activity.RESULT_CANCELED, intent);
            finish();
        });
    }

    private void init(){
        btnSavePersonalDetails = findViewById(R.id.btnSavePersonalDetails);
        btnCancelPersonalDetails = findViewById(R.id.btnCancelPersonalDetails);
        etNameInput = findViewById(R.id.etNameInput);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
    }
}