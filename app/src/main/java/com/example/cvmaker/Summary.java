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

public class Summary extends AppCompatActivity {

    EditText etSummary;
    Button btnSaveSummary, btnCancelSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_summary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        btnSaveSummary.setOnClickListener((v)->{
            Intent intent = new Intent();
            if(etSummary.getText().length() != 0){
                String str = etSummary.getText().toString();
                intent.putExtra("SummaryDetails", str);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
            else {
                Toast.makeText(Summary.this, "Experience Details are empty.", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancelSummary.setOnClickListener((v)->{
            Intent intent = new Intent();
            setResult(Activity.RESULT_CANCELED, intent);
            finish();
        });
    }

    private void init() {
        etSummary = findViewById(R.id.etSummary);
        btnSaveSummary = findViewById(R.id.btnSaveSummary);
        btnCancelSummary = findViewById(R.id.btnCancelSummary);
    }
}