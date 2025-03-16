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

public class Certifications extends AppCompatActivity {

    EditText etCertifications;
    Button btnSaveCertifications, btnCancelCertifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_certifications);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        btnSaveCertifications.setOnClickListener((v)->{
            Intent intent = new Intent();
            if(etCertifications.getText().length() != 0){
                String str = etCertifications.getText().toString();
                intent.putExtra("CertificationsDetails", str);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
            else {
                Toast.makeText(Certifications.this, "Experience Details are empty.", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancelCertifications.setOnClickListener((v)->{
            Intent intent = new Intent();
            setResult(Activity.RESULT_CANCELED, intent);
            finish();
        });
    }

    private void init(){
        etCertifications = findViewById(R.id.etCertifications);
        btnSaveCertifications = findViewById(R.id.btnSaveCertifications);
        btnCancelCertifications = findViewById(R.id.btnCancelCertifications);
    }
}