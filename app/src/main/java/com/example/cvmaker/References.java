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

public class References extends AppCompatActivity {

    EditText etReferences;
    Button btnSaveReferences, btnCancelReferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_references);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        btnSaveReferences.setOnClickListener((v)->{
            Intent intent = new Intent();
            if(etReferences.getText().length() != 0){
                String str = etReferences.getText().toString();
                intent.putExtra("ReferencesDetails", str);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
            else {
                Toast.makeText(References.this, "Experience Details are empty.", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancelReferences.setOnClickListener((v)->{
            Intent intent = new Intent();
            setResult(Activity.RESULT_CANCELED, intent);
            finish();
        });
    }

    private void init() {
        etReferences = findViewById(R.id.etReferences);
        btnSaveReferences = findViewById(R.id.btnSaveReferences);
        btnCancelReferences = findViewById(R.id.btnCancelReferences);
    }
}