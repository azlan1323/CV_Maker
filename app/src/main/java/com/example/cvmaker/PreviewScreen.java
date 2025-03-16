package com.example.cvmaker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PreviewScreen extends AppCompatActivity {

    TextView tvPersonalDetails, tvSummary, tvEducation, tvExperience, tvReferences, tvCertifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_preview_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
        setDetails();
    }

    private void init() {
        tvPersonalDetails = findViewById(R.id.tvPersonalDetails);
        tvSummary = findViewById(R.id.tvSummary);
        tvEducation = findViewById(R.id.tvEducation);
        tvExperience = findViewById(R.id.tvExperience);
        tvReferences = findViewById(R.id.tvReferences);
        tvCertifications = findViewById(R.id.tvCertifications);
    }

    private void setDetails() {
        Intent intent = getIntent();

        String summaryDetails = intent.getStringExtra("SummaryDetails");
        String certificationsDetails = intent.getStringExtra("CertificationsDetails");
        String experienceDetails = intent.getStringExtra("ExperienceDetails");
        String referencesDetails = intent.getStringExtra("ReferencesDetails");
        String educationDetails = intent.getStringExtra("EducationDetails");
        String[] personalDetails = intent.getStringArrayExtra("PersonalDetails");

        String str = "Summary\n" + (summaryDetails != null ? summaryDetails : "");
        tvSummary.setText(str);

        str = "Certifications\n" + (certificationsDetails != null ? certificationsDetails : "");
        tvCertifications.setText(str);

        str = "Work Experience\n" + (experienceDetails != null ? experienceDetails : "");
        tvExperience.setText(str);

        str = "References\n" + (referencesDetails != null ? referencesDetails : "");
        tvReferences.setText(str);

        str = "Education\n" + (educationDetails != null ? educationDetails : "");
        tvEducation.setText(str);

        if (personalDetails != null){
            int i = 0;
            for (String detail : personalDetails) {
                tvPersonalDetails.setText(String.format("%s%s", tvPersonalDetails.getText(), detail));
                if (i != personalDetails.length){
                    tvPersonalDetails.setText(String.format("%s\n", tvPersonalDetails.getText()));
                }
                i++;
            }
        }
    }
}