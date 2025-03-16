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

public class Experience extends AppCompatActivity {

    EditText etExperience;
    Button btnSaveExperience, btnCancelExperience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_experience);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        btnSaveExperience.setOnClickListener((v)->{
            Intent intent = new Intent();
            if(etExperience.getText().length() != 0){
                String str = etExperience.getText().toString();
                intent.putExtra("ExperienceDetails", str);

                if (str == null) {
                    Toast.makeText(Experience.this, "Experience NULL", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Experience.this, str, Toast.LENGTH_SHORT).show();
                }

                setResult(Activity.RESULT_OK, intent);
                finish();
            }
            else {
                Toast.makeText(Experience.this, "Experience Details are empty.", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancelExperience.setOnClickListener((v)->{
            Intent intent = new Intent();
            setResult(Activity.RESULT_CANCELED, intent);
            finish();
        });
    }

    private void init(){
        etExperience = findViewById(R.id.etExperience);
        btnSaveExperience = findViewById(R.id.btnSaveExperience);
        btnCancelExperience = findViewById(R.id.btnCancelExperience);
    }
}