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

public class Education extends AppCompatActivity {

    EditText etEducation;
    Button btnSaveEducationDetails, btnCancelEducationDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_education);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        btnSaveEducationDetails.setOnClickListener((v)->{
            Intent intent = new Intent();
            if(etEducation.getText().length() != 0){
                String str = etEducation.getText().toString();
                intent.putExtra("EducationDetails", str);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
            else {
                Toast.makeText(Education.this, "Education Details are empty.", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancelEducationDetails.setOnClickListener((v)->{
            Intent intent = new Intent();
            setResult(Activity.RESULT_CANCELED, intent);
            finish();
        });
    }

    private void init() {
        etEducation = findViewById(R.id.etEducation);
        btnSaveEducationDetails = findViewById(R.id.btnSaveEducationDetails);
        btnCancelEducationDetails = findViewById(R.id.btnCancelEducationDetails);
    }
}